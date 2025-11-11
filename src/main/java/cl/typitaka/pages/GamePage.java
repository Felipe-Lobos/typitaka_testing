package cl.typitaka.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GamePage extends BasePage {

    public GamePage(WebDriver driver) {
        super(driver);
    }

    private By wordsWrapperLocator = By.className("words-wrapper");
    private By inputLocator = By.id("word-input");
    private By timerDisplayLocator = By.cssSelector(".timer-option-display>span");
    private By wordDisplayLocator = By.cssSelector(".word-option-display>span");


    private WebElement getWordsWrapper(){
        return safeFindElement(wordsWrapperLocator);
    }

    private List<WebElement> getWordElements() {
        return getWordsWrapper().findElements(By.className("word"));
    }

    private String extractWordText(WebElement wordElement) {
        // Extrae el texto de un elemento 'word' concatenando sus letras
        return wordElement.findElements(By.className("letter"))
                .stream()
                .map(letter -> letter.getText())
                .collect(Collectors.joining());
    }

    private List<String> getWordTexts() {
        return getWordElements()
                .stream()
                .map(word -> extractWordText(word))
                .collect(Collectors.toList());
    }

   

    public List<String> getWordsList() {
        return getWordTexts();
    }

    public void focusWordInput() {
        WebElement wordInput = safeFindElement(inputLocator);
        wordInput.click();
    }

    public void typeOnInput(String word) {
        WebElement wordInput = safeFindElement(inputLocator);
        wordInput.sendKeys(word);
    }

    public boolean isTimerDisplayVisible() {
        return safeFindElement(timerDisplayLocator).isDisplayed();
    }

    public boolean isWordDisplayVisible() {
        return safeFindElement(wordDisplayLocator).isDisplayed();
    }

    public String getTimerDisplayText() {
        return safeFindElement(timerDisplayLocator).getText();
    }

    public String getWordDisplayText() {
        return safeFindElement(wordDisplayLocator).getText();
    }

}
