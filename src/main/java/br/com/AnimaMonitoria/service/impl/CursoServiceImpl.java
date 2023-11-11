package br.com.AnimaMonitoria.service.impl;

import br.com.AnimaMonitoria.DTO.request.CursoRequest;
import br.com.AnimaMonitoria.DTO.response.CursoResponse;
import br.com.AnimaMonitoria.model.Curso;
import br.com.AnimaMonitoria.repository.CursoRepository;
import br.com.AnimaMonitoria.service.CursoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<CursoResponse> buscarCursos() {
        return cursoRepository.findAll().stream().map(this::converterCursoToCursoResponse).collect(Collectors.toList());
    }

    @Override
    public String cadastrarCurso(CursoRequest cursoRequest) {
        try {
            Curso curso = converterCursoRequestToCurso(cursoRequest);
            cursoRepository.save(curso);
            return "Curso cadastrado com sucesso";
        }catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String atualizarCurso(CursoRequest cursoRequest) {

        Curso curso = cursoRepository.findById(cursoRequest.getId()).stream().findFirst().orElseThrow(() -> new RuntimeException("Erro ao buscar curso"));
        try {
            curso.setNome(cursoRequest.getNome() == null ? curso.getNome() : cursoRequest.getNome() );
            curso.setIdCampos(cursoRequest.getIdCampos() == null ? curso.getIdCampos() : cursoRequest.getIdCampos());

            cursoRepository.save(curso);
            return "Curso atualizada com sucesso";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletarCurso(Long idCurso) {
        try {
            cursoRepository.deleteById(idCurso);
            return "Curso deletado com sucesso";
        }catch (Exception e) {
            return e.getMessage();
        }
    }

    public CursoResponse converterCursoToCursoResponse(Curso curso) {
        CursoResponse cursoResponse = new CursoResponse();
        BeanUtils.copyProperties(curso, cursoResponse);
        return cursoResponse;
    }

    public static Curso converterCursoRequestToCurso(CursoRequest cursoRequest) {
        Curso curso = new Curso();
        BeanUtils.copyProperties(cursoRequest, curso);
        return curso;
    }
}
