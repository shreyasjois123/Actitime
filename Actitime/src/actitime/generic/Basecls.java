package actitime.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.acttime.pom.HomePage;
import com.acttime.pom.loginpage;

public class Basecls {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
		public static WebDriver driver;
		@BeforeTest
		public void openBrowser() {
			Reporter.log("openBrowser",true);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
@AfterTest
public void closeBrowser() {
	Reporter.log("close the browser",true);
	driver.close();
}
@BeforeTest
public void login() throws IOException {
	Reporter.log("log i to the webapplication",true);
	loginpage l=new loginpage(driver);
	FileLib f=new FileLib();
	String url = f.getPropertyData("url");
	String un = f.getPropertyData("username");
	String pw = f.getPropertyData("password");
	driver.get(url);
	l.setlogin(un, pw);	
}
@AfterMethod
public void logout() {
	HomePage h=new HomePage(driver);
	h.getLgbtn().click();
}
}
