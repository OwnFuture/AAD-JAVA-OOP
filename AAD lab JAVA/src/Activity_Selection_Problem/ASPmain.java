package Activity_Selection_Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ASPmain {
    public static void main(String[] args) {
        ArrayList<activityselectionproblem> list=new ArrayList<activityselectionproblem>();

        int n;
        System.out.println("Enter the size of the array: ");

        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){
            activityselectionproblem activity=new activityselectionproblem();

            System.out.print("Enter the name for activity "+(i+1)+" : ");
            activity.setItem(sc.nextLine());

            System.out.print("Enter the start time for "+activity.getItem()+" : ");
            activity.setStart(sc.nextInt());

            System.out.print("Enter the finish time for "+activity.getItem()+" : ");
            activity.setFinish(sc.nextInt());
            sc.nextLine();

            list.add(activity);
        }

        Collections.sort(list,new ASPcomparator());
        check(list);
    }

    private static void check(ArrayList<activityselectionproblem> list) {
        // TODO Auto-generated method stub
        int last=-1;

        for(activityselectionproblem problem : list){
            if(problem.getStart()>=last){
                System.out.println(problem.getItem());

                last=problem.getFinish();
            }
        }
    }
   
}
