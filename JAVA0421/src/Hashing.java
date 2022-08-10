import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {

	public static void main(String[] args) {
		hashing("SHA-256", "admin123");
	}

	private static void hashing(String algorithm, String data) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			
			md.update(data.getBytes());
			
			byte[] byteData = md.digest();
			
			String str = "";
			
//			for(int i = 0; i < byteData.length; i++) {}
			
			for(byte b : byteData) {
				str += Integer.toHexString(b & 0xFF).toUpperCase();
			}
			
			System.out.println(str);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("알고리즘 없음");
		}
	}

}








