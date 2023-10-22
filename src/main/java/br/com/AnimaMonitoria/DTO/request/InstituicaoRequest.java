package br.com.AnimaMonitoria.DTO.request;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class InstituicaoRequest {

    private Long id;

    private String nome;

    private String imgLogo;

    private String descricao;

    private LocalDateTime dtRegistro;
}
