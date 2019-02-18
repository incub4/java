/*
Пример Многопоточночти из книги (Руководстводля начинающих)
Это первый пример из этой книги
*/

//Создание потока путем реализации интерфейса Runnable
class MyThread implements Runnable {
    //String ThrdName;
    Thread newThread;

    public MyThread(String name) {
        newThread = new Thread(this, name);
        newThread.start();
    }
    @Override // Точка вход в поток
    public void run() {
        System.out.println(newThread.getName() + " - Запуск");
        try {
            for (int count = 0; count <10; count++) {
                Thread.sleep(400);
                System.out.println("В " + newThread.getName() + ", счетчик: " + count);
            }
        }
        catch (InterruptedException exc){
            System.out.println(newThread.getName() + " - Прерван");
        }
        System.out.println(newThread.getName() + "Завершение");
    }
}
public class UseThread  {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Запуск основного потока: ");

        MyThread mt = new MyThread("child # 1");

        for (int i = 0; i<50; i++){
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

