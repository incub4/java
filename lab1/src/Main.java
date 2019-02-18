
import com.sun.jdi.ArrayReference;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Main {
    //Обычная быстрая сортировка
    static boolean[] isThread = new boolean[]{false, false};

    public static void quickSort(int[] array, int low, int high) {
        // Задаем условие продолжения рекурсии
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // 1. Выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // 2. Разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
    /////////////////////////////////////////////////////////////////////////////

    //метод main()
    public static void main(String[] args)
    {
        // Первая лаба

//        for (int i=0; i<array.length; i++) {
//            array2[i] = array[i];
//        }

        //System.out.println(Arrays.toString(array));    // Вывод результата
        int[] arr = {1,5,2,3,5,6,3,2,5,7};// Тестовые данные

        int[] array = new int[1_000_000];

        Random generator = new Random();
        for (int i=0; i<array.length; i++) {
            array[i] = generator.nextInt(1_000_000);
        }
        int[] array2 =(int[])array.clone();

        //Многопоточная сортировка
        long t1 = System.currentTimeMillis();
        lab1.parallelSort(array);                             // Сортировка
        long t2 = System.currentTimeMillis();
        System.out.println("ParallelSort speed: " + (t2-t1));

        //Обычная сортировка
        long t11 = System.currentTimeMillis();
        quickSort(array2, 0, (array2.length-1));                             // Сортировка
        long t22 = System.currentTimeMillis();
        System.out.println("QuickSort speed: " + (t22-t11));

        //Разница в времени
        System.out.println("Разница: " + ((t2-t1)-(t22-t11)));

    }
}