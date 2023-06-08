/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aula.disciplina;

import br.edu.ifms.aula.curso.CursoDto;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 *
 * @author 1513003
 */
@Getter
@EqualsAndHashCode
@Builder
public class DisciplinaDto {

    private Long id;
    private String nome;
    private Double cargaHoraria;
    private String ementa;
    private CursoDto curso;
}
