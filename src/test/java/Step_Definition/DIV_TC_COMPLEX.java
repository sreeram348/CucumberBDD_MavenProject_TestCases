package Step_Definition;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Cucumber.Transform.ExcelDataToDataTable3;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DIV_TC_COMPLEX {
	public WebDriver driver;
	
	@Given("^As an admin$")
	public void as_an_admin() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium triang\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8585/");

		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	   
	}
	@When("^Admin enters <Member login> at \"([^\"]*)\"\\.$")
	public void admin_enters_Member_login_at(@Transform(ExcelDataToDataTable3.class)DataTable table) throws Throwable {
		 List<String> dataList = new ArrayList<String>(table.asList(String.class));
			
			for(int i=0;i<dataList.size();i++){
				System.out.println(dataList.get(i));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("memberUsername")).sendKeys(dataList.get(i));
		Thread.sleep(30000);
		Robot robo=new Robot();
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath("//input[@linkurl='changeMemberGroup?memberId=9']")).click();
		WebElement ng=driver.findElement(By.name("newGroupId"));
		Select sel=new Select(ng);
		sel.selectByVisibleText("Full members"); 
		driver.findElement(By.id("comments")).sendKeys("welcome");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Alert a =driver.switchTo().alert();
		a.accept(); 
		
		driver.findElement(By.xpath("//li[@id='menu0']//span[@class='menuText']")).click();
		
	}


	}}
