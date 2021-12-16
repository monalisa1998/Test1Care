package care.maevenproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class providertestng {
WebDriver driver;
	
	@BeforeMethod
	public void initializing(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Initializing the borwser");
		
	}
	
	@AfterMethod
	public void closingbrowser(){
		driver.quit();
	}
	
	//  Static memory Allocation
	/* @DataProvider(name = "facebooktestdata")
	public static Object[][] data(){
	Object[][] data = new Object[2][2];

	data[0][0] ="username1";
	data[0][1]= "password1";
	data[1][0]="username2";
	data[1][1] = "password2";
	return data;

	}*/

	//    Dynamic memory Allocation
	@DataProvider(name = "facebooktestdata")
	public static Object[][] data(){
	return new Object[][]{
	{"username1","password1"},
	{"username2","password2"},
	{"username3","password3"} };
	
	}


	@Test(dataProvider= "facebooktestdata")
	public void ticketbooking(String un, String ps ) throws InterruptedException
	{
	driver.get("https://www.facebook.com/");
	WebElement Username = driver.findElement(By.name("email"));
	WebElement password = driver.findElement(By.name("pass"));
	Username.sendKeys(un);
	password.sendKeys(ps);
	Thread.sleep(1500);

	}
	
	
	
	
	
	
}


