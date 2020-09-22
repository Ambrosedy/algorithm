package thread;

/**
 * @author 汐19990223
 */
public class LocalThreadTest {

    static ThreadLocal<String> localVar = new ThreadLocal<String>();

    static void print(String str){
        //打印当前线程内存中的变量
        System.out.println(str+"："+localVar.get());
        //清除当前线程中变量副本的值
        localVar.remove();
    }

    public static void main(String[] args) {

        localVar.set("Hello World");
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                localVar.set("threadOne's value!");

                print("threadOne");

                System.out.println("threadOne remove localVar :"+localVar.get());
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                localVar.set("threadTwo's value!");

                print("threadTwo");

                System.out.println("threadTwo remove localVar :"+localVar.get());
            }
        });

        th1.start();
        th2.start();
        System.out.println("the value: "+localVar.get());
    }
}
