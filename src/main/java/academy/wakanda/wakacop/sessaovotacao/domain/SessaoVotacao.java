package academy.wakanda.wakacop.sessaovotacao.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import academy.wakanda.wakacop.pauta.domain.Pauta;
import academy.wakanda.wakacop.sessaovotacao.application.api.SessaoAberturaRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessaoVotacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID id;
	private UUID idPauta;
	private Integer tempoDuracao;
	@Enumerated(EnumType.STRING)
	private StatusVotacao status;
	private LocalDateTime dataAbertura;
	private LocalDateTime dataEncerramento;

	public SessaoVotacao(SessaoAberturaRequest sessaoAberturaRequest, Pauta pauta) {
		this.idPauta = pauta.getId();
		this.tempoDuracao = sessaoAberturaRequest.getTempoDuracao().orElse(1);
		this.dataAbertura = LocalDateTime.now();
		this.dataEncerramento = dataAbertura.plusMinutes(this.tempoDuracao);
		this.status = StatusVotacao.ABERTA;
	}

}
