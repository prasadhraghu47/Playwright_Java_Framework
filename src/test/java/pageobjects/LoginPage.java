package pageobjects;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public LoginPage enterUsername(String username) {
        page.fill("#user-name", username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        page.fill("#password", password);
        return this;
    }

    public void clickLogin() {
        page.click("#login-button");
    }
}
