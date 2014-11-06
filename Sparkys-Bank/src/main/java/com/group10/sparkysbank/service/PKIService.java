package com.group10.sparkysbank.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.x509.X509V1CertificateGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group10.sparkysbank.dao.UserPKIDAO;

@Service("pkiService")
public class PKIService {

	@Autowired
	UserPKIDAO userPKIDAO;
	

	public void generateKeyPairAndToken(String username) throws Exception{
	
		
		Date startDate = new Date();              // time from which certificate is valid
		Date expiryDate =new Date();       // time after which certificate is not valid
		BigInteger serialNumber =  BigInteger.valueOf(System.currentTimeMillis());     // serial number for certificate
		KeyPairGenerator keygen=KeyPairGenerator.getInstance("RSA");
		SecureRandom sr =SecureRandom.getInstance("SHA1PRNG", "SUN");
		keygen.initialize(2048, sr);
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
		FileOutputStream cos = new FileOutputStream(username+".cer");
		cos.write(cert.getEncoded());
		
		KeyStore ks = KeyStore.getInstance("pkcs12");   
		char[] password = "123456".toCharArray();
		ks.load(null,null);
		System.out.println();
		ks.setKeyEntry("test", pair.getPrivate(), password, new Certificate[]{cert,cert});
		FileOutputStream fos = new FileOutputStream(username+".pfx");
		ks.store(fos, password);
		fos.close();
		userPKIDAO.storePublicKeyAndToken(username, pair.getPublic().getEncoded(), "asdasdadadasd");
		
	}
	
	public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, Exception {
		PKIService pki=new PKIService();
		pki.generateKeyPairAndToken("harry");
		


	}
	public static String displayHex(byte[] bytesKey)
	{
		String str = new String();
		for(byte b : bytesKey)
			str+=String.format("%02X ",b);
		return str;
	}
}
