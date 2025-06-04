package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.UIElementsValidation;

public class UIElementsValidationSteps extends TestBase {
	//WebDriver driver;
	UIElementsValidation ui;

	@Then("user should see the {string} button and it should be clickable")
	public void user_should_see_the_button_and_it_should_be_clickable(String buttonName) {
		 ui = new UIElementsValidation(driver);
		if (buttonName.equalsIgnoreCase("LOGIN")) {
			Assert.assertTrue(ui.isLoginBtnClickable());
		    System.out.println("Login Button is clickable");
		} else if (buttonName.equalsIgnoreCase("REGISTER")) {
			Assert.assertTrue(ui.isRegBtnClickable());
			System.out.println("Register button is clickable");
		} else {
			Assert.fail("Unknown button: " + buttonName);
		}
	}

	@Then("user should see the search text box and it should be enabled")
	public void user_should_see_the_search_text_box_and_it_should_be_enabled() {
		 ui = new UIElementsValidation(driver);
		Assert.assertTrue(ui.isSrchBtnClickable());
		System.out.println("Search button is clickable");
	}

	

}
