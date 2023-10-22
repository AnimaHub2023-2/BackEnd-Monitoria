package br.com.AnimaMonitoria.service;

import br.com.AnimaMonitoria.DTO.request.InstituicaoRequest;
import br.com.AnimaMonitoria.DTO.response.InstituicaoResponse;

import java.util.List;

public interface InstituicaoService {
    String cadastrarInstituicao(InstituicaoRequest instituicaoRequest);

    List<InstituicaoResponse> buscarInstituicoes();

    String atualizarInstituicao(InstituicaoRequest instituicaoRequest);

    String deletarInstituicao(Long idInstituicao);
}
