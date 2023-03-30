package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestConfigReader;

import java.time.Duration;
import java.util.Map;

public class LoginPage extends BasePage{
    protected final WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@formcontrolname='username']")
    WebElement txtUsername;

    @FindBy(xpath ="//input[@formcontrolname='password']")
    WebElement txtPassword;

    @FindBy(xpath = "//button[text()=' Login ']")
    WebElement btnLogin;

    @FindBy(xpath = "//a[@class='close']")
    WebElement alertMsg;



    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        // this.driver = driver;
        driver.get(TestConfigReader.read("app.url"));
        PageFactory.initElements(driver, this);
    }

  public void validCredentials(Map<String,String> userData){
      if(userData.containsKey("firstname"))
          txtUsername.sendKeys(userData.get("firstname"));

      if(userData.containsKey("password"))
          txtUsername.sendKeys(userData.get("password"));

      btnLogin.click();



  }

  public void invalidCredentials(Map<String,String> userData){
      if(userData.containsKey("firstname"))
          txtUsername.sendKeys(userData.get("firstname"));

      if(userData.containsKey("password"))
          txtPassword.sendKeys(userData.get("password"));

      btnLogin.click();
     WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='close']")));

     alertMsg.click();

  }

}

