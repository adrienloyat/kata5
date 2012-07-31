package fr.loyat.kata5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class BloomFilter {

	public int k_hash;
	public int hash_size;
	public int m_size;
	private byte[] vector;
	
	
	public byte[] getVector() {
		return vector;
	}

	public BloomFilter(int k_hash) {
		this.k_hash = k_hash;
		this.hash_size=k_hash*2;
		this.m_size = (int) Math.pow(16,hash_size);
		vector= new byte[m_size];
	}
	
	public void add(String chaine) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA-256");

		byte[] dig = md.digest(chaine.getBytes());
		
		int position = (dig[0]+256)%256;
		System.out.println(position);
		vector[position]=1;
	}

}
