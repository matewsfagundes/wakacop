package academy.wakanda.wakacop.sessaovotacao.service;

import org.springframework.stereotype.Service;

import academy.wakanda.wakacop.sessaovotacao.application.api.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.SessaoAberturaResponse;
import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoApplicationService implements SessaoVotacaoService {
	private final SessaoVotacaoRepository sessaoVotacaoRepository;

	@Override
	public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
		log.info("[start] SessaoVotacaoApplicationService - abreSessao");
		SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.salva(new SessaoVotacao(sessaoAberturaRequest));
		log.info("[finish] SessaoVotacaoApplicationService - abreSessao");
		return new SessaoAberturaResponse(sessaoVotacao);
	}

}
