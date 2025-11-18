package cl.typitaka.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.typitaka.pages.GamePage;
import cl.typitaka.pages.OptionsPage;

public class GameFlowTest extends BaseTest {
    List<String> wordsList;

    @Test
    @DisplayName("Test a las palabras del juego")
    public void testGameFlow(){
        OptionsPage optionsPage = new OptionsPage(driver);
        GamePage gamePage = new GamePage(driver);
        wordsList = gamePage.getWordsList();
        
        for (String word : wordsList) {
            gamePage.typeOnInput(word);
            gamePage.typeOnInput(" ");
        }

    }

    @Test
    @DisplayName("Test de prueba para screenshots")
    public void testScreenshot(){
        assertTrue(false);
    }
}
