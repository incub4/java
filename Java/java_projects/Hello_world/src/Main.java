import java.util.Scanner;
//Scanner - так и будет "Сканер"

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Hello World!");

        Scanner in = new Scanner(System.in); // создаем экземпляр класса Сканер
        float число = in.nextFloat();

        System.out.println("мое число: " + число );
        if (число==1){
            System.out.println("немедленный конец");
        System.exit(-1);
        }
        else {System.out.println("Конец");
        }
    }
}

