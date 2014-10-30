/*package com.group10.sparkysbank.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class PKIService {

	public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		
		KeyPairGenerator gen=KeyPairGenerator.getInstance("RSA");
		KeyPair pair=gen.generateKeyPair();
		CertificateFactory cFactory =CertificateFactory.getInstance("X509");
		//create a stream for raghu's certificate
		FileInputStream fis1=new FileInputStream("Raghupub.cer");
		
		X509Certificate xc=(X509Certificate) cFactory.generateCertificate(fis1);
		PublicKey pubKey = xc.getPublicKey();
		xc.
		byte[] bytepKey = pubKey.getEncoded();
		System.out.println("Raghu's PUBLIC KEY\n"+displayHex(bytepKey)+"\n");
		
		
		System.out.println(pair.getPublic().getEncoded().toString());
		System.out.println(pair.getPrivate().getEncoded().toString());
		
		String strCom = "keytool -genkeypair -dname \"cn=Mark Jones, ou=Java, o=Oracle, c=US\" -alias test -keypass 123456 -keystore my_keystore_2.jks -storepass 123456 -validity 180";
    	
		Process p = Runtime.getRuntime().exec(strCom);
		
		KeyStore ks=KeyStore.getInstance("JKS");
		
		java.io.FileInputStream fis = null; 
		fis = new java.io.FileInputStream("C:/Users/hthakkar/Documents/projf/SSProject_SparkyBankingSystem/Sparkys-Bank/my_keystore_2.jks"); 
				 ks.load(fis, "123456".toCharArray()); 
				 
				 Enumeration aliasList = ks.aliases(); 
				 
					//delete entry
					 while(aliasList.hasMoreElements()) {
						 System.out.println("Inside delete:");
						 //ks.deleteEntry(aliasList.nextElement().toString());
						 aliasList.nextElement();
						 }
						System.out.println(ks.containsAlias("test"));
						
						FileOutputStream cos = new FileOutputStream("C:/Users/hthakkar/Documents/projf/SSProject_SparkyBankingSystem/Sparkys-Bank/samCert.cer");
						 //Key pvt = ks.getKey("SBSG2", "123456".toCharArray());
						 Certificate pub = ks.getCertificate("test");
						 cos.write(pub.getEncoded());
						 FileInputStream fis1=new FileInputStream("samCert.cer");
						 CertificateFactory cFactory =CertificateFactory.getInstance("X509");
						// FileInputStream fis1=new FileInputStream("Raghupub.cer");
							
							X509Certificate xc=(X509Certificate) cFactory.generateCertificate(fis1);
							PublicKey pubKey = xc.getPublicKey();
							
							byte[] bytepKey = pubKey.getEncoded();
							System.out.println("Raghu's PUBLIC KEY\n"+displayHex(bytepKey)+"\n");
							
							 KeyPair pair = generateRSAKeyPair();
							    X509Certificate cert = generateV3Certificate(pair); 
							    KeyStore ks = KeyStore.getInstance("PKCS12", "BC");   
							    char[] password = "abc".toCharArray();
							    ks.load(null,null);
							    ks.setCertificateEntry(cert.getSerialNumber().toString(), cert);
							    ks.setKeyEntry(cert.getSerialNumber().toString(), pair.getPrivate(), password, new Certificate[]{cert,cert});
							    FileOutputStream fos = new FileOutputStream("keystore.pfx");
							    ks.store(fos, password);
							    fos.close();
							
							
	}
	public static String displayHex(byte[] bytesKey)
	{
		String str = new String();
		for(byte b : bytesKey)
			str+=String.format("%02X ",b);
		return str;
	}
}
*/