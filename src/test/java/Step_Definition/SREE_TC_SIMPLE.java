package Step_Definition;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class SREE_TC_SIMPLE {
	public WebDriver driver;
	@Given("^as an unregistered user$")
	public void as_an_unregistered_user(){
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium triang\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8585/");
		 driver.findElement(By.xpath("//input[@onclick='publicRegisterUser()']")).click();
	}
	@When("^I fill out the signup form$")
	public void i_fill_out_the_signup_form() throws InterruptedException {
		
		  driver.findElement(By.name("member(user).username")).sendKeys(" sree1 ");
		  driver.findElement(By.name("member(name)")).sendKeys("sree123");
		  driver.findElement(By.name("member(email)")).sendKeys("mnbvx134@gmail.com");
		  driver.findElement(By.xpath("//input[@name='_radio_2' and @value='2']")).click();
		  driver.findElement(By.xpath("//input[@fieldname='address']")).sendKeys("banglore","KARNATAKA");
		  driver.findElement(By.xpath("//input[@fieldname='postalCode']")).sendKeys("5642671");
		  driver.findElement(By.xpath("//input[@fieldname='city']")).sendKeys("Banglore");
		  driver.findElement(By.xpath("//input[@fieldname='phone']")).sendKeys("42234569");
		  driver.findElement(By.xpath("//input[@fieldname='mobilePhone']")).sendKeys("9976543200");
		  driver.findElement(By.xpath("//input[@fieldname='fax']")).sendKeys("15263784758449"); 
		  driver.findElement(By.xpath("//input[@name='member(user).password']")).sendKeys("1234");
		  driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("1234");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		              
	}

	@When("^click submit$")
	public void click_submit() {
		 driver.findElement(By.xpath("//input[@id='saveButton']")).click();
	}

	@Then("^I should receive a confirmation message stating:\"([^\"]*)\"  \\.$")
	public void i_should_receive_a_confirmation_message_stating(String arg1) {
		 String expected ="Thanks for registering!    Your account has been created and needs to be activated b the administration";
		 String actual=driver.findElement(By.xpath("//table[@class='defaultTable']//tbody//tr//td")).getText();
		 assertEquals(expected, actual);
		 System.out.println("Message displayed");
		 driver.close();
		
	}


}
