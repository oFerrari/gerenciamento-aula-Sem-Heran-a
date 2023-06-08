/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aula.periodo;

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


@RestController
@RequestMapping("/api/periodo")
public class PeriodoController {
    @Autowired // faz o Spring criar uma instância de PeriodoService
    private PeriodoService service;
    
    @GetMapping
    public ResponseEntity<List<PeriodoDto>> listar() {
        List<Periodo> listaEntity = service.listar();
        List<PeriodoDto> listaDto = PeriodoMapper.INSTANCE.map(listaEntity);
        return ResponseEntity.ok(listaDto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PeriodoDto> cadastrar(
            @RequestBody @Valid PeriodoForm form) {
        Periodo entity = PeriodoMapper.INSTANCE.toEntity(form);
        service.salvar(entity);
        PeriodoDto dto = PeriodoMapper.INSTANCE.toDto(entity);
        return ResponseEntity.accepted().body(dto);
    }
    
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PeriodoDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid PeriodoForm form) {
        Periodo entity = service.atualizar(id, form);
        PeriodoDto dto = PeriodoMapper.INSTANCE.toDto(entity);
        return ResponseEntity.ok(dto);
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }

}
