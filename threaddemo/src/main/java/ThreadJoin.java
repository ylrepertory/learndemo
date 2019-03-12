import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: learndemo
 * @description: 线程join 指定的线程加入到当前线程
 *              比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
 * @author: leo
 * @create: 2019-01-10 17:13
 **/
public class ThreadJoin {

    private static void join() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running1");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("running1 over");
            }
        }) ;
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("running2 over");
            }
        }) ;
        long base = System.currentTimeMillis();
        t1.start();
        t2.start();

        //等待线程1终止
        t1.join();

        //等待线程2终止
        t2.join();
        System.out.println("main over"+(System.currentTimeMillis() - base));
    }

    public static void main(String[] args) throws InterruptedException {
       join();
    }
}
