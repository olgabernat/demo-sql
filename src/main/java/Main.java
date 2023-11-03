import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Utils.delete();
        Utils.insert(1, "Peter", "1234", 0);
        Utils.insert(2, "Ivan", "12345", 1);
        Utils.insert(3, "Dan", "12347", 0);
        Utils.insert(4, "Sam", "12349", 0);
        Utils.insert(5, "Fil", "12342", 0);
        Utils.selectAll();
        Utils.delete1User(1);
        Utils.update(5, "Nina", "123");
    }
}


//        for (int i = 1; i <= 5; i++) {
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.print("Введите ID: ");
//            int id = scanner.nextInt();
//
//            System.out.print("Введите имя: ");
//            String name = scanner.next();
//
//            System.out.print("Введите пароль: ");
//            String password = scanner.next();
//
//            System.out.print("Введите IsAdmin (1 или 0): ");
//            int isAdmin = scanner.nextInt();
//
//            Utils.insert(id, name, password, isAdmin);
//        }