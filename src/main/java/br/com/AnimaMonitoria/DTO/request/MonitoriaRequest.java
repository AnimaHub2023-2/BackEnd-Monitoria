package br.com.AnimaMonitoria.DTO.request;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class MonitoriaRequest {

    private Long id;

    private Long idInstituicao;

    private Long idCampus;

    private String nomeProfessor;

    private String sobrenomeProfessor;

    @NotBlank(message = "Formato CPF incorreto")
    @CPF
    private String cpfProfessor;

    private String emailProfessor;

    private String telefoneProfessor;

    private String modalidade;

    private String horario;

    private LocalDateTime data;

}
