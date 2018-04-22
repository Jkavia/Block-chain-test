package com;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

// Genesis block - pointing to nothing, previous has is null for this one
public class Block {
	// contents of the block
	private String version;
	private Date Timestamp;
	private String hash;
	private String previousHash;
	private String data;
	private String coin;

	// constructor
	public Block(String version, Date timestamp, String data, String coin) {
		this.version = version;
		this.Timestamp = timestamp;
		this.data = data;
		this.hash = computeHash();
		this.coin =coin;
	}

	// SHA-256 Hash function - takes in data and outputs fixed hashcode of 256 bits
	public String computeHash() {

		String dataToHash = "" + this.version + this.Timestamp + this.previousHash + this.data+this.coin;

		MessageDigest digest; //MessageDigest class provides applications the functionality of a message digest algorithm, such as SHA-1 or SHA-256
		String encoded = null;

		try {
			digest = MessageDigest.getInstance("SHA-256"); //Returns a MessageDigest object that implements the specified digest algorithm
			byte[] hash = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8)); 
			//digest function of digest object Performs a final update on the digest using the specified array of bytes, then completes the digest computation
			//getBytes encodes the String dataToHash into sequence of bytes using the specified charset(UTF_8) and returns the array of those bytes
			encoded = Base64.getEncoder().encodeToString(hash);
			//getEncoder returns a Base64.Encoder that encodes using the Basic type base64 encoding scheme.
			//encodeToString Encodes the specified byte array(hash) into a String using the Base64 encoding scheme.
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		this.hash = encoded;
		return encoded;

	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getCoin() {
		return coin;
	}

	public void setCoin(String coin) {
		this.coin = coin;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
