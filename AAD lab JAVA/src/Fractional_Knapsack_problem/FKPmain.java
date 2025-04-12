package Fractional_Knapsack_problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FKPmain {
    public static void main(String[] args) {
        ArrayList<itemValues> list=new ArrayList<itemValues>();

        int n;
        System.out.println("Enter the size of the array: ");

        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){
            itemValues item=new itemValues();
            System.out.print("Enter the name of the object "+(i+1)+" : ");
            item.setItem(sc.nextLine());

            System.out.print("Enter the profit of "+item.getItem()+" : ");
            item.setProfit(sc.nextDouble());

            System.out.print("Enter the weight of "+item.getItem()+" : ");
            item.setWeight(sc.nextDouble());

            sc.nextLine();
            list.add(item);
        }

        Collections.sort(list,new FKPcomparator());
        select(list);
    }

    private static void select(ArrayList<itemValues> list) {
        // TODO Auto-generated method stub
       double capacity;
       System.out.println("Enter the capacity of the knapsack: ");

       Scanner s=new Scanner(System.in);
       capacity=s.nextDouble();

       double profit=0;

       for(itemValues i: list){
        if(capacity==0){
            break;
        }
        if(capacity>=i.getWeight()){
            capacity=capacity-i.getWeight();
            profit=profit+i.getProfit();
        }
        else{
            profit=profit+(i.getProfit()*capacity)/i.getWeight();
            capacity=0;
        }

        System.out.println(i);
       }

       System.out.println("Total profit: "+profit);
    }
}
