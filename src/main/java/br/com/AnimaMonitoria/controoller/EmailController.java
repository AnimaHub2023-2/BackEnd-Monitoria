package br.com.AnimaMonitoria.controoller;

import br.com.AnimaMonitoria.DTO.request.AlunoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {


    @PostMapping("envio-aluno")
    public ResponseEntity<?> envirEmailAluno(AlunoRequest alunoRequest) {
        return null;
    }


}
