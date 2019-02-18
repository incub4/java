import java.util.concurrent.RecursiveTask;
//Комментарий
public class MyFork extends RecursiveTask<Long> { // Fork - развилка


    long from, to, numOfOperations, numOfThreads; // Значения "от" и "до".


    public MyFork(long from, long to) {
        this.from = from;
        this.to = to;
        this.numOfThreads = Runtime.getRuntime().availableProcessors();
        this.numOfOperations = 10_000_000_000L;
    }

    @Override
    protected Long compute() {

        if (to-from<=numOfOperations/numOfThreads)
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