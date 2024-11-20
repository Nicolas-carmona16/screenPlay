package co.com.udea.certificacion.busquedavuelosa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.udea.certificacion.busquedavuelosa.userinterfaces.BusquedaVuelosPage.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ElCalendario implements Question<Boolean> {

    private String campo;

    public ElCalendario(String campo) {
        this.campo = campo;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        if (campo.equalsIgnoreCase("ida")) {
            return the(CALENDARIO_FECHA_IDA).answeredBy(actor).isCurrentlyVisible();
        } else if (campo.equalsIgnoreCase("vuelta")) {
            return the(CALENDARIO_FECHA_VUELTA).answeredBy(actor).isCurrentlyVisible();
        }
        return false;
    }

    public static ElCalendario estaVisible(String campo) {
        return new ElCalendario(campo);
    }
}
