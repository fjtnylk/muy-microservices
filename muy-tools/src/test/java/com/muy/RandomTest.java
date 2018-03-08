package com.muy;

import com.muy.misc.RandomUtils;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * Created by yanglikai on 2018/3/8.
 */
public class RandomTest {
  @Test
  public void generateRandoms() {
    long start = System.currentTimeMillis();

    Set<Integer> randoms = RandomUtils.generateRandoms(500000, 6);
    //Set<Integer> randoms = generate();

    long end = System.currentTimeMillis();
    long diff = end - start;

    System.out.println(diff / 1000 + " ms");
    System.out.println(randoms.size());
    System.out.println(isValid(randoms));
    //System.out.println(randoms);
  }

  private boolean isValid(Set<Integer> target) {
    for (Integer integer : target) {
      String r = String.valueOf(integer);
      if (r.length() != 6) {
        return false;
      }
    }

    return true;
  }

  private Set<Integer> generate() {
    Set<Integer> randoms = new HashSet<>();

    for(int j = 0; j< 1000000; j++){
      randoms.add((int)((Math.random()*9+1)*100000));
    }

    return randoms;
  }
}
