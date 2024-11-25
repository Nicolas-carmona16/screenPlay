package co.com.udea.certificacion.busquedavuelosa.tasks;

import co.com.udea.certificacion.busquedavuelosa.models.BusquedaDeVuelos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;

import static co.com.udea.certificacion.busquedavuelosa.userinterfaces.BusquedaVuelosPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarDestino implements Task {

    private final BusquedaDeVuelos busquedaDeVuelos;

    public SeleccionarDestino(BusquedaDeVuelos busquedaDeVuelos) {
        this.busquedaDeVuelos = busquedaDeVuelos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(INPUT_DESTINO),
                SendKeys.of(busquedaDeVuelos.getDestino()).into(CAMPO_BUSQUEDA_DESTINO),
                Hit.the(Keys.ENTER).into(CAMPO_BUSQUEDA_DESTINO)
        );
    }

    public static SeleccionarDestino con(BusquedaDeVuelos busquedaDeVuelos) {
        return instrumented(SeleccionarDestino.class, busquedaDeVuelos);
    }
}
