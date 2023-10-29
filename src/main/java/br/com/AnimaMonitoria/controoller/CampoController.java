package br.com.AnimaMonitoria.controoller;

import br.com.AnimaMonitoria.DTO.request.CamposRequest;
import br.com.AnimaMonitoria.DTO.request.InstituicaoRequest;
import br.com.AnimaMonitoria.DTO.response.CamposResponse;
import br.com.AnimaMonitoria.DTO.response.InstituicaoResponse;
import br.com.AnimaMonitoria.service.CamposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/campos")
@RestController
public class CampoController {

    @Autowired
    private CamposService camposService;

    @GetMapping("/buscar")
    public List<CamposResponse> buscarCampos() {
        return camposService.buscarCampos();
    }

    @PostMapping("/cadastrar")
    public String cadastrarCampos(@RequestBody CamposRequest camposRequest) {
        return camposService.cadastrarCampos(camposRequest);
    }

    @PutMapping("/atualizar")
    public String atualizarCampos(@RequestBody CamposRequest camposRequest) {
        return camposService.atualizarCampos(camposRequest);
    }

    @DeleteMapping("/deletar")
    public String deletarCampos(@RequestParam Long idCampos) {
        return camposService.deletarCampos(idCampos);
    }


}
