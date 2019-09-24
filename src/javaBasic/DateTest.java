package javaBasic;

import java.util.Date;
import java.util.Scanner;

public class DateTest {

    private String getToday() {

        Date date = new Date();
        String strDate =String.format("今天是今年的第%tj天" ,date);
        System.out.println(strDate);
        return strDate;
    }

    public static void main(String[] args) {
        DateTest dt = new DateTest();
        dt.getToday();
        dt.getToDay2();
    }

    private void getToDay2() {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            int year = sc.nextInt();//年份

            int month = sc.nextInt();//月份

            int day = sc.nextInt();//日期


            boolean isleapYear  = ((year%4==0&&year%100!=0)||(year%400)==0?true:false);

            int days = 0;

            switch (month-1){

                case 12:days += 31;

                case 11:days += 30;

                case 10:days += 31;

                case 9:days += 30;

                case 8:days += 31;

                case 7:days += 31;

                case 6:days += 30;

                case 5:days += 31;

                case 4:days += 30;

                case 3:days += 31;

                case 2: if(isleapYear)

                    days += 29;

                else

                    days += 28;

                case 1:days += 31;

            }

            System.out.println(day+days);

        }
    }

}
