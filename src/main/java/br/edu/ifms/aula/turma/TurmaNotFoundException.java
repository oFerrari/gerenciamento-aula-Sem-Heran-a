package br.edu.ifms.aula.turma;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Turma nao encontrada")
public class TurmaNotFoundException extends ResponseStatusException {

    public TurmaNotFoundException(String errorMessage) {
        super(HttpStatus.NOT_FOUND, errorMessage);
}}
