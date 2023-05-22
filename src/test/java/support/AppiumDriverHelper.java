package support;

import com.sun.javafx.scene.traversal.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.restassured.RestAssured.given;
import static org.openqa.selenium.Keys.DOWN;
import static org.openqa.selenium.Keys.UP;
import static support.DeviceCreation.appiumDriver;

public class AppiumDriverHelper {
    public static Wait<AppiumDriver> wait;
    private static AppiumDriver driver;

    public AppiumDriverHelper(AppiumDriver driver) {
        AppiumDriverHelper.driver = driver;
    }

    public static void waitUntilVisible(MobileElement element, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout + 30)).pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void waitUntilVisibleOnBrowser(WebElement element, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout + 30)).pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void FindPaymentMethod(String paymentName) {
        int count = 0;
        boolean clicked = false;
        while (count < 7 && !clicked) {
            try {
                do {

                    AppiumDriverHelper.swipe(0, 694, 0, 70, 5);
                    System.out.println("Scrolling Down");
                } while (appiumDriver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeImage[`label == \"" + paymentName + "\"`]")).size() != 1);
                if (appiumDriver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeImage[`label == \"" + paymentName + "\"`]")).size() == 1) {
                    appiumDriver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeImage[`label == \"" + paymentName + "\"`]")).click();
                    clicked = true;
                    System.out.println("Tap on to" + paymentName + "");
                }
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }
        }
    }

    public static void findCountry(String countryName) {
        int count = 0;
        boolean clicked = false;
        while (count < 7 && !clicked) {
            try {
                do {
                    AppiumDriverHelper.swipe(1000,817,1000,900,1);
                    System.out.println("Scrolling to find Country");
                } while (appiumDriver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypePickerWheel[`value == \"" + countryName + "\"`]")).size() != 1);
                if (appiumDriver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypePickerWheel[`value == \"" + countryName + "\"`]")).size() == 1) {
                    appiumDriver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypePickerWheel[`value == \"" + countryName + "\"`]")).click();
                    clicked = true;
                    System.out.println("Tap on to" + countryName + "");
                }
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }
        }
    }


    public static void StagingProcess(String element) {
        int count = 0;
        boolean clicked = false;
        while (count < 3 && !clicked) {
            try {
                WebElement yourSlipperyElement = appiumDriver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label == \""+element+"\"`]"));
                yourSlipperyElement.click();
                clicked = true;
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }
        }
    }



    public static void StaleElementHandlePaymentLogo(String paymentLogo) {
        int count = 0;
        boolean clicked = false;
        while (count < 7 && !clicked) {
            try {
                do {
                    AppiumDriverHelper.swipe(0, 394, 0, 70, 3);
                    System.out.println("Scrolling Down");

                } while (appiumDriver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeImage[`label == \"" + paymentLogo + "\"`]")).size() != 1);
                if (appiumDriver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeImage[`label == \"" + paymentLogo + "\"`]")).size() == 1) {
                    appiumDriver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeImage[`label == \"" + paymentLogo + "\"`]")).click();
                    clicked = true;
                    System.out.println("Payment method is displayed :" + paymentLogo + "");
                }
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }

        }
    }


    public static void ScrollToFindElement(String element) {
        int count = 0;
        while (count < 7) {
            try {
                do {
                    AppiumDriverHelper.swipe(0, 394, 0, 70, 3);
                    System.out.println("Scrolling Down");

                } while (appiumDriver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"" + element + "\"`]")).size() != 1);

            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }

        }
    }

    public static void StaleElementHandleAccountMenus(String menuName) {
        int count = 0;
        boolean clicked = false;
        while (count < 3 && !clicked) {
            try {
                do {
                    AppiumDriverHelper.swipe(0, 394, 0, 70, 5);
                    System.out.println("Scrolling Down");

                } while (appiumDriver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"" + menuName + "\"`]")).size() != 1);
                if (appiumDriver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"" + menuName + "\"`]")).size() == 1) {
                    appiumDriver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"" + menuName + "\"`]")).click();
                    clicked = true;
                    System.out.println("Tap on to " + menuName + "");
                }
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }
            if (appiumDriver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"Menu\"`]")).size() == 1) {
                System.out.println("navigate to " + menuName + "");
            } else {
                StaleElementHandleAccountMenus(menuName);
            }
        }
    }   public static void StaleElementHandleAccountMenu(String menuName) {
        int count = 0;
        boolean clicked = false;
        while (count < 3 && !clicked) {
            try {
                do {
                    AppiumDriverHelper.swipe(0, 394, 0, 70, 5);
                    System.out.println("Scrolling Down");

                } while (appiumDriver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"" + menuName + "\"`]")).size() != 1);
                if (appiumDriver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"" + menuName + "\"`]")).size() == 1) {
                    appiumDriver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"" + menuName + "\"`]")).click();
                    clicked = true;
                    System.out.println("Tap on to " + menuName + "");
                }
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }
            if (appiumDriver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"Menu\"`]")).size() == 1) {
                System.out.println("navigate to " + menuName + "");
            } else {
                StaleElementHandleAccountMenus(menuName);
            }
        }
    }
    public static void NavigationsAccountMenus(String menuName) {
        int count = 0;
        boolean clicked = false;
        while (count < 3 && !clicked) {
            try {
                do {
                    AppiumDriverHelper.swipe(0, 394, 0, 70, 5);
                    System.out.println("Scrolling Down");

                } while (appiumDriver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"" + menuName + "\"`]")).size() != 1);
                if (appiumDriver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"" + menuName + "\"`]")).size() == 1) {
                    appiumDriver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"" + menuName + "\"`]")).click();
                    clicked = true;
                    System.out.println("Tap on to " + menuName + "");
                }
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }
            if (appiumDriver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"Menu\"`]")).size() == 1) {
                appiumDriver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"Menu\"`]")).click();
                System.out.println("Click On Back Menu from - > "+menuName+" -> Screen");
            } else {
                NavigationsAccountMenus(menuName);
            }
        }
    }
    public static void StaleElementHandleWithdrawalButton(String elementID) {
        int count = 0;
        boolean clicked = false;
        while (count < 7 && !clicked) {
            try {
                WebElement yourSlipperyElement = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"" + elementID + "\"`]"));
                yourSlipperyElement.click();
                IOSTouchAction iosTouchAction = new IOSTouchAction(appiumDriver);
                iosTouchAction.tap(element(yourSlipperyElement));
                clicked = true;
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }
        }
    }

    public static void StaleElementHandleDepositButton(String elementID) {
        int count = 0;
        boolean clicked = false;
        while (count < 7 && !clicked) {
            try {
                WebElement yourSlipperyElement = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"" + elementID + "\"`]"));
                yourSlipperyElement.click();
                IOSTouchAction iosTouchAction = new IOSTouchAction(appiumDriver);
                iosTouchAction.tap(element(yourSlipperyElement));
                clicked = true;
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }
        }
    }

    public static void StaleElementHandleIsDisplayed(String elementID) {
        int count = 0;
        while (count < 7) {
            try {
                WebElement yourSlipperyElement = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"" + elementID + "\"`]"));
                yourSlipperyElement.isDisplayed();
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }
        }
    }

    public static void StaleElementHandle(String elementID) {
        int count = 0;
        boolean clicked = false;
        while (count < 7 && !clicked) {
            try {
                WebElement yourSlipperyElement = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypePickerWheel[`value == \"" + elementID + "\"`]"));
                yourSlipperyElement.click();
                IOSTouchAction iosTouchAction = new IOSTouchAction(appiumDriver);
                iosTouchAction.tap(element(yourSlipperyElement));
                clicked = true;
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }
        }
    }

    public static String getRequiredDay(String incOrDecDays, String expectedDateFormat, String timeZoneId) {
        try {
            DateFormat dateFormat;
            Calendar calendar = Calendar.getInstance();
            dateFormat = new SimpleDateFormat(expectedDateFormat);
            if (timeZoneId != null && !timeZoneId.equals("")) dateFormat.setTimeZone(TimeZone.getTimeZone(timeZoneId));
            calendar.add(Calendar.DAY_OF_MONTH, Integer.parseInt(incOrDecDays));
            Date tomorrow = calendar.getTime();
            String formattedDate = dateFormat.format(tomorrow);
            return formattedDate;
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String getValueFromResponseNew(Response responses, String path) {
        String value = responses.path(path);
        return value;
    }

    public static Response GetRequest(String params) {
        Response response = given().contentType(ContentType.ANY).relaxedHTTPSValidation().log().all().when().get(params).then().extract().response();
        return response;
    }

    /**
     * return require date with increment/decrement in months from current date
     *
     * @param : incOrDecMonth Number by which user want increase/decrease month
     * @param : sExpectedDateFormat - User expected date format eg. 9 april 2014
     *          --- dd/MM/yyyy -> 09/04/2015, dd-MM-yyyy -> 09-04-2015
     * @param : timeZoneId - Time Zone
     * @Author : Rahul Shelke (Expleo)
     */
    public static String getRequiredMonth(String incOrDecMonth, String expectedDateFormat, String timeZoneId) {
        try {
            DateFormat dateFormat;
            Calendar calendar = Calendar.getInstance();
            dateFormat = new SimpleDateFormat(expectedDateFormat);
            if (timeZoneId != null && !timeZoneId.equals("")) dateFormat.setTimeZone(TimeZone.getTimeZone(timeZoneId));
            calendar.add(Calendar.MONTH, Integer.parseInt(incOrDecMonth));
            Date tomorrow = calendar.getTime();
            String formattedDate = dateFormat.format(tomorrow);
            return formattedDate;
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }


    public static String getRequiredDateWithCustomYear(String incOrDecYear, String expectedDateFormat, String timeZoneId) {
        try {
            DateFormat dateFormat;
            Calendar calendar = Calendar.getInstance();
            dateFormat = new SimpleDateFormat(expectedDateFormat);
            if (timeZoneId != null && !timeZoneId.equals("")) dateFormat.setTimeZone(TimeZone.getTimeZone(timeZoneId));
            calendar.add(Calendar.YEAR, Integer.parseInt(incOrDecYear));
            Date tomorrow = calendar.getTime();
            String formattedDate = dateFormat.format(tomorrow);
            return formattedDate;
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }


    public static String getFormatedDate(String date, String originalDateFormat, String expectedDateFormat) {
        try {
            DateFormat inputFormatter = new SimpleDateFormat(originalDateFormat);
            Date originalDate = inputFormatter.parse(date);
            DateFormat outputFormatter = new SimpleDateFormat(expectedDateFormat);
            String expectedDate = outputFormatter.format(originalDate);
            return expectedDate;
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }


    public static String modifyDaysFromDate(String incOrDecDays, String date, String userDateFormat) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(userDateFormat);
            Calendar c = Calendar.getInstance();
            c.setTime(dateFormat.parse(date));
            c.add(Calendar.DATE, Integer.parseInt(incOrDecDays));
            String convertedDate = dateFormat.format(c.getTime());
            return convertedDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void copyFileUsingStream(String sourceFilePath, String destinationFilePath) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(new File(sourceFilePath));
            outputStream = new FileOutputStream(new File(destinationFilePath));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        } catch (Exception exception) {
            exception.printStackTrace();

        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public static String getMonthInNumber(String expectedMonth) {
        try {
            Date date;
            date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(expectedMonth);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int month = cal.get(Calendar.MONTH);
            month = month + 1;
            String strMonth = String.valueOf(month);
            if (strMonth.length() == 1) strMonth = "0" + strMonth;
            return strMonth;
        } catch (Exception exp) {
            exp.printStackTrace();
            return "";
        }
    }

    public static String getRandomAlphabeticString(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }

    public static String getRandomAlphanumericString(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    public static String getRandomNumeric(int count) {
        return RandomStringUtils.randomNumeric(count);
    }

    public static String getRandomNumericBetweenTwo(int min, int max) {
        Random random = new Random();
        int result = random.nextInt(max - min) + min;
        return String.valueOf(result);
    }

    public static String getRandomAlphanumericEmailString(int count, String emailAddress) {
        return "e" + RandomStringUtils.randomAlphanumeric(count) + emailAddress;
    }
    public static String getRandomAlphanumericAddressString(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    public static String getRandomTitleForUser() {
        String[] arrTitles = {"Mr", "Miss", "Mrs", "Ms"};
        int idx = new Random().nextInt(arrTitles.length);
        return (arrTitles[idx]);
    }

    public static void writeAppiumLogs(LogEntries appiumLogEntries) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File(System.getProperty("user.dir") + "src/test/resources/Logs/Appium.log"), true);
            StringBuilder buf = new StringBuilder();
            buf.append("Appium Driver LOGS:\n\n");
            for (final LogEntry entry : appiumLogEntries) {
                buf.append(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage() + "\n");
                writer.write(buf.toString());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* returns Current date in provided date format*/
    public static String getCurrentDate(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        String date1 = dateFormat.format(date);
        //System.out.println("Current date is " + date1);
        return date1;
    }

    public static void swipe(int x_start, int y_start, int x_stop, int y_stop, int duration) {
        new TouchAction<>(driver).press(PointOption.point(x_start, y_start)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration))).moveTo(PointOption.point(x_stop, y_stop)).perform();
    }

    public static void waitUntilClickable(MobileElement element, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean switchToWebContext() {
        ArrayList<String> contexts = new ArrayList(driver.getContextHandles());
        for (String context : contexts) {
            System.out.println(context);
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                return true;
            }
        }
        return false;
    }

    public static String getBase64Screenshot() throws IOException {
        String Base64StraingOfScreenshots = "";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");
        String sDate = sdf.format(date);
        String newFileName = "test-output/screenshots/" + "image_" + sDate + ".png";
        FileUtils.copyFile(src, new File(newFileName));
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        Base64StraingOfScreenshots = "date:image/png;base64," + fileContent;
        return newFileName;
    }

    public static String getScreenshot() throws Exception {

        String Base64StraingOfScreenshots = "";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");
        String sDate = sdf.format(date);
        String newFileName = "/test-output/screenshots/" + "image_" + sDate + ".png";
        FileUtils.copyFile(src, new File(newFileName));
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        Base64StraingOfScreenshots = "date:image/png;base64," + fileContent;
        return newFileName;
    }

    public static boolean retryingFindClick(String element) {
        boolean result = false;
        int attempts = 0;
        while (attempts < 2) {
            try {
                driver.findElement(MobileBy.iOSNsPredicateString(element));
                result = true;
                break;
            } catch (StaleElementReferenceException staleElementReferenceException) {
            }
            attempts++;
        }
        return result;
    }

    public static void scrollToElement(MobileElement responsibleGamingLogoMSNJ) {
    }


    public byte[] getByteScreenshot() throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        return fileContent;
    }

    public void verifyPageTitle(String expectedPageTitle) {
        Assert.assertTrue(driver.getTitle().contains(expectedPageTitle));
    }

    public void waitUntilPresenceOfAllElements(String element, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(element)));
    }

    public void waitUntilFrameToBeAvailableAndSwitchToIt(MobileElement element, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public void waitUntilURLContains(String url, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(pollingTime));
        wait.until(ExpectedConditions.urlContains(url));
    }

    public void waitUntilInvisibilityOfElementWithText(String element, String value, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(pollingTime));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(element), value));
    }

    public void waitUntilTextToBePresentInElement(MobileElement element, Integer timeout, Integer pollingTime, String text) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(pollingTime));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitUntilAttributeToBePresent(MobileElement element, String attribute, String value, Integer timeout, Integer pollingTime) {
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(pollingTime));
        wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }


    public static void StaleElementHandleGamingLimitsubmenu(String menuName) {
        int count = 0;
        boolean clicked = false;
        while (count < 7 && !clicked) {
            try {
                WebElement yourSlipperyElement = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"" + menuName + "\"`]"));
                yourSlipperyElement.click();
                clicked = true;
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }
        }
    }
    public static void StaleElementHandleForButton(String buttonName) {
        int count = 0;
        boolean clicked = false;
        while (count < 7 && !clicked) {
            try {
                WebElement yourSlipperyElement = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"" + buttonName + "\"`]"));
                yourSlipperyElement.click();
                IOSTouchAction iosTouchAction = new IOSTouchAction(appiumDriver);
                iosTouchAction.tap(element(yourSlipperyElement));
                clicked = true;
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }
        }
    }

    public static void pressBackButton() throws InterruptedException {
        System.out.println("Pressing android navigate back button");
        AndroidDriver androidDriver=(AndroidDriver) driver;
        Thread.sleep(8000);
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(4000);
        //TouchAction action= new TouchAction(appiumDriver);
        //action.press().release().perform();
       /*TouchAction action= new TouchAction(driver);
       action.press(1065, 202).perform();*/
        //DeviceCreation.androidDriverInstance().pressKey(new KeyEvent(AndroidKey.BACK));
    }
    public static void scrollUP(){
        Dimension size =driver.manage().window().getSize();
        int startVerticalY =(int) (size.height * 0.8);
        int endVerticalY = (int) (size.height * 0.18);
        int startVerticalX = (int) (size.width / 2);
        try{
            System.out.println("performing scroll action");
            new TouchAction<>(driver).longPress(point(startVerticalX,startVerticalY)).moveTo(point(startVerticalX,endVerticalY)).release().perform();
        }catch (Exception e){
            System.out.println("not scrolled");
        }
    }

    public static  void mobileScrollElementIOS(MobileElement el, Direction dir) {
        System.out.println("mobileScrollElementIOS(): dir: '" + dir + "'");

        final int ANIMATION_TIME = 200;
        final HashMap<String, String> scrollObject = new HashMap<String, String>();

        switch (dir) {
            case DOWN: // from down to up (! differs from mobile:swipe)
            case UP: // from up to down (! differs from mobile:swipe)
            case LEFT: // from left to right (! differs from mobile:swipe)
            case RIGHT: // from right to left (! differs from mobile:swipe)
                scrollObject.put("direction", dir.name().toLowerCase());
                break;
            default:
                throw new IllegalArgumentException("mobileScrollElementIOS(): dir: '" + dir + "' NOT supported");
        }
        scrollObject.put("element", el.getId());
        try {
            driver.executeScript("mobile:scroll", scrollObject); // swipe faster then scroll
            Thread.sleep(ANIMATION_TIME); // always allow swipe action to complete
        } catch (Exception e) {
            System.err.println("mobileScrollElementIOS(): FAILED\n" + e.getMessage());
            return;
        }
    }

    public static void scrollToElement(String visibleText){
        System.out.println("scrolling to visible text: "+ visibleText);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable (new UiSelector().scrollable(true)).setMaxSearchSwipes(10).scrollIntoView(new UiSelector().text(\"" + visibleText + "\"))"));
    }
    public static void scrollUpTillVisibilityOfElement(int howManySwipes,String text){
        Dimension size =driver.manage().window().getSize();
        int startVerticalY =(int) (size.height * 0.8);
        int endVerticalY = (int) (size.height * 0.21);
        int startVerticalX = (int) (size.width / 2);
        for(int i=0;i<howManySwipes;i++){
            try{
                scrollToElement(text);
            }catch (Exception e){
                new TouchAction<>(driver).longPress(point(startVerticalX,startVerticalY)).moveTo(point(startVerticalX,endVerticalY)).release().perform();
            }
        }
    }
}

