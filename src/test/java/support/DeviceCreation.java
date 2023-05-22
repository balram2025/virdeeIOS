package support;

import com.browserstack.local.Local;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static support.World.*;

public class DeviceCreation {
    private static final DesiredCapabilities capabilities = new DesiredCapabilities();
    //public IOSDriver<IOSElement> driver;
    public static AppiumDriver appiumDriver;
    public static SafariDriver safariDriver;
    public static ChromeDriver chromeDriver;
    public static FirefoxDriver firefoxDriver;
    public static EdgeDriver edgeDriver;
    private Local l;
    Iterator it;
    private int x;
    private static String timestamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()).replaceAll(":", "-");

    final PropertiesReader propertiesReader = new PropertiesReader();
    Scenario scenario;

    @Before("@android")
    public void setUpAndroid(Scenario scenario) throws Exception {
        propertiesReader.loadProperties();
        capabilities.setCapability("android_udid", PropertiesReader.android_udid);
        capabilities.setCapability("android_automationInstumentation", PropertiesReader.android_automationInstrumentation);
        capabilities.setCapability("android_platformName", PropertiesReader.android_platformName);
        capabilities.setCapability("android_platformVersion", PropertiesReader.android_platformVersion);
        capabilities.setCapability("android_deviceName", PropertiesReader.android_deviceName);
        capabilities.setCapability("android_deviceReadyTimeout", PropertiesReader.android_deviceReadyTimeout);
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("platform", "WINDOWS");
        capabilities.setCapability("appPackage", PropertiesReader.android_appPackage);
        capabilities.setCapability("appActivity",PropertiesReader.android_appActivity);
        capabilities.setCapability("uiautomator2ServerLaunchTimeout", "10000");
        appiumDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        new World().driverClass();
    }



    @After("@iosBrowserStack")
    public void tearDownBS(Scenario scenario) throws Exception {
        appiumDriver.quit();
        if (l != null) {
            l.stop();
        }
    }

    @Before("@ios")
    public void setUpIos(Scenario scenario) throws Exception {
        propertiesReader.loadProperties();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertiesReader.iOS_platformVersion);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertiesReader.iOS_platformName);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesReader.iOS_deviceName);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, PropertiesReader.iOS_automationInstrumentation);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, PropertiesReader.iOS_commandTimeout);
        capabilities.setCapability(MobileCapabilityType.APP, PropertiesReader.iOS_application);
        capabilities.setCapability(MobileCapabilityType.UDID, PropertiesReader.iOS_UDID);
        capabilities.setCapability("sendKeyStrategy", "setValue");
        appiumDriver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(10000);
        new World().driverClass();
    }

    @Before("@safari")
    public void setUp() throws IOException {
        propertiesReader.loadProperties();
        System.setProperty("webdriver..driver", "src/test/resources/Drivers/msedgedriver");
        safariDriver = new SafariDriver();
        safariDriver.manage().window().maximize();
        safariDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Before("@chrome")
    public void setUpChrome() throws IOException {
        propertiesReader.loadProperties();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Before("@firefox")
    public void setUpFirefox() throws IOException {
        propertiesReader.loadProperties();
        System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver");
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().window().maximize();
        firefoxDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Before("@edge")
    public void setUpEdge() throws IOException {
        propertiesReader.loadProperties();
        System.setProperty("webdriver.edge.driver", "src/test/resources/Drivers/msedgedriver");
        edgeDriver = new EdgeDriver();
        edgeDriver.manage().window().maximize();
        edgeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @After("@ios")
    public void addScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
        //appiumDriver.quit();
    }

   /* @Before("@iosBrowserStack")
    public void tearDownBrowserStack(Scenario scenario) throws IOException {
        appiumDriver.quit();
    }*/

    @After("@safari")
    public void cleanUp(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) safariDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
        safariDriver.close();
    }

    @After("@chrome")
    public void cleanUpChrome(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
        chromeDriver.close();
    }


    @After("@firefox")
    public void cleanUpFirefox(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) firefoxDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
        firefoxDriver.close();
    }

    @After("@edge")
    public void cleanUpEdgeDriver(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) edgeDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
        edgeDriver.close();
    }



    @After("@ios and @quit")
    public void tearDown() {

        //appiumDriver.quit();
    }

    @After("@ios and @bonusEnd")
    public void tearDownBonusDeposit() {
        //appiumDriver.quit();
    }


    public AppiumDriver getDriver() {
        return appiumDriver;
    }


    public WebDriver getSafariDriver() {
        return safariDriver;
    }

    public WebDriver getChromeDriver() {
        return chromeDriver;
    }

    public WebDriver getFirefoxDriver() {
        return firefoxDriver;
    }

    public WebDriver getEdgeDriver() {
        return edgeDriver;
    }
}
