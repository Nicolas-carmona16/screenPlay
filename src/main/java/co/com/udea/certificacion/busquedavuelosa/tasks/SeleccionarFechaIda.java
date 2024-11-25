package co.com.udea.certificacion.busquedavuelosa.tasks;

import co.com.udea.certificacion.busquedavuelosa.models.BusquedaDeVuelos;
import co.com.udea.certificacion.busquedavuelosa.utils.DateUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.udea.certificacion.busquedavuelosa.userinterfaces.BusquedaVuelosPage.INPUT_FECHA_IDA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarFechaIda implements Task {

    private final BusquedaDeVuelos busquedaDeVuelos;

    public SeleccionarFechaIda(BusquedaDeVuelos busquedaDeVuelos) {
        this.busquedaDeVuelos = busquedaDeVuelos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(INPUT_FECHA_IDA)
        );
        DateUtils.seleccionarFecha(actor, busquedaDeVuelos.getFechaIda());
    }

    public static SeleccionarFechaIda con(BusquedaDeVuelos busquedaDeVuelos) {
        return instrumented(SeleccionarFechaIda.class, busquedaDeVuelos);
    }
}
