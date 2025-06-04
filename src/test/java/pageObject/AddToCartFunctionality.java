package pageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartFunctionality {

	WebDriver driver;

	public AddToCartFunctionality(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(idriver, this);
	}

	// Repository
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	WebElement loginBtn;
	@FindBy(name = "username")
	WebElement usrnm;
	@FindBy(name = "password")
	WebElement passwd;
	@FindBy(xpath = "//button[contains(text(),'Login to QKart')]")
	WebElement loginBtnQk;
	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-md-3 css-sycj1h']")
	List<WebElement> itemTable;
	// @FindBy (xpath=".//div[@class='MuiCardActions-root MuiCardActions-spacing
	// card-actions css-3zukih']//button[1]")
	// WebElement addtoCartBtn;
	@FindBy(xpath = "//div[@class='SnackbarContainer-bottom SnackbarContainer-center SnackbarContainer-root css-uwcd5u']//descendant::div[@id='notistack-snackbar']")
	WebElement duplicateMsg;
	@FindBy(xpath = "//div[@class='cart MuiBox-root css-0']")
	List<WebElement> cartTable;
	@FindBy(xpath = "//div[@class='cart MuiBox-root css-0']//div[@class='cart-footer MuiBox-root css-1bvc4cc']//button[@type='button']")
	WebElement checkOutBtn;
	@FindBy(xpath = "//button[@id='add-new-btn']")
	WebElement addAddressBtn;
	@FindBy(xpath = "//div[@class='MuiFormControl-root MuiTextField-root css-i44wyl']//textarea[1]")
	WebElement addAddress;
	@FindBy(xpath = "//div[@class='css-19a1170']//button[text()='Add']")
	WebElement addBtn;
	@FindBy(xpath = "//div[@class='MuiBox-root css-0']")
	List<WebElement> addressTable;

	public void clickOnLoginBtn() {
		loginBtn.click();
	}

	public void enterUserName(String un) {
		usrnm.sendKeys(un);
	}

	public void enterPass(String pw) {
		passwd.sendKeys(pw);
	}

	public void clickOnLoginQKart() {
		loginBtnQk.click();
	}

	public void selectItemFromListAndAddtoCart(String itemOName) throws InterruptedException {
		for (WebElement items : itemTable) {
			Thread.sleep(3000);
			WebElement item = items.findElement(By.xpath(".//p"));
			String itemName = item.getText().trim();
			if (itemOName.equalsIgnoreCase(itemName)) {
				WebElement maindiv = items.findElement(By.xpath(
						".//ancestor::div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root card css-s18byi']"));
				WebElement addtoCartBtn = maindiv.findElement(By.tagName("button"));
				Thread.sleep(3000);
				addtoCartBtn.click();
				break;
			}

		}
	}

	public String selectSameItemFromList(String sameItemName) throws InterruptedException {
		String duplicateMsgTxt = null;
		for (WebElement items : itemTable) {
			WebElement item = items.findElement(By.xpath(".//p"));
			String itemName = item.getText().trim();

			if (sameItemName.equalsIgnoreCase(itemName)) {
				WebElement maindiv = items.findElement(By.xpath(
						".//ancestor::div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root card css-s18byi']"));
				WebElement addtoCartBtn = maindiv.findElement(By.tagName("button"));
				Thread.sleep(3000);
				addtoCartBtn.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement snackbar = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='notistack-snackbar']")));
				duplicateMsgTxt = snackbar.getText().trim();

				/*
				 * Thread.sleep(5000); duplicateMsgTxt=duplicateMsg.getText().trim();
				 */
				break;
			}
		}
		return duplicateMsgTxt;
	}

	public void selectNewItemFromListAndAddtoCart(String itemSName, String shoeSize) throws InterruptedException {
		for (WebElement items : itemTable) {
			WebElement item = items.findElement(By.xpath(".//p"));
			String itemName = item.getText().trim();
			if (itemSName.equalsIgnoreCase(itemName)) {
				WebElement sizeDropDown = driver.findElement(By.xpath(".//select"));
				Select size = new Select(sizeDropDown);
				size.selectByVisibleText(shoeSize);
				Thread.sleep(3000);
				WebElement maindiv = items.findElement(By.xpath(
						".//ancestor::div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiCard-root card css-s18byi']"));
				Thread.sleep(5000);
				WebElement addtoCartBtn = maindiv.findElement(By.xpath(".//button[text()='Add to cart']"));
				addtoCartBtn.click();
				Thread.sleep(3000);
				break;
			}

		}
	}

	List<String> actualItemNames = new ArrayList<String>();

	public void validateCartItems(List<String> expectedItemNames) {
		for (WebElement cartItems : cartTable) {

			WebElement cartItem = cartItems.findElement(By.xpath(".//div[@class='MuiBox-root css-1gjj37g']//div"));
			String actualItemName = cartItem.getText().trim();
			actualItemNames.add(actualItemName);
		}

		for (String expectedItem : expectedItemNames) {
			if (actualItemNames.contains(expectedItem)) {
				System.out.println("Items added in the cart as expected");
			}
		}
	}

	public void clickOnCheckOutBtn() {
		checkOutBtn.click();
	}

	public String getTitleOfThePage() {
		return driver.getTitle();
	}

	public void clickOnAddAddressBtn(String address) throws InterruptedException {
		addAddressBtn.click();
		Thread.sleep(4000);
		addAddress.sendKeys(address);
	}

	public void clickOnAddBtn(String expectedAddress) throws InterruptedException {
		addBtn.click();
		Thread.sleep(4000);
		//List<WebElement> addressTable = driver.findElements(By.xpath("//div[contains(@class,'MuiGrid-item')]"));
		boolean addressFound=false;
		for (WebElement addressNames : addressTable) {
			List<WebElement> addressName = addressNames.findElements(By.tagName("p"));
			//System.out.println(addressName.size());
			for (WebElement addressPara : addressName)
			{
			String actualAddress = addressPara.getText().trim();		
			if (actualAddress.equalsIgnoreCase(expectedAddress)) {
				System.out.println("Expected address added correctly");
				addressFound=true;
				break;
			}
			}
			
			if(addressFound)
			{
				break;
			}
			
		}
	}

	public void deleteAddress(String expAddrtoDelete) throws InterruptedException {
		boolean addressFound=false;
		for (WebElement addressNamesToDelete : addressTable) {
			List<WebElement> addressName = addressNamesToDelete.findElements(By.tagName("p"));
			for (WebElement addressPara : addressName)
			{
			String actualaddrToDelete = addressPara.getText().trim();
			if (actualaddrToDelete.equalsIgnoreCase(expAddrtoDelete)) {
				addressFound=true;
				//WebElement maindiv = addressName.findElement(By.xpath(".//ancestor::div[@class='address-item not-selected MuiBox-root css-0']"));
				WebElement deleteBtn = addressNamesToDelete.findElement(By.xpath(".//button"));
				deleteBtn.click();
				Thread.sleep(2000);
				break;
			}
			}
			if(addressFound)
			{
				break;
			}
		}
	}

	// Item already in cart. Use the cart sidebar to update quantity or remove item.

}
