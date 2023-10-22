package br.com.AnimaMonitoria.controoller;

import br.com.AnimaMonitoria.DTO.request.InstituicaoRequest;
import br.com.AnimaMonitoria.DTO.response.InstituicaoResponse;
import br.com.AnimaMonitoria.service.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/instituicao")
@RestController
public class
InstituicaoController {

    @Autowired
    private InstituicaoService instituicaoService;

    @GetMapping("/buscar")
    public List<InstituicaoResponse> buscarInstituicoes() {
        return instituicaoService.buscarInstituicoes();
    }

    @PostMapping("/cadastrar")
    public String cadastrarInstituicao(@RequestBody InstituicaoRequest instituicaoRequest) {
        return instituicaoService.cadastrarInstituicao(instituicaoRequest);
    }

    @PutMapping("/atualizar")
    public String atualizarInstituicao(@RequestBody InstituicaoRequest instituicaoRequest) {
        return instituicaoService.atualizarInstituicao(instituicaoRequest);
    }

    @DeleteMapping("/deletar")
    public String deletarInstituicao(@RequestParam Long idInstituicao) {
        return instituicaoService.deletarInstituicao(idInstituicao);
    }


}
