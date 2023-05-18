package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class subscribeEnglishPage {
	@FindBy(css="#country-name")
	WebElement countryName;
	
	@FindBy(css="#classic-selection")
	WebElement classicPlanSelection;
	
	WebDriver driver;
	
	public void clickSelection() {
		classicPlanSelection.click();
	}
	
	public WebElement getCountryName() {
		return countryName;
	}

	public void setCountryName(WebElement countryName) {
		this.countryName = countryName;
	}

	public subscribeEnglishPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

}
