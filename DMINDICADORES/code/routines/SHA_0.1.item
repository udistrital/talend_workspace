package routines;

/**
 * Converts a string  value to its md5 equivalent.
 *
 * {talendTypes} String
 *
 * {Category} User defined
 *
 * {param} String(1) text: string  value, String(2) salt: salt value
 *
 * {example} String(1):hola, Sting(2):xxxxx
 *
 */


import java.security.MessageDigest;
import java.math.BigInteger;
public class SHA {

	public static String getMD5HashedText(String text, String salt) {
        String sTH;
        if(text == null) {
            if(salt == null) sTH = "";
            else sTH = salt;
        }
        else {
            if(salt == null) sTH = text;
            else sTH = text + salt;
        }
       
        try {
            MessageDigest md5 = MessageDigest.getInstance("SHA-256");
            md5.update(sTH.getBytes());
            BigInteger hash = new BigInteger(1, md5.digest());
            return hash.toString(16);
        } 
        catch (Exception e) {
            return null;
        }
    }
}
