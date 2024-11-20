package co.com.udea.certificacion.busquedavuelosa.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.targets.Target.the;

public class BusquedaVuelosPage extends PageObject {

    // ORIGEN
    public static final Target INPUT_ORIGEN = the("campo para origen")
            .located(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/div[1]/button"));

    public static final Target DESPLEGABLE_CIUDADES_ORIGEN = the("desplegable de ciudades para el origen")
            .located(By.xpath("//*[@id=\"radix-:r7t:\"]"));

    // DESTINO
    public static final Target INPUT_DESTINO = the("campo para destino")
            .located(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/div[2]/button"));

    public static final Target DESPLEGABLE_CIUDADES_DESTINO = the("desplegable de ciudades para el destino")
            .located(By.xpath("//*[@id=\"radix-:r7v:\"]"));

    // FECHA IDA
    public static final Target INPUT_FECHA_IDA = the("campo para fecha ida")
            .located(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[3]/div[1]/button"));

    public static final Target CALENDARIO_FECHA_IDA = the("calendario para la fecha de ida")
            .located(By.xpath("//*[@id=\"radix-:r81:\"]"));

    // FECHA VUELTA
    public static final Target INPUT_FECHA_VUELTA = the("campo para fecha vuelta")
            .located(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[3]/div[2]/button"));

    public static final Target CALENDARIO_FECHA_VUELTA = the("calendario para la fecha de vuelta")
            .located(By.xpath("//*[@id=\"radix-:r81:\"]"));

    // BOTON BUSCA
    public static final Target BOTON_BUSCAR = the("botón para buscar vuelos")
            .located(By.xpath("//*[@id=\"searchButton\"]"));

    // VUELOS NO DISPONIBLES
    public static final Target MENSAJE_NO_VUELOS = the("mensaje de no hay vuelos disponibles")
            .located(By.xpath("//div[contains(text(),'No hay vuelos disponibles para las fechas seleccionadas.')]"));

    // VUELO ENCONTRADO
    public static final Target VUELO_DISPONIBLE = the("div con la información básica del vuelo encontrado")
            .located(By.xpath("/html/body/div[1]/div[2]/div/ul/li"));
}
