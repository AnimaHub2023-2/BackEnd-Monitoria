package br.com.AnimaMonitoria.service.impl;

import br.com.AnimaMonitoria.DTO.request.MonitoriaRequest;
import br.com.AnimaMonitoria.DTO.response.MonitoriaResponse;
import br.com.AnimaMonitoria.model.Monitoria;
import br.com.AnimaMonitoria.repository.MonitoriaRepository;
import br.com.AnimaMonitoria.service.MonitoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonitoriaServiceImpl implements MonitoriaService {

    @Autowired
    private MonitoriaRepository monitoriaRepository;

    @Override
    public List<MonitoriaResponse> buscarMonitoria() {
        return monitoriaRepository.findAll().stream().map(this::converterMonitoriaToMonitoriaResponse).collect(Collectors.toList());
    }

    @Override
    public String cadastrarMonitoria(MonitoriaRequest monitoriaRequest) {
        try {
            monitoriaRepository.save(converterMonitoriaRequestToMonitoria(monitoriaRequest));
            return "Monitoria cadastrada com sucesso";
        }catch (Exception e) {
           return e.getMessage();
        }
    }

    @Override
    public String atualizarMonitoria(MonitoriaRequest monitoriaRequest) {
        Monitoria monitoria =  monitoriaRepository.findById(monitoriaRequest.getId()).stream().findFirst().orElseThrow(() -> new RuntimeException("Erro ao buscar monitoria para atualizar"));

        try {
            monitoria.setIdInstituicao(monitoriaRequest.getIdInstituicao() == null ? monitoria.getIdInstituicao() : monitoriaRequest.getIdInstituicao() );
            monitoria.setIdCampus(monitoriaRequest.getIdCampus() == null ? monitoria.getIdCampus() : monitoriaRequest.getIdCampus() );
            monitoria.setNomeProfessor(monitoriaRequest.getNomeProfessor() == null ? monitoria.getNomeProfessor() : monitoriaRequest.getNomeProfessor() );
            monitoria.setSobrenomeProfessor(monitoriaRequest.getSobrenomeProfessor() == null ? monitoria.getSobrenomeProfessor() : monitoriaRequest.getSobrenomeProfessor() );
            monitoria.setCpfProfessor(monitoriaRequest.getCpfProfessor() == null ? monitoria.getCpfProfessor() : monitoriaRequest.getCpfProfessor() );
            monitoria.setEmailProfessor(monitoriaRequest.getEmailProfessor() == null ? monitoria.getEmailProfessor() : monitoriaRequest.getEmailProfessor() );
            monitoria.setTelefoneProfessor(monitoriaRequest.getTelefoneProfessor() == null ? monitoria.getTelefoneProfessor() : monitoriaRequest.getTelefoneProfessor() );
            monitoria.setModalidade(monitoriaRequest.getModalidade() == null ? monitoria.getModalidade() : monitoriaRequest.getModalidade() );
            monitoria.setHorario(monitoriaRequest.getHorario() == null ? monitoria.getHorario() : monitoriaRequest.getHorario() );
            monitoria.setData(monitoriaRequest.getData() == null ? monitoria.getData() : monitoriaRequest.getData() );
            monitoriaRepository.save(monitoria);

            return "Monitoria atualizada com sucesso";

        }catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletarMonitoria(Long idMonitoria) {
        try {
            monitoriaRepository.deleteById(idMonitoria);
            return "Monitoria deletada com sucesso";
        }catch (Exception e) {
            return e.getMessage();
        }
    }

    public MonitoriaResponse converterMonitoriaToMonitoriaResponse(Monitoria monitoria) {
        MonitoriaResponse monitoriaResponse = new MonitoriaResponse();
        BeanUtils.copyProperties(monitoria, monitoriaResponse);
        return monitoriaResponse;
    }

    public static Monitoria converterMonitoriaRequestToMonitoria(MonitoriaRequest monitoriaRequest) {
        Monitoria monitoria = new Monitoria();
        BeanUtils.copyProperties(monitoriaRequest, monitoria);
        return monitoria;
    }
}
