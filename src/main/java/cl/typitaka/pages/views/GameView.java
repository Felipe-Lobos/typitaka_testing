package cl.typitaka.pages.views;

import org.openqa.selenium.WebDriver;

import cl.typitaka.pages.base.BasePage;
import cl.typitaka.pages.components.OptionComponent;
import cl.typitaka.pages.components.ResetButtonComponent;
import cl.typitaka.pages.sections.GameSection;

public class GameView extends BasePage {
    private final GameSection gameSection;
    private final OptionComponent optionComponent;
    private final ResetButtonComponent resetButtonComponent;

    public GameView(WebDriver driver) {
        super(driver);
        this.optionComponent = new OptionComponent(driver);
        this.resetButtonComponent = new ResetButtonComponent(driver);
        this.gameSection = new GameSection(driver);
    }

    public GameSection getGameSection() {
        return gameSection;
    }

    public OptionComponent getOptionComponent() {
        return optionComponent;
    }
    public ResetButtonComponent getResetButtonComponent(){
        return resetButtonComponent;
    }
  
}
