package fr.loyat.kata5;

import java.nio.charset.Charset;
import java.security.MessageDigest;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestBloomFilterTest {
/*
 * SHA-256 = 32 octets;
 * la taille du filtre est un expostant de 16
 * 
 * 
 */
	 
	@Test
	public void testAdd() throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		 
		
		BloomFilter filtre = new BloomFilter(1);
		String mot = "salut";
		System.out.println(mot.getBytes());
		byte[] dig = md.digest(mot.getBytes());
		printBytes(dig,"dig");
		filtre.add(mot);
		Assert.assertEquals(filtre.getVector()[0xec],1);
		
		
	}

	public static void printBytes(byte[] array, String name) {
	    for (int k = 0; k < array.length; k++) {
	        System.out.println(name + "[" + k + "] = " + "0x" +
	            UnicodeFormatter.byteToHex(array[k]));
	    }
	}
}
