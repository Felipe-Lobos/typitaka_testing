package cl.typitaka.pages.sections;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cl.typitaka.pages.base.BasePage;

public class GameSection extends BasePage {

    public GameSection(WebDriver driver) {
        super(driver);
    }

    private By inputLocator = By.id("word-input");
    private By timerDisplayLocator = By.cssSelector(".timer-option-display>span");
    private By wordDisplayLocator = By.cssSelector(".word-option-display>span");
    private By wordsLocator = By.className("word");

    private String extractWordText(WebElement wordElement) {
        // Extrae el texto de un elemento 'word' concatenando sus letras
        return wordElement.findElements(By.className("letter"))
                .stream()
                .map(letter -> letter.getText())
                .collect(Collectors.joining());
    }

    public List<String> getWordsList() {
        return waitAndFindAll(wordsLocator)
                .stream()
                .map(word -> extractWordText(word))
                .collect(Collectors.toList());
    }

    /**
     * Espera a que las palabras se actualicen
     * (después de cambiar idioma)
     */
    public void waitForWordsToUpdate() {
        // Esperar un momento a que React detecte el cambio
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Esperar que las palabras estén presentes
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(wordsLocator));
        
        // Esperar que al menos una palabra sea visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(wordsLocator));
    }
    /**
     * Espera a que haya al menos N palabras
     */
    public void waitForWords(int minCount) {
        wait.until(driver -> findAll(wordsLocator).size() >= minCount);
    }

    public void focusWordInput() {
        find(inputLocator).click();
    }

    public void typeOnWordInput(String word) {
        find(inputLocator).sendKeys(word);
    }

    public String getTimerDisplayText() {
        return find(timerDisplayLocator).getText();
    }

    public String getWordDisplayText() {
        return find(wordDisplayLocator).getText();
    }
}
