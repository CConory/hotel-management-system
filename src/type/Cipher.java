package type;

public class Cipher {	
	public String Encrypt(String code) {
		String encrypt="";
		
		for(int i=0;i<code.length();i++) {
			int tmp=code.charAt(i);
			tmp=(tmp+5)%128;
			encrypt+=((char)tmp);
		}
		
		return encrypt;
	}
	public String Decode(String code) {
		String decode="";
		
		for(int i=0;i<code.length();i++) {
			int tmp=code.charAt(i);
			tmp=(tmp-5)%128;
			decode+=((char)tmp);
		}
		
		return decode;
	}
}
