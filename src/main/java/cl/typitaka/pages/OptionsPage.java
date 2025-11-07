package cl.typitaka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OptionsPage {
    private WebDriver driver;

    public OptionsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By wordsTypeContainer = By.className("wordsType-container");
    private By gameModeContainer = By.className("gameMode-container");
    private By gameModeSelector = By.className("mode-selector");

    private By optionButtonByText(String text) {
        // (".//*[normalize-space(text())='" + text + "']");
        return By.xpath(".//button[normalize-space(text())='" + text + "']");
    }

    // Acciones

    public void selectWordsType(String wordsType) {
        WebElement container = driver.findElement(wordsTypeContainer);
        container.findElement(optionButtonByText(wordsType)).click();
    }

    public void selectGameMode(String gameMode) {
        WebElement container = driver.findElement(gameModeContainer);
        container.findElement(optionButtonByText(gameMode)).click();
    }

//     public void selectWordsType(String wordsType) {
//         WebElement container = driver.findElement(wordsTypeContainer);
//         container.findElement(optionButtonByText(wordsType)).click();
//     }
}
