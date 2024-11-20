package co.com.udea.certificacion.busquedavuelosa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;

import static co.com.udea.certificacion.busquedavuelosa.userinterfaces.BusquedaVuelosPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarCampo implements Task {

    private String campo;

    public SeleccionarCampo(String campo) {
        this.campo = campo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (campo.equalsIgnoreCase("origen")) {
            actor.attemptsTo(Click.on(INPUT_ORIGEN));
        } else if (campo.equalsIgnoreCase("destino")) {
            actor.attemptsTo(Click.on(INPUT_DESTINO));
        } else if (campo.equalsIgnoreCase("ida")) {
            actor.attemptsTo(Click.on(INPUT_FECHA_IDA));
        } else if (campo.equalsIgnoreCase("vuelta")) {
            actor.attemptsTo(Click.on(INPUT_FECHA_VUELTA));
        }
    }

    public static SeleccionarCampo enLaPagina(String campo) {
        return instrumented(SeleccionarCampo.class, campo);
    }
}
