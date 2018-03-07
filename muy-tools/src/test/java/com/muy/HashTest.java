package com.muy;

import com.muy.crypto.hash.Md5DigestUtils;
import com.muy.crypto.hash.Sha256DigestUtils;
import com.muy.crypto.hash.Sha512DigestUtils;
import org.junit.Test;

/**
 * Created by yanglikai on 2018/3/7.
 */
public class HashTest {

  @Test
  public void hash4MD5() {
    String rawText = "yanglikai";
    String hash = Md5DigestUtils.md5Hex(rawText);
    System.out.println(hash);
  }

  @Test
  public void hash4Sha256() {
    String rawText = "yanglikai";
    String hash = Sha256DigestUtils.shaHex(rawText);
    System.out.println(hash);
  }

  @Test
  public void hash4Sha512() {
    String rawText = "yanglikai";
    String hash = Sha512DigestUtils.shaHex(rawText);
    System.out.println(hash);
  }
}
