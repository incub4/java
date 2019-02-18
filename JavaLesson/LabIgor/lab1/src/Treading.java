public class Treading {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Runnable() { //Это отделтный поток в который я могу передать на выполнение какую то функцию
            @Override
            public void run() {
                int arr[] = new int[100_000_000];
                for (int i = 0; i < arr.length; i++)
                    arr[i] = i;
                System.out.println("Поток 1");
            }
        });
        thread.start();//Запуск потока

        Thread thread1 = new Thread(new Runnable() { //Это отделтный поток в который я могу передать на выполнение какую то функцию
            @Override
            public void run() {
                System.out.println("Поток 2");
            }
        });
        thread1.start();//Запуск потока

        thread.join(); //Заставляет основной поток ждать пока
        thread1.join();//Не завершатся 2 этих потока, и только после переходит к следующим задачам

        System.out.println("Конец метода main");
        //System.exit(0);
    }
}
