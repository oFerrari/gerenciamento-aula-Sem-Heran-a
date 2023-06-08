/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aula.disciplina;

import br.edu.ifms.aula.curso.CursoDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author 1513003
 */
@Data
@EqualsAndHashCode
@Builder
public class DisciplinaForm {

    private String nome;
    private Double cargaHoraria;
    private String ementa;
    
    private CursoDto curso;
}
