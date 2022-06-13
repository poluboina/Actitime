package com.actitime.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.actitime.genericLib.BaseTest;
import com.actitime.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	public static WebDriver driver;
	@Before
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saikr\\eclipse-workspace\\Actitime\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
	}
	
	@After
	public void closeBrowser()
	{
		driver.quit();
	}
	
	LoginPage lp;
	
	@Given("^user on Login Page$")
	public void user_on_login_page() {
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
		Reporter.log("Login Page is Displayed, PASS",true);
		
	}

	@When("^user enters username as (.*)$")
	public void user_enters_username_as_username(String un) {
		lp=new LoginPage(driver);
		lp.getUntb().sendKeys(un);
	}

	@When("^user enters password as (.*)$")
	public void user_enters_password_as_password(String pw) {
		lp=new LoginPage(driver);
		lp.getPwtb().sendKeys(pw);
	}

	@When("^user clicks on Login button$")
	public void user_clicks_on_login_button() {
		lp.getLoginBtn().click();
	}

	@Then("^user should be on home page$")
	public void user_should_be_on_home_page() throws InterruptedException {
		Thread.sleep(4000);
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		Reporter.log("Home Page is Displayed, PASS",true);
	}
}









