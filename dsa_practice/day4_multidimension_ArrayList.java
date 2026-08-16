package dsa_practice;
import java.util.ArrayList;
import java.util.Scanner;
public class day4_multidimension_ArrayList{
  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> list=new ArrayList<>(); // created only one list
    // now a list is created but does not have any indices in it i.e. it is not initialised
    //initialise
    System.out.println(list); // one empty list prints
    for(int i=0; i<3;i++){
        list.add(new ArrayList<>());  // created 3 list inside a list
    }
    System.out.println(list); // 3 empty lists inside one list prints
    //input
    Scanner sc= new Scanner(System.in);
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            list.get(i).add(sc.nextInt());
        }
    }
    System.out.println(list);
   }
}