package cl.typitaka.utils;

import io.qameta.allure.Allure;

import java.util.Optional;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

import cl.typitaka.tests.BaseTest;

/**
 * Listener que captura screenshot automáticamente cuando un test falla
 */
public class TestListener implements AfterTestExecutionCallback  {

    /**
     * Se ejecuta automaticamente despues de cada test, pero antes del @afterEach
     * 
     */
    @Override
    public void afterTestExecution(ExtensionContext context) {
        // Tenemos que consultar el resultado manualmente
        Optional<Throwable> exception = context.getExecutionException();
        
        if (exception.isPresent()) {
            // El test falló
            WebDriver driver = BaseTest.getDriver();
            String testName = context.getDisplayName();
            ScreenshotHelper.captureScreenshot(driver, "FALLO - " + testName);
            attachHtmlSource(driver, "Página Fuente al Fallo");
        } else {
            // El test pasó
            System.out.println("Test exitoso!");
        }
    }


    // Método auxiliar para adjuntar HTML (usando Allure.addAttachment)
    private void attachHtmlSource(WebDriver driver, String name) {
        try {
            String source = driver.getPageSource();
            Allure.addAttachment(name, "text/html", source, "html");
        } catch (Exception ignored) {
            // Ignorar errores si el driver ya está cerrado
        }
    }
}