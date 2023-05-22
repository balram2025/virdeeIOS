package screens.Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginScreenOfAdroid {

    public LoginScreenOfAdroid(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver),this);
    }


//    private final String firstName = "Auto" + AppiumDriverHelper.getRandomAlphabeticString(4);
//    private final String lastName = "Auto" + AppiumDriverHelper.getRandomAlphabeticString(4);
//    private final String ssnNumber = AppiumDriverHelper.getRandomNumeric(4);
//    private final String addressString1 = AppiumDriverHelper.getRandomAlphabeticString(5);
//    private final String addressString2 = AppiumDriverHelper.getRandomAlphabeticString(5);

    public static String realMobNumber;
    public String env;

    @AndroidFindBy(xpath = "")
    MobileElement okButton;
    @AndroidFindBy(id = "")
    MobileElement whileUsingApp;
    @AndroidFindBy(xpath = "")
    MobileElement signUpButton;
    @AndroidFindBy(xpath = "")
    MobileElement emailTextField;
    @AndroidFindBy(xpath = "")
    MobileElement passwordTextField;



    public void enterEmail(){

    }


}
