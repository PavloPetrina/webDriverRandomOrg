package standardDeviation;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class getRandomNumbers extends WebDriverSettings {
    @Test
    public void getNumbersToCalculateStandardDeviation() throws InterruptedException {
        driver.get("https://www.random.org/");
        String title1 = driver.getTitle();
        Assert.assertEquals(title1, "RANDOM.ORG - True Random Number Service");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Integer Generator")));
        WebElement linkByText = driver.findElement(By.linkText("Integer Generator"));
        linkByText.click();
        String title2 = driver.getTitle();
        Assert.assertEquals(title2, "RANDOM.ORG - Integer Generator");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div/form")));
        //Form=>Generate_random_int
        WebElement numClear = driver.findElement(By.xpath("/html/body/div/form/p[1]/input[1]"));
        numClear.clear();
        WebElement num = driver.findElement(By.xpath("/html/body/div/form/p[1]/input[1]"));
        num.sendKeys("50");
        //Form=>min_value
        WebElement minClear = driver.findElement(By.xpath("/html/body/div/form/p[2]/input[1]"));
        minClear.clear();
        WebElement min = driver.findElement(By.xpath("/html/body/div/form/p[2]/input[1]"));
        min.sendKeys("2");
        //Form=>max_value
        WebElement maxClear = driver.findElement(By.xpath("/html/body/div/form/p[2]/input[2]"));
        maxClear.clear();
        WebElement max = driver.findElement(By.xpath("/html/body/div/form/p[2]/input[2]"));
        max.sendKeys("200");
        //Form=>column_qty
        WebElement colClear = driver.findElement(By.xpath("/html/body/div/form/p[3]/input"));
        colClear.clear();
        WebElement col = driver.findElement(By.xpath("/html/body/div/form/p[3]/input"));
        col.sendKeys("1");
        //Form=>Get_numbs
        WebElement submit = driver.findElement(By.xpath("/html/body/div/form/p[5]/input[1]"));
        submit.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/pre")));
        //Copy_numbs
        String copyText = driver.findElement(By.xpath("/html/body/div/pre")).getText();
        //SD_page
        driver.get("https://www.free-online-calculator-use.com/standard-deviation-calculator.html");
        driver.findElement(By.id("desktop-header-skip-to")).click();
        //Paste_numbs
        driver.findElement(By.xpath("/html/body/div[4]/main/div/div[2]/article/form/div/table/tbody/tr[2]/td/textarea")).sendKeys(copyText);
        //Calculate_SD
        driver.findElement(By.xpath("/html/body/div[4]/main/div/div[2]/article/form/div/table/tbody/tr[3]/td/button")).click();
        //Scroll_to_SD
        WebElement element = driver.findElement(By.xpath("/html/body/div[4]/main/div/div[2]/article/form/div/table/tbody/tr[11]/td/div[1]/div[3]/table[4]/tbody/tr[1]/th"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //Highlight_result_SD
        WebElement sd = driver.findElement(By.xpath("/html/body/div[4]/main/div/div[2]/article/form/div/table/tbody/tr[11]/td/div[1]/div[3]/table[5]/tbody/tr[3]/td[5]"));
        driver.findElement(By.xpath("/html/body/div[4]/main/div/div[2]/article/form/div/table/tbody/tr[11]/td/div[1]/div[3]/table[5]/tbody/tr[3]/td[5]"));
        highLightElement(sd);
        //Just to show result - redundant
        Thread.sleep (3000);
    }

    public void highLightElement(WebElement sd) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", sd);
    }

   //  @Override
   //  protected boolean isFullscreenEnable() {
   //  return false;
   //  }

}