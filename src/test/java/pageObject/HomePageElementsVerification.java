package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageElementsVerification {

	WebDriver driver;
	
	public HomePageElementsVerification(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);
	}
	
	//Repository
	@FindBy (tagName="img") List<WebElement> images;
	@FindBy (tagName="a") List<WebElement> links;
	
	public int imagesCount()
	{
		int images_Count=images.size();
		return images_Count;
	}
	
	
	public int linksCount()
	{
		int links_Count=links.size();
		return links_Count;
	}
	
	
}
