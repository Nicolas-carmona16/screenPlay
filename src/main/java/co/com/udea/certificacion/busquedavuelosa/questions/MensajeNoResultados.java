package co.com.udea.certificacion.busquedavuelosa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.udea.certificacion.busquedavuelosa.userinterfaces.BusquedaVuelosPage.MENSAJE_NO_RESULTADOS;

public class MensajeNoResultados implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String mensajeReal = actor.asksFor(Text.of(MENSAJE_NO_RESULTADOS).asString());
        return mensajeReal.equalsIgnoreCase("No hay resultados");
    }

    public static MensajeNoResultados esVisible() {
        return new MensajeNoResultados();
    }
}
