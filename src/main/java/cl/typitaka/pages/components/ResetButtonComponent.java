package cl.typitaka.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cl.typitaka.pages.base.BasePage;

public class ResetButtonComponent extends BasePage{

    public ResetButtonComponent(WebDriver driver) {
        super(driver);
    }

    private By resetButtonLocator = By.id("reset-button");

    public void resetGame(){
        waitAndClick(resetButtonLocator);
       } 
}
