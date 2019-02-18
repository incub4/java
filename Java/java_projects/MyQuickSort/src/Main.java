import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Main {
    public static void quickSort(int arrey[], int low, int hight) {
        if(arrey.length ==0)
            return; // Завершить если длинна массива равна 0

        if (low >= hight)
            return; // Завершить, если больше нечего делить
        //Выбираем опорный элемент
        int middle = low + (hight - low)/2;
        int opora = arrey[middle];

        //Разделить на подмассивы, которые больше и меньше опорного элемента
        int i = low, j = hight;
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
    public static void main(String[] args) {

    }
}
