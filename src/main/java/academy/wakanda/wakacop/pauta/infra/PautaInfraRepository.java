package academy.wakanda.wakacop.pauta.infra;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import academy.wakanda.wakacop.pauta.application.service.PautaRepository;
import academy.wakanda.wakacop.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PautaInfraRepository implements PautaRepository {
	private final PautaSprigDataJpaRepository pautaSprigDataJpaRepository;

	@Override
	public Pauta salva(Pauta pauta) {
		log.info("[start] PautaInfraRepository - salva");
		pautaSprigDataJpaRepository.save(pauta);
		log.info("[finish] PautaInfraRepository - salva");
		return pauta;
	}

	@Override
	public Pauta buscaPautaPorId(UUID idPauta) {
		log.info("[start] PautaInfraRepository - buscaPautaPorId");
		Pauta pautaPorId = pautaSprigDataJpaRepository.findById(idPauta)
				.orElseThrow(() -> new RuntimeException("pauta não encontrada"));
		log.info("[finish] PautaInfraRepository - buscaPautaPorId");
		return pautaPorId;
	}

}
