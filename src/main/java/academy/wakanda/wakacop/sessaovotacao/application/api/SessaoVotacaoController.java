package academy.wakanda.wakacop.sessaovotacao.application.api;

import org.springframework.web.bind.annotation.RestController;

import academy.wakanda.wakacop.sessaovotacao.service.SessaoVotacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoController implements SessaoVotacaoAPI {
	private final SessaoVotacaoService sessaoVotacaoService;

	@Override
	public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest){
	log.info("[start] SessaoVotacaoController - abreSessao");
	SessaoAberturaResponse sessaoAberturaResponse = sessaoVotacaoService.abreSessao(sessaoAberturaRequest);
	log.info("[finish] PautaController - cadastraPauta");
	return sessaoAberturaResponse;
	
  }
}