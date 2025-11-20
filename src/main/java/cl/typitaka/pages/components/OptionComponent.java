package cl.typitaka.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import cl.typitaka.pages.base.BasePage;

public class OptionComponent extends BasePage {

    public OptionComponent(WebDriver driver) {
        super(driver);
        
    }

    // Locators
    private By wordsTypeContainerLocator = By.className("wordsType-container");
    private By gameModeContainerLocator = By.className("gameMode-container");
    private By suboptionsLocator = By.className("gamemode-suboptions");

    // Devuelve un By para un <button> cuyo texto normalizado coincide con el
    // parámetro
    private By getButtonLocatorByText(String text) {
        return By.xpath(".//button[normalize-space(text())='" + text + "']");
    }

    // Acciones
    public void selectWordsType(String wordsType) {
        WebElement container = find(wordsTypeContainerLocator);
        container.findElement(getButtonLocatorByText(wordsType)).click();
    }

    public void selectGameMode(String gameMode) {
        WebElement container = find(gameModeContainerLocator);
        container.findElement(getButtonLocatorByText(gameMode)).click();
    }

    public void selectGameModeSuboption(String text) {
        WebElement container = find(suboptionsLocator);
        container.findElement(getButtonLocatorByText(text)).click();
    }


    
}
