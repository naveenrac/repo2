package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class subscribeArabicPage {
	@FindBy(css = "#translation-btn")
	WebElement englishButton;

	public void clickEnglishButton() {
		englishButton.click();
	}
	WebDriver driver;

	public subscribeArabicPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
}
