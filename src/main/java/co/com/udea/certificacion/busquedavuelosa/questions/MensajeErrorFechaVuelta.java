package co.com.udea.certificacion.busquedavuelosa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.udea.certificacion.busquedavuelosa.userinterfaces.BusquedaVuelosPage.MENSAJE_ERROR_FECHA_VUELTA;

public class MensajeErrorFechaVuelta implements Question<Boolean> {

    private final String mensajeEsperado;

    public MensajeErrorFechaVuelta(String mensajeEsperado) {
        this.mensajeEsperado = mensajeEsperado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String mensajeReal = actor.asksFor(Text.of(MENSAJE_ERROR_FECHA_VUELTA).asString());
        return mensajeReal.equalsIgnoreCase(mensajeEsperado);
    }

    public static MensajeErrorFechaVuelta esVisible(String mensajeEsperado) {
        return new MensajeErrorFechaVuelta(mensajeEsperado);
    }
}
