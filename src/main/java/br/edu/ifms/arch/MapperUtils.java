/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.arch;

/**
 *
 * @author nicho
 */
public class MapperUtils {
    private static final String ERROR_MESSAGE = "O MAPPER ainda n�o foi atribu�do � classe %s.";
    
    public static void validate(Class clazz, ISimpleMapper mapper) {
        if (mapper == null) {
            throw new UnsupportedOperationException(
                    String.format(ERROR_MESSAGE, 
                            clazz.getName())
            );
        }
    }
}
