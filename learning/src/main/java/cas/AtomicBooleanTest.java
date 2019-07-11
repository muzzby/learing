package src.main.java.cas;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author byway
 */
public class AtomicBooleanTest implements Runnable{
    private static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) {
        AtomicBooleanTest ast = new AtomicBooleanTest();
        Thread t1 = new Thread(ast);
//        Thread t2 = new Thread(ast);
        t1.start();
//        t2.start();
    }
    @Override
    public void run() {
        System.out.println("thread: "+Thread.currentThread().getName()+";flag: "+flag.get());
        //api解释：如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值。
        if (flag.compareAndSet(true,false)){
            System.out.println(Thread.currentThread().getName()+" "+flag.get());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag.set(true);
        }else{
            System.out.println("重试机制thread:"+Thread.currentThread().getName()+";flag:"+flag.get());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            run();
        }

    }
}
