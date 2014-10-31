package com.group10.sparkysbank.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.x509.X509V1CertificateGenerator;


public class PKIService {

	public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, Exception {

		Date startDate = new Date();              // time from which certificate is valid
		Date expiryDate =new Date();       // time after which certificate is not valid
		BigInteger serialNumber =  BigInteger.valueOf(System.currentTimeMillis());     // serial number for certificate
		KeyPairGenerator keygen=KeyPairGenerator.getInstance("RSA");
		KeyPair pair = keygen.generateKeyPair();
		
		X509V1CertificateGenerator certGen = new X509V1CertificateGenerator();
		X500Principal dnName = new X500Principal("CN=Test CA Certificate");
		certGen.setSerialNumber(serialNumber);
		certGen.setIssuerDN(dnName);
		certGen.setNotBefore(startDate);
		certGen.setNotAfter(expiryDate);
		certGen.setSubjectDN(dnName);                       // note: same as issuer
		certGen.setPublicKey(pair.getPublic());
		certGen.setSignatureAlgorithm("SHA1withRSA");;
		X509Certificate cert = certGen.generate(pair.getPrivate());
		
		cert.verify(pair.getPublic());
		System.out.println(displayHex(pair.getPublic().getEncoded()));
		System.out.println(displayHex(pair.getPrivate().getEncoded()));
		
		FileOutputStream cos = new FileOutputStream("test.cer");
		cos.write(cert.getEncoded());
		
		KeyStore ks1 = KeyStore.getInstance("pkcs12");   
		char[] password = "123456".toCharArray();
		ks1.load(null,null);
		System.out.println();
		ks1.setKeyEntry("test", pair.getPrivate(), password, new Certificate[]{cert,cert});
		FileOutputStream fos = new FileOutputStream("keystore.pfx");
		ks1.store(fos, password);
		fos.close();
		
KeyStore ks2=KeyStore.getInstance("pkcs12");
		
		FileInputStream fis3 =new FileInputStream("keystore.pfx");
		ks2.load(fis3, "123456".toCharArray());
		Enumeration<String> strs =  ks2.aliases();
		String astr = strs.nextElement();
		Key ke = ks2.getKey(astr, "123456".toCharArray()); 
		PrivateKey privateKey = (PrivateKey)ke;
		byte[] prikeyB = privateKey.getEncoded();

		
		System.out.println("my private key");
		System.out.println(displayHex(prikeyB));


	}
	public static String displayHex(byte[] bytesKey)
	{
		String str = new String();
		for(byte b : bytesKey)
			str+=String.format("%02X ",b);
		return str;
	}
}
