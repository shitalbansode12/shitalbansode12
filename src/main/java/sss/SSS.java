package sss;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class SSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//      1. Launch browser window(Chrome)
      WebDriver driver = new ChromeDriver();
     
//      2. Maximize the browser window
      driver.manage().window().maximize();
     
//      3. Delete all the cookies
      driver.manage().deleteAllCookies();
     
//      4. Enter URL and Launch the application (https://parabank.parasoft.com/parabank/index.htm)
      driver.get("https://parabank.parasoft.com/parabank/index.htm");
     
//      5. Verify application title (ParaBank | Welcome | Online Banking)
      String actualTitle = driver.getTitle();
      String expectedTitle="ParaBank | Welcome | Online Banking";
      Assert.assertEquals(actualTitle, expectedTitle);
     
//      6. Verify application logo
      WebElement logo = driver.findElement(By.xpath("//img[@class='logo']"));
      Assert.assertTrue(logo.isDisplayed());
     
//      7. Verify application caption (Experience the difference)
      WebElement caption = driver.findElement(By.xpath("//p[@class='caption']"));
      String actualCaption = caption.getText();
      String expectedCaption="Experience the difference";
      Assert.assertEquals(actualCaption, expectedCaption);
     
//      8. Enter Invalid credentials in Username and Password textboxes
      WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
      WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
      Assert.assertTrue(username.isDisplayed() && username.isEnabled() && password.isDisplayed() && password.isEnabled());
      username.clear();
      password.clear();
      username.sendKeys("abcdefgh");
      password.sendKeys("abcd12345");
     
//      9. Verify button label (LOG IN) and Click on Login Button
      WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
      String actualLabel = loginButton.getAttribute("value").toUpperCase();
      String expectedLabel = "LOG IN";
      Assert.assertEquals(actualLabel, expectedLabel);
      loginButton.click();
     
//      10. Verify error message is coming    
      By errorMsg = By.xpath("//p[@class='error']");
      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
      wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(errorMsg, 0));
     
//      11. Click on Admin page link
      WebElement adminLink = driver.findElement(By.xpath("//a[text()='Admin Page']"));
      adminLink.click();
     
//      12. Wait for admin page
      By adminPageHeader = By.xpath("//h1[contains(text(),'Administration')]");
      wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(adminPageHeader, 0));
     
//      13. Select Data access mode as ' SOAP'
      WebElement dba = driver.findElement(dbaMode("soap"));
      dba.click();
     
//      14. Scroll-down till Loan provider
      WebElement loanProvider = driver.findElement(By.xpath("//select[@id='loanProvider']"));
      ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()",loanProvider);
     
//      15. Select Loan provider as 'Web Service'
      Select s = new Select(loanProvider);
      s.selectByVisibleText("Web Service");
     
//      16. Click on Submit button
      WebElement submitBtn = driver.findElement(By.xpath("//input[@value='Submit']"));
      submitBtn.click();
     
//      17. wait for Successful submission message
      By successMsg = By.xpath("//b[contains(text(),'saved successfully')]");
      wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(successMsg, 0));

//      18. Click on Services Link
      WebElement services = driver.findElement(By.xpath("//ul[@class='leftmenu']//a[text()='Services']"));
      services.click();
     
//      19. Wait for Services page
      By servicesPageHeader= By.xpath("//span[contains(text(),'Bookstore SOAP services')]");
      wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(servicesPageHeader, 0));
     
//      20. Scrolldown till Bookstore services
      WebElement bookstoreServices = driver.findElement(By.xpath("//span[text()='Bookstore services:']"));
      ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()",bookstoreServices);
   //   21. Get total rows, columns in the bookstore service table
//    22. Get Column headers of book store services table    
//    23. Get all the data from book store service table
//    24. Close browser window    
    driver.close();
   
}

public static By dbaMode(String option) {
    return By.xpath("//input[@value='"+option+"']");

	}

}
