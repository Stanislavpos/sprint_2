import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ScanCSV scanCSV = new ScanCSV(); //
        Calculations calculations = new Calculations();  //
        Scanner scanner = new Scanner(System.in);  //
        while (true) {
            printInfo();  //
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    scanCSV.readMonthFile();
//                    scanCSV.readMonthFileproba();
                    break;
                case 2:
                    scanCSV.readYearFile();
                    break;
                case 3:
                    calculations.compareReports();
                    break;
                case 4:
                    calculations.infoMonth();
                    break;
                case 5:
                    calculations.infoYear();
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                    System.out.println("Выход");
                    break;

                default:
                    System.out.println("Не верная команда");
                    break;
            }
        }
    }
    private static void printInfo() {
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}