package co.com.udea.certificacion.busquedavuelosa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.udea.certificacion.busquedavuelosa.userinterfaces.BusquedaVuelosPage.VUELO_DISPONIBLE;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class VuelosDisponibles implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return the(VUELO_DISPONIBLE).answeredBy(actor).isCurrentlyVisible();
    }

    public static VuelosDisponibles sonVisibles() {
        return new VuelosDisponibles();
    }
}
