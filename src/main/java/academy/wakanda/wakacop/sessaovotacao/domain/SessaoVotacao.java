package academy.wakanda.wakacop.sessaovotacao.domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import academy.wakanda.wakacop.pauta.domain.Pauta;
import academy.wakanda.wakacop.sessaovotacao.application.api.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.VotoRequest;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKey;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessaoVotacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID id;
	private UUID idPauta;
	private Integer tempoDuracao;
	@Enumerated(EnumType.STRING)
	private StatusSessaoVotacao status;
	private LocalDateTime dataAbertura;
	private LocalDateTime dataEncerramento;

	@OneToMany(mappedBy = "sessaoVotacao", cascade = CascadeType.ALL, orphanRemoval = true)
	@MapKey(name = "cpfAssociado")
	private Map<String, VotoPauta> votos;

	public SessaoVotacao(SessaoAberturaRequest sessaoAberturaRequest, Pauta pauta) {
		this.idPauta = pauta.getId();
		this.tempoDuracao = sessaoAberturaRequest.getTempoDuracao().orElse(1);
		this.dataAbertura = LocalDateTime.now();
		this.dataEncerramento = dataAbertura.plusMinutes(this.tempoDuracao);
		this.status = StatusSessaoVotacao.ABERTA;
		this.votos = new HashMap<>();
	}

	public VotoPauta recebeVoto(VotoRequest votoRequest) {
		validaSessaoAberta();
		validaAssociado(votoRequest.getCpfAssociado());
		VotoPauta voto = new VotoPauta(this, votoRequest);
		votos.put(votoRequest.getCpfAssociado(), voto);
		return voto;
	}

	private void validaSessaoAberta() {
		atualizaStatus();
		if (this.status.equals(StatusSessaoVotacao.FECHADA)) {
			throw new RuntimeException("Sessão está fechada!");
		}
	}

	private void atualizaStatus() {
		if (this.status.equals(StatusSessaoVotacao.ABERTA)) {
			if (LocalDateTime.now().isAfter(this.dataEncerramento)) {
				fechaSessao();
			}
		}
	}

	private void fechaSessao() {
		this.status = StatusSessaoVotacao.FECHADA;
	}

	private void validaAssociado(String cpfAssociado) {
		if (this.votos.containsKey(cpfAssociado)) {
			new RuntimeException("Associado já votou nessa sessão!");
		}

	}
}
