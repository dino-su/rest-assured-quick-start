package github.dinosu.api;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GithubTest 
{
    @Test
    public void testUserInfo()
    {
        when().get("https://api.github.com/users/dino-su").
        then().assertThat()
            .body("name", equalTo("Dino Su"))
            .body("bio", equalTo("Software Engineer, focusing on test engineering."));
    }

    @Test
    public void testUserRepoInfo()
    {
        when().get("https://api.github.com/users/dino-su/repos").
        then().assertThat().body("find {it.name == 'android-e2e-mock-example'}.description", equalTo("Android E2E mock testing example."))
                           .body("find {it.name == 'android-monkey-quick-start'}.description", equalTo("This repository contains Android Monkey Test Start Kit which aim to help you enable Monkey Test in continuous testing pipeline."))
                           .body("find {it.name == 'clean-scalable-xcuitest'}.description", equalTo("Sample project of iOS UI test automation using XCUITest."))
                           .body("find {it.name == 'webdriver-io-quick-start'}.description", equalTo("Webdriver.IO Quick Start"))
                           .body("find {it.name == 'kkbox-labs'}.description", equalTo("Android UI Test Automation and Design Patterns."));
    }
}