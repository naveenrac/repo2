package StepDefintions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LiteSubscriptionTypePage;
import pages.classicPaymentMethodPage;
import pages.subscribeArabicPage;
import pages.subscribeEnglishPage;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class LoginSteps {
	WebDriver driver = null;
    subscribeArabicPage subscribePage;
    subscribeEnglishPage subscribeenglish;
    classicPaymentMethodPage classicPaymentMethod;
    LiteSubscriptionTypePage liteSubscribePage;
	@Given("user is logged into page")
	public void user_is_logged_into_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://subscribe.stctv.com/sa-ar?");

	}

	@When("user clicks on English button")
	public void user_clicks_on_english_button() {
		subscribePage=new subscribeArabicPage(driver);
		subscribePage.clickEnglishButton();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		subscribeenglish= new subscribeEnglishPage(driver);
		String country = subscribeenglish.getCountryName().getText();
		assertEquals(country, "KSA");

	}

	@And("user clicks on classic plan")
	public void user_navigates_to_login_page() {
		subscribeenglish= new subscribeEnglishPage(driver);
		subscribeenglish.clickSelection();
		classicPaymentMethod=new classicPaymentMethodPage(driver);
		String payment = classicPaymentMethod.getPaymentMethodText().getText();
		assertEquals(payment, "Payment Method");
		classicPaymentMethod.clickonNextButtonPaymentMethod();
		classicPaymentMethod.clickonFightingSpritSub();
		classicPaymentMethod.clickonnextButtonOrderSummary();
		classicPaymentMethod.setMobileNumber("505473147");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		try {
			classicPaymentMethod.clickonnextButtonofPromo();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			classicPaymentMethod.clickonpopUp();
		} catch (Exception e) {
			driver.close();
		}
	}

	@Then("verify user clicks on LITE plan")
	public void verify_landed_on_correct_page() {
		try {
			user_is_logged_into_page();
			subscribePage=new subscribeArabicPage(driver);
			subscribePage.clickEnglishButton();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			liteSubscribePage=new LiteSubscriptionTypePage(driver);
			liteSubscribePage.clickonstartYourtrial();
			liteSubscribePage.clickonvsSarType();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			liteSubscribePage.clickOnorderSummaryNextButton();
		} catch (Exception e) {
			driver.close();
		}
	}
}
