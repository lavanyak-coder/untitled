package Tests;
import Base.BaseTest;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.FilloUtil;
import java.util.Map;
public class LoginTest extends BaseTest{
    LoginPage loginPage;
    @BeforeMethod
    public void init() {
        setup();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() throws Exception {
        Map<String, String> data = FilloUtil.getLoginData();
        loginPage.login(
                data.get("Username"),
                data.get("Password")
        );
    }
    @AfterMethod
    public void close() {
        tearDown();
    }
}

