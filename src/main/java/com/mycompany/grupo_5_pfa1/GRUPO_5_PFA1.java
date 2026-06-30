package com.mycompany.grupo_5_pfa1;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Punto de entrada principal del sistema de gestión de atención del
 * Hospital Su Salud.
 * 
 * Inicializa las estructuras de datos ({@link ColaPacientes} regular y
 * preferencial, {@link PilaQuejas} y {@link GestorAtencion}) y presenta
 * al usuario un menú principal con las opciones:
 *
 *Gestionar Llegada de Pacientes
 *Ayuda
 *Salir
 * 
 *
 * @author Grupo 5
 * @version 1.0.1
 */
public class GRUPO_5_PFA1 {

    /**
     * Método principal que arranca el sistema.
     * 
     * Crea las estructuras de datos, muestra el mensaje de bienvenida en
     * consola y presenta el menú principal en un bucle hasta que el usuario
     * seleccione "Salir" o cierre la ventana.
     * 
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        System.out.println("¡Bienvenido al sistema del Hospital Su Salud!");

        ColaPacientes colaRegular      = new ColaPacientes();
        ColaPacientes colaPreferencial = new ColaPacientes();
        PilaQuejas    pilaQuejas       = new PilaQuejas();
        GestorAtencion gestor          = new GestorAtencion(colaPreferencial, colaRegular);

        String[] opcionesMenu = {
            "1. Gestionar Llegada de Pacientes",
            "2. Ayuda",
            "3. Salir"
        };

        boolean ejecutando = true;
        while (ejecutando) {
            int opcion = JOptionPane.showOptionDialog(
                null,
                "¡Bienvenido al sistema del Hospital Su Salud!\nSeleccione una opción:",
                "Menú Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcionesMenu,
                opcionesMenu[0]
            );

            switch (opcion) {
                case 0 -> mostrarSubmenu(gestor, colaRegular, colaPreferencial, pilaQuejas);
                case 1 -> mostrarAyuda();
                default -> {
                    ejecutando = false;
                    JOptionPane.showMessageDialog(
                        null,
                        "Gracias por usar el sistema. ¡Hasta luego!",
                        "Salir",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        }
    }

    /**
     * Muestra el submenú de Gestionar Llegada de Pacientes con sus
     * seis opciones y permanece activo hasta que el usuario seleccione
     * "Regresar" o cierre la ventana.
     *
     * @param gestor           gestor de atención activo en la sesión
     * @param colaRegular      cola de pacientes regulares
     * @param colaPreferencial cola de pacientes preferenciales
     * @param pilaQuejas       pila de quejas del sistema
     */
    private static void mostrarSubmenu(
            GestorAtencion gestor,
            ColaPacientes colaRegular,
            ColaPacientes colaPreferencial,
            PilaQuejas pilaQuejas) {

        String[] opciones = {
            "1. Seleccionar Ficha",
            "2. Atender Paciente",
            "3. Abandonar Cola de Pacientes",
            "4. Mostrar Fichas Pendientes",
            "5. Mostrar Quejas Recibidas",
            "6. Regresar"
        };

        boolean enSubmenu = true;
        while (enSubmenu) {
            int opcion = JOptionPane.showOptionDialog(
                null,
                "Gestionar Llegada de Pacientes\nSeleccione una opción:",
                "Submenú — Hospital Su Salud",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            switch (opcion) {
                case 0 -> gestor.seleccionarFicha();
                case 1 -> gestor.atenderPaciente();
                case 2 -> pilaQuejas.abandonarColaInteractivo(colaRegular, colaPreferencial);
                case 3 -> mostrarFichasPendientes(colaRegular, colaPreferencial);
                case 4 -> pilaQuejas.mostrarPila();
                default -> enSubmenu = false;
            }
        }
    }

    /**
     * Muestra en consola y en una ventana {@code JOptionPane} las fichas
     * pendientes de la cola preferencial y la cola regular, cada una con su
     * distintivo de color.
     * 
     * Distintivos utilizados:
     * 
     * Preferencial: {@code [PREFERENCIAL - NARANJA]}
     * Regular:      {@code [REGULAR - VERDE]}
     *
     * @param colaRegular      cola de pacientes regulares
     * @param colaPreferencial cola de pacientes preferenciales
     */
    private static void mostrarFichasPendientes(
            ColaPacientes colaRegular,
            ColaPacientes colaPreferencial) {

        System.out.println("\n--- Fichas Pendientes ---");
        colaPreferencial.mostrarCola("[PREFERENCIAL - NARANJA]");
        colaRegular.mostrarCola("[REGULAR - VERDE]");

        StringBuilder sb = new StringBuilder();
        sb.append("=== [PREFERENCIAL - NARANJA] ===\n");
        sb.append(obtenerTextoCola(colaPreferencial));
        sb.append("\n=== [REGULAR - VERDE] ===\n");
        sb.append(obtenerTextoCola(colaRegular));

        JOptionPane.showMessageDialog(
            null,
            sb.toString(),
            "Fichas Pendientes",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Genera y retorna una cadena con los datos de todos los pacientes de
     * la cola indicada, formateados para mostrarse en la ventana de
     * fichas pendientes.
     * 
     * Accede al campo {@code frente} (protegido en {@link ColaBase}) ya que
     * esta clase se encuentra en el mismo paquete.
     * 
     *
     * @param cola cola cuyos pacientes se desean listar
     * @return cadena con una línea por paciente, o
     *         {@code "  No hay fichas pendientes.\n"} si la cola está vacía
     */
    private static String obtenerTextoCola(ColaPacientes cola) {
        if (cola.esVacia()) {
            return "  No hay fichas pendientes.\n";
        }
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        NodoPaciente aux = cola.frente;
        while (aux != null) {
            Paciente p = aux.getPaciente();
            sb.append("  Ficha: ").append(p.getFicha())
              .append(" | Cédula: ").append(p.getCedula())
              .append(" | Nombre: ").append(p.getNombre())
              .append(" | Llegada: ").append(sdf.format(p.getFechaLlegada()))
              .append("\n");
            aux = aux.getSiguiente();
        }
        return sb.toString();
    }

    /**
     * Muestra una ventana de ayuda con la versión del sistema, los nombres
     * de los desarrolladores y una descripción de cada opción disponible en
     * el submenú de gestión de pacientes.
     */
    private static void mostrarAyuda() {
        String mensaje =
            "=== AYUDA — Sistema Hospital Su Salud ===\n\n" +
            "Versión: Avance 1 V 1.0.1\n\n" +
            "Desarrollado por Grupo 5:\n" +
            "  • [Camila Cabrera Camacho]\n" +
            "  • [Diego Armando Jimenez]\n" +
            "  • [Ismael Sanbria Moya]\n\n" +
            "  • [Israel Apuy Martinez]\n\n" +
            "Opciones disponibles en Gestionar Llegada de Pacientes:\n" +
            "  1. Seleccionar Ficha         — Registra un paciente (Regular o Preferencial)\n" +
            "  2. Atender Paciente          — Atiende según regla 2 preferenciales : 1 regular\n" +
            "  3. Abandonar Cola            — Retira una ficha y registra la queja\n" +
            "  4. Mostrar Fichas Pendientes — Lista ambas colas con distintivo de color\n" +
            "  5. Mostrar Quejas Recibidas  — Lista todas las quejas registradas\n" +
            "  6. Regresar                 — Vuelve al menú principal";

        JOptionPane.showMessageDialog(
            null,
            mensaje,
            "Ayuda",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
