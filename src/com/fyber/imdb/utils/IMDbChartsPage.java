package com.fyber.imdb.utils;


import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.openqa.selenium.support.ui.Select;

import com.fyber.common.utils.Logging;

import com.fyber.imdb.utils.*;

public class IMDbChartsPage {

	
public static final Logger log = Logging.getLogger();
	
    @FindBy(how = How.XPATH,using=LocatorsandConstants.IMDbChartsPage_sortby )
 
    public static WebElement sortby;
    
    @FindBy(how = How.XPATH,using=LocatorsandConstants.IMDBChartsPage_sidebar_western )
    
    public static WebElement sidebarwestern;
    
    
    @FindBy(how = How.XPATH,using=LocatorsandConstants.IMDbChartsPage_top250table )
    
    public static List <WebElement> top250table;
    
    public boolean selectbyVisibleText(WebElement target,String value) {		
			try {			
					
				log.info("Entering selectbyVisibleText");
				Select select = new Select(target);
	         
				log.info("Created selection object");
				select.selectByVisibleText(value);
				log.info("selection is successful");
				return true;			
			} catch(Exception e) {
				log.error(e);
				return false;
			}
    }
		 	   public boolean verifyMoviesearch () {
		 		    try {
		 		    	
		 		    	Thread.sleep(10000);
		 		    	log.info("Entering verifyMoviesearch function");
		 		    	for ( int i = 0; i<top250table.size() ; i++ ) {
		 		    		log.info(top250table.get(i).getText());
		 		    		if (top250table.get(i).getText()!=null) {
		 		    			log.info(top250table.get(i).getText());
		 		    			WebElement cell = top250table.get(i);
		 		    			log.info("Successfully found cell: ");
		 		    			cell.findElement(By.tagName("a"));
		 		    			log.info("Successfully clicked on movie");
		 		              return true;
		 		    		}
		 		    		
		 		    	}
		 		    }
		 		    catch (Exception e) {
		 		    	
		 		    log.error("Unable to find a movie"+e);
		 		    	return false;
		 		    }
					return false;
		 		  
		 		}
		 	  
		 	     
    
		 	  public boolean clicktarget(WebElement target){
		 	    	log.info("Entering the  method clicktarget");
		 	    	try {
		 	    				target.click();
		 	    		return true;
		 	    	}
		 	    	catch(Exception e) {
		 	    		
		 	    		log.info("Failed to click on target");
		 	    		return false;
		 	    	}
		 	            
		 	 
		 	    }
		 		
    
    
    
    
    
    
    
    
    
    
    
    
    
}
