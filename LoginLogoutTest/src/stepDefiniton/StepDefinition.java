package stepDefiniton;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition{
	WebDriver driver;

@Given("^the user is on the login page$")
public void the_user_is_on_the_login_page() throws Throwable {
	System.setProperty("webdriver.gecko.driver", "/home/lily/Downloads/geckodriver");
	driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get("https://practicetestautomation.com/practice-test-login/");
}

@When("^the user enters valid Username and Password$")
public void the_user_enters_valid_Username_and_Password() throws Throwable {
	driver.findElement(By.id("username")).sendKeys("student");
	driver.findElement(By.id("password")).sendKeys("Password123");
}

@When("^the user clicks on the Login button$")
public void the_user_clicks_on_the_Login_button() throws Throwable {
	driver.findElement(By.id("submit")).click();
}

@Then("^the user should be redirected to the homepage$")
public void the_user_should_be_redirected_to_the_homepage() throws Throwable {
	String currentUrl = driver.getCurrentUrl();
	assertEquals(currentUrl, "https://practicetestautomation.com/logged-in-successfully/");
}

@Then("^the message \"([^\"]*)\" should be displayed on the homepage$")
public void the_message_should_be_displayed_on_the_homepage(String arg1) throws Throwable {
	WebElement webElement = driver.findElement(By.cssSelector(".post-title"));
	assertEquals(webElement, "Logged In Successfully");
}

@Given("^the user is on the homepage page$")
public void the_user_is_on_the_homepage_page() throws Throwable {
	the_user_is_on_the_login_page();
	the_user_enters_valid_Username_and_Password();
	the_user_clicks_on_the_Login_button();
}

@When("^the user clicks on the Logout button$")
public void the_user_clicks_on_the_Logout_button() throws Throwable {
	driver.findElement(By.cssSelector(".wp-block-button__link")).click();
}

@Then("^the user should be redirected to the login page$")
public void the_user_should_be_redirected_to_the_login_page() throws Throwable {
	String currentUrl = driver.getCurrentUrl();
	assertEquals(currentUrl, "https://practicetestautomation.com/practice-test-login/");
}

@When("^the user enters invalid Username Password$")
public void the_user_enters_invalid_Username_Password() throws Throwable {
	driver.findElement(By.id("username")).sendKeys("lalala");
	driver.findElement(By.id("password")).sendKeys("lalala");
}

@Then("^the message \"([^\"]*)\" should be displayed$")
public void the_message_should_be_displayed(String arg1) throws Throwable {
	WebElement webElement = driver.findElement(By.id("error"));
	assertEquals(webElement, "Your username is invalid!");
}

@When("^the user clicks on the Home menu$")
public void the_user_clicks_on_the_Home_menu() throws Throwable {
	driver.findElement(By.id("menu-item-43")).click();
}

@Then("^the user unable to logout successfully and should be redirected to the homepage$")
public void the_user_unable_to_logout_successfully_and_should_be_redirected_to_the_homepage() throws Throwable {
	String currentUrl = driver.getCurrentUrl();
	assertEquals(currentUrl, "https://practicetestautomation.com/");
}
}
