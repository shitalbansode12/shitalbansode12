package launchapp;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Browserapp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	

		
		       
//		        1. Launch the Browser window (Browser = Chrome)  
		        WebDriver driver = new ChromeDriver();
		       
//		        2. Minimize browser window    
		        driver.manage().window().minimize();
		       
//		        3. Maximize to specific resolution(800X400)  
		        driver.manage().window().setSize(new Dimension(800,400));
		       
//		        4. Maximize the browser window  
		        driver.manage().window().maximize();
		       
//		        5. Delete all browser cookies      
		        driver.manage().deleteAllCookies();
		       
//		        6. Enter URL and Launch the Application (https://www.google.co.in/)  
		        driver.get("https://www.google.co.in/");
		        		//launch the page and wait until each and every element loads into the page
		       
//		        7. Verify the application title (Google)  
		        String actualTitle = driver.getTitle();
		        Assert.assertEquals(actualTitle, "Google");        
		       
//		        8. Navigate to Different application (https://www.selenium.dev/)
		        driver.navigate().to("https://www.selenium.dev");
		        //simply launch the page or navigates to different page
		       
//		        9. Go back to previous application
		        driver.navigate().back();
		       
//		        10. Move forward to next application
		        driver.navigate().forward();
		       
//		        11. Refresh the application  
		        driver.navigate().refresh();
		       
//		        12.collect the main window id (window handle id)
		        String mainWindowId = driver.getWindowHandle();
		        System.out.println(mainWindowId);
		       
//		        13.Launch new tab and Launch the application in new tab (https://in.search.yahoo.com/)    
		        driver.switchTo().newWindow(WindowType.TAB);
		        driver.get("https://in.search.yahoo.com");
		       
//		        14. Switch back to the main window
		        driver.switchTo().window(mainWindowId);
		       
//		        15.Launch new window and Launch the application in new window (https://parabank.parasoft.com/parabank/index.htm)  
		        driver.switchTo().newWindow(WindowType.WINDOW);
		        driver.get("https://parabank.parasoft.com/parabank/index.htm");
		       
//		        16.Switch back to main window  
		        driver.switchTo().window(mainWindowId);
		       
//		        17.Print browser window URL  
		        String url = driver.getCurrentUrl();
		        System.out.println(url);
		       
//		        18. Get the Size of window
		        int height = driver.manage().window().getSize().getHeight();
		        int width = driver.manage().window().getSize().getWidth();
		        System.out.println(height+" X "+width);
		       
//		        19. Close Current Window  
		        driver.close();
		       
//		        20. Close all windows
		        driver.quit();

		    }

}
