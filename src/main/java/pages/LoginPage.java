package pages;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import mobileWrapper.AppSpecificMethods;

public class LoginPage extends AppSpecificMethods{
	
	public LoginPage(AppiumDriver<WebElement> driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	
	public LoginPage enterEmailAddress(String email) {
		if(enterValue(email, "xpath", "//input[@placeholder='Email']"))
			reportStep("Email address "+email+" entered successfully", "PASS");
		else
			reportStep("Email address couldn't enter", "FAIL");
		return this;
	}
	
	public LoginPage enterPassword(String pwd) {
		if(enterValue(pwd, "xpath", "//input[@placeholder='Password']"))
			reportStep("Email address "+pwd+" entered successfully", "PASS");
		else
			reportStep("Email address couldn't enter", "FAIL");
		return this;
	}
	
	@When("the user clicked login which is designed under the password test field")
	public HomePage clickLogin() {
		if(click("xpath", "//span[text()='Login']")) {
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("done");
			reportStep("Login button clicked Successfully", "PASS");
		}
		else
			reportStep("Login button click failed", "FAIL");
		return new HomePage(driver, test);
	}
	
	@Given("the user enter valied credential username as {} and password as {}")
	public void enterValidCredential(String email, String pwd) {
		enterEmailAddress(email);
		enterPassword(pwd);
	}
	
	

}
