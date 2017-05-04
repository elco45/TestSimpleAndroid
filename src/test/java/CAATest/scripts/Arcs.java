package CAATest.scripts;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.net.URL;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Arcs {
    private AndroidDriver driver;
    
    @Before
    public void startApp() throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.0"); //Replace this with your Android version
        caps.setCapability("deviceName", "Android Samsung Galaxy 8"); //Replace this with your simulator/device 
        caps.setCapability("app", "http://appium.github.io/appium/assets/ApiDemos-debug.apk"); //Replace this with app path in your system
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
    }
    
    @After
    public void quitApp(){
        driver.quit();
    }
    
    @Given("^The android app$")
    public void The_android_app(){
        
    }
    
    @When("^Click on graphics button$")
    public void Click_on_graphics_button(){
        driver.findElementByAccessibilityId("Graphics").click();
    }
    
    @And("^Click on arcs button$")
    public void Click_on_arcs_button(){
        driver.findElementByAccessibilityId("Arcs").click();
    }
    
    @Then("^I can view a small graph$")
    public void I_can_view_a_small_graph(){
        Assert.assertEquals(true,driver.findElement(By.xpath("//*[1]//*[1]//*[2]//*[1]")).isDisplayed());
    }
}
