package br.com.AnimaMonitoria.DTO.request;

import lombok.Data;

@Data
public class CursoRequest {

    private Long id;

    private Long idCampos;

    private String nome;
}
