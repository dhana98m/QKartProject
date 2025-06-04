package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAttributesVerification {

	WebDriver driver;
	
	public PageAttributesVerification(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);
	}
	
	//Repository
	@FindBy(xpath = "//div[@class='header MuiBox-root css-0']/descendant::input[@placeholder='Search for items/categories']")
	WebElement srchplaceholder;

	
	public String getSearchboxPlaceholder() 
	{
		//System.out.println(srchplaceholder.getAttribute("placeholder"));
		return srchplaceholder.getAttribute("placeholder");
		
	}
	
	public String getTitleofthePage()
	{
		return driver.getTitle();
	}
	
	public String getURLofthePage()
	{
		return driver.getCurrentUrl();
	}
}
