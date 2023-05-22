package support;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StaleElementUtils {

    /**
     * The Constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(StaleElementUtils.class);

    private static By getBy(final String key, final String value) throws InvocationTargetException, IllegalAccessException {
        final By by = null;
        final Class clazz = By.class;
        final String methodName = key.replace(" ", "");
        final Method m = getCaseInsensitiveStaticDeclaredMethod(clazz, methodName);
        return (By) m.invoke(null, value);
    }

    private static Method getCaseInsensitiveDeclaredMethod(final Object obj, final String methodName) {
        final Method[] methods = obj.getClass().getMethods();
        Method method = null;
        for (final Method m : methods) {
            if (m.getName().equalsIgnoreCase(methodName)) {
                method = m;
                break;
            }
        }
        if (method == null) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s Method name is not found for this Class %s", methodName,
                    obj.getClass().toString()));
        }
        return method;
    }

    private static Method getCaseInsensitiveStaticDeclaredMethod(final Class clazz, final String methodName) {
        final Method[] methods = clazz.getMethods();
        Method method = null;
        for (final Method m : methods) {
            if (m.getName().equalsIgnoreCase(methodName)) {
                method = m;
                break;
            }
        }
        if (method == null) {
            throw new IllegalStateException(
                    String.format(Locale.ENGLISH, "%s Method name is not found for this Class %s", methodName, clazz.toString()));
        }
        return method;
    }

    private static MobileElement getWebElement(final Object lastObject, final String key, final String value) {
        MobileElement element = null;
        try {
            final By by = getBy(key, value);
            final Method m = getCaseInsensitiveDeclaredMethod(lastObject, "findElement");
            element = (MobileElement) m.invoke(lastObject, by);
        } catch (final InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return element;
    }

    public static boolean isElementStale(final MobileElement e) {
        try {
            e.isDisplayed();
            return false;
        } catch (final StaleElementReferenceException ex) {
            return true;
        }
    }

    public static MobileElement refreshElement(final MobileElement elem, final AppiumDriver appiumDriver) {
        if (!isElementStale(elem)) {
            return elem;
        }
        Object lastObject = null;
        try {
            final String[] arr = elem.toString().split("->");
            final List<String> newStr = new ArrayList<>();
            for (final String s : arr) {
                final String newstr = s.trim().replaceAll("^\\[+", "").replaceAll("\\]+$", "");
                final String[] parts = newstr.split(": ");
                final String key = parts[0];
                String value = parts[1];
                final int leftBracketsCount = value.length() - value.replace("[", "").length();
                final int rightBracketscount = value.length() - value.replace("]", "").length();
                if (leftBracketsCount - rightBracketscount == 1) {
                    value = value + "]";
                }
                if (lastObject == null) {
                    lastObject = appiumDriver;
                } else {
                    lastObject = getWebElement(lastObject, key, value);
                }
            }
        } catch (final Exception e) {
            System.out.println("Error in Refreshing the stale Element.");
        }
        return (MobileElement) lastObject;
    }
}