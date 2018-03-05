package com.muy.misc;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yanglikai on 2018/3/1.
 */
public final class TimeUtils {
  private static final String FORMAT_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

  private TimeUtils() {
  }

  public static String formatTime(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYYMMDDHHMMSS);
    return sdf.format(date);
  }

  public static String formatTime(Date date, String pattern) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    return sdf.format(date);
  }
}
