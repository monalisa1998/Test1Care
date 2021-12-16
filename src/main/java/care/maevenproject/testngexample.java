package care.maevenproject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class testngexample {
WebDriver driver;
@BeforeMethod
public void init()
{
System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver.exe");
driver = new ChromeDriver();
}
@AfterMethod
public void closingbrowser()
{
driver.quit();
}
@Test(priority=1)
public void testcase1() throws InterruptedException
{
driver.get("https://www.google.com/");
Thread.sleep(5000);
}
@Test(dependsOnMethods="testcase1")
public void testcase2() throws InterruptedException
{
driver.get("https://www.makemytrip.com/");
Thread.sleep(5000);
}
@BeforeSuite
public void beforesuiteex()
{
System.out.println("before suite");
}
@AfterSuite
public void aftersuiteex()
{
System.out.println("after suite");
}

@Test(groups={"ticketbooking","regression"})
public void ticketbooking()
{

System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://www.makemytrip.com/");
System.out.println("this is my test case 1");


}

@Test(groups={"smoke"})
public void statuscheck() throws InterruptedException
{
//driver.get("https://www.google.com/");
Thread.sleep(5000);
System.out.println("this is my test case 2");

}
}

