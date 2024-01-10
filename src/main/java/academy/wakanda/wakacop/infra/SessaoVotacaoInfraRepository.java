package academy.wakanda.wakacop.infra;

import org.springframework.stereotype.Repository;

import academy.wakanda.wakacop.sessaovotacao.domain.SessaoVotacao;
import academy.wakanda.wakacop.sessaovotacao.service.SessaoVotacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoInfraRepository implements SessaoVotacaoRepository {
	private final SessaoVotacaoSpringDataJPARepository sessaoVotacaoSpringDataJPARepository;

	@Override
	public SessaoVotacao salva(SessaoVotacao sessaoVotacao) {
		log.info("[start] SessaoVotacaoInfraRepository - salva");
		sessaoVotacaoSpringDataJPARepository.save(sessaoVotacao);
		log.info("[finish] SessaoVotacaoInfraRepository - salva");
		return sessaoVotacao;
	}
}
