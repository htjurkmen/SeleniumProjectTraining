package com.company.tests;

import com.company.pagefactory.Header;
import com.company.pagefactory.LoginPage;
import com.company.pagefactory.NewPost;
import com.company.pagefactory.RegistrationForm;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Instant;

public class LoginTests extends BaseTests {

    @DataProvider (name = "Registration data")
    public Object[][] registrationData(){
        return new Object[][] {{"", "alala"},
                {"hjusein", ""},
                {"", ""}
        };

    }

    @Test(dataProvider = "Registration data")
    void unsuccessfulLogin(String username, String password) throws IOException {
        Header header = new Header(getDriver());
        LoginPage loginpage = header.clickLogin();
        loginpage.fillUsername(username);
        loginpage.fillPassword(password);
        Assert.assertFalse(loginpage.isLoginBtnClickable());
    }

    @Test
    void successfulLogin() {
        long timestamp = Instant.now().getEpochSecond();
        String username = "hjusein" + timestamp;
        Header header = new Header(getDriver());
        LoginPage loginpage = header.clickLogin();
        RegistrationForm registrationForm = loginpage.clickRegister();
        registrationForm.fillUsername(username);
        registrationForm.fillEmail(timestamp + "@gmail.com");
        registrationForm.fillBirthDate("03211984");
        registrationForm.fillPass("Hju123_");
        registrationForm.fillConfirmPass("Hju123_");
        registrationForm.fillPublicInfo("alabala");
        registrationForm.clickSignIn();
        //NewPost newPostPage = header.clickNewPost();
        //newPostPage.uploadPostPicture("pic1.png");
        //newPostPage.uploadNewestPicture();
        //newPostPage.fillCaption("Test caption");
        //newPostPage.clickSubmit();
    }
}
