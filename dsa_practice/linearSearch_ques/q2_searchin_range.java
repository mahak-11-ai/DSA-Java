package dsa_practice.linearSearch_ques;

public class q2_searchin_range {
    public static void main(String[] args) {
        int[] arr={2,34,1,6,32};
        int target=2;
        System.out.println(search(arr,target,0,3));
    }
    static boolean search(int [] find,int target,int start, int end){
        for(int i=start; i<=end; i++){
            if(find[i]==target){
                return true;
            }
        }
        return false;
    }
    
}
