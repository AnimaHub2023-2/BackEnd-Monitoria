package br.com.AnimaMonitoria.DTO.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InstituicaoResponse {
    private String nome;

    private String imgLogo;

    private String descricao;

    private LocalDateTime dtRegistro;

}
