package cl.typitaka.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.typitaka.pages.OptionsPage;

public class GameFlowTest extends BaseTest{
    @Test
    @DisplayName("Test a los botones de opciones")
    public void testOptionButtons() {
        //driver viene desde la clase abstracta BaseTest, que su vez viene de DriverFactory
        OptionsPage optionPage = new OptionsPage(driver);
        optionPage.selectGameMode("Time");
        optionPage.selectWordsType("Spanish");
        optionPage.selectWordsType("Romaji");

    }
}
