package cl.typitaka.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

/**
 * Utilidad para captura de screenshots integrada con Allure Reports
 * Soporta múltiples estrategias de captura según el caso de uso
 */
public class ScreenshotHelper {

    /**
     * Captura screenshot y lo adjunta al reporte Allure
     * Uso recomendado en bloques catch de excepciones
     * 
     * @param driver         WebDriver instance
     * @param screenshotName Nombre descriptivo del screenshot
     * @return byte array del screenshot capturado
     */
    @Attachment(value = "{screenshotName}", type = "image/png")
    public static byte[] captureScreenshot(WebDriver driver, String screenshotName) {
        System.out.println("📸 Capturando screenshot: " + screenshotName);
        if (driver == null) {
            return new byte[0];
        }

        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            System.out.println("✅ Screenshot capturado: " + screenshot.length + " bytes");
            return screenshot;
        } catch (Exception e) {
            System.err.println("Error al capturar screenshot: " + e.getMessage());
            return new byte[0];
        }
    }

    /**
     * Captura screenshot sin anotación @Attachment
     * Útil para captura manual con mayor control
     * 
     * @param driver         WebDriver instance
     * @param screenshotName Nombre para el attachment en Allure
     */
    public static void attachScreenshot(WebDriver driver, String screenshotName) {
        if (driver == null) {
            return;
        }

        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(screenshotName, "image/png",
                    new ByteArrayInputStream(screenshot), ".png");
        } catch (Exception e) {
            System.err.println("Error al adjuntar screenshot: " + e.getMessage());
        }
    }

    /**
     * Captura screenshot solo en caso de fallo
     * Integrado con el estado del test de JUnit
     * 
     * @param driver   WebDriver instance
     * @param testName Nombre del test que falló
     */
    public static void captureOnFailure(WebDriver driver, String testName) {
        captureScreenshot(driver, "FAILURE - " + testName);
    }

    /**
     * Captura screenshot para steps específicos
     * Útil para debugging de flujos complejos
     * 
     * @param driver          WebDriver instance
     * @param stepDescription Descripción del step
     */
    public static void captureStep(WebDriver driver, String stepDescription) {
        attachScreenshot(driver, "Step: " + stepDescription);
    }
}
