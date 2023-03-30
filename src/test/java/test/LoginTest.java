package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.HashMap;
import java.util.Map;

public class LoginTest extends BaseTest {

    @DataProvider(name ="validUserData")
    public Object[][] validUserData(){
        Map<String,String> userData= new HashMap<>();
                userData.put("firstname","user");
                userData.put("password","pass");
                Object[][] ret={{userData}};
                return ret;
    }


    @Test(dataProvider = "validUserData",priority = 4)
    public void validateLoginFunctionalityForValidCredentials(Map<String,String> userData){
        LoginPage loginPage = new LoginPage(super.driver);
        extent.createTest("Login With Valid Credentials");
        loginPage.validCredentials(userData);

    }

    @DataProvider(name="invalidUserData1")
    public Object[][]  invalidUserData1(){
        Map<String,String> userData=new HashMap<>();
        userData.put("firstname","InvalidUser");
        userData.put("password","pass");
        Object[][] ret={{userData}};
        return ret;

    }

    @Test(dataProvider = "invalidUserData1",priority = 3)
    public void validateLoginFunctionalityForInvalidUsernameAndValidPassword(Map<String ,String> userData){
        LoginPage loginPage=new LoginPage(super.driver);
        extent.createTest("Login with invalid username and valid pass");
        loginPage.invalidCredentials(userData);
    }

    @DataProvider(name="invalidUserData2")
    public Object[][]  invalidUserData2(){
        Map<String,String> userData=new HashMap<>();
        userData.put("firstname","User");
        userData.put("password","InvalidPass");
        Object[][] ret={{userData}};
        return ret;

    }

    @Test(dataProvider = "invalidUserData2",priority = 2)
    public void validateLoginFunctionalityForValidUsernameAndInvalidPassword(Map<String ,String> userData){
        LoginPage loginPage=new LoginPage(super.driver);
        extent.createTest("Login with valid username and invalid pass");
        loginPage.invalidCredentials(userData);
    }

    @DataProvider(name="invalidUserData3")
    public Object[][]  invalidUserData3(){
        Map<String,String> userData=new HashMap<>();
        userData.put("firstname","InvalidUser");
        userData.put("password","InvalidPass");
        Object[][] ret={{userData}};
        return ret;

    }

    @Test(dataProvider = "invalidUserData3",priority = 1)
    public void validateLoginFunctionalityForInvalidUsernameAndInvalidPassword(Map<String ,String> userData){
        LoginPage loginPage=new LoginPage(super.driver);
        extent.createTest("Login with Invalid username and invalid pass");
        loginPage.invalidCredentials(userData);
    }




}
