/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aula.disciplina;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 1513003
 */
@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository repository;
    
    public List<Disciplina> listar() {
        return repository.findAll();
    }
    
    public Disciplina salvar(Disciplina entity) {
        Disciplina p = repository.save(entity);
        return p;
    }
    
    public Disciplina atualizar(Long id, DisciplinaForm form) {
        Disciplina entity = buscarPorId(id);
        DisciplinaMapper.INSTANCE.update(form, entity);
        return entity;
    }
    
    public Disciplina buscarPorId(Long id) {
        Optional<Disciplina> optional = repository.findById(id);
        if (optional.isEmpty()) {
            String msg = "Não existe Disciplina para o código [%d] informado";
            throw new DisciplinaNotFoundException(String.format(msg, id));
        }
        return optional.get();
    }

    public void excluir(Long id) {
        Disciplina entity = buscarPorId(id);
        repository.delete(entity);
    }
}
