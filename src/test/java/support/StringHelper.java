package support;

import org.iban4j.CountryCode;
import org.iban4j.Iban;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Random;

public class StringHelper {

    public static Iban setIBANGen() {
        Iban iban = Iban.random(CountryCode.NL);
        System.out.println("set IBAN->" + iban);
        return iban;
    }

    public static boolean isAlphaNumeric(String s) {
        String pattern = "^[a-zA-Z0-9]{1,15}$";
        System.out.println("Reg expression" + s.matches(pattern));
        return s.matches(pattern);
    }

    public int randomNumberPositiveInteger(Integer lowNumber, Integer highNumber) {
        //creates a positive, integer only random number between provided low and high numbers for inserting into text strings
        // int lowNumber = 1;
        // int highNumber = 1000;
        // returns a number between 1 and 1000
        double a = lowNumber + (Math.random() * highNumber);
        int randomNumber = (int) a;
        System.out.println(randomNumber);
        return randomNumber;
    }

    // generates alpha Numeric character string of x value.
    public String alphaNumericCharacterGenerator(Integer stringLength) {
        int leftLimit = 48; // numeral '0' ASCII value
        int rightLimit = 122; // letter 'z' ASCII value
        int targetStringLength = stringLength;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    // generates special character string of x length.
    public String specialCharacterGenerator(Integer stringLength) {
        String specialChars = "@$%&*#?";
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < stringLength; i++) {
            builder.append(specialChars.charAt(random.nextInt(specialChars.length())));
        }
        return builder.toString();
    }

    // Below method generates unique string value in yyyyMMddHHmmssSS format
    public String randomNumberGeneratorForGameplay() {
        Date dNow1 = new Date();
        SimpleDateFormat ft1 = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String number1 = ft1.format(dNow1);

        return number1;
    }

    // Below method generates unique string value in yyMMddhhmmssMs format
    public String randomNumberGenerator() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
        String number = ft.format(dNow);

        return number;
    }

    // Below method generates Epoch timestamp in milliseconds
    public String epochTime() {
        long uniqueNumber = ZonedDateTime.now().toInstant().toEpochMilli();
        String s = Long.toString(uniqueNumber);

        return s;
    }

    public String getSpinCountFromGoalName(String goalName) {
        StringBuffer sb = new StringBuffer(goalName);
        String spinCount = sb.substring(0, sb.length() - 5);
        return spinCount;
    }
}