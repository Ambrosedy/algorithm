/**
 * 题目：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。n<=39
 * 来源：牛客网
 */


public class Feibo {
    public int Fibonacci(int n) {
        //F(0) = 0,F(1) = 1;
        //从0开始，往后加，保留两个指针，分别指向F(n-1)和F(n)
        //g是F(1),f是F(0)
        int f = 0,g=1;
        for(int i=0;i<n;i++){
            g += f;//g变为F(2)
            f = g-f;//F(2)-F(0) = F(1)[第一次循环]
        }
        return f;
    }
}