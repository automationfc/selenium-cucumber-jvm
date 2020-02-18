package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps {
	private WebDriver driver;

	@Given("^I open live guru application$")
	public void iOpenLiveGuruApplication() {
		driver = new FirefoxDriver();
		driver.get("http://live.demoguru99.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@When("^Click to My Account page$")
	public void clickToMyAccountPage() {
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	}

	@When("^Input to email textbox with \"([^\"]*)\"$")
	public void inputToEmailTextboxWith(String emailValue) {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailValue);
	}

	@When("^Input to password textbox with \"([^\"]*)\"$")
	public void inputToPasswordTextboxWith(String password) {
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
	}

	@When("^Click to Login button$")
	public void clickToLoginButton() {
		driver.findElement(By.xpath("//button[@id='send2']")).click();
	}

	@Then("^Verify error message displayed at email textbox$")
	public void verifyErrorMessageDisplayedAtEmailTextbox() {
		Assert.assertTrue(driver
				.findElement(
						By.xpath("//div[@id='advice-required-entry-email' and text()='This is a required field.']"))
				.isDisplayed());
	}

	@Then("^Verify error message displayed at password textbox$")
	public void verifyErrorMessageDisplayedAtPasswordTextbox() {
		Assert.assertTrue(driver
				.findElement(By.xpath("//div[@id='advice-required-entry-pass' and text()='This is a required field.']"))
				.isDisplayed());
	}

	@Then("^Quit application$")
	public void quitApplication() {
		driver.quit();
	}

}