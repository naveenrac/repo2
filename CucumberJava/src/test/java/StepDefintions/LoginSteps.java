package StepDefintions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginSteps {
	WebDriver driver = null;

	@Given("user is logged into page")
	public void user_is_logged_into_page() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://subscribe.stctv.com/sa-ar?");

	}

	@When("user clicks on English button")
	public void user_clicks_on_english_button() {
		WebElement englishButton = driver.findElement(By.cssSelector("#translation-btn"));
		englishButton.click();
		driver.get("https://subscribe.stctv.com/sa-en");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement countryName = driver.findElement(By.cssSelector("#country-name"));
		String country = countryName.getText();
		assertEquals(country, "KSA");

	}

	@And("user clicks on classic plan")
	public void user_navigates_to_login_page() {
		WebElement classicPlan = driver.findElement(By.cssSelector("#classic-selection"));
		classicPlan.click();
		WebElement paymentMethodText = driver
				.findElement(By.cssSelector("#main > div > div > div:nth-child(1) > div > h3"));
		String payment = paymentMethodText.getText();
		assertEquals(payment, "Payment Method");
		WebElement nextButton = driver.findElement(By.cssSelector("#btnChoosePaymentMethod"));
		nextButton.click();

		WebElement paymentMethod = driver
				.findElement(By.cssSelector("#FIGHTING_SPIRIT_SUBSCRIPTION > div > div.payment-header > div > b"));
		paymentMethod.click();
		WebElement nextButtononOrderSummary = driver.findElement(By.cssSelector("#btnChooseAddons"));
		nextButtononOrderSummary.click();
		WebElement mobileNumber = driver.findElement(By.cssSelector(
				"#main > div.container > div > div:nth-child(1) > div:nth-child(1) > div > input[type=text]"));
		mobileNumber.sendKeys("505473147");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement nextButtonpromocodepage = driver.findElement(By.cssSelector("#btnFinalStepSubscribe"));
		try {
			nextButtonpromocodepage.click();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			WebElement popUp = driver.findElement(By.cssSelector("#submitPopupAction"));
			popUp.click();
		} catch (Exception e) {
			driver.close();
		}
	}

	@Then("verify user clicks on LITE plan")
	public void verify_landed_on_correct_page() {
		try {
			user_is_logged_into_page();
			WebElement englishButton = driver.findElement(By.cssSelector("#translation-btn"));
			englishButton.click();
			driver.get("https://subscribe.stctv.com/sa-en");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement startYourtrial = driver.findElement(By.cssSelector("#lite-selection"));
			startYourtrial.click();
			WebElement vsSarmonth= driver.findElement(By.cssSelector("#FIGHTING_SPIRIT_SUBSCRIPTION > div > div.payment-header > div > b"));
			vsSarmonth.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebElement orderSummaryNextButton = driver.findElement(By.cssSelector("#btnChoosePaymentMethod"));
			orderSummaryNextButton.click();
		} catch (Exception e) {
			driver.close();
		}
	}
}
