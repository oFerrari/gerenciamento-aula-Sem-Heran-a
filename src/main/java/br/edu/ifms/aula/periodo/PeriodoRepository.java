/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.aula.periodo;

import br.edu.ifms.aula.professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 07180871192
 */
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
    
}
