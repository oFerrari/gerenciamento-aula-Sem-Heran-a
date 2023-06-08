/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.arch.dto;

/**
 * Interface para Formul�rio para BaseObject. Interface utilizada para definir
 os m�todos b�sicos para a implementa��o do padr�o DTO para envio de dados
 para os servi�os cuja Classe de Neg�cio seja uma subclasse de
 <class>BaseObject</class>.
 *
 * @author santos
 */
public interface IBaseForm {
    
    String getNome();
    void setNome(String value);
}
