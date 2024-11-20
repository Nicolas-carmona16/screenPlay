package co.com.udea.certificacion.busquedavuelosa.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/busqueda_vuelos_a.feature",
        glue = "co.com.udea.certificacion.busquedavuelosa.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class BusquedaVuelosRunner {
}
