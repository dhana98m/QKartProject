package stepDefinitions;

import java.util.Arrays;
import java.util.List;

import base.TestBase;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pageObject.AddToCartFunctionality;
import pageObject.HomePageElementsVerification;
import pageObject.LoginFunctionality;

public class AddToCartFunctionalitySteps extends TestBase{

	AddToCartFunctionality ac;

	
	@Then("user adds {string} item to cart")
	public void user_adds_item_to_cart(String addItem) throws InterruptedException {
		ac=new AddToCartFunctionality(driver);
	    ac.selectItemFromListAndAddtoCart(addItem);
	}

	@Then("user clicks add to cart again for {string} and validates the message {string}")
	public void user_clicks_add_to_cart_again_for_and_validates_the_message(String addItemAgain, String dupMsg) throws InterruptedException {
		ac=new AddToCartFunctionality(driver);
	  String actualDupMsg=ac.selectSameItemFromList(addItemAgain);
	  Assert.assertEquals(dupMsg,actualDupMsg);
	}

	@Then("user adds {string} and select size {string} from the dropdown")
	public void user_adds_and_select_size_from_the_dropdown(String addNewItem, String sizeS) throws InterruptedException {
		ac=new AddToCartFunctionality(driver);
	    ac.selectNewItemFromListAndAddtoCart(addNewItem, sizeS);
	}

	@Then("user validates the cart items {string},{string}")
	public void user_validates_the_cart_items(String item1, String item2) {
		ac=new AddToCartFunctionality(driver);
		List<String> expectedItems=Arrays.asList(item1,item2);
	    ac.validateCartItems(expectedItems);
	}

	@Then("user clicks on checkout button")
	public void user_clicks_on_checkout_button() {
		ac=new AddToCartFunctionality(driver);
	    ac.clickOnCheckOutBtn();
	}

	@Then("user verifies that the page title is {string}")
	public void user_verifies_that_the_page_title_is(String expPageTitle) {
		ac=new AddToCartFunctionality(driver);
	    Assert.assertEquals(expPageTitle, ac.getTitleOfThePage());
	}

	@Then("user clicks on add new address and enters address {string}")
	public void user_clicks_on_add_new_address_and_enters_address(String addressToAdd) throws InterruptedException {
		ac=new AddToCartFunctionality(driver);
	    ac.clickOnAddAddressBtn(addressToAdd);
	}

	@Then("user clicks on ADD button and verifies the address {string} entered is displayed")
	public void user_clicks_on_add_button_and_verifies_the_address_entered_is_displayed(String addressToVerify) throws InterruptedException {
		ac=new AddToCartFunctionality(driver);
	    ac.clickOnAddBtn(addressToVerify);
	}

	@Then("user clicks on DELETE button to remove an address {string}")
	public void user_clicks_on_delete_button_to_remove_an_address(String addressToDelete) throws InterruptedException {
		ac=new AddToCartFunctionality(driver);
	    ac.deleteAddress(addressToDelete);
	}
	
}
