package co.com.udea.certificacion.busquedavuelosa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.udea.certificacion.busquedavuelosa.userinterfaces.BusquedaVuelosPage.MENSAJE_NO_VUELOS;

public class MensajeNoVuelos implements Question<Boolean> {

    private final String mensajeEsperado;

    public MensajeNoVuelos(String mensajeEsperado) {
        this.mensajeEsperado = mensajeEsperado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String mensajeReal = actor.asksFor(Text.of(MENSAJE_NO_VUELOS).asString());
        return mensajeReal.equalsIgnoreCase(mensajeEsperado);
    }

    public static MensajeNoVuelos esVisible(String mensajeEsperado) {
        return new MensajeNoVuelos(mensajeEsperado);
    }
}
