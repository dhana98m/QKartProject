package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import base.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObject.PageAttributesVerification;
import pageObject.UIElementsValidation;

public class PageAttributesVerificationSteps extends TestBase {

	//WebDriver driver = new EdgeDriver();
	PageAttributesVerification pav;
	
	@Then("user should see the place holder text {string} in search box")
	public void user_should_see_the_place_holder_text_in_search_box(String placeHolder) throws InterruptedException {
		Thread.sleep(2000);
		pav = new PageAttributesVerification(driver);
		Assert.assertEquals(placeHolder, pav.getSearchboxPlaceholder());
		System.out.println("Place holder in search box is correct");
	}

	@Then("the page title should be {string}")
	public void the_page_title_should_be(String title) {
		pav = new PageAttributesVerification(driver);
		Assert.assertEquals(title, pav.getTitleofthePage());
		System.out.println("Title of the page is correct");

	}

	@Then("the url should starts with {string}")
	public void the_url_should_starts_with(String url) {
		pav = new PageAttributesVerification(driver);
		if(pav.getURLofthePage().contains(url))
		{
			System.out.println("Yes, it contains https");
		}

	}
}
