package cl.typitaka.pages;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GamePage {
    WebDriver driver;

    public GamePage(WebDriver driver) {
        this.driver = driver;
    }

    private By wordsWrapperLocator = By.className("words-wrapper");
    private WebElement wordsWrapper;
    private List<WebElement> wordElements;
    private List<String> wordTextList;

    private List<WebElement> getWordElements() {
        // Asegurarse de tener el contenedor actualizado antes de buscar las palabras
        if (wordsWrapper == null) {
            wordsWrapper = driver.findElement(wordsWrapperLocator);
        }
        return wordsWrapper.findElements(By.className("word"));
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

    public void updateWordsList(){
        this.wordTextList = getWordTexts();
    }
    

}
