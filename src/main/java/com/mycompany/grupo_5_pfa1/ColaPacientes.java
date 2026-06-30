package com.mycompany.grupo_5_pfa1;

/**
 * Cola especializada para la gestión de pacientes en el hospital.
 * 
 * Extiende {@link ColaBase} heredando toda la lógica FIFO de encolar,
 * desencolar y eliminación por ficha. Esta clase existe para diferenciar
 * semánticamente la cola regular de la preferencial sin duplicar código.
 *
 * @author Grupo 5
 * @version 1.0
 * @see ColaBase
 */
public class ColaPacientes extends ColaBase {

    /**
     * Construye una cola de pacientes vacía invocando al constructor de
     * {@link ColaBase}.
     */
    public ColaPacientes() {
        super();
    }
}
