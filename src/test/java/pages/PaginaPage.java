package pages;

import driverConfig.DriverContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.MetodosGenericos;

import static org.junit.Assert.fail;

public class PaginaPage {

    private WebDriver driver;

    private static final Logger log = LoggerFactory.getLogger(GooglePage.class);

    public PaginaPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(),\"casa de tus sueños\")]")
    WebElement inputText;

    public void realizoBusqueda(String search){
        try {
            boolean validarInputText = MetodosGenericos.visualizarObjeto(inputText, 10);
            if(validarInputText){
                System.out.println("se encontró");
            }
            else {
                fail("no se logro visualizar el campo de busqueda");
            }
        }catch (Exception e){
            fail("no fue posible ingresar el texto " + search + " en el campo de busqueda");
        }

    }
}
