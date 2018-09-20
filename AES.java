import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class AESImplementation {

	public static void main(String[] args) 
      {		
		long starttime = System.nanoTime();
		byte[] plainText = new byte[] {'A','B','C','D','E','F','G','H'};    // 128  bit block
		AESImplementation a = new AESImplementation();             
		KeyGenerator kgen = KeyGenerator.getInstance("AES");               // Generate key for AES Algorithm
	        kgen.init(128);                                                    // Defines length of the key 
	        SecretKey ky = kgen.generateKey();
		byte [] ciphertext = a.encryptAES_ECB(plainText,ky);
		byte[] textAfterDecryption = a.decryptAES_ECB(ciphertext, ky);     // Call to Decryption Function
        	System.out.println(new String(textAfterDecryption));
        	System.out.println(ciphertext);

    
	}



      	 public byte[] encryptAES_ECB(byte [] plaintext, SecretKey ky)
       {
		 Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, ky);
	        byte[] ciphertext = cipher.doFinal(plaintext);
		 
		    return ciphertext;
		 
	 }
	
	 public byte[] decryptAES_ECB(byte [] ciphertext, SecretKey ky) 
       {
		 Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		 cipher.init(Cipher.DECRYPT_MODE, ky);
		 byte[] decValue = cipher.doFinal(ciphertext);
		 return decValue;
	 }
