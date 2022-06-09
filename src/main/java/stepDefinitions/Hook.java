package stepDefinitions;

import org.openqa.selenium.remote.RemoteWebDriver;

import MyRunner.TestRunner;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook extends TestRunner {
    public RemoteWebDriver driver = this.connection;

    @Before
    public void updateName(Scenario scenario) throws InterruptedException {
        Thread.sleep(30);
        driver.executeScript("lambda-name=" + scenario.getName());
    }

    @After
    public void close_the_browser(Scenario scenario) throws InterruptedException {
        // Clearing browser Cache after Test
        driver.manage().deleteAllCookies(); // delete all cookies
        Thread.sleep(7000); // wait 7 seconds to clear cookies.
        driver.executeScript("lambda-status=" + (scenario.isFailed() ? "failed" : "passed"));
        System.out.println(driver.getSessionId());
        driver.quit();
    }

}