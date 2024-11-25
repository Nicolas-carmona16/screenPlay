package co.com.udea.certificacion.busquedavuelosa.tasks;

import co.com.udea.certificacion.busquedavuelosa.models.BusquedaDeVuelos;
import co.com.udea.certificacion.busquedavuelosa.utils.DateUtils;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

import static co.com.udea.certificacion.busquedavuelosa.userinterfaces.BusquedaVuelosPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarCampos implements Task {

    private final BusquedaDeVuelos busquedaDeVuelos;

    public SeleccionarCampos(BusquedaDeVuelos busquedaDeVuelos) {
        this.busquedaDeVuelos = busquedaDeVuelos;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        // Campo origen
        actor.attemptsTo(
                Click.on(INPUT_ORIGEN),
                SendKeys.of(busquedaDeVuelos.getOrigen()).into(CAMPO_BUSQUEDA_ORIGEN),
                Hit.the(Keys.ENTER).into(CAMPO_BUSQUEDA_ORIGEN)
        );

        // Campo destino
        actor.attemptsTo(
                Click.on(INPUT_DESTINO),
                SendKeys.of(busquedaDeVuelos.getDestino()).into(CAMPO_BUSQUEDA_DESTINO),
                Hit.the(Keys.ENTER).into(CAMPO_BUSQUEDA_DESTINO)
        );

        // Fecha ida
        actor.attemptsTo(
                Click.on(INPUT_FECHA_IDA)
        );
        DateUtils.seleccionarFecha(actor, busquedaDeVuelos.getFechaIda());

        // Fecha vuelta
        actor.attemptsTo(
                DoubleClick.on(INPUT_FECHA_VUELTA)
        );
        DateUtils.seleccionarFecha(actor, busquedaDeVuelos.getFechaVuelta());
    }

    public static SeleccionarCampos conDatos(BusquedaDeVuelos busquedaDeVuelos) {
        return instrumented(SeleccionarCampos.class, busquedaDeVuelos);
    }
}
