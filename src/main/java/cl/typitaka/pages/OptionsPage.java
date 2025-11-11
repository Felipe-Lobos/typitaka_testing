package cl.typitaka.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OptionsPage extends BasePage{

    public OptionsPage(WebDriver driver) {
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
        WebElement container = safeFindElement(wordsTypeContainerLocator);
        container.findElement(getButtonLocatorByText(wordsType)).click();
    }

    public void selectGameMode(String gameMode) {
        WebElement container = safeFindElement(gameModeContainerLocator);
        container.findElement(getButtonLocatorByText(gameMode)).click();
    }

    public void selectGameModeSuboption(String text) {
        WebElement container = safeFindElement(suboptionsLocator);
        container.findElement(getButtonLocatorByText(text)).click();
    }
}
