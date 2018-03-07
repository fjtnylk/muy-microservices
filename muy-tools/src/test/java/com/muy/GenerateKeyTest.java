package com.muy;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.junit.Test;
import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * Created by yanglikai on 2018/3/7.
 */
public class GenerateKeyTest {

  @Test
  public void generateKey() {
    String salt = new String(Hex.encode(KeyGenerators.secureRandom(64).generateKey()));
    System.out.println(salt);
  }

  @Test
  public void passwordEncoder() {
    String secret = KeyGenerators.string().generateKey();
    StandardPasswordEncoder encoder = new StandardPasswordEncoder(secret);
    String result = encoder.encode("yanglikai");
    System.out.println(result);

    boolean isOK = encoder.matches("yanglikai", result);
    System.out.println(isOK);
  }

  @Test
  public void generatePassword() {
    String sha = Sha512DigestUtils.shaHex("yanglikai");
    System.out.println(sha);
    String rawPassword = "yanglikai";
    String salt = KeyGenerators.string().generateKey();
    System.out.println(salt);
  }

  @Test
  public void hashPassword() {
    String rawPassword = generatePassword4Front();
    System.out.println(rawPassword);
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    String hashPassword = bCryptPasswordEncoder.encode(rawPassword);
    System.out.println(hashPassword);
  }

  private String generatePassword4Front() {
    String rawPassword = "yanglikai";
    String hash = Sha512DigestUtils.shaHex(rawPassword);
    String salt = KeyGenerators.string().generateKey();
    return Sha512DigestUtils.shaHex(hash + salt);
  }

  @Test
  public void registerUser() {
    String rawPassword = "yanglikai";
    String hash = Sha512DigestUtils.shaHex(rawPassword);
  }

  @Test
  public void sha256() {
    String result = getSHA256StrJava("yanglikai");
    System.out.println(result);
  }

  public static String getSHA256StrJava(String str){
    MessageDigest messageDigest;
    String encodeStr = "";
    try {
      messageDigest = MessageDigest.getInstance("SHA-256");
      messageDigest.update(str.getBytes("UTF-8"));
      encodeStr = byte2Hex(messageDigest.digest());
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return encodeStr;
  }

  /**
   * 将byte转为16进制
   * @param bytes
   * @return
   */
  private static String byte2Hex(byte[] bytes){
    StringBuffer stringBuffer = new StringBuffer();
    String temp = null;
    for (int i=0;i<bytes.length;i++){
      temp = Integer.toHexString(bytes[i] & 0xFF);
      if (temp.length()==1){
        //1得到一位的进行补0操作
        stringBuffer.append("0");
      }
      stringBuffer.append(temp);
    }
    return stringBuffer.toString();
  }

  private String generateSalt() {
    return new String(Hex.encode(KeyGenerators.secureRandom(64).generateKey()));
  }

  @Test
  public void hash4MD5() {

  }
}
