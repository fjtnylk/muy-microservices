package com.muy.crypto.encryptor;

import com.muy.crypto.hash.Md5DigestUtils;
import com.muy.crypto.hash.Sha256DigestUtils;
import com.muy.crypto.hash.Sha512DigestUtils;
import com.muy.crypto.hash.SlowEqualsUtils;
import com.muy.crypto.keygen.KeyGeneratorUtils;

/**
 * Created by yanglikai on 2018/3/7.
 */
public final class EncryptorsUtils {
  private EncryptorsUtils() {
  }

  public static String md5(String target) {
    return Md5DigestUtils.md5Hex(target);
  }

  public static String sha256(String target) {
    return Sha256DigestUtils.shaHex(target);
  }

  public static String sha512(String target) {
    return Sha512DigestUtils.shaHex(target);
  }

  public static boolean slowEquals(String arg1, String arg2) {
    return SlowEqualsUtils.slowEquals(arg1.getBytes(), arg2.getBytes());
  }

  public static String generateKey() {
    return KeyGeneratorUtils.generateKey();
  }
}
