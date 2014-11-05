package com.group10.sparkysbank.dao;

public interface UserPKIDAO {

	public void storePublicKeyAndToken(String username,byte[] publicKey, String token);
}
