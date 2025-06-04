package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import pageObject.HomePageElementsVerification;

public class HomePageElementsVerificationSteps extends TestBase {

	HomePageElementsVerification hp;
	
	
	@Then("user should see the images count {int}")
	public void user_should_see_the_images_count(int imgcount) throws InterruptedException {
		hp=new HomePageElementsVerification(driver);
		if(hp.imagesCount()==imgcount)
	    {
	    	System.out.println("Images count is matched");
	    }
	}

	@Then("user should see the links count {int}")
	public void user_should_see_the_links_count(int linkcount) {
		hp=new HomePageElementsVerification(driver);
		if(hp.linksCount()==linkcount)
	    {
	    	System.out.println("Links count is matched");
	    }
	}
	
}
