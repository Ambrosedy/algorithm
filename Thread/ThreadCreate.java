import java.lang.Thread;
/**
 * 使用继承Thread创建线程
 * 优点：在run（） 方法内获取当前线程直接使用this 就可以了，无须使用Thread. currentThread（） 方法；
 * 缺点：Java 不支持多继承，如果继承了Thread 类，那么就不能再继承其他类。另外任务与代码没有分离， 
 *       当多个线程执行一样的任务时需要多份任务代码，而Runable 则没有这个限制。
 */
public class ThreadCreate extends Thread
{
   @Override
   public void run()
   {
      System.out.println("I am a Child!!!");
   }

   public static void main(String[] args) {
      
      ThreadCreate tc  = new ThreadCreate();
      tc.start();
   }
}