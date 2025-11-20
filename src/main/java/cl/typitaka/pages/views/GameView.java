package cl.typitaka.pages.views;

import org.openqa.selenium.WebDriver;

import cl.typitaka.pages.base.BasePage;
import cl.typitaka.pages.components.OptionComponent;
import cl.typitaka.pages.sections.GameSection;

public class GameView extends BasePage {

    public GameView(WebDriver driver) {
        super(driver);
    }
    GameSection gameSection = new GameSection(driver);
    OptionComponent optionComponent = new OptionComponent(driver);
    public GameSection getGameSection() {
        return gameSection;
    }
    public OptionComponent getOptionComponent() {
        return optionComponent;
    }
    

}
