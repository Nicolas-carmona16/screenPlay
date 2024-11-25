package co.com.udea.certificacion.busquedavuelosa.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.targets.Target.the;

public class BusquedaVuelosPage extends PageObject {

    // ORIGEN
    public static final Target INPUT_ORIGEN = the("campo para origen")
            .located(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/div[1]/button"));

    public static final Target CAMPO_BUSQUEDA_ORIGEN = Target.the("campo de búsqueda en el desplegable de origen")
            .locatedBy("//input[@placeholder='Busca lugar...']");

    public static final Target DESPLEGABLE_CIUDADES_ORIGEN = the("desplegable de ciudades para el origen")
            .located(By.xpath("/html/body/div[3]/div/div/div[2]/div/div"));

    // DESTINO
    public static final Target INPUT_DESTINO = the("campo para destino")
            .located(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/div[2]/button"));

    public static final Target CAMPO_BUSQUEDA_DESTINO = Target.the("campo de búsqueda en el desplegable de destino")
            .locatedBy("//input[@placeholder='Busca lugar...']");

    public static final Target DESPLEGABLE_CIUDADES_DESTINO = the("desplegable de ciudades para el destino")
            .located(By.xpath("/html/body/div[3]/div/div/div[2]/div/div"));

    // FECHA IDA
    public static final Target INPUT_FECHA_IDA = the("campo para fecha ida")
            .located(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[3]/div[1]/button"));

    // FECHA VUELTA
    public static final Target INPUT_FECHA_VUELTA = the("campo para fecha vuelta")
            .located(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[3]/div[2]/button"));

    public static final Target CONTENEDOR_CALENDARIO = the("contenedor del calendario")
            .locatedBy("/html/body/div[3]/div/div");

    public static final Target BOTON_SIGUIENTE_MES = the("botón siguiente mes")
            .locatedBy("/html/body/div[3]/div/div/div/div/div/div[2]/button[2]");

    public static final Target DIA_EN_CALENDARIO(String dia) {
        return the("día en el calendario")
                .locatedBy("//button[text()='" + dia + "']");
    }

    // BOTON BUSCA
    public static final Target BOTON_BUSCAR = the("botón para buscar vuelos")
            .located(By.xpath("//*[@id=\"searchButton\"]"));

    // VUELOS NO DISPONIBLES
    public static final Target MENSAJE_NO_VUELOS = the("mensaje de no hay vuelos disponibles")
            .locatedBy("//div[contains(text(),'No hay vuelos disponibles para las fechas seleccionadas.')]");

    // VUELO ENCONTRADO
    public static final Target VUELO_DISPONIBLE = the("div con la información básica del vuelo encontrado")
            .located(By.xpath("/html/body/div[1]/div[2]/div/ul/li"));

    public static final Target MENSAJE_NO_RESULTADOS = Target.the("mensaje de no hay resultados")
            .locatedBy("//div[contains(text(),'No hay resultados')]");
}
