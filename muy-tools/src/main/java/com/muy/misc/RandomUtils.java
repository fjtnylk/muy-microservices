package com.muy.misc;

import com.muy.GlobalConstants;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanglikai on 2018/3/8.
 */
public final class RandomUtils {
  private RandomUtils() {
  }

  public static Set<Integer> generateRandoms() {
    return generateRandoms(GlobalConstants.RANDOM_MAX, GlobalConstants.RANDOM_LENGTH);
  }

  public static Set<Integer> generateRandoms(int length) {
    return generateRandoms(GlobalConstants.RANDOM_MAX, length);
  }

  public static Set<Integer> generateRandoms(int size, int length) {
    Set<Integer> randoms = new HashSet<>();

    int bound = calcBound(length);
    while (randoms.size() < size) {
      int r = (int) ((Math.random() * 9 + 1) * bound);

      if (randoms.contains(r)) {
        continue;
      }

      randoms.add(r);
    }

    return randoms;
  }

  private static Integer calcBound(int length) {
    String bound = "1";
    for (int i = 0; i < length - 1; i++) {
      bound = bound.concat("0");
    }

    return Integer.valueOf(bound);
  }
}
