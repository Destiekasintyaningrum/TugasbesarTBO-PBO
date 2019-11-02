package com.example.root.myapplication;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Aes {
  /*  String kunci="0000000000000000";
    byte[] key=kunci.getBytes();*/
    String iv="0000000000000000";
    byte[] ivk=iv.getBytes();

    public static final byte[] encBytes(byte[] srcBytes, byte[] key,
                                        byte[] newIv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec iv = new IvParameterSpec(newIv);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(srcBytes);
        return encrypted;
    }

    public String encText(String sSrc, byte[] key, byte[] newIv)
            throws Exception {
        byte[] srcBytes = sSrc.getBytes("utf-8");
        byte[] encrypted = encBytes(srcBytes, key, newIv);
        return Base64.encodeToString(encrypted, Base64.DEFAULT);
    }

    public static final byte[] decBytes(byte[] srcBytes, byte[] key,
                                        byte[] newIv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec iv = new IvParameterSpec(newIv);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(srcBytes);
        return encrypted;
    }

    public String decText(String sSrc, byte[] key, byte[] newIv)
            throws Exception {
        byte[] srcBytes = Base64.decode(sSrc, Base64.DEFAULT);
        byte[] decrypted = decBytes(srcBytes, key, newIv);
        return new String(decrypted, "utf-8");
    }

   /* public static void main(String[] args) {
        String s = "password";
       // byte[] key = { 1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6 };
        String kunci="ujicobaenkripsi1";
        byte[] key=kunci.getBytes();
        String iv="ujicobaenkripsi1";
        byte[] ivk=iv.getBytes();
      //  byte[] ivk = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        try {
            String enc = encText(s, key, ivk);
            System.out.println(enc);
            String dec = decText(enc, key, ivk);
            System.out.println(dec);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
}