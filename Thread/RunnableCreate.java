import java.lang.Runnable;
/**
 * 实现Runnable方法创建线程
 * 两个线程共用一个task 代码逻辑，如果需要，可以给RunableTask
 * 添加参数进行任务区分。另外， Runab l eTask 可以继承其他类。但是上面介绍的两种方式
 * 都有一个缺点，就是任务没有返回值。
 */
public class RunnableCreate implements Runnable
{
    @Override
   public void run()
   {
      System.out.println("I am a Child!!!");
   }

   public static void main(String[] args) throws InterruptedException{
       //default 构造方法
        RunnableCreate task = new RunnableCreate();
        new Thread(task).start();
        new Thread(task).start();
   }
}