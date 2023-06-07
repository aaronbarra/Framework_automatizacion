package steps;

import constants.Navegador;
import driverConfig.DriverContext;
import io.cucumber.java.en.Given;
import util.MetodosGenericos;

import static constants.Constant.URL_PAGINA;
import static org.junit.Assert.assertEquals;

public class BackgroundPagina {
    @Given("Ingresar a pagina")
    public void ingresarAPagina() {
        DriverContext.setUp(Navegador.Chrome, URL_PAGINA);
        MetodosGenericos.esperar(2);
        String url = DriverContext.getDriver().getCurrentUrl();
        assertEquals(URL_PAGINA, url);
    }
}
