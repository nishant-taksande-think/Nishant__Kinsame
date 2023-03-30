package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import util.TestDriverManager;

import java.lang.reflect.Method;
@Log4j2
public class


BaseTest {
    protected WebDriver driver;
    static  ExtentReports extent;

    @BeforeSuite
    public void initReporting(){
        extent = new ExtentReports();
        ExtentSparkReporter spark=new ExtentSparkReporter("./reports/index.html");
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void flushReports(){
        extent.flush();
    }


    @BeforeMethod
    public void initTest(Method method){
        log.info("======= starting execution of test Method" + method.getName() + "===========");
        driver = TestDriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown(Method method){
        driver.quit();
        log.info("======= completing execution of test Method" + method.getName()+"===========");

    }
}
