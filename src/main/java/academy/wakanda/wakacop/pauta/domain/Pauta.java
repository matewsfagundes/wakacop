package academy.wakanda.wakacop.pauta.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import academy.wakanda.wakacop.pauta.application.api.NovaPautaRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Pauta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID id;
	private String titulo;
	private String descricao;
	private UUID idAssociadoAutor;
	private LocalDateTime dataCriacao;

	public Pauta(NovaPautaRequest novaPauta) {
		this.titulo = novaPauta.getTitulo();
		this.descricao = novaPauta.getDescricao();
		this.idAssociadoAutor = novaPauta.getIdAssociadoAutor();
		this.dataCriacao = LocalDateTime.now();

	}
}
