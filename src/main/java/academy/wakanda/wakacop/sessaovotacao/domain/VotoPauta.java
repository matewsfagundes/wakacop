package academy.wakanda.wakacop.sessaovotacao.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import academy.wakanda.wakacop.sessaovotacao.application.api.VotoRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VotoPauta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sessao_Votacao_id")
	private SessaoVotacao sessaoVotacao;
	private String cpfAssociado;
	private OpcaoVoto opcaoVoto;
	private LocalDateTime momentoVoto;
	
	public VotoPauta(SessaoVotacao sessaoVotacao, VotoRequest votoRequest) {
		this.cpfAssociado = votoRequest.getCpfAssociado();
		this.opcaoVoto = votoRequest.getOpcao();
		this.momentoVoto = LocalDateTime.now();
		this.opcaoVoto = votoRequest.getOpcao();
	}
}
