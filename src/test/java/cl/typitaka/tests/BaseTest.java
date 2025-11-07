package cl.typitaka.tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import cl.typitaka.utils.DriverFactory;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://felipe-lobos.github.io/typitaka/");
    }

    @AfterEach
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
