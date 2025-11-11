package cl.typitaka.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    private final int MAX_RETRIES = 3; // Numero maximos de intentos

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Encuentra un WebElement y lo devuelve, reintentando si falla por
     * StaleElementReferenceException.
     * 
     * @param locator El selector By del elemento.
     * @return El WebElement "fresco".
     */
    protected WebElement safeFindElement(By locator) {
        for (int attempt = 0; attempt < MAX_RETRIES; attempt++) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                return driver.findElement(locator);
            } catch (StaleElementReferenceException e) {
                System.out.println(
                        "ADVERTENCIA: StaleElementReference detectado en " + locator.toString() + ". Reintentando...");
            } catch (Exception e) {
                // Manejar otras excepciones (ej: TimeoutException)
                throw e;
            }
        }
        throw new StaleElementReferenceException(
                "Fallo en encontrar el elemento despues de " + MAX_RETRIES + " reintentos: " + locator.toString());
    }
}
