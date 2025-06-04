package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFunctionality {

	WebDriver driver;
	
	public LoginFunctionality(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(idriver, this);
	}
	
	//Repository
	@FindBy (xpath="//button[contains(text(),'Login')]") WebElement loginBtn;
	@FindBy (name="username") WebElement usrnm;
	@FindBy (name="password") WebElement passwd;
    @FindBy (xpath="//button[contains(text(),'Login to QKart')]") WebElement loginBtnQk;
    @FindBy (xpath="//button[text()='Logout']") WebElement logOutBtn;
    
    public void clickOnLoginBtn()
    {
    	loginBtn.click();
    }
    
    public void enterUserName(String un)
    {
    	usrnm.sendKeys(un);
    }
    
    public void enterPass(String pw)
    {
    	passwd.sendKeys(pw);
    }
    
    public void clickOnLoginQKart()
    {
    	loginBtnQk.click();
    }

	public boolean isLogoutBtnDisplayed() 
	{
		return logOutBtn.isDisplayed();
	}
}
