import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


public class Main {

//    public static void ПодсчетJ() {
//        System.out.println(new Date());
//        long j=0;
//        for (long i = 0; i < numOfOperations; i++) {
//            j+=i;
//        }
//        System.out.println("j=" + j);
//        System.out.println(new Date());
//    }


    static long numOfOperations = 10_000_000_000L;
    static int numOfThreads = Runtime.getRuntime().availableProcessors();//Колличество потоков; available - имеется в наличии

    public static void main(String[] args)throws Exception {
        //ПодсчетJ();
        System.out.println(new Date());
        ForkJoinPool pool = new ForkJoinPool();//Пулл потоков, позволяет разделять операции на части

        System.out.println(pool.invoke(new MyFork(0, numOfOperations)));
        System.out.println(new Date());
        //pool.invoke(new MyFork(0, numOfOperations)); //Принимает класс, который будет выполнять всю работу; invoke - призывать, взывать.

    }


}
public class MyFork extends RecursiveTask<Long> { // Fork - развилка



    long from, to; // Значения "от" и "до".

    long numOfOperationss;
    int numOfThreadss;
    public MyFork(long from, long to) {
        this.from = from;
        this.to = to;
        numOfOperationss = 10_000_000_000L;
        numOfThreadss = Runtime.getRuntime().availableProcessors();//Колличество потоков; available - имеется в наличии
    }

    @Override
    protected Long compute() {

        if (to-from<=numOfOperationss/numOfThreadss)
        {
            long j=0;
            for (long i = 0; i<to; i++)
                j+=i;
            return j;
        } else { //Здесь разбитие на мелкие части
            long middle = (to+from)/2;
            MyFork firstHalf = new MyFork(from, middle); //Первая половина
            firstHalf.fork(); //Разветвляем
            MyFork secondHalf = new MyFork(middle+1, to);//Вторая половинка
            long secondValue = secondHalf.compute();
            return firstHalf.join() + secondValue;
        }
    }
}
