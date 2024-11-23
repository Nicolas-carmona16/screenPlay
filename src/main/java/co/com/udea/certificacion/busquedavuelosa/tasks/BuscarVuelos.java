package co.com.udea.certificacion.busquedavuelosa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.udea.certificacion.busquedavuelosa.userinterfaces.BusquedaVuelosPage.BOTON_BUSCAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarVuelos implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_BUSCAR)
        );
    }

    public static BuscarVuelos ahora() {
        return instrumented(BuscarVuelos.class);
    }
}
