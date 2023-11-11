package br.com.AnimaMonitoria.controoller;

import br.com.AnimaMonitoria.DTO.request.CursoRequest;
import br.com.AnimaMonitoria.DTO.response.CursoResponse;
import br.com.AnimaMonitoria.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/curso")
@RestController
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/buscar")
    public List<CursoResponse> buscarCampos() {
        return cursoService.buscarCursos();
    }

    @PostMapping("/cadastrar")
    public String cadastrarCurso(@RequestBody CursoRequest cursoRequest) {
        return cursoService.cadastrarCurso(cursoRequest);
    }

    @PutMapping("/atualizar")
    public String atualizarCurso(@RequestBody CursoRequest cursoRequest) {
        return cursoService.atualizarCurso(cursoRequest);
    }

    @DeleteMapping("/deletar")
    public String deletarCurso(@RequestParam Long idCurso) {
        return cursoService.deletarCurso(idCurso);
    }


}
