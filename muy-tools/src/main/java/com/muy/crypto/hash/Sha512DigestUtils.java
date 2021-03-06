package com.muy.crypto.hash;

import com.muy.crypto.codec.Hex;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yanglikai on 2018/3/7.
 */
public final class Sha512DigestUtils {
  private Sha512DigestUtils() {
  }

  private static MessageDigest getSha512Digest() {
    try {
      return MessageDigest.getInstance("SHA-512");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public static byte[] sha(byte[] data) {
    return getSha512Digest().digest(data);
  }

  public static byte[] sha(String data) {
    return sha(data.getBytes());
  }

  public static String shaHex(byte[] data) {
    return new String(Hex.encode(sha(data)));
  }

  public static String shaHex(String data) {
    return new String(Hex.encode(sha(data)));
  }
}
