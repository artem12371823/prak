import javax.swing.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
    function function = new function();
    car car = new car();
    Scanner sc = new Scanner(System.in);
        for(;;) {
            try {
                Boolean exit=false;
                System.out.println();
                System.out.println("Просмотр машины(1)");
                System.out.println("Добавление машины(2)");
                System.out.println("Удаление машины(3)");
                System.out.println("Изменение машины(4)");
                System.out.println("Поиск машины по цвету(5)");
                System.out.println("Выход(6)");
                System.out.print("Введите номер меню - ");
                String menu = sc.nextLine();
                System.out.println();System.out.println();System.out.println();System.out.println();
                System.out.println();System.out.println();System.out.println();System.out.println();

                switch (menu){
                    case "1": {
                        function.info();
                        break;
                    }
                    case "2": {
                        function.add();
                        break;
                    }
                    case "3": {
                        function.delete();
                        break;
                    }
                    case "4": {
                        function.change();
                        break;
                    }
                    case "5": {
                        function.find();
                        break;
                    }
                    case "6": {
                        exit=true;
                        break;
                    }
                }
                if(exit){
                    break;
                }
            }catch (Exception e){
                System.out.println("Введены некорретные данные " + e.getMessage());
            }

        }

}

}

