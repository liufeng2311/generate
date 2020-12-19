package com.generate;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: liufeng
 * @Date: 2020/12/18
 * @desc 输入年月日，计算该日期是这一年的第几天。
 * <p>
 * 输入：
 * <p>
 * 2020
 * <p>
 * 12
 * <p>
 * 07
 * <p>
 * 输出：
 * <p>
 * ?
 * <p>
 * 关于闰年和平年的计算
 * <p>
 * 一般的年份除以4，有余数的是平年，没有余数的是闰年。 但如果是那个年份是整百的，那么该年份除以400，有余数的是平年，没有余数的是闰年；
 * <p>
 * 举个栗子：2020年能被4整除， 那么2020年就是闰年；2000年能被400整除， 这一年也是闰年；2019年除以4，余数为3，不能被4或者400整除，那么2019年就是平年
 *
 *
 *
 * 1111111111111111111111111111111
 */
public class TestYear {


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Integer year = scanner.nextInt();
    int month = scanner.nextInt();
    int day = scanner.nextInt();
    int days = 0;
    //判断平年闰年
    boolean ruinian = false;
    if ((year.toString().endsWith("00") && year % 400 == 0) || year % 4 == 0) {
      ruinian = true;
    }
    List<Integer> list = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
    List<Integer> list1 = Arrays.asList(4, 6, 9, 11);

    for (int i = 1; i < 13; i++) {
      if (i < month) {
        if (list.contains(i)) {
          days += 31;
        } else if (list1.contains(i)) {
          days += 30;
        } else if (ruinian) {
          days += 29;
        } else {
          days += 28;
        }
      }

    }
    days += day;

    System.out.println(days);
  }

}
