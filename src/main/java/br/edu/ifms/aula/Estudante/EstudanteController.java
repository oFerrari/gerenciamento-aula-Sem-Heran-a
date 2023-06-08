/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aula.Estudante;


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
 * @author 07041626105
 */
@RestController
@RequestMapping("/api/estudante")
public class EstudanteController {
     @Autowired // faz o Spring criar uma instância de DiciplinaService
    private EstudanteService service;
    
    @GetMapping
    public ResponseEntity<List<EstudanteDto>> listar() {
        List<Estudante> listaEntity = service.listar();
        List<EstudanteDto> listaDto = EstudanteMapper.INSTANCE.map(listaEntity);
        return ResponseEntity.ok(listaDto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EstudanteDto> cadastrar(
            @RequestBody @Valid EstudanteForm form) {
        Estudante entity = EstudanteMapper.INSTANCE.toEntity(form);
        service.salvar(entity);
        EstudanteDto dto = EstudanteMapper.INSTANCE.toDto(entity);
        return ResponseEntity.accepted().body(dto);
    }
    
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EstudanteDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid EstudanteForm form) {
        Estudante entity = service.atualizar(id, form);
        EstudanteDto dto = EstudanteMapper.INSTANCE.toDto(entity);
        return ResponseEntity.ok(dto);
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}
