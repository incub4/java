/*
Пример Многопоточночти из книги (Руководстводля начинающих)
Это Второй пример из этой книги
*/
class MyThread2 extends Thread {
    //String ThrdName;


    public MyThread2(String name) {
        this.setName(name);
    }
    @Override // Точка вход в поток
    public void run() {
        System.out.println(this.getName() + " - Запуск");
        try {
            for (int count = 0; count <10; count++) {
                Thread.sleep(400);
                System.out.println("В " + this.getName() + ", счетчик: " + count);
            }
        }
        catch (InterruptedException exc){
            System.out.println(this.getName() + " - Прерван");
        }
        System.out.println(this.getName() + "Завершение");
    }
}
public class ExtendThread  {
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

