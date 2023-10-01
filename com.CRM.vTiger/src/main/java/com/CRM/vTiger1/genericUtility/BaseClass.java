package com.CRM.vTiger1.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.CRM.vTiger1.ObjectRepository.HomePage;
import com.CRM.vTiger1.ObjectRepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver ldriver;	//Only For Listner Class
	FileUtility util=new FileUtility();
	WebDriverUtility web=new WebDriverUtility();
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig() {
		System.out.println("Create database connection");
	}
	@Parameters("Browser")
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String Browser*/) throws Throwable {
		
		String Browser=util.toGetDataFromPropertyFile("browserName");
		
		//READ DATA FROM COMMAND LINE
		//String Browser=System.getProperty("browserName");
		String url=util.toGetDataFromPropertyFile("url");
		if(Browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();		
			}
		else if(Browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=new EdgeDriver();
		}
		ldriver=driver;		//Only For Listner Class
		driver.get(url);
		web.maximize(driver);
		web.implicitWait(driver);
	}
	
	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws Throwable {
		String username = util.toGetDataFromPropertyFile("userName");
		String pwd=util.toGetDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginIntoApp(username, pwd);
	}
	
	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void amConfig() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		hp.signoutFromApp(driver);
	}
	
	@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	public void acConfig() {
		driver.quit();
	}
	
	@AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void asConfig() {
		System.out.println("Close database connection");
	}
}
























