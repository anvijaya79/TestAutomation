package com.fyber.imdb.testClasses;

import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fyber.common.utils.Logging;
import com.google.common.base.Function;
import com.thoughtworks.selenium.webdriven.ElementFinder;
import com.thoughtworks.selenium.webdriven.JavascriptLibrary;

public class BaseTest {
	public static WebDriver driver=null;
	
	
	public static Logger log;
	public static final int TIMEOUT = 30;
	public static com.thoughtworks.selenium.webdriven.ElementFinder elementFinder;
	public static WebDriverWait wait; 
	public static FluentWait fwait;
	public static WebElement element;
	public String browserType ="firefox";
	public static WebElement webdriverwait;
	public static WebElement fluentwait;
	public static final int fluentwithtimeout = 60;
	public static final int fluentpolling = 5;
	public static Actions action;
	public static boolean value;
	  public static String userDir = System.getProperty("user.dir");
	  public static String destFile = userDir+"/src/chromedriver.exe";
	public static void initConfig(String Testname) {
		
		
		String filename = Testname + "latest";
		 String logname = filename+".txt";

		 log = Logging.getLogger(logname);
		 
		 
	}
	
	
	
	public static boolean init(String browserType,String remoteurl,String url) {
		
		
		try {

			log.info("Entering init function");
			JavascriptLibrary javascriptLibrary = new JavascriptLibrary();

			elementFinder = new ElementFinder(javascriptLibrary);
			
			

			
			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities.setJavascriptEnabled(true);

			capabilities.setBrowserName(browserType);

			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			

			

			driver = new RemoteWebDriver(new URL(remoteurl),capabilities );
				 driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
				
			
			try {
			driver.get(url);
			
			}
			catch (Exception e) {
				log.info("Unable to launch the url.Please check the ip");
			return false;
			}
			
			try {
				wait = new WebDriverWait(driver, TIMEOUT);
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("IMDb")));
			} catch(Exception e1) {
				log.info("Please check if the url is proper");
				driver = null;
				System.out.println("We could not get an instance of the web browser");
				e1.printStackTrace();
				driver.quit();

				return false;
			
			}
			
			if(element != null) {
				System.out.println("Successfully launch the url");
				
			} 
			
			
			return true;
		} catch (Exception e) {

			driver = null;
			System.out.println("We could not get an instance of the web browser");
			e.printStackTrace();
			driver.quit();

			return false;

		}

	}
public static boolean init(String browserType,String url) {
		
		
		try {

			log.info("Entering init function");
			JavascriptLibrary javascriptLibrary = new JavascriptLibrary();

			elementFinder = new ElementFinder(javascriptLibrary);
			
			

			
			DesiredCapabilities capabilities1 = new DesiredCapabilities();

			capabilities1.setJavascriptEnabled(true);

			capabilities1.setBrowserName(browserType);

			capabilities1.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			

			if (browserType=="firefox") {
		        driver = new FirefoxDriver(capabilities1);
			    driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				}
			
			if (browserType=="chrome") {
				System.setProperty("webdriver.chrome.driver", destFile);
				 driver = new ChromeDriver(capabilities1);
				 driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			}
			
			
			try {
			driver.get(url);
			
			}
			catch (Exception e) {
				log.info("Unable to launch the url.Please check the ip");
			return false;
			}
			
			try {
				wait = new WebDriverWait(driver, TIMEOUT);
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("IMDb")));
			} catch(Exception e1) {
				log.info("Please check if the url is proper");
				driver = null;
				System.out.println("We could not get an instance of the web browser");
				e1.printStackTrace();
				driver.quit();

				return false;
			
			}
			
			if(element != null) {
				System.out.println("Successfully launch the url portal");
				
			} 
			
			
			return true;
		} catch (Exception e) {

			driver = null;
			System.out.println("We could not get an instance of the web browser");
			e.printStackTrace();
			driver.quit();

			return false;

		}

	}
	public static boolean webDriverwait (WebElement webdriverwait, String name) {

    	log.info("Entering webdriver wait function");
    	try {
    		WebDriverWait wait = new WebDriverWait (driver,TIMEOUT);
    		    element = wait.until(ExpectedConditions.visibilityOf(webdriverwait));
    			log.info("Found the"+ name + "field");
    		return true;	
    			
    	 } catch(Exception e1) {
    		 e1.printStackTrace();
    			log.info("The field"+name+"is not present");
    			
    			return false;
    		}
    		
	}

	
	public static boolean fluentDriverwait(WebElement fluentwait, String name1) {
		log.info("Entering fluent driver wait function");
    	try {
    		FluentWait <WebDriver> fwait = new FluentWait <WebDriver>(driver)
    				.withTimeout(fluentwithtimeout,TimeUnit.SECONDS)
    				.pollingEvery(fluentpolling, TimeUnit.SECONDS)
    				.ignoring(NoSuchElementException.class);
    				
    		       
    		    element = fwait.until(ExpectedConditions.visibilityOf(fluentwait));
    			log.info("Found the"+ name1 + "field");
    		return true;	
    			
    	 } catch(Exception e1) {
    		 e1.printStackTrace();
    			log.info("The field"+name1+"is not present");
    			return false;
    			
    		}
		
	}
	

	








} 
