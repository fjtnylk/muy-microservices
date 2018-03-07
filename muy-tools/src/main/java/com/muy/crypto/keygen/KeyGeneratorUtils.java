package com.muy.crypto.keygen;

import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.keygen.KeyGenerators;

/**
 * Created by yanglikai on 2018/3/7.
 */
public final class KeyGeneratorUtils {
  private KeyGeneratorUtils() {
  }

  public static String generateKey() {
    return generateKey(32);
  }

  public static String generateKey(int keyLength) {
    return
        new String(Hex.encode(KeyGenerators.secureRandom(keyLength).generateKey()));
  }
}
