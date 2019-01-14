import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: learndemo
 * @description: 线程池
 * @author: leo
 * @create: 2019-01-10 14:52
 **/
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
//        executorService.submit();
//        executorService.execute();
    }
}
