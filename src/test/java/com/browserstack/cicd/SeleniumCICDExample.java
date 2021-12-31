package com.browserstack.cicd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.*;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumCICDExample {
    public static void main(String[] args) throws Exception {
        WebDriver driver;
        String username = System.getenv("BROWSERSTACK_USERNAME");
        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
        String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
        String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("os_version", "10");
        capabilities.setCapability("browser", "chrome");
        capabilities.setCapability("browser_version", "latest");
        capabilities.setCapability("name", "BStack-[Java] Sample Test"); // test buildName
        capabilities.setCapability("build", buildName); // CI/CD job name using BROWSERSTACK_BUILD_NAME env variable
        capabilities.setCapability("browserstack.local", browserstackLocal);
        capabilities.setCapability("browserstack.localIdentifier", browserstackLocalIdentifier);
        driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
    }
}
