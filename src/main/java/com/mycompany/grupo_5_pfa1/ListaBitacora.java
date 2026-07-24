package com.mycompany.grupo_5_pfa1;

/**
 * Lista simple para almacenar la bitácora de citas atendidas durante el día.
 *
 * @author Diego
 */
public class ListaBitacora {

    private NodoBitacora primero;
    private NodoBitacora ultimo;

    /**
     * Constructor de la lista de bitácora.
     */
    public ListaBitacora() {

        this.primero = null;
        this.ultimo = null;
    }

    /**
     * Retorna el primer nodo de la lista.
     *
     * @return Primer nodo.
     */
    public NodoBitacora getPrimero() {
        return primero;
    }

    /**
     * Modifica el primer nodo de la lista.
     *
     * @param primero Nuevo primer nodo.
     */
    public void setPrimero(NodoBitacora primero) {
        this.primero = primero;
    }

    /**
     * Retorna el último nodo de la lista.
     *
     * @return Último nodo.
     */
    public NodoBitacora getUltimo() {
        return ultimo;
    }

    /**
     * Modifica el último nodo de la lista.
     *
     * @param ultimo Nuevo último nodo.
     */
    public void setUltimo(NodoBitacora ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si está vacía, false si contiene datos.
     */
    public boolean estaVacia() {

        if (primero == null) {

            return true;
        }

        return false;
    }

    /**
     * Inserta una cita atendida al final de la lista simple.
     *
     * @param bitacoraCita Cita atendida que se desea insertar.
     */
    public void insertarFinal(BitacoraCita bitacoraCita) {

        NodoBitacora nuevoNodo = new NodoBitacora(bitacoraCita);

        if (primero == null) {

            primero = nuevoNodo;
            ultimo = nuevoNodo;

        } else {

            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }

    /**
     * Retorna todas las citas atendidas durante la sesión.
     *
     * @return Información completa de la bitácora.
     */
    public String mostrarBitacora() {

        String texto = "";

        if (primero == null) {

            texto = "No hay citas registradas en la bitácora del día.";

        } else {

            NodoBitacora aux = primero;

            while (aux != null) {

                texto = texto + aux.getDato().mostrarDatos()
                        + "\n-----------------------------\n";

                aux = aux.getSiguiente();
            }
        }

        return texto;
    }

    /**
     * Retorna todas las citas atendidas durante la sesión en formato HTML,
     * resaltando cada registro con un distintivo de color según su tiempo
     * de espera:
     * 
     * Verde: de 1 a 30 segundos.
     * Amarillo: más de 30 segundos y menos de 1 minuto.
     * Rojo: más de 1 minuto.
     * 
     * Pensado para presentarse dentro de un {@code JOptionPane}, ya que
     * Swing interpreta las etiquetas HTML dentro del mensaje.
     *
     * @author Camila Cabrera
     */
    public String mostrarBitacoraConColor() {

        StringBuilder html = new StringBuilder("<html><body style='font-family:monospace; width:320px;'>");

        if (primero == null) {

            html.append("No hay citas registradas en la bitácora del día.");

        } else {

            NodoBitacora aux = primero;

            while (aux != null) {

                BitacoraCita cita = aux.getDato();
                String colorHex = obtenerColorHex(cita.getCodigoColor());

                html.append("<div style='color:").append(colorHex).append("; margin-bottom:8px;'>")
                        .append("<b>[").append(cita.getCodigoColor()).append("]</b><br>")
                        .append("Cédula: ").append(cita.getCedula()).append("<br>")
                        .append("Nombre: ").append(cita.getNombreCompleto()).append("<br>")
                        .append("Llegada: ").append(cita.getFechaHoraLlegada()).append("<br>")
                        .append("Atención: ").append(cita.getFechaHoraAtencion()).append("<br>")
                        .append("Tiempo de espera: ").append(cita.getTiempoEsperaSegundos())
                        .append(" segundos</div><hr>");

                aux = aux.getSiguiente();
            }
        }

        html.append("</body></html>");

        return html.toString();
    }

    /**
     * Traduce el código de color textual de una cita (VERDE, AMARILLO,
     * ROJO) a su valor hexadecimal correspondiente para uso en HTML.
     *
     * @param codigoColor Código de color calculado en {@link BitacoraCita}.
     * @return Valor hexadecimal del color.
     */
    private String obtenerColorHex(String codigoColor) {

        switch (codigoColor) {

            case "VERDE":
                return "#1B7A1B";

            case "AMARILLO":
                return "#B8860B";

            case "ROJO":
                return "#C0392B";

            default:
                return "#000000";
        }
    }
}
