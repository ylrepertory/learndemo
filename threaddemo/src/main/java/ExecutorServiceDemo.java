import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: learndemo
 * @description: 线程池
 * @author: leo
 * @create: 2019-04-28 17:15
 **/
public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            executorService.submit(new testRunnable(i));
        }
    }
}
class testRunnable implements Runnable{
    private int id=0;

    public testRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("call()方法被自动调用,干活！！！             " + Thread.currentThread().getName());
        for (int i = 999999999; i > 0; i--)
            ;
        System.out.println("call()方法被自动调用，任务的结果是：" + id + "    " + Thread.currentThread().getName()) ;
    }
}
