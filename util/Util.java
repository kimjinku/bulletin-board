package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

    // util 데이터를 표현 X
    public static String getCurrentDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        String formatedNow = now.format(formatter);

        return formatedNow;
    }
}