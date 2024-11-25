package co.com.udea.certificacion.busquedavuelosa.utils;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import static co.com.udea.certificacion.busquedavuelosa.userinterfaces.BusquedaVuelosPage.*;

public class DateUtils {

    public static <T extends Actor> void seleccionarFecha(T actor, String fecha) {
        String[] partesFecha = fecha.split("-");
        String anio = partesFecha[0];
        String mes = partesFecha[1];
        String dia = partesFecha[2];

        String mesEnIngles = obtenerNombreMes(mes);
        String diaNormalizado = normalizarNumero(dia);

        boolean mesCorrecto = false;

        while (!mesCorrecto) {
            String textoCalendario = CONTENEDOR_CALENDARIO.resolveFor(actor).getText();
            if (textoCalendario.contains(mesEnIngles + " " + anio)) {
                mesCorrecto = true;
            } else {
                actor.attemptsTo(
                        Click.on(BOTON_SIGUIENTE_MES)
                );
            }
        }
        ListOfWebElementFacades diasVisibles = DIA_EN_CALENDARIO(diaNormalizado).resolveAllFor(actor);
        if (diasVisibles.size() == 1) {
            actor.attemptsTo(
                    Click.on(diasVisibles.get(0))
            );
        } else if (diasVisibles.size() > 1) {
            if (Integer.parseInt(diaNormalizado) < 15) {
                actor.attemptsTo(
                        Click.on(diasVisibles.get(0))
                );
            } else {
                actor.attemptsTo(
                        Click.on(diasVisibles.get(1))
                );
            }
        }
    }

    public static String obtenerNombreMes(String mes) {
        switch (mes) {
            case "01": return "January";
            case "02": return "February";
            case "03": return "March";
            case "04": return "April";
            case "05": return "May";
            case "06": return "June";
            case "07": return "July";
            case "08": return "August";
            case "09": return "September";
            case "10": return "October";
            case "11": return "November";
            case "12": return "December";
            default: throw new IllegalArgumentException("Mes no válido: " + mes);
        }
    }

    public static String normalizarNumero(String numero) {
        return numero.startsWith("0") ? numero.substring(1) : numero;
    }
}
