/**
 * 题目：作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，要么涂了若干种颜色。为了使手串的色彩看起来不那么单调，金主要求，手串上的任意一种颜色（不包含无色），在任意连续的m个串珠里至多出现一次（注意这里手串是一个环形）。手串上的颜色一共有c种。现在按顺时针序告诉你n个串珠的手串上，每个串珠用所包含的颜色分别有哪些。请你判断该手串上有多少种颜色不符合要求。即询问有多少种颜色在任意连续m个串珠中出现了至少两次。
 * 来源：
 */

import java.util.*;

public class Main
{
    public Main(){}
    
    public int getNum(){
        Scanner sc = new Scanner(System.in);
        //number
        int n = sc.nextInt();
        //limit
        int m = sc.nextInt();
        //color
        int c = sc.nextInt();
        Map<Integer,ArrayList<Integer>> xpos = new HashMap<Integer,ArrayList<Integer>>();
        for(int i=1;i<=c;i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            xpos.put(i,list);
        }
        
        int k=1;
        while(k<=n&&sc.hasNextInt())
        {
            
            int colorNum = sc.nextInt();
            for(int i=0;i<colorNum;i++){
                int x = sc.nextInt();
                //此处加的k是有序的
                xpos.get(x).add(k);
              
            }
            
            k++;
        }
        
        int res=0;
        for(int key:xpos.keySet())
        {
            int len1 = xpos.get(key).size();
            if(len1==0)continue;
            int min_dis = -1;
            //相邻距离
            for(int i=0;i<len1-1;i++)
            {
                int dis1 = xpos.get(key).get(i+1)-xpos.get(key).get(i);
                //手链是环形，最大距离是n/2,此处所得是位置，位置差mod n/2是距离
                if(min_dis==-1){
                    min_dis = dis1;
                }else if(dis1<min_dis){
                    min_dis = dis1;
                }
            }
            if(min_dis!=-1&&min_dis%(n/2)<m){
                res++;
            }
        }
        return res;
    }
    
    public static void main(String[] a)
    {
        Main m = new Main();
        int res = m.getNum();
        System.out.println(res);
    }
}