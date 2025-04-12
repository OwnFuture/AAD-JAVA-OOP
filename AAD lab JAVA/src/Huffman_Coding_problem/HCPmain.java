package Huffman_Coding_problem;

import java.util.PriorityQueue;

public class HCPmain {
    static int count=0;

    public static void main(String[] args) {
        int n=4;
        char[] c={'c','a','b','d'};
        int[] data={23,45,30,50};

        PriorityQueue<huffmanNode> q=new PriorityQueue<huffmanNode>(n,new HCPcomparator());

        for(int i=0;i<n;i++){
            huffmanNode hn=new huffmanNode();
            hn.c=c[i];
            hn.data=data[i];
            hn.left=null;
            hn.right=null;

            q.add(hn);
        }

        huffmanNode root=null;

        while(q.size()>1){
            huffmanNode x=q.poll();
            huffmanNode y=q.poll();

            huffmanNode f=new huffmanNode();
            f.data=x.data+y.data;
            f.c='-';
            f.left=x;
            f.right=y;

            root=f;
            q.add(root);
        }
        int total=root.data*8;
        System.out.println("The original length: "+total);

        print(root,"",c,data);

        System.out.println("The compression length :"+count);
        System.out.println("The compression percentage :"+((double)(total-count)/total)*100+"%");
    }

    private static void print(huffmanNode root, String s, char[] c, int[] data) {
        // TODO Auto-generated method stub
        
        if(root.left==null && root.right==null && Character.isLetter(root.c)){
            System.out.println(root.c+" : "+s);

            int fre=0;
            for(int i=0;i<c.length;i++){
                if(c[i]==root.c){
                    fre=data[i];
                    break;
                }
            }
            count+=fre*s.length();
            return;
        }

        print(root.left,s+"0",c,data);
        print(root.right,s+"1",c,data);
    }
}
