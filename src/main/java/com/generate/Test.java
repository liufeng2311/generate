package com.generate;

import lombok.Data;

/**
 * @Author: liufeng
 * @Date: 2020/8/23
 * @desc 判断链表是否有环
 */
public class Test {


  public static void main(String[] args) {
    Ring ring = new Ring();
    Ring ring1 = new Ring();
    Ring ring2 = new Ring();
    Ring ring3 = new Ring();
    ring.next = ring1;
    ring1.next = ring2;
    ring2.next = ring3;
    ring3.next = ring2;
    Boolean aBoolean1 = hasRing(ring);
    Boolean aBoolean2 = hasRing1(ring);
    System.out.println(aBoolean1);
    System.out.println(aBoolean2);
  }

  /**
   * 定义两个指针 slow每次前进一步、
   *
   * @param ring
   * @return
   */
  public static Boolean hasRing(Ring ring) {
    Ring slow, fast;
    if (ring == null || (slow = ring.next) == null || (fast = slow.next) == null) {
      return false;
    }
    while (true) {
      if (slow == fast) {
        return true;
      }

      if ((fast = fast.next) == null || ((fast = fast.next) == null)) {
        return false;
      }
      slow = slow.next;
    }
  }


  public static Boolean hasRing1(Ring ring) {
    Ring slow = ring;
    Ring fast = ring;

    while (fast != null && (fast = fast.next) != null) {
      fast = fast.next;
      if ((slow = slow.next) == fast) {
        return true;
      }
    }
    return false;
  }
}


@Data
class Ring {

  Ring next;
}