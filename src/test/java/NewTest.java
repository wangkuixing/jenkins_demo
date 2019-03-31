
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {

    private WebDriver driver;

    @Test
    public void test(){

        driver.get("http://baidu.com");
        String tittle=driver.getTitle();
        AssertJUnit.assertTrue(tittle.contains("百度"));
    }

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver=new ChromeDriver();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
