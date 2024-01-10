package academy.wakanda.wakacop.pauta.application.service;

import java.util.UUID;

import academy.wakanda.wakacop.pauta.application.api.NovaPautaRequest;
import academy.wakanda.wakacop.pauta.application.api.PautaCadastradaResponse;
import academy.wakanda.wakacop.pauta.domain.Pauta;

public interface PautaService{
	PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta);
	Pauta getPautaPorId(UUID idPauta);


}
