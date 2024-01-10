package academy.wakanda.wakacop.pauta.application.service;

import java.util.UUID;

import academy.wakanda.wakacop.pauta.domain.Pauta;

public interface PautaRepository {
	Pauta salva(Pauta pauta);
	Pauta buscaPautaPorId(UUID idPauta);

}
