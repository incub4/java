import java.util.Date;
import java.util.concurrent.ForkJoinPool;



public class Main {

    public static void ПодсчетJ() {
        System.out.println(new Date());
        long j=0;
        for (long i = 0; i < 10_000_000_000L; i++) {
            j+=i;
        }
        System.out.println("j=" + j);
        System.out.println(new Date());
    }


    //static long numOfOperations = 10_000_000_000L;
   // static int numOfThreads = Runtime.getRuntime().availableProcessors();//Колличество потоков; available - имеется в наличии

    public static void main(String[] args)throws Exception {
        long numOfOperations = 10_000_000_000L;
        int numOfThreads = Runtime.getRuntime().availableProcessors();//Колличество потоков; available - имеется в наличии
        ПодсчетJ();
        long zero =0;
        MyFork myFork = new MyFork(zero, numOfOperations);
        System.out.println(new Date());
        ForkJoinPool pool = new ForkJoinPool();//Пулл потоков, позволяет разделять операции на части

        System.out.println(pool.invoke(myFork));
        System.out.println(new Date());
        //pool.invoke(new MyFork(0, numOfOperations)); //Принимает класс, который будет выполнять всю работу; invoke - призывать, взывать.

    }


}

