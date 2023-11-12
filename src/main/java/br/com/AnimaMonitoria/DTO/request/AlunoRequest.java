package br.com.AnimaMonitoria.DTO.request;

import lombok.Data;

@Data
public class AlunoRequest {

    private String nome;

    private String sobrenome;

    private String ra;

    private String email;

    private int semestre;

    private String periodo;

    private String instituicao;

    private String campos;

    private String monitoria;

    private Boolean monitor;

    private Boolean ucCursada;

    private String areaConhecimento;
}
