package util;

/**
 *
 * @author Jesus Diaz
 */
public class StringUtil {
    
    public static String repeat(String str, int times) {
        String result = "";
        
        if (times < 0)
            throw new IllegalArgumentException("Negatives times not allowed");
        
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }
    
    public static boolean isEmpty(String str){
        return str == null || str.trim().length() == 0;
    }
}
