package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiteSubscriptionTypePage {
@FindBy(css="#lite-selection")
WebElement startYourtrial;

@FindBy(css="#FIGHTING_SPIRIT_SUBSCRIPTION > div > div.payment-header > div > b")
WebElement vsSarmonth;

@FindBy(css="#btnChoosePaymentMethod")
WebElement orderSummaryNextButton;

WebDriver driver;

public void clickOnorderSummaryNextButton() {
	orderSummaryNextButton.click();
}

public void clickonvsSarType() {
	vsSarmonth.click();
}

public void clickonstartYourtrial() {
	startYourtrial.click();
}
public LiteSubscriptionTypePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
}
