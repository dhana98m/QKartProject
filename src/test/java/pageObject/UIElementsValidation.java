package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UIElementsValidation {
	
	WebDriver driver;

	public UIElementsValidation(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);
	}
	
	//Repository
	@FindBy (xpath="//button[contains(text(),'Login')]") WebElement loginBtn;
	@FindBy (xpath="//button[contains(text(),'Register')]") WebElement registerBtn;
	@FindBy (xpath="//div[@class='header MuiBox-root css-0']/descendant::input[1]") WebElement srchTxtBox;
	
	public boolean isLoginBtnClickable()
	{
		return loginBtn.isDisplayed()&&loginBtn.isEnabled();
	}
	
	public boolean isRegBtnClickable()
	{
		return registerBtn.isDisplayed()&&registerBtn.isEnabled();
	}
	
	public boolean isSrchBtnClickable()
	{
		return srchTxtBox.isDisplayed()&&srchTxtBox.isEnabled();
	}
}
