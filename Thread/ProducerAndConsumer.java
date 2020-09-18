
public class ProducerAndConsumer
{
    private static volatile Object resourceA = new Object();
    
    public static void main(String[] args) throws InterruptedException{
        //创建线程
        Thread threadA = new Thread(new Runnable(){
            public void run(){
                //获取监视器锁
                synchronized(resourceA){
                    System.out.println("ThreadA get the resourceA lock");
                    try {
                        System.out.println("threadA begin wait");
                        resourceA.wait();
                        System.out.println("threadA end wait");

                    } catch (Exception e) {
                        //TODO: handle exception
                        e.printStackTrace();
                    }
                }
            }
        });

        //创建线程
        Thread threadB = new Thread(new Runnable(){
            public void run(){
                //获取监视器锁
                synchronized(resourceA){
                    System.out.println("threadB get the resourceA lock");
                    try {
                        System.out.println("threadB begin wait");
                        resourceA.wait();
                        System.out.println("threadB end wait");

                    } catch (Exception e) {
                        //TODO: handle exception
                        e.printStackTrace();
                    }
                }
            }
        });

        //创建线程
        Thread threadC = new Thread(new Runnable(){
            public void run(){
                //获取监视器锁
                synchronized(resourceA){
                    System.out.println("ThreadC begin notify");
                    // resourceA.notify();
                    /**输出如下 */
                    // ThreadA get the resourceA lock
                    // threadA begin wait
                    // threadB get the resourceA lock
                    // threadB begin wait
                    // ThreadC begin notify
                    // threadA end wait
                    resourceA.notifyAll();
                    /**
                     * 结果如下
                     * ThreadA get the resourceA lock
                     * threadA begin wait
                     * threadB get the resourceA lock
                     * threadB begin wait
                     * ThreadC begin notify
                     * threadB end wait
                     * threadA end wait
                     * over
                     */
                }
            }
        });


        threadA.start();
        threadB.start();
        //目的是让线程A 和线程B 全部执行到调用wa it 方法后再调用线程C的notify 方法
        Thread.sleep(1000);
        threadC.start();

        //等待线程结束
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("over");
        
    }

}