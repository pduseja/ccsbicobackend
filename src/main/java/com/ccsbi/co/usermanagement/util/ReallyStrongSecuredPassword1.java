package com.ccsbi.co.usermanagement.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

public class ReallyStrongSecuredPassword1 {
	public static void main(String[] args) {

		String decryptPassword = decrypt("u3pK4eFc78L6g3LbTw2aMw==");
		System.out.println("matched : " + decryptPassword);
		String decryptPassword2 = decrypt("0Om/fKeWMdH7Je+9FOtOTg==");
		System.out.println("matched : " + decryptPassword2);
		String decryptPassword3 = decrypt("VmlAdjUclQPBPzTAwe5LWw==");
		System.out.println("matched : " + decryptPassword3);
		String decryptPassword4 = decrypt("1RdlQ5Yg6iUINTLFodWleA==");
		System.out.println("matched : " + decryptPassword4);
	
		String encryptPassword = encrypt("Spd0104@");
		System.out.println("matched : " + encryptPassword);
	}

	private static final String key = "aesEncryptionKey";

	private static final String initVector = "encryptionIntVec";

	public static String encrypt(String value) {

		try {

			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));

			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());

			return Base64.encodeBase64String(encrypted);

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return null;

	}

	public static String decrypt(String encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
}
