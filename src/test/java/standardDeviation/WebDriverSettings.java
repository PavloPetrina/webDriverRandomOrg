package standardDeviation;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class WebDriverSettings {

    public ChromeDriver driver;
    public WebDriverWait wait;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\ItelliJ_Idea\\RandomOrg\\src\\main\\resources\\drivers\\chromedriver70.0.3538.67.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        if (isFullscreenEnable()) {
            driver.manage().window().fullscreen();
        }

    }

    protected boolean isFullscreenEnable() {
        return true;
    }

    @After
    public void  closeSession() {
        driver.quit();
    }
}
