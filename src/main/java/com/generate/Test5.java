package com.generate;

/**
 * @Author: liufeng
 * @Date: 2020/12/18
 * @desc
 */
public class Test5 {

  private static volatile Test5 instance;

  private Test5() {
  }

  public static Test5 getInstance() {
    if (instance == null) {
      synchronized (Test5.class) {
        if (instance == null) {
          instance = new Test5();
        }
      }
    }
    return instance;
  }
}
