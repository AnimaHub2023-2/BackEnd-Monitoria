package br.com.AnimaMonitoria.service;

import br.com.AnimaMonitoria.DTO.request.MonitoriaRequest;
import br.com.AnimaMonitoria.DTO.response.MonitoriaResponse;

import java.util.List;

public interface MonitoriaService {
    List<MonitoriaResponse> buscarMonitoria();

    String cadastrarMonitoria(MonitoriaRequest monitoriaRequest);

    String atualizarMonitoria(MonitoriaRequest monitoriaRequest);

    String deletarMonitoria(Long idMonitoria);
}
