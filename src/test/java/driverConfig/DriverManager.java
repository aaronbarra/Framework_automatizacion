package driverConfig;

import constants.Navegador;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class DriverManager {

private static final String USERNAME = "israelgarate_cqE1fL";

private static final String AUTOMATE_KEY = "CQMS9txkfeQsZkyH5pr1";

private WebDriver driver;
private DesiredCapabilities capabilities = new DesiredCapabilities();
private File root = new File("driverNavegador");
private String extensionDriver = "";

       protected void resolveDriver(Navegador nav, String ambURL) {
    	    File driverPath;
    	    String os = System.getProperty("os.name").toLowerCase();
    	    System.out.println("\nSistema operativo ->" + System.getProperty("os.name").toLowerCase() + " " +System.getProperty("os.version").toLowerCase() +"\n");
    	    if (!os.contains("mac"))
    	      this.extensionDriver = ".exe";
    	    System.out.println(nav);
    	    switch (nav) {
    	       case Chrome:
    	        System.out.println("Se selecciona Chrome");
				   ChromeOptions chromeOptions = new ChromeOptions();
				   chromeOptions.addArguments("--remote-allow-origins=*");
				   chromeOptions.setCapability("browserVersion", "113.0");
				   chromeOptions.setCapability("platformName", "Windows");
				   Map<String, Object> browserStackOptions = new HashMap<>();
				   browserStackOptions.put("osVersion", "10");
				   browserStackOptions.put("resolution", "1920x1080") ;
				   browserStackOptions.put( "buildName", "browserstack local automate");
				   browserStackOptions.put("sessionName", "BStack local prueba framework");
				   browserStackOptions.put( "local", true);
				   // Otras opciones de BrowserStack pueden ir aquí.

				   chromeOptions.setCapability("bstack:options", browserStackOptions);

				if (os.contains("linux")){
					System.out.println("entre a linux");
					System.out.println(System.getProperty("user.name"));
					chromeOptions.addArguments("--disable-dev-shm-usage");
					chromeOptions.addArguments("--no-sandbox");
					chromeOptions.addArguments("--disable-gpu");
					chromeOptions.addArguments("--headless");
					chromeOptions.addArguments("--ignore-ssl-errors=yes");
					chromeOptions.addArguments("--window-size=1920x1080");


				}
				   try {
					   this.driver = new RemoteWebDriver(
							   new URL("https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub"),
							   chromeOptions
					   );
				   } catch (MalformedURLException e) {
					   e.printStackTrace();
				   }
    	        break;
    	      case Explorer:
    	        System.out.println("Se selecciona Explorer");
    	        this.capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
    	        this.capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
    	        this.capabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
    	        this.capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	        this.capabilities.setCapability(
    	            InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
    	        this.capabilities.setJavascriptEnabled(true);
    	        WebDriverManager.iedriver().setup();
    	        this.driver = (WebDriver)new InternetExplorerDriver();
    	        this.capabilities.setBrowserName("Explorer");
    	        break;
    	      case Firefox:
    	        System.out.println("Se selecciona Firefox");
    	        WebDriverManager.firefoxdriver().setup();
    	        this.driver = (WebDriver)new FirefoxDriver();
    	        this.capabilities.setBrowserName("Firefox");
    	        break;
    	      case Edge:
    	        System.out.println("Se selecciona Edge");
    	        WebDriverManager.edgedriver().setup();
    	        this.driver = (WebDriver)new EdgeDriver();
    	        this.capabilities.setBrowserName("Microsoft Edge");
    	        break;
    	      case Safari:
    	        System.out.println("Se selecciona Safari");
    	        driverPath = new File(this.root, "safaridriver" + this.extensionDriver);
    	        System.setProperty("webdriver.safari.driver", driverPath.getAbsolutePath());
    	        this.driver = (WebDriver)new SafariDriver();
    	        this.capabilities.setBrowserName("Safari");
    	        break;
    	      default:
    	        System.out.println("No es posible lanzar el navegador, no se reconoce el navegador: " + nav);
    	        break;
    	    }
    	    this.driver.manage().window().maximize();
    		this.driver.get(ambURL);

    	  }
       
   
    protected WebDriver getDriver() {
    	if (driver == null) {
			return driver;
		} else {
			return driver;
		}    	
    
    }

}
