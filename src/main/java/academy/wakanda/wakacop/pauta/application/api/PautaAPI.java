package academy.wakanda.wakacop.pauta.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pauta")
public interface PautaAPI {
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	 PautaCadastradaResponse cadastraPauta(@RequestBody NovaPautaRequest novaPauta);

}
