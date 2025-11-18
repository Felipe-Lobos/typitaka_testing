package cl.typitaka.utils;

import cl.typitaka.utils.ScreenshotHelper;

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
        } else {
            // El test pasó
            System.out.println("Test exitoso!");
        }
    }
}