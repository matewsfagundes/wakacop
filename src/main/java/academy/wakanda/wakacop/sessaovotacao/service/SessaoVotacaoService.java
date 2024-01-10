package academy.wakanda.wakacop.sessaovotacao.service;

import academy.wakanda.wakacop.sessaovotacao.application.api.SessaoAberturaRequest;
import academy.wakanda.wakacop.sessaovotacao.application.api.SessaoAberturaResponse;

public interface SessaoVotacaoService {
	SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);

}
