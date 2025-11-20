package cl.typitaka.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.typitaka.pages.views.GameView;



public class GameFlowTest extends BaseTest {
    List<String> wordsList;

    @Test
    @DisplayName("Test a las palabras del juego")
    public void testGameFlow(){
        GameView gameView = new GameView(driver);
        wordsList = gameView.getGameSection().getWordsList();
        
        for (String word : wordsList) {
            gameView.getGameSection().typeOnWordInput(word);
            gameView.getGameSection().typeOnWordInput(" ");
        }

    }

    @Test
    @DisplayName("Test de prueba para screenshots")
    public void testScreenshot(){
        assertTrue(false);
    }
}
