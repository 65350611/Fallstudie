package wwi.fallstudie.gui.utilities;

import java.util.Arrays;

public final class Comparator {
    private Comparator(){
    }
    public static boolean compatePasswords(char[] pw1, char[] pw2){
       if(pw1.length > 0 && pw2.length > 0){
           return Arrays.equals(pw1, pw2);
       } else {
           return false;
       }
    }
}
