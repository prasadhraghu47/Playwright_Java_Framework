package steps;

import com.microsoft.playwright.*;
import hooks.TestHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import world.PageObjectWorld;

import java.util.List;
import java.util.Map;

public class LoginSteps {
    private Page page;
    private LoginPage loginPage;

    public LoginSteps() {
        this.page = TestHooks.getPage();
        this.loginPage = new PageObjectWorld(page).getPageObject(LoginPage.class);
    }

    @Given("user is on login page {string}")
    public void user_is_on_login_page( String url) {
        page.navigate(url);
        loginPage = new LoginPage(page);
    }

    @When("user logs in with valid credentials")
    public void login_with_valid_credentials(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        String userName = credentials.get(0).get("Username");
        String password = credentials.get(0).get("Password");
        loginPage.enterUsername(userName).enterPassword(password).clickLogin();
    }

    @Then("user should see the dashboard")
    public void verify_dashboard() {
        assert page.url().contains("inventory.html");
    }

}
