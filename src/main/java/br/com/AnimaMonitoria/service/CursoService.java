package br.com.AnimaMonitoria.service;

import br.com.AnimaMonitoria.DTO.request.CursoRequest;
import br.com.AnimaMonitoria.DTO.response.CursoResponse;

import java.util.List;

public interface CursoService {
    List<CursoResponse> buscarCursos();

    String cadastrarCurso(CursoRequest cursoRequest);

    String atualizarCurso(CursoRequest cursoRequest);

    String deletarCurso(Long idCurso);
}
