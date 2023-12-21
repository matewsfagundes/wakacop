package academy.wakanda.wakacop.pauta.application.api;

import java.util.UUID;

import academy.wakanda.wakacop.pauta.domain.Pauta;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PautaCadastradaResponse {

	@Id
	private UUID id;

	public PautaCadastradaResponse(Pauta pauta) {
		this.id = pauta.getId();
	}
}
