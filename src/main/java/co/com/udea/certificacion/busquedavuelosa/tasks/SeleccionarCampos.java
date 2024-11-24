package co.com.udea.certificacion.busquedavuelosa.tasks;

import co.com.udea.certificacion.busquedavuelosa.models.BusquedaDeVuelos;
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
                Click.on(INPUT_FECHA_IDA) // Abre el calendario
        );
        seleccionarFecha(actor, busquedaDeVuelos.getFechaIda());

        // Fecha vuelta
        actor.attemptsTo(
                DoubleClick.on(INPUT_FECHA_VUELTA) // Abre el calendario
        );
        seleccionarFecha(actor, busquedaDeVuelos.getFechaVuelta());
    }

    private <T extends Actor> void seleccionarFecha(T actor, String fecha) {
        String[] partesFecha = fecha.split("-");
        String anio = partesFecha[0];
        String mes = partesFecha[1];
        String dia = partesFecha[2];

        String mesEnIngles = obtenerNombreMes(mes);

        boolean mesCorrecto = false;

        while (!mesCorrecto) {
            String textoCalendario = CONTENEDOR_CALENDARIO.resolveFor(actor).getText();
            if (textoCalendario.contains(mesEnIngles + " " + anio)) {
                mesCorrecto = true;
            } else {
                actor.attemptsTo(
                        Click.on(BOTON_SIGUIENTE_MES)
                );
            }
        }

        actor.attemptsTo(
                Click.on(DIA_EN_CALENDARIO(dia))
        );
    }

     private String obtenerNombreMes(String mes) {
        switch (mes) {
            case "01": return "January";
            case "02": return "February";
            case "03": return "March";
            case "04": return "April";
            case "05": return "May";
            case "06": return "June";
            case "07": return "July";
            case "08": return "August";
            case "09": return "September";
            case "10": return "October";
            case "11": return "November";
            case "12": return "December";
            default: throw new IllegalArgumentException("Mes no válido: " + mes);
        }
    }


    public static SeleccionarCampos conDatos(BusquedaDeVuelos busquedaDeVuelos) {
        return instrumented(SeleccionarCampos.class, busquedaDeVuelos);
    }
}
