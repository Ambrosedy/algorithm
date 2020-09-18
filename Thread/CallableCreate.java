import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ExecutionException;
/**
 * 实现Callable方法创建线程
 * 实现了Callable 接口的call（）方法。在main 函数内首先创
 * 建了一个Futrue Task 对象（ 构造函数为CallerTask 的实例） ， 然后使用创建的FutrueTask
 * 对象作为任务创建了一个线程并且启动它， 最后通过fu归reTask.get（） 等待任务执行完毕并返回结果。
 */
public class CallableCreate implements Callable<String> 
{
    @Override
    public String call()throws Exception
    {
      return "hello world ,I am a child prcesson";
    }

   public static void main(String[] args) throws InterruptedException{
       //创建异步任务
       FutureTask<String> futuretask = new FutureTask<String>(new CallableCreate());

       //启动线程
       new Thread(futuretask).start();

       try {
           //等待任务执行完毕并返回结果
           String res = futuretask.get();
           System.out.println(res);
       } catch (ExecutionException e) {
           //TODO: handle exception
           e.printStackTrace();
       }
   }
}