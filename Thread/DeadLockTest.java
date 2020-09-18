
public class DeadLockTest
{
    //资源
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) {
        //线程A
        Thread threadA = new Thread(new Runnable(){
            public void run(){
                synchronized(resourceA){
                    System.out.println(Thread.currentThread()+" get resourceA!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //TODO: handle exception
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+" wait resourceB!!");
                    synchronized(resourceB){
                        System.out.println(Thread.currentThread()+" get resourceB!");
                        
                    }
                    
                }
            }
        });
        //线程B
        // Thread threadB = new Thread(new Runnable(){
        //     public void run(){
        //         synchronized(resourceB){
        //             System.out.println(Thread.currentThread()+" get resourceB!");
        //             try {
        //                 Thread.sleep(1000);
        //             } catch (InterruptedException e) {
        //                 //TODO: handle exception
        //                 e.printStackTrace();
        //             }
        //             System.out.println(Thread.currentThread()+" wait resourceA!!");
        //             synchronized(resourceA){
        //                 System.out.println(Thread.currentThread()+" get resourceA!");
                        
        //             }
                    
        //         }
        //     }
        // });

        //线程B+（资源有序分配避免死锁）
        Thread threadB = new Thread(new Runnable(){
            public void run(){
                synchronized(resourceA){
                    System.out.println(Thread.currentThread()+" get resourceB!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //TODO: handle exception
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+" wait resourceA!!");
                    synchronized(resourceB){
                        System.out.println(Thread.currentThread()+" get resourceA!");
                        
                    }
                    
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
/**
 * result:
 * Thread[Thread-1,5,main] get resourceB!
 * Thread[Thread-0,5,main] get resourceA!
 * Thread[Thread-1,5,main] wait resourceA!!
 * Thread[Thread-0,5,main] wait resourceB!!
 */

 /**
  * result2
  * Thread[Thread-0,5,main] get resourceA!
  * Thread[Thread-0,5,main] wait resourceB!!
  * Thread[Thread-0,5,main] get resourceB!
  * Thread[Thread-1,5,main] get resourceB!
  * Thread[Thread-1,5,main] wait resourceA!!
  * Thread[Thread-1,5,main] get resourceA!
  */