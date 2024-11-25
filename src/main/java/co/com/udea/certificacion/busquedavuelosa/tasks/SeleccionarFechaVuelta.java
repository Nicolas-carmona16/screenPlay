package co.com.udea.certificacion.busquedavuelosa.tasks;

import co.com.udea.certificacion.busquedavuelosa.models.BusquedaDeVuelos;
import co.com.udea.certificacion.busquedavuelosa.utils.DateUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;

import static co.com.udea.certificacion.busquedavuelosa.userinterfaces.BusquedaVuelosPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarFechaVuelta implements Task {

    private final BusquedaDeVuelos busquedaDeVuelos;

    public SeleccionarFechaVuelta(BusquedaDeVuelos busquedaDeVuelos) {
        this.busquedaDeVuelos = busquedaDeVuelos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                DoubleClick.on(INPUT_FECHA_VUELTA),
                Click.on(BOTON_ANTERIOR_MES)
        );
        DateUtils.seleccionarFecha(actor, busquedaDeVuelos.getFechaVuelta());
    }

    public static SeleccionarFechaVuelta con(BusquedaDeVuelos busquedaDeVuelos) {
        return instrumented(SeleccionarFechaVuelta.class, busquedaDeVuelos);
    }
}
