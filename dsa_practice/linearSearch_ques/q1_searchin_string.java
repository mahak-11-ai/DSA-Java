package dsa_practice.linearSearch_ques;

import java.util.Arrays;

public class q1_searchin_string {
    public static void main(String[] args) {
        String str = "Mahak";
        System.out.println(Arrays.toString(str.toCharArray()));
        char target='k';
        System.out.println(search(str,target));
    }
    static boolean search(String str , char target ){
        // for(int i=0; i<str.length(); i++){
        //     if(target==str.charAt(i)){
        //         return true;
        //     }
        // }
        // for each loop
        for(char ch: str.toCharArray()){
            if(target==ch){
                return true;
            }
        }
        return false;
    }
}
