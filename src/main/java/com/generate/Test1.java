package com.generate;

/**
 * @Author: liufeng
 * @Date: 2020/12/14
 * @desc 一个含有多个空格的ASCII串，求最长非空格字符串的长度
 */
public class Test1 {

  public static void main(String[] args) {
    String aa = "dadwqdadwqdadwqdadwqdadwqdadwqdadwqdadwqdadwqdadwqdadwqdadwqdadwqdadwqdadwqdadwq";
    Integer integer = maxLength(aa);
    System.out.println(integer);
  }


  public static Integer maxLength(String str) {
    int head = 0;  //开始位置
    int tail = 0; //结束位置
    boolean flag = false; //是否经过空格需要重新定位head
    int max = 0; //记录之前字符串的最大长度
    int length; //本次字符串的长度
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] != ' ') {
        tail = i;
        if (flag) {
          head = tail;
          flag = false;
        }
      } else {
        flag = true; //遇到空格时设置该属性为true表示再次遇到非空格时需要重新移动head指针(解决连续多空格问题)
      }

      //当遇到空格或者数组遍历完成时,需要判断是否是否超过最大长度
      if ((flag || i == chars.length - 1) && tail != 0 && (length = tail - head + 1) > max) {
        max = length;
      }
    }
    return max;
  }


}
