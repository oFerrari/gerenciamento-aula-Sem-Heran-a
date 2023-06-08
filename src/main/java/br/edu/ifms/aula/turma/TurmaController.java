package br.edu.ifms.aula.turma;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.aula.professor.Professor;
import br.edu.ifms.aula.professor.ProfessorDto;
import br.edu.ifms.aula.professor.ProfessorForm;
import br.edu.ifms.aula.professor.ProfessorMapper;
import br.edu.ifms.aula.professor.ProfessorService;

/**
 *
 * @author 1513003
 */
@RestController
@RequestMapping("/api/turma")
public class TurmaController {
	  @Autowired // faz o Spring criar uma instância de ProfessorService
	    private TurmaService service;
	    
	    @GetMapping
	    public ResponseEntity<List<TurmaDto>> listar() {
	        List<Turma> listaEntity = service.listar();
	        List<TurmaDto> listaDto = TurmaMapper.INSTANCE.map(listaEntity);
	        return ResponseEntity.ok(listaDto);
	    }

	    @PostMapping
	    @Transactional
	    public ResponseEntity<TurmaDto> cadastrar(
	            @RequestBody @Valid TurmaForm form) {
	    	Turma entity = TurmaMapper.INSTANCE.toEntity(form);
	        service.salvar(entity);
	        TurmaDto dto = TurmaMapper.INSTANCE.toDto(entity);
	        return ResponseEntity.accepted().body(dto);
	    }
	    
	    @PutMapping("/{id}")
	    @Transactional
	    public ResponseEntity<TurmaDto> atualizar(
	            @PathVariable Long id,
	            @RequestBody @Valid TurmaForm form) {
	    	Turma entity = service.atualizar(id, form);
	    	TurmaDto dto = TurmaMapper.INSTANCE.toDto(entity);
	        return ResponseEntity.ok(dto);
	    }
	    
	    @DeleteMapping("/{id}")
	    @Transactional
	    public ResponseEntity<?> excluir(@PathVariable Long id) {
	        service.excluir(id);
	        return ResponseEntity.ok().build();
	    }

}
