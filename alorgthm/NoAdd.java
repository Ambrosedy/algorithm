/**
 * ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 */

public class NoAdd {
    
    public int Sum_Solution(int n) {
        int res=n;
        boolean t = (res!=0) && ((res+=Sum_Solution(n-1))!=0);
        return res;
    }
}