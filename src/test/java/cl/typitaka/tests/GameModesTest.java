package cl.typitaka.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import cl.typitaka.pages.GamePage;
import cl.typitaka.pages.OptionsPage;

public class GameModesTest extends BaseTest{
    OptionsPage optionsPage;
    GamePage gamePage;

    static Stream<Arguments> gameConfigsCombination(){
        return Stream.of(
            Arguments.of("Spanish","Words","10"),
            Arguments.of("English","Time","30"),
            Arguments.of("Romaji","Time","60"),
            Arguments.of("Spanish","Words","25"),
            Arguments.of("English","Words","50")
        );
    }

    @Test
    @DisplayName("Verificar que las palabras cambien al seleccionar un idioma")
    public void testSelectLanguage_wordsListShouldUpdate(){
        optionsPage = new OptionsPage(driver);
        gamePage = new GamePage(driver);
        
        optionsPage.selectWordsType("English");
        List<String> wordList = gamePage.getWordsList();
        optionsPage.selectWordsType("Spanish");
        List<String> updatedWordList = gamePage.getWordsList();

        assertNotEquals(wordList, updatedWordList,"La lista de palabras siguen siendo las mismas");
    }

    @ParameterizedTest
    @MethodSource("gameConfigsCombination")
    @DisplayName("Verificar que el juego cambien entre modo 'Words' y 'Time'")
    public void TestSelectGameMode_gameDisplayShouldUpdate(String language, String gameMode, String suboption){
        optionsPage = new OptionsPage(driver);
        gamePage = new GamePage(driver);
        
        optionsPage.selectWordsType(language);
        optionsPage.selectGameMode(gameMode);
        optionsPage.selectGameModeSuboption(suboption);
        String gameDisplay =  gameMode == "Words" ? gamePage.getWordDisplayText() : gamePage.getTimerDisplayText();
        assertEquals(gameDisplay, suboption);
    }
    
    
}
