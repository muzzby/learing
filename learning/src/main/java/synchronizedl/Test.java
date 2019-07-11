package synchronizedl;

/**
 * @author byway
 */
public class Test extends Thread{
    @Override
    public void run() {
        writeSomething();
    }
    public synchronized void writeSomething(){
        for (int i=0; i<10; i++){
            System.out.print(i+" ");
        }
    }
}

