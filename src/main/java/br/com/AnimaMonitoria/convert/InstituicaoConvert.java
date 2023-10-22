package br.com.AnimaMonitoria.convert;

import br.com.AnimaMonitoria.DTO.request.InstituicaoRequest;
import br.com.AnimaMonitoria.model.Instituicao;
import org.springframework.beans.BeanUtils;

public class InstituicaoConvert {

    public static Instituicao convertInstituicaoRequestToInstituicao(InstituicaoRequest instituicaoRequest) {
        Instituicao instituicao = new Instituicao();
        BeanUtils.copyProperties(instituicaoRequest, instituicao);
        instituicao.setNome(instituicaoRequest.getNome().toUpperCase());
        return instituicao;
    }

}
