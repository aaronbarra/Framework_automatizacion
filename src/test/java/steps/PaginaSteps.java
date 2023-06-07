package steps;

import io.cucumber.java.en.When;
import pages.PaginaPage;

public class PaginaSteps {

    PaginaPage paginaPage = new PaginaPage();

    @When("Busco {string}")
    public void busco(String comentario) {
        paginaPage.realizoBusqueda(comentario);
    }
}
