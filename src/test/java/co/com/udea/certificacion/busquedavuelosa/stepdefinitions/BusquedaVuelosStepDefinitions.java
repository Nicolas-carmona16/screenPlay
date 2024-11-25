package co.com.udea.certificacion.busquedavuelosa.stepdefinitions;

import co.com.udea.certificacion.busquedavuelosa.models.BusquedaDeVuelos;
import co.com.udea.certificacion.busquedavuelosa.questions.*;
import co.com.udea.certificacion.busquedavuelosa.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static co.com.udea.certificacion.busquedavuelosa.questions.ElDesplegable.estaVisible;
import static org.hamcrest.CoreMatchers.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class BusquedaVuelosStepDefinitions {

    @Managed
    WebDriver driver;

    private final Actor usuario = Actor.named("usuario");

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que estoy en la pagina de busqueda de vuelos")
    public void queEstoyEnLaPaginaDeBusquedaDeVuelos() {
        usuario.can(BrowseTheWeb.with(driver));
        usuario.attemptsTo(
                AbrirPagina.busquedaVuelos()
        );
    }

    @When("selecciona el campo {string}")
    public void seleccionoElCampo(String campo) {
        if (campo.equalsIgnoreCase("origen")) {
            usuario.attemptsTo(SeleccionarCampo.enLaPagina("origen"));
        } else if (campo.equalsIgnoreCase("destino")) {
            usuario.attemptsTo(SeleccionarCampo.enLaPagina("destino"));
        } else if (campo.equalsIgnoreCase("ida")) {
            usuario.attemptsTo(SeleccionarCampo.enLaPagina("ida"));
        } else if (campo.equalsIgnoreCase("vuelta")) {
            usuario.attemptsTo(SeleccionarCampo.enLaPagina("vuelta"));
        }
    }

    @Then("se despliega una lista de ciudades para el campo {string}")
    public void seDespliegaUnaListaDeCiudadesParaElCampo(String campo) {
        if (campo.equalsIgnoreCase("origen")) {
            usuario.should(
                    seeThat(estaVisible("origen"), is(true))
            );
        } else if (campo.equalsIgnoreCase("destino")) {
            usuario.should(
                    seeThat(ElDesplegable.estaVisible("destino"), is(true))
            );
        }
    }

    @Then("se muestra el calendario para {string}")
    public void seMuestraElCalendarioPara(String campo) {
        if (campo.equalsIgnoreCase("ida")) {
            usuario.should(
                    seeThat(ElCalendario.estaVisible("ida"), is(true))
            );
        } else if (campo.equalsIgnoreCase("vuelta")) {
            usuario.should(
                    seeThat(ElCalendario.estaVisible("vuelta"), is(true))
            );
        }
    }

    @Given("selecciono origen {string} destino {string} fecha ida {string} y fecha vuelta {string}")
    public void seleccionoOrigenDestinoFechaIdaYFechaVuelta(String origen, String destino, String fechaIda, String fechaVuelta) {
        BusquedaDeVuelos busquedaDeVuelos = new BusquedaDeVuelos(origen, destino, fechaIda, fechaVuelta);
        usuario.attemptsTo(
                SeleccionarCampos.conDatos(
                        busquedaDeVuelos
                )
        );
    }

    @When("doy click en el boton buscar")
    public void doyClickEnElBotonBuscar() {
        usuario.attemptsTo(BuscarVuelos.ahora());
    }

    @Then("se obtienen los vuelos disponibles")
    public void seObtienenLosVuelosDisponibles() {
        usuario.should(
                seeThat(VuelosDisponibles.sonVisibles(), is(true))
        );
    }

    @Then("se obtienen el mensaje {string}")
    public void seObtienenElMensaje(String mensajeEsperado) {
        usuario.should(
                seeThat(MensajeNoVuelos.esVisible(mensajeEsperado), is(true))
        );
    }

    @When("selecciono origen {string}")
    public void seleccionoOrigen(String origen) {
        BusquedaDeVuelos busquedaDeVuelos = new BusquedaDeVuelos(origen, "", "", "");
        usuario.attemptsTo(
                SeleccionarOrigen.con(busquedaDeVuelos)
        );
    }

    @When("selecciono destino {string}")
    public void seleccionoDestino(String destino) {
        BusquedaDeVuelos busquedaDeVuelos = new BusquedaDeVuelos("", destino, "", "");
        usuario.attemptsTo(
                SeleccionarDestino.con(busquedaDeVuelos)
        );
    }

    @Then("se muestra el mensaje no disponible")
    public void seMuestraElMensajeNoDisponible() {
        usuario.should(
                seeThat(MensajeNoResultados.esVisible(), is(true))
        );
    }

    @When("selecciono fecha de ida {string}")
    public void seleccionoFechaDeIda(String fechaIda) {
        BusquedaDeVuelos busquedaDeVuelos = new BusquedaDeVuelos("", "", fechaIda, "");
        usuario.attemptsTo(
                SeleccionarFechaIda.con(busquedaDeVuelos)
        );
    }

    @When("selecciono fecha de vuelta {string}")
    public void seleccionoFechaDeVuelta(String fechaVuelta) {
        BusquedaDeVuelos busquedaDeVuelos = new BusquedaDeVuelos("", "", "", fechaVuelta);
        usuario.attemptsTo(
                SeleccionarFechaVuelta.con(busquedaDeVuelos)
        );
    }

    @Then("se muestra el mensaje de error fecha ida {string}")
    public void seMuestraElMensajeDeErrorFechaIda(String mensajeEsperado) {
        usuario.should(
                seeThat(MensajeErrorFechaIda.esVisible(mensajeEsperado), is(true))
        );
    }

    @Then("se muestra el mensaje de error fecha vuelta {string}")
    public void seMuestraElMensajeDeErrorFechaVuelta(String mensajeEsperado) {
        usuario.should(
                seeThat(MensajeErrorFechaVuelta.esVisible(mensajeEsperado), is(true))
        );
    }
}
