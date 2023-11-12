package br.com.AnimaMonitoria.controoller;

import br.com.AnimaMonitoria.DTO.request.MonitoriaRequest;
import br.com.AnimaMonitoria.DTO.response.MonitoriaResponse;
import br.com.AnimaMonitoria.service.MonitoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitoria")
public class MonitoriaController {

    @Autowired
    private MonitoriaService monitoriaService;

    @GetMapping("/buscar")
    public List<MonitoriaResponse> buscarMonitoria() {
        return monitoriaService.buscarMonitoria();
    }

    @PostMapping("/cadastrar")
    public String cadastrarMonitoria(@RequestBody MonitoriaRequest monitoriaRequest) {
        return monitoriaService.cadastrarMonitoria(monitoriaRequest);
    }

    @PutMapping("/atualizar")
    public String atualizarMonitoria(@RequestBody MonitoriaRequest monitoriaRequest) {
        return monitoriaService.atualizarMonitoria(monitoriaRequest);
    }

    @DeleteMapping("/deletar")
    public String deletarMonitoria(@RequestParam Long idMonitoria) {
        return monitoriaService.deletarMonitoria(idMonitoria);
    }


}
