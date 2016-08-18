package com.example.api.str.time;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by lazygod on 2016/8/16 ${Time}.
 */
public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2016, 8, 16);
        while (date.getMonthValue() == 8) {
            System.out.printf("%4d",date.getDayOfMonth());
            date = date.plusDays(1);
            System.out.println("date = " + date);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            int value = dayOfWeek.getValue();
            System.out.println("value = " + value);
            for (int i = 0; i < value; i++) {
                System.out.println("  ");
            }
        }
    }
}
