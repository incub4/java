import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class QuickSort {

    private static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1; //
        int n2 = r - m;     //

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private static void sort(int arr[], int l, int r) {
        if (l < r) {
            var m = (l+r) / 2;
            sort(arr, l, m);
            sort(arr , m+1, r);
            merge(arr, l, m, r);
        }
    }

    public static class ParallelMergeSort extends RecursiveAction {
        private final int[] array;
        private final int low;
        private final int high;

        public ParallelMergeSort(final int[] array, final int low, final int high) {
            this.array = array;
            this.low = low;
            this.high = high;
        }

        @Override
        protected void compute() {
            if (low < high) {
                var middle = (low + high) / 2;
                var left = new ParallelMergeSort(array, low, middle);
                var right = new ParallelMergeSort(array, middle + 1, high);
                invokeAll(left, right);
                merge(array, low, middle, high);
            }
        }
    }

    public static void parallelSort(int[] arr) //Параллельная сортировка
    {
        var forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() - 1);
        forkJoinPool.invoke(new ParallelMergeSort(arr, 0, arr.length - 1));
    }
}
