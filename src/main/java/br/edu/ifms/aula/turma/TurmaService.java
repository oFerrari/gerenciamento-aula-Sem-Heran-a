package br.edu.ifms.aula.turma;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.aula.professor.Professor;
import br.edu.ifms.aula.professor.ProfessorForm;
import br.edu.ifms.aula.professor.ProfessorMapper;
import br.edu.ifms.aula.professor.ProfessorNotFoundException;
import br.edu.ifms.aula.professor.ProfessorRepository;


@Service
public class TurmaService {

	@Autowired
    private TurmaRepository repository;
    
    public List<Turma> listar() {
        return repository.findAll();
    }
    
    public Turma salvar(Turma entity) {
    	Turma p = repository.save(entity);
        return p;
    }
    
    public Turma atualizar(Long id, TurmaForm form) {
    	Turma entity = buscarPorId(id);
    	TurmaMapper.INSTANCE.update(form, entity);
        return entity;
    }
    
    public Turma buscarPorId(Long id) {
        Optional<Turma> optional = repository.findById(id);
        if (optional.isEmpty()) {
            String msg = "Não existe Professor para o código [%d] informado";
            throw new TurmaNotFoundException(String.format(msg, id));
        }
        return optional.get();
    }

    public void excluir(Long id) {
    	Turma entity = buscarPorId(id);
        repository.delete(entity);
    }
}
