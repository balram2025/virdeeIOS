package screens.iOS;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.AppiumDriverHelper;
import support.DeviceCreation;

import java.io.IOException;

import static support.DeviceCreation.*;


public class UserRegistrationScreen {

    public UserRegistrationScreen(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(DeviceCreation.appiumDriver), this);
    }

//    public static String realMobNumber2;
//
//    private final String firstName = "Auto" + AppiumDriverHelper.getRandomAlphabeticString(4);
//    private final String lastName = "Auto" + AppiumDriverHelper.getRandomAlphabeticString(4);
//    private final String ssnNumber = AppiumDriverHelper.getRandomNumeric(4);
//    private final String addressString1 = AppiumDriverHelper.getRandomAlphabeticString(5);
//    private final String addressString2 = AppiumDriverHelper.getRandomAlphabeticString(5);

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Check-in\"")
    MobileElement checkIN;

    @iOSXCUITFindBy(accessibility = "Phone")
    MobileElement phoneNumberField;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Check-out\"")
    MobileElement checkOut;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"First Name\"`]")
    MobileElement firstNameTextF;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Last Name\"`]")
    MobileElement lastNameTextF;


    @iOSXCUITFindBy(iOSNsPredicate = "label == \"\uF004 Name\"")
    MobileElement name;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"\uF1F0 Email\"")
    MobileElement email;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Email\"`]")
    MobileElement emailAddressTextF;

    @iOSXCUITFindBy(accessibility = "Continue")
    MobileElement continueButton;

    @iOSXCUITFindBy(accessibility = "Enter the code we sent to your phone")
    MobileElement enterOtpHeadLineText;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Please enter your first and last name\"`]")
    MobileElement enterDetailsHeadingText;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Validate\"`]")
    MobileElement validateButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"\uF141 Back\"`][2]")
    MobileElement backButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Enter Code\"`]")
    MobileElement enterOtp;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"\uF432 QR Code\"`]")
    MobileElement QRCode;

    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH \"Email\"")
    MobileElement emailDeparture;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Select your reservation\"`]")
    MobileElement reservationDetailsPage;

    @iOSXCUITFindBy(accessibility = "Want to talk to someone? Remote Assistance 24/7 \uF3F2")
    MobileElement wantToTakTextLink;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"\uF567 Video Call\"`]")
    MobileElement chooseVideoCall;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"\uF3F2 Voice Call\"`]")
    MobileElement chooseAudioCall;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Remote Assistance\"`]")
    MobileElement remoteAssistance;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"\uF3F5\"`]")
    MobileElement videoCallCut;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Are you sure you want to end call?\"`]")
    MobileElement callCutConfirmationPopup;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Yes\"")
    MobileElement yesButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Continue\"`][2]")
    MobileElement continueButtonConfirmDetails;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Done\"`][2]")
    MobileElement doneButtonConfirmDetails;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"End Session\"`][2]")
    MobileElement endSession;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"\uF013\"`][2]")
    MobileElement settingsIcon;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`value == \"Password\"`]")
    MobileElement passwordTextF;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"OK\"")
    MobileElement okButton;


    public void checkIn() {
        AppiumDriverHelper.waitUntilVisible(checkIN, 120, 2);
        checkIN.click();
    }

    public void selectLoginByUsingName() {
        AppiumDriverHelper.waitUntilVisible(name, 120, 2);
        name.click();

    }

    public void enterFirstNameAndLastName(String firstName, String lastName) throws InterruptedException {
        firstNameTextF.setValue(firstName);
        lastNameTextF.setValue(lastName);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.tap(new PointOption().withCoordinates(1290, 940)).perform();
    }

    public void clickOnContinue() {
        AppiumDriverHelper.waitUntilVisible(continueButton, 30, 3);
        continueButton.click();
    }

    public void navigateBackToHome() {
        backButton.click();
        AppiumDriverHelper.waitUntilVisible(backButton, 30, 2);
        backButton.click();
    }

    public void backToHome() throws InterruptedException {
        AppiumDriverHelper.waitUntilVisible(backButton, 30, 2);
        backButton.click();
        Thread.sleep(2000);
        backButton.click();
    }

    public void selectCheckInUsingConfirmationNumber() {
        AppiumDriverHelper.waitUntilVisible(confirmationNumber, 60, 1);
        confirmationNumber.click();
    }

    public void clickOnPhoneNumberFieldAndWaitForOtp() throws InterruptedException {
        AppiumDriverHelper.waitUntilVisible(phoneNumberField, 30, 3);
        phoneNumberField.click();
//        AppiumDriverHelper.waitUntilVisible(enterOtpHeadLineText, 60, 2);

    }

    public void waitTillOtpEnterAndClickOnValidate() throws InterruptedException, IOException {
        AppiumDriverHelper.waitUntilClickable(enterOtp, 60, 1);
        enterOtp.setValue(OTPForMobile);
        hideKeyboard();
        AppiumDriverHelper.waitUntilVisible(validateButton, 30, 2);
        validateButton.click();
    }

     @SneakyThrows
    public void hideKeyboard() throws InterruptedException {
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.tap(new PointOption().withCoordinates(1290, 940)).perform();
    }

//    public void enterOTPForMobile(String mobileNumberForOTP) throws InterruptedException, IOException {
//        AppiumDriverHelper.waitUntilClickable(enterOtp, 60, 1);
//        enterOtp.setValue(getOTPForMobileNumber(mobileNumberForOTP));
//        hideKeyboard();
//        AppiumDriverHelper.waitUntilVisible(validateButton, 30, 2);
//        validateButton.click();
//    }

    @iOSXCUITFindBy(className = "XCUIElementTypePickerWheel")
    WebElement countryPicker;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"United States\"`]")
    MobileElement usCountry;

    @iOSXCUITFindBy(iOSNsPredicate = "value ==\"India (भारत)\"")
    MobileElement selectIndia;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Telephone input\"`]")
    MobileElement mobileNumberTexF;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"ﭏ Confirmation Number\"`]")
    MobileElement confirmationNumber;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Confirmation Number\"`]")
    MobileElement confirmationNumberTextF;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Last Name\"`]")
    MobileElement lastName;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"\uF004 Name & Departure Date\"`]")
    MobileElement departureDate;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"First Name\"`]")
    MobileElement firstNameDepF;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Last Name\"`]")
    MobileElement lastNameDepF;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"\uF0ED Departure Date\"`]")
    MobileElement departureDateDepF;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Please enter your name and departure date\"`]")
    MobileElement departureFTitle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Confirm\"`]")
    MobileElement confirmDate;


    public void clickOnContinueAfterEnteringMobileNumber(String mobileNumber) throws InterruptedException {
        AppiumDriverHelper.waitUntilVisible(usCountry, 60, 2);
        mobileNumberTexF.clear();
        mobileNumberTexF.sendKeys(mobileNumber);
    }

    public void selectUsingDepartureDate() {
        AppiumDriverHelper.waitUntilVisible(departureDate, 60, 1);
        departureDate.click();
    }

    public void enterFirstNameAndLastNameForDepartureFunctionality(String firstName, String lastName) throws InterruptedException {
        AppiumDriverHelper.waitUntilVisible(departureFTitle, 60, 1);
        firstNameDepF.setValue(firstName);
        lastNameDepF.setValue(lastName);
        hideKeyboard();
    }

    public void selectDepartureDate(String departureDateText) throws InterruptedException {
        departureDateDepF.click();
        Thread.sleep(5000);
        appiumDriver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"" + departureDateText + "\"`]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")).click();
        confirmDate.click();
        AppiumDriverHelper.waitUntilVisible(continueButton, 60, 1);
        continueButton.click();
    }

    public void emailProceedDeparture() {
        AppiumDriverHelper.waitUntilVisible(emailDeparture, 60, 1);
        emailDeparture.click();
    }


    public void selectQRCodeFromMenus() {
        AppiumDriverHelper.waitUntilVisible(QRCode, 60, 1);
        QRCode.click();
    }

    public void clickOnContinueAfterEnteringEmailAddress(String emailAddress) {
        AppiumDriverHelper.waitUntilVisible(emailAddressTextF, 60, 1);
        emailAddressTextF.clear();
        emailAddressTextF.setValue(emailAddress);
    }

    public void fillConfirmationNumberDetails(String confirmationNumber, String lastName) {
        AppiumDriverHelper.waitUntilVisible(confirmationNumberTextF, 120, 2);
        confirmationNumberTextF.setValue(confirmationNumber);
        AppiumDriverHelper.waitUntilVisible(lastNameTextF, 120, 2);
        lastNameTextF.setValue(lastName);

    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"\uF3F2 Phone Number\" OR label == \"Phone\" `]")
    MobileElement selectPhoneNumber;


    public void selectPhoneNumberToContinue() {
        AppiumDriverHelper.waitUntilVisible(selectPhoneNumber, 120, 2);
        selectPhoneNumber.click();
    }


    public void enterSSNNumber() {
        AppiumDriverHelper.waitUntilVisible(checkOut, 120, 2);
        checkOut.click();
    }

    public void selectLoginByUsingEmailAddress() {
        AppiumDriverHelper.waitUntilVisible(email, 120, 2);
        email.click();

    }

    public String otp;

    public String getOTPFromMailinator() throws InterruptedException {
        chromeDriver.get("https://www.mailinator.com/");
        WebDriverWait wait = new WebDriverWait(chromeDriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
        chromeDriver.findElement(By.name("search")).sendKeys("balram_virdee@mailinator.com");
        Thread.sleep(1000);
        WebElement goButton = chromeDriver.findElement(By.xpath("//button[contains(text(),'GO')]"));
        Actions act = new Actions(chromeDriver);
        wait.until(ExpectedConditions.elementToBeClickable(goButton));
//        goButton.click();
        Thread.sleep(5000);
        act.moveToElement(goButton).click().build().perform();
//        act.sendKeys(Keys.ENTER);
//        act.sendKeys(Keys.ENTER);
        Thread.sleep(15000);
//        WebElement recentEmail = chromeDriver.findElement(By.xpath("(//td[contains(text(),'just now')])[1]"));
//        wait.until(ExpectedConditions.visibilityOf(recentEmail));
//        recentEmail.click();
        WebElement mailReceivedText = chromeDriver.findElement(By.xpath("//td[contains(text(),'Automation Emails')]"));
        mailReceivedText.click();
        Thread.sleep(3000);
        WebElement frame1 = chromeDriver.findElement(By.id("html_msg_body"));
        wait.until(ExpectedConditions.visibilityOf(frame1));
        chromeDriver.switchTo().frame(frame1);
        WebElement otpText = chromeDriver.findElement(
                By.xpath("//td[contains(text(),'Your authentication code is')]//parent::tr//following-sibling::tr//td")
        );
        String otpRequired = otpText.getText();
        otp = otpRequired.trim();
        System.out.println(otp);
        return otp;

    }

    public void waitTillMobileOtpEnterAndClickOnValidate() throws InterruptedException {
        AppiumDriverHelper.waitUntilClickable(enterOtp, 60, 1);
        Thread.sleep(15000);
        hideKeyboard();
        AppiumDriverHelper.waitUntilVisible(validateButton, 30, 2);
        validateButton.click();
    }

    public void verifyIfReservationCreated() {
        AppiumDriverHelper.waitUntilVisible(reservationDetailsPage, 120, 1);
        reservationDetailsPage.isDisplayed();
    }

    public void clickOnWantToTalkLink() throws InterruptedException {
        Thread.sleep(7000);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.tap(new PointOption().withCoordinates(1191, 41)).perform();
    }

    public void selectVideoCallOption() {
        AppiumDriverHelper.waitUntilVisible(chooseVideoCall, 60, 1);
        chooseVideoCall.click();
    }

    public void selectAudioCallOption() {
        AppiumDriverHelper.waitUntilVisible(chooseAudioCall, 60, 1);
        chooseAudioCall.click();
    }
    @SneakyThrows
    public void clickOnEndCall() {
        AppiumDriverHelper.waitUntilVisible(videoCallCut, 60, 1);
        videoCallCut.click();
        Thread.sleep(2000);
        if(videoCallCut.isDisplayed()){
            videoCallCut.click();
        }else {
            System.out.println("video call cut");
        }

    }

    public void verifyConfirmationPopupAndClickOnYes() {
        AppiumDriverHelper.waitUntilVisible(callCutConfirmationPopup, 60, 1);
        yesButton.click();
    }

    public void verifyCallingChoosePage() {
        AppiumDriverHelper.waitUntilVisible(chooseAudioCall, 60, 1);
        AppiumDriverHelper.waitUntilVisible(chooseVideoCall, 60, 1);
        chooseVideoCall.isDisplayed();
        chooseAudioCall.isDisplayed();
    }

    public String OTPForMobile;

    public String getOTPForMobileNumber(String MobileNumberForOTP) throws InterruptedException, IOException {
        Thread.sleep(45000);
        chromeDriver.get("https://receive-sms-free.cc/Free-USA-Phone-Number/1" + MobileNumberForOTP + "/");
        WebDriverWait wait = new WebDriverWait(chromeDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='US Phone Number']")));
        WebElement updateSMS = chromeDriver.findElement(By.xpath("//b[contains(text(),'Update the latest SMS')]"));
        wait.until(ExpectedConditions.visibilityOf(updateSMS));
        Thread.sleep(3000);
        OTPForMobile = chromeDriver.findElement(By.xpath("(//div[contains(text(),'Your authentication code is ')]//b)[1]")).getText();
        System.out.println(OTPForMobile);
        return OTPForMobile;
        /**
         FileInputStream in = new FileInputStream("data/commonData.properties");
         Properties props = new Properties();
         props.load(in);
         in.close();
         FileOutputStream out = new FileOutputStream("data/commonData.properties");
         props.setProperty("OTPForMobileNumber", OTPForMobile);
         props.store(out, null);
         out.close();
         System.out.println("OT stored in configuration file is : " +OTPForMobile);
         **/
    }

    public void waitTillOtpForEmailEnterAndClickOnValidate() throws InterruptedException {
        AppiumDriverHelper.waitUntilClickable(enterOtp, 60, 1);
        enterOtp.setValue(otp);
        hideKeyboard();
        AppiumDriverHelper.waitUntilVisible(validateButton, 30, 3);
        validateButton.click();
    }

    public void clickOnReservation() throws InterruptedException {
        Thread.sleep(5000);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.tap(new PointOption().withCoordinates(270, 450)).perform();
    }


    public void navigateToGetCardAndEndSession() {

    }

    public void validateAllThings() throws InterruptedException {
        Thread.sleep(7000);
        AppiumDriverHelper.waitUntilVisible(continueButtonConfirmDetails, 60, 1);
        continueButtonConfirmDetails.click();
        Thread.sleep(11000);
        /**
         * include if functionality changes
         *
         *AppiumDriverHelper.waitUntilVisible(continueButtonConfirmDetails, 60, 1);
         *         continueButtonConfirmDetails.click();
         *         Thread.sleep(3000);
         *        AppiumDriverHelper.waitUntilVisible(endSession,60,1);
         *        endSession.click();
         *
         */

        AppiumDriverHelper.waitUntilVisible(doneButtonConfirmDetails, 60, 1);
        doneButtonConfirmDetails.click();

    }

    public void clickOnSettingsIcon() {
        AppiumDriverHelper.waitUntilVisible(settingsIcon, 60, 1);
        settingsIcon.click();
    }

    public void enterPasswordAndSubmit(String password) throws InterruptedException {
        AppiumDriverHelper.waitUntilVisible(passwordTextF, 60, 1);
        passwordTextF.setValue(password);
        okButton.click();
        Thread.sleep(4000);
    }

    @SneakyThrows
    public void validateSignature() {
        Thread.sleep(7000);
        AppiumDriverHelper.waitUntilVisible(continueButtonConfirmDetails, 60, 1);
        continueButtonConfirmDetails.click();
        Thread.sleep(2000);
        AppiumDriverHelper.waitUntilVisible(continueButtonConfirmDetails, 60, 1);
        continueButtonConfirmDetails.click();
        Thread.sleep(8000);
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.tap(new PointOption().withCoordinates(688, 863)).perform();
        Thread.sleep(5000);
        AppiumDriverHelper.waitUntilVisible(continueButtonConfirmDetails, 60, 1);
        continueButtonConfirmDetails.click();
        Thread.sleep(10000);
        AppiumDriverHelper.waitUntilVisible(doneButtonConfirmDetails, 60, 1);
        doneButtonConfirmDetails.click();


    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Edit\"`][2]")
    MobileElement editButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Update\"`][2]")
    MobileElement updateButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uF004\"])[5]/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    MobileElement lastNameEmptyField;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Kumar\"`]")
    MobileElement lastNameAlreadyEntered;

    public void clickOnEditButton() {
        AppiumDriverHelper.waitUntilVisible(editButton, 60, 1);
        editButton.click();
    }

    public void editUserDetailsAndUpdateDetails(String newUserName, String lastName) throws InterruptedException {
       AppiumDriverHelper.waitUntilVisible(lastNameEmptyField,60,1);
        lastNameEmptyField.clear();
        lastNameEmptyField.setValue(newUserName);
        hideKeyboard();
        AppiumDriverHelper.waitUntilVisible(updateButton, 120, 1);
        updateButton.click();
        AppiumDriverHelper.waitUntilVisible(continueButtonConfirmDetails,120,1);
        continueButtonConfirmDetails.click();
        AppiumDriverHelper.waitUntilVisible(doneButtonConfirmDetails,120,1);
        doneButtonConfirmDetails.click();
        Thread.sleep(5000);
    }
}

