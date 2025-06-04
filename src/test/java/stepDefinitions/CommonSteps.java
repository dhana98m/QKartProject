package stepDefinitions;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginFunctionality;

public class CommonSteps extends TestBase{

	@Given("user Launch the Browser")
    public void user_launch_the_browser() {
        initializeDriver();
    }

    @When("user Launch the application by passing the URL {string}")
    public void user_launch_the_application_by_passing_the_url(String url) {
        driver.get(url);
    }
    
    @Then("user clicks on login button")
	public void user_clicks_on_login_button() {
    	clickOnLoginBtn();
	}

	@Then("user enters username as {string}")
	public void user_enters_username_as(String usernm) {
		enterUserName(usernm);
	}

	@Then("user enter password as {string}")
	public void user_enter_password_as(String pass) {
		enterPass(pass);
	}

	@Then("user clicks on login to QKart")
	public void user_clicks_on_login_to_q_kart() {
		clickOnLoginQKart();
	}

    @After
    public void tearDown() {
        quitDriver();
    }

}
