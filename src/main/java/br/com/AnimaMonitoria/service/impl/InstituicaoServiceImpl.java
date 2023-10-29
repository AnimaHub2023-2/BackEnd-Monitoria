package br.com.AnimaMonitoria.service.impl;

import br.com.AnimaMonitoria.DTO.request.InstituicaoRequest;
import br.com.AnimaMonitoria.DTO.response.InstituicaoResponse;
import br.com.AnimaMonitoria.model.Instituicao;
import br.com.AnimaMonitoria.repository.InstituicaoRepository;
import br.com.AnimaMonitoria.service.InstituicaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.AnimaMonitoria.convert.InstituicaoConvert.convertInstituicaoRequestToInstituicao;

@Service
public class InstituicaoServiceImpl implements InstituicaoService {

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @Override
    public String cadastrarInstituicao(InstituicaoRequest instituicaoRequest) {
        try {
            instituicaoRepository.save(convertInstituicaoRequestToInstituicao(instituicaoRequest));
            return "Instituição cadastrada com sucesso";

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List<InstituicaoResponse> buscarInstituicoes() {
        return instituicaoRepository.findAllOrderBynome().stream().map(this::convertInstituicaoToInstituicaoResponse).collect(Collectors.toList());
    }

    @Override
    public String atualizarInstituicao(InstituicaoRequest instituicaoRequest) {

        Instituicao instituicao = instituicaoRepository.findById(instituicaoRequest.getId()).stream().findFirst().orElseThrow(() -> new RuntimeException("Erro ao atualizar Instituição"));
        try {
            instituicao.setImgLogo(instituicaoRequest.getImgLogo() == null ? instituicao.getImgLogo() : instituicaoRequest.getImgLogo() );
            instituicao.setDescricao(instituicaoRequest.getDescricao() == null ? instituicao.getDescricao() : instituicaoRequest.getDescricao());
            instituicao.setNome(instituicaoRequest.getNome() == null ? instituicao.getNome() : instituicaoRequest.getNome());

            instituicaoRepository.save(instituicao);
            return "Instituição atualizada com sucesso";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletarInstituicao(Long idInstituicao) {
        try {
            instituicaoRepository.deleteById(idInstituicao);
            return "Instituição deletado com sucesso";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public InstituicaoResponse convertInstituicaoToInstituicaoResponse(Instituicao instituicao) {
        InstituicaoResponse instituicaoResponse = new InstituicaoResponse();
        BeanUtils.copyProperties(instituicao, instituicaoResponse );
        return instituicaoResponse;
    }


}
