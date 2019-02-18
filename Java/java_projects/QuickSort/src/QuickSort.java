/*
1. Выбрать опорный элемент из массива. Обычным опорным элементом является средний элемент.
2. Разделить массив на 2 подмассив: элементы меньше опорного и элементы больше опорного.
3. Рекурсивно применить сортировк к двум подмассивам
 */
/*
Разработать алгоритм параллельной сортировки массива.
       1. С использованием Fork-Join Pool
       2. C использованием произвольного пула потоков, но минимизировать
*/

import jdk.dynalink.beans.StaticClass;

import java.util.Arrays;
import java.math.*;
import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


public class QuickSort {

    public static void quickSort(int arrey[], int low, int hight) {
        if(arrey.length ==0)
            return; // Завершить если длинна массива равна 0

        if (low >= hight)
            return; // Завершить, если больше нечего делить

        //Выбираем опорный элемент
        int middle = low + (hight - low)/2;
        int opora = arrey[middle];

        //Разделить на подмассивы, которые больше и меньше опорного элемента
        int i = low, j = hight; //Меньше, Больше
        while (arrey[i] < opora){
            i++;
        }
        while (arrey[j] > opora){
            j--;
        }
        if (i <=j) { //Меняем местами
            int temp = arrey[i];
            arrey[i] = arrey[j];
            arrey[j] = temp;
            i++;
            j--;
        }
        //Вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(arrey, low, j);
        if (hight<i)
            quickSort(arrey, i, hight);
    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        if (a & b & c & d)//Если все тру то не тру
            return false;
        else if (a & b & c) return false;//Если 3 из 4 тру
        else if (a & b & d) return false;
        else if (a & d & c) return false;
        else if (b & c & d) return false;
        else if (a & b) return true;
        else if (a & c) return true;
        else if (a & d) return true;
        else if (b&c) return true;
        else if (b&d) return true;
        else if (c&d) return true;

         return false;

        //
    }       // возвращает true только если 2 из 4 х переменных true

    public static int leapYearCount(int year) {
        year = (year / 4) - (year/100)+(year/400);
        return year;
    } //Вычисляет кол-во высокосных годов по введенному году

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs((a + b) - c) < 0.0001;
    }





    static int numOfThread = Runtime.getRuntime().availableProcessors(); //количество ядер процессора
    static long numOfOperation = 10_000_000_000L;

    public static void main(String[] args)throws Exception    {
        System.out.println(new Date());
//        ForkJoinPool pool = new ForkJoinPool(numOfThread);
//        pool.invoke(new MyFork());
        long j =0;
        for (long i = 0; j <numOfOperation; i++){
            j+=i;
        }
        System.out.println("j: " + j);
        System.out.println(new Date());


        /*
        int arrey[] = {10, 3, 2, 4, 6, 5, 7, 9, 8, 1}; // Рабочая быстрая сортировка
        System.out.print("Было: ");
        System.out.println(Arrays.toString(arrey));

        int low =0;
        int hight = arrey.length-1;

        quickSort(arrey,low,hight); //Мой массив,
        System.out.print("Стало: ");
        System.out.println(Arrays.toString(arrey));

        */
//        //Находим опорный элемент
//        int middle = (arrey.length/2);
//        System.out.println("middle = " + middle);
//
//        //Ищем размеры для 2 массивов
//        int k=0, l=0; //Ищем размеры для 2 массивов
//        for (int i = 0; i<arrey.length; i++){ // Все что меньше опорного
//            if (arrey[i]<arrey[middle]) // Меньше
//                k++;
//            else if (arrey[i]>arrey[middle]) //Больше
//                l++;
//        }
//
//        int one[] = new int[k]; // Массив с эоементами меньше опорного
//        int two[] = new int[l]; // Массив с элементами больше опорного
//
//        //Распределяем все элементы на 2 соответствующих массива
//        for (int i = 0, b = 0, m = 0; i<arrey.length; i++){
//            if (arrey[i]<arrey[middle]) {
//                one[b] = arrey[i];
//                b++;
//            }
//            else if (arrey[i]>arrey[middle]){
//                two[m] = arrey[i];
//                m++;
//            }
//        }
//        MyClass.arreyPrint("Arrey: ", arrey );

    }

//    static  class MyFork extends RecursiveTask<Long> {
//        @Override
//        protected Long compute() {
//            if (){
//
//            }
//                else{
//
//            }
//        }
//    }
}
