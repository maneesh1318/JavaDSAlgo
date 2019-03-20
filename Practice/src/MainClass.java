import com.practice.thread.First;
import com.practice.thread.Second;
import com.practice.thread.Third;

/**
 * Created by Manish Richhariya(manish.richhariya@99acres.com) on 20/4/18.
 */
public class MainClass {
    public static void main(String[] args) {
        /*Thread t1 = new Thread(new First());
        Thread t2 = new Thread(new Second());
        Thread t3 = new Thread(new Third());
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        }catch (InterruptedException ex){
            //do nothing
        }*/
        int arr[] = {1,2,3,0,0,0,0,0,0,1,1,1,1,1,2,1,2,1,6,6,6,9,9,9,7,7,7};
        System.out.println(arr.length);

    }
}


