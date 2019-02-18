class MyThread implements Runnable{
    String thtdName;

    MyThread(String name){
        thtdName = name;
    }
    //Точка входа в поток
    @Override
    public void run() {
        System.out.println(thtdName + " -  Запуск");
        try {
            for (int count = 0; count <10; count++)
            {
                Thread.sleep(400);
                System.out.println("B " + thtdName + ", счетчик: " + count);
            }
        }
        catch (InterruptedException exc){ //Отлавливает слип
            System.out.println(thtdName + " - Прерван");
        }
        System.out.println(thtdName + " - Завершение");
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("Запуск основного потока.");

        //Сначало создадим объект типа MyThread
        MyThread mt = new MyThread("Child №1");

        //Затем сформировать поток на основе этого объекта
        Thread newThrd = new Thread(mt);

        //Начинаем выполнение потока
        newThrd.start();

        for (int i = 0; i < 50; i++)
        {
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException exc){
                System.out.println("Прерывание основного потока");
            }
        }
        System.out.println("Завершение основного потока");


    }
}
