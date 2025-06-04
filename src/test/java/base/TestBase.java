package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {

	protected static WebDriver driver;

    public void initializeDriver() {
        if (driver == null) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }
    
    public void clickOnLoginBtn()
    {
    	driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    }
    
    public void enterUserName(String un)
    {
    	driver.findElement(By.name("username")).sendKeys(un);
    }
    
    public void enterPass(String pw)
    {
    	driver.findElement(By.name("password")).sendKeys(pw);
    }
    
    public void clickOnLoginQKart()
    {
    	driver.findElement(By.xpath("//button[contains(text(),'Login to QKart')]")).click();
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
