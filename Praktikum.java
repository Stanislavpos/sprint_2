import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Praktikum {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

          ScanCSV scanCSV = new ScanCSV();


        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {

                  scanCSV.montsScanCSVproba();

//
            } else if (command == 2) {
                  scanCSV.yearScanCSV();
//
            } else if (command == 3) {
                  scanCSV.sumOfReports(scanCSV.yearScanCSV(), scanCSV.montsScanCSVproba());
//                System.out.println("Введите размер траты:");
//                double expense = scanner.nextDouble();
//                System.out.println("К какой категории относится трата?");
//                String category = scanner.next();
//                moneyBeforeSalary = expensesManager.saveExpense(moneyBeforeSalary, category, expense);
//            } else if (command == 4) {
//                expensesManager.printAllExpensesByCategories();
//            } else if (command == 5) {
//                System.out.println("В какой категории искать?");
//                String category = scanner.next();
//                System.out.println("Самая большая трата в категории " + category + " составила "
//                        + expensesManager.findMaxExpenseInCategory(category) + " руб.");
//            } else if (command == 6) {
//                expensesManager.removeAllExpenses();
//            } else if (command == 7){
//                // Допишите остальные пункты меню
//                System.out.println("Всего потрачено: " + expensesManager.getExpensesSum());
//            } else if (command == 8) {
//                System.out.println("Какую категорию вы хотите удалить?");
//                String category = scanner.next();
//                expensesManager.removeCategory(category);
//            } else if (command == 9) {
//                System.out.println("В категории " + expensesManager.getMaxCategoryName() + " вы потратили больше всего.");
            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");

    }
}