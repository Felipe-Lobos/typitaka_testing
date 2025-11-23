package cl.typitaka.pages.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cl.typitaka.pages.base.BasePage;
import cl.typitaka.pages.models.ScoreData;

public class ScoreSection extends BasePage {

    public ScoreSection(WebDriver driver) {
        super(driver);
    }
    
    //Locators
    private static final By wpmScoreLocator = By.cssSelector(".wpm-stat>span:nth-of-type(2)");
    private static final By wordsCorrectLocator = By.cssSelector(".words-stat>.stat-wrap>div:nth-of-type(1)>span:last-child");
    private static final By wordsIncorrectLocator = By.cssSelector(".words-stat>.stat-wrap>div:nth-of-type(2)>span:last-child");
    private static final By wordsMissedLocator = By.cssSelector(".words-stat>.stat-wrap>div:nth-of-type(3)>span:last-child");
    private static final By lettersCorrectLocator = By.cssSelector(".letters-stat>.stat-wrap>div:nth-of-type(1)>span:last-child");
    private static final By lettersIncorrectLocator = By.cssSelector(".letters-stat>.stat-wrap>div:nth-of-type(2)>span:last-child");
    private static final By lettersMissedLocator = By.cssSelector(".letters-stat>.stat-wrap>div:nth-of-type(3)>span:last-child");
    private static final By lpmScoreLocator = By.cssSelector(".lpm-stat>span:nth-of-type(2)");
    private static final By timeStatLocator = By.cssSelector(".time-stat>span:nth-of-type(2)");
    private static final By accuracyScoreLocator = By.cssSelector(".accuaracy-stat>span:nth-of-type(2)");

    /**
     * 🎯 Obtiene TODOS los datos del score de una vez
     * Retorna un objeto ScoreData con toda la información
     */
    public ScoreData getScoreData() {
        return new ScoreData(
            parseScore(find(wpmScoreLocator).getText()),
            parseScore(find(wordsCorrectLocator).getText()),
            parseScore(find(wordsIncorrectLocator).getText()),
            parseScore(find(wordsMissedLocator).getText()),
            parseScore(find(lettersCorrectLocator).getText()),
            parseScore(find(lettersIncorrectLocator).getText()),
            parseScore(find(lettersMissedLocator).getText()),
            parseScore(find(lpmScoreLocator).getText()),
            parseTime(find(timeStatLocator).getText()),
            parseAccuracy(find(accuracyScoreLocator).getText())
        );
    }

    private int parseTime(String text){
        try{
            return Integer.parseInt(text.replace("s", "").trim());
        }catch (NumberFormatException e){
            return 0;
        }
    }

    private int parseScore(String text){
        try{
            return Integer.parseInt(text.trim());
        }catch (NumberFormatException e){
            return 0;
        }
    }
    private int parseAccuracy(String text){
        try{
            return Integer.parseInt(text.replace("%", "").trim());
        }catch (NumberFormatException e){
            return 0;
        }
    }
    
}
