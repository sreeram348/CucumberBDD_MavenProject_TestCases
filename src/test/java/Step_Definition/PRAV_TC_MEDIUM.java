package Step_Definition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PRAV_TC_MEDIUM {
	public WebDriver driver;
	@Given("^User$")
	public void user()  {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium triang\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:8585/do/login");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@onclick='publicRegisterUser()']")).click();


	}

	@When("^User completes his registration$")
	public void user_completes_his_registration()   {

		driver.findElement(By.xpath("//input[@name='member(user).username']")).sendKeys("Harshn");
		driver.findElement(By.xpath("//input[@name='member(name)']")).sendKeys("Harshinin");
		driver.findElement(By.xpath("//input[@name='member(email)']")).sendKeys("harshn@gmail.com");
		driver.findElement(By.xpath("//img[@src='/pages/images/calendar.gif']")).click();
		driver.findElement(By.xpath("//input[@fieldname='birthday']")).sendKeys("14-01-1999");
		driver.findElement(By.xpath("//input[@id='_radio_2_0']")).click();
		driver.findElement(By.xpath("//input[@fieldname='address']")).sendKeys("28/1/2 Indore");
		driver.findElement(By.xpath("//input[@fieldname='postalCode']")).sendKeys("500032");
		driver.findElement(By.xpath("//input[@fieldname='city']")).sendKeys("Indore");

		WebElement  area=driver.findElement(By.xpath("//select[@fieldname='area']"));		
		Select sel = new Select(area);
		sel.selectByVisibleText("Example area"); 

		driver.findElement(By.xpath("//input[@fieldname='phone']")).sendKeys("9980076656");
		driver.findElement(By.xpath("//input[@fieldname='mobilePhone']")).sendKeys("8899770006");
		driver.findElement(By.xpath("//input[@fieldname='fax']")).sendKeys("15523456889");
		driver.findElement(By.xpath("//input[@fieldname='url']")).sendKeys("www.google.com");
		driver.findElement(By.xpath("//input[@name='member(user).password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='captcha']")).click();

	}

	@When("^click on Submit button and logs out$")
	public void click_on_Submit_button_and_logs_out() throws InterruptedException  {
		
		Thread.sleep(11000);
		driver.findElement(By.xpath("//input[@id='saveButton']")).click();
		driver.findElement(By.id("btn")).click();
		
	}

	@Then("^Admin will provide access to the registered user$")
	public void admin_will_provide_access_to_the_registered_user() throws InterruptedException  {

		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		System.out.println("Admin logged in to provide access");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@id='menu0']//span[2]")).click(); //home
		driver.findElement(By.id("memberUsername")).sendKeys("Harshn");
		driver.findElement(By.id("memberName")).sendKeys("Harshinin");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(-250,document.body.scrollHeight)");
*/		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table//tbody//tr[2]//td//fieldset//table//tbody//tr[1]//td[4]//input")).click();
		
		System.out.println("change permission button was clicked");
		
		WebElement  newgroup=driver.findElement(By.xpath("//select[@name='newGroupId']"));		
		Select sel = new Select(newgroup);
		sel.selectByVisibleText("Full members");
		driver.findElement(By.id("comments")).sendKeys("full access to the member");Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();

		System.out.println("Access Provided");
		
		WebDriverWait wait1= new WebDriverWait(driver, 300);
		if(wait1.until(ExpectedConditions.alertIsPresent())==null)
		{
			System.out.println("Access not granted");
			driver.switchTo().alert().dismiss();
		}
		else
		{
			System.out.println("Access granted");
			driver.switchTo().alert().accept();
		}

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@class='menu lastMenu']//span[@class='menuText']")).click(); //logout

		WebDriverWait wait3= new WebDriverWait(driver, 300);
		if(wait3.until(ExpectedConditions.alertIsPresent())==null)
		{
			System.out.println("Didn't logged out");
			driver.switchTo().alert().dismiss();
		}
		else
		{
			System.out.println("Logged out");
			driver.switchTo().alert().accept();
		}
		Thread.sleep(3000);
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		System.out.println("Admin logged in");
	}
}
