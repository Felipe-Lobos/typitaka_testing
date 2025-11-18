package cl.typitaka.tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import cl.typitaka.utils.DriverFactory;
import cl.typitaka.utils.TestListener;

/**
 * Clase base para todos los tests
 * Configura el driver y los screenshots automáticos
 */
@ExtendWith(TestListener.class)
public abstract class BaseTest {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
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
            APP_URL = "http://localhost:5173";
        }
        System.out.println("DEBUG: Usando URL de la Aplicación: " + APP_URL);
    }

    /**
     * Metodo publico estatico para que el listener acceda al driver
     */
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(APP_URL);
        driverThreadLocal.set(driver);
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
        driverThreadLocal.remove();
    }
}
