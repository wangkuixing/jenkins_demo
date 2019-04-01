
import io.qameta.allure.*;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class NewTest {

    static WebDriver driver;

    @Test(description = "test baidu name")
    @Description("Some detailed test description")
    @Link("https://baidu.com")
    @Severity(SeverityLevel.CRITICAL)
    void demo1(){
        login();
        login();
        try {
            Allure.addAttachment("demo picture", "image/jpeg", new FileInputStream("/Users/kevinwang/Downloads/example1.jpeg"), ".jpeg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        driver.get("http://baidu.com");
        String tittle=driver.getTitle();
        AssertJUnit.assertTrue(tittle.contains("百度"));
    }

    @Step("login step name")
    void login(){
        System.out.println("login step");
    }

    @Test
    void demo2(){

        StepResult stepResult=new StepResult();
        stepResult.setStatus(Status.FAILED);
        stepResult.setName("new step name");
        Allure.getLifecycle().startStep("new step", stepResult);
        Allure.getLifecycle().stopStep();

        driver.get("http://baidu.com");
        String tittle=driver.getTitle();
        AssertJUnit.assertTrue(tittle.contains("百度"));
    }

    @BeforeClass
    static void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver=new ChromeDriver();
    }

    @AfterClass
    static void afterTest(){
        driver.quit();
    }
}
