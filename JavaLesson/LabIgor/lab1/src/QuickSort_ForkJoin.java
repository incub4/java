import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.RecursiveAction;

public class QuickSort_ForkJoin extends RecursiveAction {
    int start, end;
    public static int a[];

    public QuickSort_ForkJoin(int p, int r) {
        this.start = p;
        this.end = r;
        compute();
    }
    public static int[] loadArray(String filename) throws Exception{
        Scanner s = new Scanner(new FileInputStream(filename));
        int n = s.nextInt();
        int[] b = new int[n];
        for (int i=0; i<n; i++)
            b[i] = s.nextInt();
        return b;
    }

    public static void storeArray(int a[], String filename) throws Exception {
        PrintWriter pw = new PrintWriter(new FileOutputStream(filename));
        int n = a.length;
        pw.println();

        for (int i=0; i<n; i++){
            pw.print(a[i]);
            pw.print(" ");
        }
        pw.close();
    }

    public void InsertionSort(int[] list, int start, int end) {
        for (int x = start +1; x<end; x++){
            int val = list[x];
            int j = x-1;
            while (j >= 0 && val < list[j]) {
                list[j+1] = list[j];
                j--;
            }
            list[j+1] = val;
        }
    }
    public static int partitition(int p, int r){
        int i = p-1;
        for (int j=p; j<r; j++){
            if (a[j] <= a[r]){
                i++;
                int t=a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i+1];
        a[i+1] = a[r];
        a[r] = t;
        return i+1;
    }

    @Override
    protected void compute() {
        int TRESHOLD=4;
        if (start < end){
            if ((end-start)<TRESHOLD){
                this.InsertionSort(a,start,end+1);
            }else {
                int part = partitition(start,end);
                QuickSort_ForkJoin q1 = new QuickSort_ForkJoin(0, part -1);
                q1.fork();
                QuickSort_ForkJoin q2 = new QuickSort_ForkJoin(part+1, end);
                q2.fork();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        long t1 = System.currentTimeMillis();

        a = loadArray("a.txt");
        QuickSort_ForkJoin q = new QuickSort_ForkJoin(0, a.length-1);
        storeArray(a,"QFJ.txt");

        long t2 = System.currentTimeMillis();
        System.out.println("time for sequential merge sort is: " + (t2-t1));
    }
}
