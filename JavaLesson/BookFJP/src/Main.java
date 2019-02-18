import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.*;

class SqrtTransform extends RecursiveAction{
    final int seqTreshold = 1000; //final Для переменных примитивного типа это означает, что однажды присвоенное значение не может быть изменено.
    //Для ссылочных переменных это означает, что после присвоения объекта, нельзя изменить ссылку на данный объект. Это важно!
    // Ссылку изменить нельзя, но состояние объекта изменять можно.

    //Значение final поля может быть переопределено с помощью Reflection или JNI. Кроме того, final поля обладают тем свойством,
    // что их настоящее значение гарантированно доступно другим потокам, как только объект данного класса родился.
    // Если поле не final, то другой поток, обратившись к полю рождённого объекта, может увидеть там 0. Это очень важный момент.

    //обратный массив
    double[] data;

    //Определить часть обрабатываемых данных
    int start, end;

    public SqrtTransform(double[] vals, int s, int e) {
        this.data = vals;
        this.start = s;
        this.end = e;
    }

    @Override //Этот метод выполняет параллельное вычисление
    protected void compute() {
        //Если кол-во елементов меньше порогового значения,
        //Выполнять дальнейшую обработку последовательно
        if ((end - start) < seqTreshold) {
            //Преобразовать значение каждого элемента массива
            //В его квадратный корень
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
            //В противном случае продолжить разделение данных на меньшие части

            //найти середину
            int middle = (start + end) / 2;

            //Запустить новые подзадачи на выполнение, используя
            //Разделенные на части данные
            invokeAll(new SqrtTransform(data, start, middle),
                    new SqrtTransform(data, middle, end));
        }


    }
}

//Продемонстрировать параллельное выполнение
public class Main {
    public static void main(String[] args) {
        //создать пул задач
        ForkJoinPool fjp = new ForkJoinPool();

        double[] nums = new double[10000];

        //Присвоить некоторые значения
        for (int i=0; i<nums.length; i++)
            nums[i] = (double) i;
        System.out.println("Часть исходной последовательности");
        for (int i=0; i<10; i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println("\n");

        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);

        //Запустить главную задачу типа ForkJoinTask на выполнение
        fjp.invoke(task);
        System.out.println("Часть преобразованной последовательности (с точностью до 4 знаков после десятичной точки): ");
        for (int i = 0; i<10; i++)
            System.out.format("%.4f ", nums[i]);
        System.out.println();

        /////////////////////////////////////////
        //обычная быстрая сортировка
        QuickSort.StartSort();
    }
}
