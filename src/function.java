import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class function {

    car car2 = new car();

    public  void info(){
        fileGet();

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Все машины");
        System.out.println();
        for (int i =0;i<car2.getCarArray().length;i++) {
            if(car2.getCarArray()[i]!=null)
                System.out.println(i+1 + ") "+car2.getCarArray()[i]);
        }
        System.out.println();
        System.out.println("Назад(0)");
        System.out.println("Номер машины для просмотра");
        System.out.print("Введите номер меню - ");
        int menu1 = sc.nextInt();
        sout();
        switch (menu1){
            case 0: {

            }break;
            default: {
                if(car2.getCarArray()[menu1-1]==null){
                    System.out.println();
                    System.out.println("Ошибка машина не существует");
                    System.out.println();
                    break;
                }
                System.out.println("Марка машины - " + car2.getMarka(menu1));
                System.out.println("Модель машины - " + car2.getModel(menu1));
                System.out.println("Цвет машины - " + car2.getColor(menu1));

                String carColor = sc.nextLine();
                String carColor1 = sc.nextLine();
                sout();
            }
        }

    }
    public  void sout(){
        System.out.println();System.out.println();System.out.println();System.out.println();
        System.out.println();System.out.println();System.out.println();System.out.println();
    }

    public   void add() {
        fileGet();

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Добавление машины");
        System.out.println();

        System.out.print("Введите модель машины - ");
        car2.setModel(sc.nextLine());

        System.out.print("Введите марку машины - ");
        car2.setMarka(sc.nextLine());

        System.out.print("Введите цвет машины - ");
        car2.setColor(sc.nextLine());

        for (int i = 0; i < car2.getCarArray().length; i++) {
            if (car2.getCarArray()[i] == null) {
                String[] carTest = new String[1000];
                carTest=car2.getCarArray();
                carTest[i]=car2.getModel() + ";" + car2.getMarka() + ";" + car2.getColor();
                car2.setCarArray(carTest);
                fileSave();
                sout();
                break;
            }
        }
    }
    public  void change(){
        fileGet();

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Изменение машины");
        System.out.println();
        for (int i =0;i<car2.getCarArray().length;i++) {
            if(car2.getCarArray()[i]!=null)
                System.out.println(i+1 + ") "+car2.getCarArray()[i]);
        }
        System.out.print("Введите номер для изменения - ");
        int change = sc.nextInt();

        if(car2.getCarArray()[change-1]==null){
            System.out.println();
            System.out.println("Ошибка машина не существует");
            System.out.println();
        }else {
        System.out.println();
        System.out.println();
        System.out.println("Марка машины(1)");
        System.out.println("Модель машины(2)");
        System.out.println("Цвет(3)");
        System.out.println("Назад(4)");
        System.out.print("Введите номер характеристики машины - ");
        int changeCharacter = sc.nextInt();

        switch (changeCharacter){
            case 1: {
                System.out.print("Введите новую марку - ");
                car2.setModel(sc.nextLine());
                car2.setModel(sc.nextLine());
                String[] words = car2.getCarArray()[change-1].split(";");
                car2.setMarka(words[1]);
                car2.setColor(words[2]);
                break;
            }
            case 2: {
                System.out.print("Введите новую модель - ");
                car2.setMarka(sc.nextLine());
                car2.setMarka(sc.nextLine());
                String[] words = car2.getCarArray()[change-1].split(";");
                car2.setModel(words[0]);
                car2.setColor(words[2]);
                break;
            }
            case 3: {
                System.out.print("Введите новую цвет - ");
                car2.setColor(sc.nextLine());
                car2.setColor(sc.nextLine());
                String[] words = car2.getCarArray()[change-1].split(";");
                car2.setModel(words[0]);
                car2.setMarka(words[1]);
                break;
            }
            case 4: {
                break;
            }
            default: break;
        }

        car2.getCarArray()[change-1]=car2.getModel()+";"+car2.getMarka()+";"+car2.getColor();
        fileSave();
        }
    }

    public  void delete(){
        fileGet();
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Удаление машины");
        System.out.println();
        for (int i =0;i<car2.getCarArray().length;i++) {
            if(car2.getCarArray()[i]!=null)
                System.out.println(i+1 + ") "+car2.getCarArray()[i]);
        }
        System.out.print("Введите номер для удаления - ");
        int delete = sc.nextInt();
        if(car2.getCarArray()[delete-1]==null){
            System.out.println();
            System.out.println("Ошибка машина не существует");
            System.out.println();
        }else {
        car2.getCarArray()[delete-1]=null;
        sout();
        for(int i =0;i<car2.getCarArray().length;i++){
            int j=i+1;
            if(car2.getCarArray()[i]==null&&car2.getCarArray()[j]!=null){
                car2.getCarArray()[i]=car2.getCarArray()[j];
                car2.getCarArray()[j]=null;
            }
            if(car2.getCarArray()[i]==null&&car2.getCarArray()[j]==null){
                fileSave();
                break;
            }
        }
        }
    }

    public  void fileGet(){
        String[] carArray=new String[1000];
        try {
            Scanner scr = new Scanner(new File("C:\\Users\\artem\\Desktop\\lab3.txt"));
            int fg=0;
            while(scr.hasNext()){
                carArray[fg]=scr.nextLine();
                fg++;
            }
        }catch (Exception e){
        }
        car2.setCarArray(carArray);
    }

    public  void fileSave(){
        try(FileWriter writer = new FileWriter("C:\\Users\\artem\\Desktop\\lab3.txt", false))
        {

            writer.write("");
            for(int j=0;j<car2.getCarArray().length;j++){
                if(car2.getCarArray()[j]==null){
                    break;
                }
                writer.append(car2.getCarArray()[j]);
                writer.append('\n');
            }
        }
        catch(IOException ex){
            Scanner sc = new Scanner(System.in);

            System.out.println(ex.getMessage());
            sc.nextInt();
        }
    }
    public  void find(){
        fileGet();
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Поиск по цвету машины");
        System.out.println();
        System.out.print("Введите цвет для поиска - ");
        String change = sc.nextLine();
        for (int i =0;i<car2.getCarArray().length;i++) {
            String[] words={};
            if(car2.getCarArray()[i]!=null)
            {
                words = car2.getCarArray()[i].split(";");
            }
            if(car2.getCarArray()[i]!=null&& words[2].equals(change))
            {
                System.out.println(i+1 + ") "+car2.getCarArray()[i]);
            }
        }
    }
}
