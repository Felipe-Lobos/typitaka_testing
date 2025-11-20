package cl.typitaka.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            // A. Headless Mode: Imprescindible en GitHub Actions (sin interfaz gráfica)
            chromeOptions.addArguments("--headless=new");
            // B. Evitar problemas de sandbox y permisos en entornos Linux (CI/CD)
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            // C. Maximizar la ventana (Para asegurar que todos los elementos estén
            // visibles)
            chromeOptions.addArguments("--window-size=1920,1080");
            // D. Desactivar barras de información (para evitar que interfieran con los
            // clics)
            chromeOptions.addArguments("--disable-infobars");

            driver = new ChromeDriver(chromeOptions);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
