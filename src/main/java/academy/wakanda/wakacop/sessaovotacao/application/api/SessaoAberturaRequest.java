package academy.wakanda.wakacop.sessaovotacao.application.api;

import java.util.Optional;
import java.util.UUID;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SessaoAberturaRequest {
	private UUID idPauta;
	private Integer tempoDuracao;
	
	public Optional<Integer> getTempoDuracao(){
		return Optional.ofNullable(this.tempoDuracao);
	}

}
