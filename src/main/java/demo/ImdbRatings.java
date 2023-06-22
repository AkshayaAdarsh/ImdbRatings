
package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///

public class ImdbRatings {
    ChromeDriver driver;

    public ImdbRatings() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        //Open URL  https://www.imdb.com/chart/top
        driver.get("https://www.imdb.com/chart/top");
        //Highest rated movie Using Locator "XPath" //td[@class='titleColumn']/a
        WebElement highRated=driver.findElementByXPath("//td[@class='titleColumn']/a");
        System.out.println("Highest rated movie"+highRated.getText());
        //Locate all Count of movies in the table Using Locator "XPath" //tbody/tr
        List <WebElement> moviesCount=driver.findElementsByXPath("//tbody/tr");
        //Print Count of all movies using movies.size()
        System.out.println("Count of all movies "+moviesCount.size());
        //Click on Sort by dropdown Using "ID" "lister-sort-by-options"
        WebElement sortDropdown=driver.findElementById("lister-sort-by-options");
        sortDropdown.click();
        //Click on "Release Date" Using Locator "XPath" //option[contains(text(),' Release Date')]
        WebElement releaseDate=driver.findElementByXPath("//option[contains(text(),' Release Date')]");
        releaseDate.click();
        //click on "Arrow" button Using Locator "XPath" //span[@class='global-sprite lister-sort-reverse ascending']
        WebElement arrowButton=driver.findElementByXPath("//span[@class='global-sprite lister-sort-reverse ascending']");
        arrowButton.click();
        //Oldest movie on the list Using Locator "XPath" //td[@class='titleColumn']/a
        WebElement oldMovie=driver.findElementByXPath("//td[@class='titleColumn']/a");
        System.out.println("Oldest movie on the list "+oldMovie.getText());
        //click on "Arrow" button Using Locator "XPath" //span[@class='global-sprite lister-sort-reverse descending']
        WebElement arrowButton1=driver.findElementByXPath("//span[@class='global-sprite lister-sort-reverse descending']");
        arrowButton1.click();
        //Most recent movie on the list Using Locator "XPath" //td[@class='titleColumn']/a
        WebElement recentMovie=driver.findElementByXPath("//td[@class='titleColumn']/a");
        System.out.println("Recent movie on the list "+recentMovie.getText());
        //Click on "Sort by" dropdown Using Locator "ID" lister-sort-by-options 
        WebElement sortDropdown1=driver.findElementById("lister-sort-by-options");
        sortDropdown1.click();
        //Click on "Number of Ratings" Using Locator "XPath" //option[contains(text(),' Number of Ratings')]
         WebElement noOfRatings=driver.findElementByXPath("//option[contains(text(),' Number of Ratings')]");
        noOfRatings.click();
        //Most user ratings movie Using Locator "XPath" //td[@class='titleColumn']/a
        WebElement userRatedMovie=driver.findElementByXPath("//td[@class='titleColumn']/a");
        System.out.println("Recent movie on the list "+userRatedMovie.getText());
     
    }

}


