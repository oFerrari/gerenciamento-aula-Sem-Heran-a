/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aula.disciplina;

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

/**
 *
 * @author 1513003
 */
@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaController {
    @Autowired // faz o Spring criar uma instância de DisciplinaService
    private DisciplinaService service;
    
    @GetMapping
    public ResponseEntity<List<DisciplinaDto>> listar() {
        List<Disciplina> listaEntity = service.listar();
        List<DisciplinaDto> listaDto = DisciplinaMapper.INSTANCE.map(listaEntity);
        return ResponseEntity.ok(listaDto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DisciplinaDto> cadastrar(
            @RequestBody @Valid DisciplinaForm form) {
        Disciplina entity = DisciplinaMapper.INSTANCE.toEntity(form);
        service.salvar(entity);
        DisciplinaDto dto = DisciplinaMapper.INSTANCE.toDto(entity);
        return ResponseEntity.accepted().body(dto);
    }
    
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DisciplinaDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid DisciplinaForm form) {
        Disciplina entity = service.atualizar(id, form);
        DisciplinaDto dto = DisciplinaMapper.INSTANCE.toDto(entity);
        return ResponseEntity.ok(dto);
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}
