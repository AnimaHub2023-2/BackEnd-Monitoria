package br.com.AnimaMonitoria.service;

import br.com.AnimaMonitoria.DTO.request.CamposRequest;
import br.com.AnimaMonitoria.DTO.response.CamposResponse;

import java.util.List;

public interface CamposService {
    List<CamposResponse> buscarCampos();

    String cadastrarCampos(CamposRequest camposRequest);

    String atualizarCampos(CamposRequest camposRequest);

    String deletarCampos(Long idCampos);
}
