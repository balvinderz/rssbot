import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AnotheTest {
    static void print(Object  toPrint)
    {
        System.out.println(toPrint.toString());
    }

    public  static  void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/balvinder/Desktop/auto_importer/ch");

        WebDriver driver = new HtmlUnitDriver();
        driver.get("https://gengo.com/");

        driver.manage().deleteAllCookies();
        driver.manage().addCookie(new Cookie("myG_myGSession_","610520f34d56769ba3096bfbaee659934c8cad14"));
        long startTime = System.nanoTime();

        driver.get("https://gengo.com/t/dashboard/");
        print(driver.getCurrentUrl());

        driver.get("http://localhost:8000/Type%20anchor%20-%20not%20clicked%20yet.htm");
        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds : " +
                timeElapsed / (1000000));
        try{
           WebElement element =  driver.findElement(By.id("start_job_button"));
           element.click();


        }

        catch (Exception e)
        {
            e.printStackTrace();;

            try {
                driver.findElement(By.id("start")).click();
            }catch (Exception f)
            {
                f.printStackTrace();
            }
        }
        print(driver.getCurrentUrl());



    }

}
