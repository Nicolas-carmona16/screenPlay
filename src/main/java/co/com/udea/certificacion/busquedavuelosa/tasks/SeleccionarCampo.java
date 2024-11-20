package co.com.udea.certificacion.busquedavuelosa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.udea.certificacion.busquedavuelosa.userinterfaces.BusquedaVuelosPage.INPUT_DESTINO;
import static co.com.udea.certificacion.busquedavuelosa.userinterfaces.BusquedaVuelosPage.INPUT_ORIGEN;
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
        }
    }

    public static SeleccionarCampo enLaPagina(String campo) {
        return instrumented(SeleccionarCampo.class, campo);
    }
}
