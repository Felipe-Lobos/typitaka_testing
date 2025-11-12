package cl.typitaka.tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import cl.typitaka.utils.DriverFactory;

public abstract class BaseTest {
    protected WebDriver driver;
    private static final String APP_URL;

    // Bloque estático para inicializar la URL al cargar la clase
    static {
        // Lee la propiedad del sistema. Si es nula, usa un fallback seguro.
        String urlFromMaven = System.getProperty("app.url");
        if (urlFromMaven != null && !urlFromMaven.isEmpty()) {
            APP_URL = urlFromMaven;
        } else {
            // Valor de seguridad si no se configura nada y la propiedad Maven falla
            APP_URL = "http://localhost:3000";
        }
        System.out.println("DEBUG: Usando URL de la Aplicación: " + APP_URL);
    }

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(APP_URL);
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
