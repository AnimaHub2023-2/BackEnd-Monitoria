package br.com.AnimaMonitoria.DTO.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MonitoriaResponse {

    private Long id;

    private Long idInstituicao;

    private Long idCampus;

    private String nomeProfessor;

    private String sobrenomeProfessor;

    private String cpfProfessor;

    private String emailProfessor;

    private String telefoneProfessor;

    private String modalidade;

    private String horario;

    private LocalDateTime data;

}
