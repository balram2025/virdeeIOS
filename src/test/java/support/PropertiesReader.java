package support;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static String browser_required;
    public static String browser_type;
    public static String browser_headless;
    public static String environment;
    public static String thorURL;
    public static String baseURL;
    public static String iOS_application;
    public static String iOS_explicitWait;
    public static String iOS_defaultWait;
    public static String iOS_implicitWait;
    public static String iOS_appiumServerPort;
    public static String iOS_automationInstrumentation;
    public static String iOS_browserName;
    public static String iOS_platformName;
    public static String iOS_deviceName;
    public static String iOS_platformVersion;
    public static String iOS_commandTimeout;
    public static String iOS_deviceReadyTimeout;
    public static String iOS_UDID;
    public static String iOS_automationName;
    public static String android_udid;
    public static String android_automationInstrumentation;
    public static String android_platformName;
    public static String android_deviceName;
    public static String android_platformVersion;
    public static String android_deviceReadyTimeout;
    public static String updatedEmailAddres;
    public static String payment_Enroll_NewUser_EmailAdd;
    public static String AmountToDepositVisaCard;
    public static String VisaCardNumber;
    public static String NewRegUserEmailId;
    public static String MasterCardNumber;
    public static String OldPassword;
    public static String NewPassword;
    public static String realMobileNumber;
    public static String realMobileNumber2;
    public static String realMobileNumber3;
    public static String realMobileNumber4;
    public static String MobileCode;
    public static String NewRegisterUserAccountID;
    public static String updatedEmailAddresRNJ;
    public static String updatedEmailAddresMSNJ;
    public static String android_appPackage;
    public static String android_appActivity;
    public static String NewPassword_resortsNj1;

    public static String OTPForMobileNumber;

    public void loadProperties() throws IOException {
        Properties settings = new Properties();
        Properties data = new Properties();
        Properties mobileData = new Properties();

        settings.load(new FileInputStream("config/settings.properties"));
        data.load(new FileInputStream("data/commonData.properties"));
        mobileData.load(new FileInputStream("data/commonData.properties"));

         //get the property value and set it to a global variable
        browser_required = settings.getProperty("browser.required");
        browser_type = settings.getProperty("browser.type");
        browser_headless = settings.getProperty("browser.headless");
        environment = settings.getProperty("environment");
        thorURL = settings.getProperty("thorURL");

        //iOS Device Capabilities
        iOS_UDID = settings.getProperty("iOS_UDID");
        iOS_application = settings.getProperty("iOS_application");
        iOS_explicitWait = settings.getProperty("iOS_explicitWait");
        iOS_defaultWait = settings.getProperty("iOS_defaultWait");
        iOS_implicitWait = settings.getProperty("iOS_implicitWait");
        iOS_appiumServerPort = settings.getProperty("iOS_appiumServerPort");
        iOS_automationInstrumentation = settings.getProperty("iOS_automationInstrumentation");
        iOS_platformName = settings.getProperty("iOS_platformName");
        iOS_browserName = settings.getProperty("iOS_browserName");
        iOS_deviceName = settings.getProperty("iOS_deviceName");
        iOS_platformVersion = settings.getProperty("iOS_platformVersion");
        iOS_commandTimeout = settings.getProperty("iOS_commandTimeout");
        iOS_deviceReadyTimeout = settings.getProperty("iOS_device-readyTimeout");
        iOS_automationName = settings.getProperty("iOS_automationName");

        //android Device Capabilities
        android_udid = settings.getProperty("android_udid");
        android_automationInstrumentation = settings.getProperty("android_automationInstumentation");
        android_platformName = settings.getProperty("android_platformName");
        android_deviceName = settings.getProperty("android_deviceName");
        android_platformVersion = settings.getProperty("android_platformVersion");
        android_platformVersion = settings.getProperty("android_newCommandTimeout");
        android_deviceReadyTimeout = settings.getProperty("android_deviceReadyTimeout");
        android_appPackage= settings.getProperty("android_appPackage");
        android_appActivity=settings.getProperty("android_appActivity");

        //Mobile TestData
        updatedEmailAddres = mobileData.getProperty("UpdatedEmailAddress");
        payment_Enroll_NewUser_EmailAdd = mobileData.getProperty("Payment_Enroll_NewUser_EmailAdd");
        AmountToDepositVisaCard = mobileData.getProperty("VisaAmountToDeposit");
        VisaCardNumber = mobileData.getProperty("VisaCardNumber");
        MasterCardNumber = mobileData.getProperty("MasterCardNumber");
        NewRegUserEmailId = mobileData.getProperty("NewRegisterUserEmail");
        NewRegisterUserAccountID = mobileData.getProperty("NewRegisterUserAccountID");
        OldPassword = mobileData.getProperty("OldPassword");
        NewPassword = mobileData.getProperty("NewPassword");
        realMobileNumber = mobileData.getProperty("goldenNuggetNj_Mobile");
        realMobileNumber2 = mobileData.getProperty("goldenNuggetNj_Mobile2");
        MobileCode = mobileData.getProperty("goldenNuggetNj_MobileCode");
        realMobileNumber3 = mobileData.getProperty("resortsNj_Mobile");
        realMobileNumber4 = mobileData.getProperty("resortsNj_Mobile2");
        NewPassword_resortsNj1=mobileData.getProperty("NewPassword_resortsNj");
        updatedEmailAddresRNJ = mobileData.getProperty("UpdatedEmailAddressRNJ");
        updatedEmailAddresMSNJ = mobileData.getProperty("UpdatedEmailAddressMSNJ");
        OTPForMobileNumber = mobileData.getProperty("OTPForMobileNumber");
    }


    public String loadProperties(String key) {
        Properties data = new Properties();
        try {
            data.load(new FileInputStream("data/commonData.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.getProperty(key);
    }

}