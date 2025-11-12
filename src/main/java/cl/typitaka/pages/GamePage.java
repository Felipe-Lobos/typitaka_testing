package cl.typitaka.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GamePage extends BasePage {

    public GamePage(WebDriver driver) {
        super(driver);
    }

    // private By wordsWrapperLocator = By.className("words-wrapper");
    private By inputLocator = By.id("word-input");
    private By timerDisplayLocator = By.cssSelector(".timer-option-display>span");
    private By wordDisplayLocator = By.cssSelector(".word-option-display>span");

    private String extractWordText(WebElement wordElement) {
        // Extrae el texto de un elemento 'word' concatenando sus letras
        return wordElement.findElements(By.className("letter"))
                .stream()
                .map(letter -> letter.getText())
                .collect(Collectors.joining());
    }

    public void waitForWordsToChange(List<String> oldWords) {
        wait.until(driver -> {
            try {
                List<String> newWords = getWordsList();
                // Considerar cambio si hay diferencia en longitud o en al menos una palabra
                return !newWords.equals(oldWords);
            } catch (StaleElementReferenceException e) {
                return true;
            }
        });
    }

    public List<String> getWordsList() {
        // Esperar a que existan al menos 1 o más palabras visibles
        wait.until(driver -> {
            List<WebElement> words = driver.findElements(By.className("word"));
            return words.size() > 0 && words.stream().allMatch(WebElement::isDisplayed);
        });
        // Esperar a que el texto del primer elemento no esté vacío (React render
        // completo)
        wait.until(driver -> {
            String text = driver.findElements(By.className("word")).get(0).getText();
            return text != null && !text.trim().isEmpty();
        });
        // Una vez estable, recoger los textos
        List<WebElement> wordElements = driver.findElements(By.className("word"));

        return wordElements
                .stream()
                .map(word -> extractWordText(word))
                .collect(Collectors.toList());
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
