package com.generate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    String l = in.next();
    List<Integer> list = new ArrayList<>();
    char[] chars = s.toCharArray();
    char[] chars1 = l.toCharArray();
    int index = 0;  //记录下次L遍历开始的位置

    if (s.length() > l.length()) {
      System.out.println(-1);
    }
    outer:
    for (int i = 0; i < chars.length; i++) {
      for (int j = index; j < chars1.length; j++) {
        if (chars[i] == chars1[j]) {
          list.add(j);
          index = j + 1;
          continue outer;
        }
        if (i < chars.length - 1 && j == chars1.length) {
          System.out.println(-1);
        }
      }

    }

    if (list.size() == chars.length) {
      System.out.println(list.get(list.size() - 1));
    } else {
      System.out.println(-1);
    }
  }

}
