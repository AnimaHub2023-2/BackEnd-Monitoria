package br.com.AnimaMonitoria.service.impl;

import br.com.AnimaMonitoria.DTO.request.CamposRequest;
import br.com.AnimaMonitoria.DTO.request.InstituicaoRequest;
import br.com.AnimaMonitoria.DTO.response.CamposResponse;
import br.com.AnimaMonitoria.DTO.response.InstituicaoResponse;
import br.com.AnimaMonitoria.model.Campos;
import br.com.AnimaMonitoria.model.Instituicao;
import br.com.AnimaMonitoria.repository.CamposRepository;
import br.com.AnimaMonitoria.service.CamposService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CamposServiceImpl implements CamposService {

    @Autowired
    private CamposRepository camposRepository;

    @Override
    public List<CamposResponse> buscarCampos() {
        return converterCamposToCamposResponse(camposRepository.findAll());
    }

    @Override
    public String cadastrarCampos(CamposRequest camposRequest) {
        try {
            camposRepository.save(convertCamposRequestToCampos(camposRequest));
            return "Campos Salvo com sucesso";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String atualizarCampos(CamposRequest camposRequest) {
        Campos campos = camposRepository.findById(camposRequest.getId()).stream().findFirst().orElseThrow(() -> new RuntimeException("Erro ao atualizar campos"));
        try {
            campos.setImgCampos(camposRequest.getImgCampos() == null ? campos.getImgCampos() : camposRequest.getImgCampos() );
            campos.setUnidade(camposRequest.getUnidade() == null ? campos.getUnidade() : camposRequest.getUnidade());
            campos.setResponsavel(camposRequest.getResponsavel() == null ? campos.getResponsavel() : camposRequest.getResponsavel());
            campos.setIdInstituicao(camposRequest.getIdInstituicao() == null ? campos.getIdInstituicao() : camposRequest.getIdInstituicao());
            camposRepository.save(campos);
            return "Campos atualizada com sucesso";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletarCampos(Long idCampos) {
        try {
            camposRepository.deleteById(idCampos);
            return "Campos deletado com sucesso";

        } catch (Exception e) {
            return e.getMessage();
        }

    }

    private List<CamposResponse> converterCamposToCamposResponse(List<Campos> camposList) {
        List<CamposResponse> camposResponseList = new ArrayList<>();

        camposList.forEach(campos -> {
            CamposResponse camposResponse = new CamposResponse();
            BeanUtils.copyProperties(campos, camposResponse );
            camposResponseList.add(camposResponse);
        });

        return camposResponseList;
    }

    public Campos convertCamposRequestToCampos(CamposRequest CamposRequest) {
        Campos campos = new Campos();
        BeanUtils.copyProperties(CamposRequest, campos);
        return campos;
    }


}
