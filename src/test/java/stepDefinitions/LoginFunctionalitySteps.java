package stepDefinitions;

import org.junit.Assert;

import base.TestBase;
import io.cucumber.java.en.Then;
import pageObject.LoginFunctionality;

public class LoginFunctionalitySteps extends TestBase {

	LoginFunctionality lf;

	@Then("user should see the {string} button")
	public void user_should_see_the_button(String logoutBtn) {
		lf=new LoginFunctionality(driver);
	    if(logoutBtn.equalsIgnoreCase("LOGOUT"))
	    {
	    	Assert.assertTrue(lf.isLogoutBtnDisplayed());
		    System.out.println("Logout Button is displayed");
	    }
	}

}
