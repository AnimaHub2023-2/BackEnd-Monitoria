package br.com.AnimaMonitoria.DTO.request;

import lombok.Data;

@Data
public class CamposRequest {

    private Long id;

    private Long idInstituicao;

    private String unidade;

    private String imgCampos;

    private String responsavel;

}
