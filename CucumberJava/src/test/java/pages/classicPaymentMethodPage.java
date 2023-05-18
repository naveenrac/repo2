package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class classicPaymentMethodPage {
	@FindBy(css = "#main > div > div > div:nth-child(1) > div > h3")
	WebElement paymentMethodText;

	@FindBy(css = "#btnChoosePaymentMethod")
	WebElement nextButtonPaymentMethod;
	
	@FindBy(css="#FIGHTING_SPIRIT_SUBSCRIPTION > div > div.payment-header > div > b")
    WebElement fightingSpiritSub;
	
	@FindBy(css="#btnChooseAddons")
	WebElement nextButtononOrderSummary;
	
	@FindBy(css="#main > div.container > div > div:nth-child(1) > div:nth-child(1) > div > input[type=text]")
	WebElement mobileNumber;
	
	@FindBy(css="#btnFinalStepSubscribe")
	WebElement nextButtonpromocodepage;
	
	@FindBy(css="#submitPopupAction")
	WebElement popUp;
    
	WebDriver driver;
	
	public void clickonpopUp() {
		popUp.click();
	}
	
	public void clickonnextButtonofPromo() {
		nextButtonpromocodepage.click();
	}
	
	public WebElement getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String number) {
		mobileNumber.clear();
		mobileNumber.sendKeys(number);
	}

	public void clickonnextButtonOrderSummary() {
		nextButtononOrderSummary.click();
	}
	
	public void clickonFightingSpritSub() {
		fightingSpiritSub.click();
	}

	public void clickonNextButtonPaymentMethod() {
		nextButtonPaymentMethod.click();
	}

	public WebElement getPaymentMethodText() {
		return paymentMethodText;
	}

	public void setPaymentMethodText(WebElement paymentMethodText) {
		this.paymentMethodText = paymentMethodText;
	}

	public classicPaymentMethodPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
