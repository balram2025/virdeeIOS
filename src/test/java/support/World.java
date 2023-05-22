package support;

import io.appium.java_client.AppiumDriver;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import screens.iOS.UserRegistrationScreen;


public class World {

    public static StringHelper stringHelper;
    public static JsonHelper jsonHelper;
    public static JSONObject jsonPayload;
    public static XmlBuilder xmlBuilder;
    public static AppiumDriverHelper appiumDriverHelper;

    public static UserRegistrationScreen objRegister1;

//    public static ThorScreen objThorScreen;
//    public static SelfExclusionScreen objSelfExclusionScreen;
//    public static EmailNotificationsScreen objEmailNotificationsScreen;
//    public static CanvasScreen objCanvasScreen;


    //AndroidScreen
//    public static UserRegistration_NJ_Android_Screen objUserRegistration_NJ_Android_Screen;



    final AppiumDriver appiumDriver = new DeviceCreation().getDriver();
    final WebDriver safariDriver = new DeviceCreation().getSafariDriver();
    final WebDriver chromeDriver = new DeviceCreation().getChromeDriver();
    final WebDriver firefoxDriver = new DeviceCreation().getFirefoxDriver();
    final WebDriver edgeDriver = new DeviceCreation().getEdgeDriver();


    public void driverClass() throws Exception {
        World.stringHelper = new StringHelper();
//        World.jsonHelper = new JsonHelper();
//        World.xmlBuilder = new XmlBuilder();
        World.appiumDriverHelper = new AppiumDriverHelper(appiumDriver);
//        World.objLoginscreen = new LoginScreen(appiumDriver);

        World.objRegister1 = new UserRegistrationScreen(appiumDriver);
//        World.objMailinatorScreen = new MailinatorScreen((SafariDriver) safariDriver);
//        World.objTradingInterfaceScreen = new TradingInterfaceScreen((FirefoxDriver) firefoxDriver);

       //AndroidScreen
//       World.objUserRegistration_NJ_Android_Screen = new UserRegistration_NJ_Android_Screen(appiumDriver);
//        World.objLogin_NJ_Android_Screen = new Login_NJ_Android_Screen(appiumDriver);
//        World.objApiAndroidScreen = new ApiAndroidScreen(appiumDriver);
//        World.objLoginFromDemoPlay_NJ_Android_Screen = new LoginFromDemoPlay_NJ_Android_Screen(appiumDriver);
//        World.objLoginFromGameIcon_NJ_Android_Screen = new LoginFromGameIcon_NJ_Android_Screen(appiumDriver);
//        World.objGamingLimit_NJ_Android_Screen =new GamingLimit_NJ_Android_Screen(appiumDriver);
//        World.objMyAccount_NJ_Android_Screen = new MyAccount_NJ_Android_Screen(appiumDriver);
//        World.objAccountStatement_NJ_Android_Screen = new AccountStatement_NJ_Android_Screen(appiumDriver);
//        World.objSelfExclusion_NJ_Android_Screen = new SelfExclusion_NJ_Android_Screen(appiumDriver);
//        World.objSessionExpiration_NJ_Android_Screen= new SessionExpiration_NJ_Android_Screen((ChromeDriver)chromeDriver);

    }
}

