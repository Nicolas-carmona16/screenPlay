package co.com.udea.certificacion.busquedavuelosa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.udea.certificacion.busquedavuelosa.userinterfaces.BusquedaVuelosPage.DESPLEGABLE_CIUDADES_DESTINO;
import static co.com.udea.certificacion.busquedavuelosa.userinterfaces.BusquedaVuelosPage.DESPLEGABLE_CIUDADES_ORIGEN;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ElDesplegable implements Question<Boolean> {

    private String campo;

    public ElDesplegable(String campo) {
        this.campo = campo;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        if (campo.equalsIgnoreCase("origen")) {
            return the(DESPLEGABLE_CIUDADES_ORIGEN).answeredBy(actor).isCurrentlyVisible();
        } else if (campo.equalsIgnoreCase("destino")) {
            return the(DESPLEGABLE_CIUDADES_DESTINO).answeredBy(actor).isCurrentlyVisible();
        }
        return false;
    }

    public static ElDesplegable estaVisible(String campo) {
        return new ElDesplegable(campo);
    }
}