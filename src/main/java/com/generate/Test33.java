package com.generate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author: liufeng
 * @Date: 2020/12/16
 * @desc
 */
public class Test33 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int test = in.nextInt();
    Scanner inq = new Scanner(System.in);
    String aa = inq.nextLine();
    String[] aaaa = aa.split(" ");
    Integer[] a = new Integer[aaaa.length];
    for (int m = 0; m < aaaa.length; m++) {
      a[m] = Integer.valueOf(aaaa[m]);
    }
    int aaa = 0;  //记录当前最长长度
    List list = new ArrayList();
    int length = 1;
    int num = 0;
    for (int i = 0; i < a.length; i++) {
      num = a[i];
      for (int j = i + 1; j < a.length; j++) {
        length++;
        num += a[j];
        if (test * length >= num) {
          if (length == aaa) {
            list.add(i + "-" + j);
          } else if (length > aaa) {
            aaa = length;
            list.clear();
            list.add(i + "-" + j);
          }
        }
      }
      length = 1;
    }

    String s = list.stream().collect(Collectors.joining(" ")).toString();
    System.out.println(s);
  }
}
