package cl.typitaka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OptionsPage {
    private WebDriver driver;

    public OptionsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By wordsTypeContainerLocator = By.className("wordsType-container");
    private By gameModeContainerLocator = By.className("gameMode-container");

    // Devuelve un By para un <button> cuyo texto normalizado coincide con el parámetro
    private By getButtonLocatorByText(String text) {
        return By.xpath(".//button[normalize-space(text())='" + text + "']");
    }

    // Acciones

    public void selectWordsType(String wordsType) {
        WebElement container = driver.findElement(wordsTypeContainerLocator);
        container.findElement(getButtonLocatorByText(wordsType)).click();
    }

    public void selectGameMode(String gameMode) {
        WebElement container = driver.findElement(gameModeContainerLocator);
        container.findElement(getButtonLocatorByText(gameMode)).click();
    }
    
}
