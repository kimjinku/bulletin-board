package main.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CurrentDateTime {
    public static void main(String[] args) {

        // 현재 날짜 구하기
        LocalDateTime now = LocalDateTime.now();
        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        // 포맷 적용
        String formatedNow = now.format(formatter);

        // 결과 출력
        System.out.println(formatedNow);  // 2021/06/17
    }
}
