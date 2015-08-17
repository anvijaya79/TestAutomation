package com.fyber.imdb.testClasses;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.fyber.imdb.testClasses.*;
import com.fyber.imdb.utils.IMDbChartsPage;
import com.fyber.common.utils.Logging;

public class ImdbTest extends BaseTest {
	
	public String browserType="chrome";
	public IMDbChartsPage objIMDpChartsPage = null;

	@BeforeTest
	 
	   public void setup(){
		
		initConfig("ImdbTest");
	
		log.info("Initiating the test ImdbTest");
		 
	       
	    }
	
	@Parameters({"url"})
	@Test(priority=1)
	
	public void getIMDbTest(String url) {
	
		Assert.assertTrue(init(browserType, url));
	}

	@Test(dependsOnMethods="getIMDbTest")
	
	public void Test1() {
		objIMDpChartsPage = PageFactory.initElements(driver, IMDbChartsPage.class);
		Assert.assertTrue(objIMDpChartsPage.verifyMoviesearch());
	}
	
	@Parameters({"SortbyRanking"})
	@Test(dependsOnMethods="Test1")
	
	public void Test2(String SortbyRanking) {
		
		Assert.assertTrue(objIMDpChartsPage.selectbyVisibleText(objIMDpChartsPage.sortby, SortbyRanking));
	}
	@Parameters({"SortbyIMDbRating"})
	@Test(dependsOnMethods="Test2")
	
	public void Test3(String SortbyIMDbRating) {
		
		Assert.assertTrue(objIMDpChartsPage.selectbyVisibleText(objIMDpChartsPage.sortby, SortbyIMDbRating));
	}
	
	@Parameters({"SortbyReleasedate"})
	@Test(dependsOnMethods="Test3")
	
	public void Test4(String SortbyReleasedate) {
		
		Assert.assertTrue(objIMDpChartsPage.selectbyVisibleText(objIMDpChartsPage.sortby, SortbyReleasedate));
	}

	@Parameters({"Sortbyyourrating"})
	@Test(dependsOnMethods="Test4")
	
	public void Test5(String Sortbyyourrating) {
		
		Assert.assertTrue(objIMDpChartsPage.selectbyVisibleText(objIMDpChartsPage.sortby, Sortbyyourrating));
	}

	
	
	@Test(dependsOnMethods="Test5")
	
	public void Test6() {
		
		Assert.assertTrue(objIMDpChartsPage.clicktarget(objIMDpChartsPage.sidebarwestern));
	}
	

	@AfterTest
	 
	   public void cleanup(){
		
		
	   driver.quit();
		log.info("Quiting the browser");
		 
	       
	    }
	


}
