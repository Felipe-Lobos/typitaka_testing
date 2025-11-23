package cl.typitaka.pages.views;

import org.openqa.selenium.WebDriver;

import cl.typitaka.pages.base.BasePage;
import cl.typitaka.pages.components.OptionComponent;
import cl.typitaka.pages.components.ResetButtonComponent;
import cl.typitaka.pages.sections.ScoreSection;

public class ScoreView  extends BasePage{

    private final ResetButtonComponent resetButtonComponent;
    private final OptionComponent optionComponent;
    private final ScoreSection scoreSection;
    public ScoreView(WebDriver driver) {
        super(driver);
        this.resetButtonComponent = new ResetButtonComponent(driver);
        this.optionComponent = new OptionComponent(driver);
        this.scoreSection = new ScoreSection(driver);
    }
    public ResetButtonComponent getResetButtonComponent() {
        return resetButtonComponent;
    }
    public OptionComponent getOptionComponent() {
        return optionComponent;
    }
    public ScoreSection getScoreSection() {
        return scoreSection;
    }

    




    
}
