package care.maevenproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class upskilltestng {
	
	WebDriver driver;
	
	@BeforeMethod
	public void initializing(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Initializing the borwser");
		
	}
	
	@AfterMethod
	public void closingbrowser(){
		driver.quit();
	}
	
	//  Static memory Allocation
	 @DataProvider(name = "facebooktestdata")
	public static Object[][] data(){
	Object[][] data = new Object[2][6];

	data[0][0] ="monalisa";
	data[0][1]= "dash";
	data[0][2] ="mona@gmail.com";
	data[0][3]= "mona98";
	data[0][4] ="pass72067";
	data[0][5]= "pass09876";
	
	data[1][0] ="Pinaki";
	data[1][1]= "Nandan";
	data[1][2] ="mjpinaki@gmail.com";
	data[1][3]= "pinaki97";
	data[1][4] ="pass3456";
	data[1][5]= "pass123987";
	return data;

	}

/*	//    Dynamic memory Allocation
	@DataProvider(name = "facebooktestdata")
	public static Object[][] data(){
	return new Object[][]{
	{"username1","password1"},
	{"username2","password2"},
	{"username3","password3"} };
	
	}*/


	@Test(dataProvider= "facebooktestdata")
	public void ticketbooking(String fn, String ln, String email, String usern, String pw, String cpw ) throws InterruptedException
	{
		
	driver.get("http://elearningm1.upskills.in/main/auth/inscription.php");
	driver.findElement(By.xpath("//input[@name='pass2']")).sendKeys(""); // Empty
	WebElement Firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
	WebElement Lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
	WebElement Email = driver.findElement(By.xpath("//input[@name='email']"));
	WebElement Username = driver.findElement(By.xpath("//input[@name='username']"));
	WebElement Password1 = driver.findElement(By.xpath("//input[@name='pass1']"));
	WebElement Password2 = driver.findElement(By.xpath("//input[@name='pass2']"));
	
	Firstname.sendKeys(fn);
	Lastname.sendKeys(ln);
	Email.sendKeys(email);
	Username.sendKeys(usern);
	Password1.sendKeys(pw);
	Password2.sendKeys(cpw);
	
	Thread.sleep(2000);
	
	//Clicking on Register Button
	WebElement obj = driver.findElement(By.name("submit"));
	obj.click();

	Thread.sleep(2500);
	}
	
}
