package Step_Definition;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Cucumber.Transform.ExcelDataToDataTable;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SREE_TC_COMPLEX {
	public WebDriver driver;
	@Given("^Registration Page$")
	public void in_Registration_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium triang\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8585/");
		 driver.findElement(By.xpath("//input[@onclick='publicRegisterUser()']")).click();
	}

	
	@When("^Enter Details <Login name>,<Full name>,<E-Mail>	,<Gender>,<Address>,<Postal Code>,<City>,<Phone>,<Mobile phone>,<Fax>,<Url>,<Password>	and <Confirm password> at\"([^\"]*)\"\\.$")
	public void enters_Login_name_Full_name_E_Mail_Gender_Address_Postal_Code_City_Phone_Mobile_phone_Fax_Url_Password_and_Confirm_password(@Transform(ExcelDataToDataTable.class)DataTable table) throws Throwable {
		
		   List<String> dataList = new ArrayList<String>(table.asList(String.class));
			
			for(int i=0;i<dataList.size();i++){
				System.out.println(dataList.get(0));
				 driver.findElement(By.name("member(user).username")).sendKeys(dataList.get(i));
				 i++;
				  driver.findElement(By.name("member(name)")).sendKeys(dataList.get(i));
				  i++;
				  driver.findElement(By.name("member(email)")).sendKeys(dataList.get(i));
				  i++;
				  driver.findElement(By.name("member(customValues).value")).sendKeys(dataList.get(i));
				  i++;
				  driver.findElement(By.xpath("//input[@name='_radio_2' and @value='2']")).click();
				  i++;
				  driver.findElement(By.xpath("//input[@fieldname='address']")).sendKeys(dataList.get(i));
				  i++;
				  driver.findElement(By.xpath("//input[@fieldname='postalCode']")).sendKeys(dataList.get(i));
				  i++;
				  driver.findElement(By.xpath("//input[@fieldname='city']")).sendKeys(dataList.get(i));
				  i++;
				  driver.findElement(By.xpath("//input[@fieldname='phone']")).sendKeys(dataList.get(i));
				  i++;
				  driver.findElement(By.xpath("//input[@fieldname='mobilePhone']")).sendKeys(dataList.get(i));
				  
				  i++;
				  driver.findElement(By.xpath("//input[@fieldname='fax']")).sendKeys(dataList.get(i)); 
				  i++;
				  driver.findElement(By.xpath("//input[@name='member(customValues).value']")).sendKeys(dataList.get(i));
				  i++;
				  driver.findElement(By.xpath("//input[@name='member(user).password']")).sendKeys(dataList.get(i));
				  i++;
				  driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(dataList.get(i));
				  Thread.sleep(10000);
				  
				  driver.findElement(By.xpath("//input[@id='saveButton']")).click();
				  String expected ="Thanks for registering!    Your account has been created and needs to be activated b the administration";
					 String actual=driver.findElement(By.xpath("//table[@class='defaultTable']//tbody//tr//td")).getText();
					 assertEquals(expected, actual);
					 System.out.println("Message displayed");
					 driver.close();
				  
			}
		
		
		
	}
}