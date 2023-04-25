import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList <Integer> applyFunction (ArrayList <Integer> numbers, Function x){
        ArrayList <Integer> newNumbers = new ArrayList<>();
        for (int i = 0; i<numbers.size();i++){
            newNumbers.add(x.evaluate((Integer) numbers.get(i)));
        }
        return newNumbers;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название функции из списка (Half, Double, Exact, Square) и несколько целых чисел через пробел: ");
        String n = in.nextLine();  // через аргументы командной строки передаются названия элементов
        String[] words = n.split("\\s+"); // разбиваем на массив отдельных слов

        if (n.equals("")) System.out.println("Не передано название операции");
        else {
            ArrayList<Integer> numbers = new ArrayList<Integer>();   // создаем массив для хранения введенных чисел
            String operand = words[0];   // первое слово в списке обозначаем функцию
            Function x = null;
            String res = "OK";
            switch (operand) {
                case "Half":
                    x = new Half();
                    res = "OK";
                    break;
                case "Double":
                    x = new Double();
                    res = "OK";
                    break;
                case "Exact":
                    x = new Exact();
                    res = "OK";
                    break;
                case "Square":
                    x = new Square();
                    res = "OK";
                    break;
                default:
                    res = "Close";
                    break;
            }
            if (res == "OK") {
                for (int i = 1; i < words.length; i++) {   // заполняем массив введенными числами
                    int y = Integer.parseInt(words[i]);
                    numbers.add(y);
                }
                if (numbers.isEmpty()) System.out.println("Не переданы числа для операции");
                else {
                    System.out.println(numbers);
                    ArrayList newNumbers = applyFunction(numbers, (Function) x);
                    System.out.println(newNumbers);
                }
            }
            else System.out.println("Операция " + operand + " не поддерживается");
        }
    }
}