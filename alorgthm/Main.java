/**
 * ��Ŀ����Ϊһ���ִ����ˣ��н������㶩����һ������n����ɫ������ִ�����ÿ������Ҫô��ɫ��ҪôͿ����������ɫ��Ϊ��ʹ�ִ���ɫ�ʿ���������ô����������Ҫ���ִ��ϵ�����һ����ɫ����������ɫ����������������m���������������һ�Σ�ע�������ִ���һ�����Σ����ִ��ϵ���ɫһ����c�֡����ڰ�˳ʱ���������n��������ִ��ϣ�ÿ������������������ɫ�ֱ�����Щ�������жϸ��ִ����ж�������ɫ������Ҫ�󡣼�ѯ���ж�������ɫ����������m�������г������������Ρ�
 * ��Դ��
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
                //�˴��ӵ�k�������
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
            //���ھ���
            for(int i=0;i<len1-1;i++)
            {
                int dis1 = xpos.get(key).get(i+1)-xpos.get(key).get(i);
                //�����ǻ��Σ���������n/2,�˴�������λ�ã�λ�ò�mod n/2�Ǿ���
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