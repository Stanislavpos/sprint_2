
//package ru.yandex.practicum;

import java.util.Scanner;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
//    private static final String QA2_ABSOLUTE_PATH =
//            "C:\\Users\\Victor\\IdeaProjects\\praktikum\\src\\ru\\yandex\\practicum\\QA2.java";

//    private static final String QA2_RELATIVE_PATH =
//            "resources/QA2.java";
//    for (int i=0; i <= 3 ; i++)
//    {
//        List<String> lines = readAllLines("resources/m.20210" + i + ".csv");
//    }
// Read file in loop
//        List<String> fileLinesMonts = null;
//        for (int i = 1; i <= 3; i++) {
//            fileLinesMonts = readAllLines(String.format(
//                    "resources/m.20210" + i + ".csv", i));
//            System.out.println(fileLinesMonts);
//        }
//
//        String[] csvLines;
//        csvLines = fileLinesMonts.split(System.lineSeparator());
//        System.out.println("Array of lines: " + Arrays.toString(csvLines));
//
//        String csvLine = csvLines[1];
//        System.out.println("First line: " + csvLine);
//
//        String values[] = csvLine.split(",");
//        System.out.println("First line values: " + Arrays.toString(values));


        List<String> fileLinesYears = readAllLines(String.format(
                "resources/y.2021.csv"));
        System.out.println(fileLinesYears);
        ArrayList<Integer> listIncome = new ArrayList<>(); //создаем список доходов
        ArrayList<Integer> listExpenditure = new ArrayList<>(); //создаем список расходов

        for (int i = 1; i < fileLinesYears.size(); i++) {
            String[] lineArray = fileLinesYears.get(i).split(","); //делим строку списка fileLinesYears
            if ( lineArray [i] != null) {

                if (!Boolean.parseBoolean(lineArray[2])) { //проверяем, в строке значение дохода (false) или расхода (true)
                    listIncome.add(Integer.parseInt(lineArray[1])); //добавляем значение в список доходов
                } else {
                    listExpenditure.add(Integer.parseInt(lineArray[1])); //добавляем значение в список расходов
                }
            }
            else {

            }
        }
        for (int i = 0; i < listIncome.size(); i++) {
            YearlyObject yearlyObject = new YearlyObject(listIncome.get(i), listExpenditure.get(i)); //создаем объект класса YearlyObject(доход за месяц, расход за месяц)
            tableYear.put(i + 1, yearlyObject); //заполняем HashMap
        }

//    public static void main(String[] args) throws IOException {

//        Save reports to lists
//        ArrayList<MonthReport> monthReports = new ArrayList<>();

//        Read file to oneline
//        String content = readFileContentsOrNull(QA2_RELATIVE_PATH);
//        System.out.println(content);

//        Read file to List
//        List<String> lines = readAllLines(QA2_RELATIVE_PATH);
/*        for (String line : lines) {
            System.out.println(line);
        }*/

// Read all files in directory
//        List<Path> filePaths = Files.list(Paths.get("resources")).toList();
//        for (Path path : filePaths) {
//            String file = readFileContentsOrNull(path);
//            System.out.println(file);
//        }


//
//
//        String csvExample = "Victor,Bodrov,1994\r\nIvan,Ivanov,2000";
//        System.out.println("CSV:");
//        System.out.println(csvExample);
//        System.out.println();
//
//        String[] csvLines = csvExample.split(System.lineSeparator());
//        System.out.println("Array of lines: " + Arrays.toString(csvLines));
//
//        String csvLine = csvLines[1];
//        System.out.println("First line: " + csvLine);
//
//        String values[] = csvLine.split(",");
//        System.out.println("First line values: " + Arrays.toString(values));
//
//        String firstName = values[0];
//        System.out.println("First Name: " + firstName);
//
//        String lastName = values[1];
//        System.out.println("Last Name: " + lastName);
//
//        int yearOfBirth = Integer.parseInt(values[2]);
//        System.out.println("Year Of Birth: " + yearOfBirth);
//
//        String s = "Hello";
//        SoftReference<String> sr = new SoftReference<>("Hello2");
//        WeakReference<String> wr = new WeakReference<>("Hello2");
//        WeakHashMap<Integer, String> weakMap = new WeakHashMap<>();
    }


//
//    private static String readFileContentsOrNull(String path) {
//        try {
//            return Files.readString(Path.of(path));
//        } catch (IOException e) {
//            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
//            return null;
//        }
//    }
//
//    private static String readFileContentsOrNull(Path path) {
//        try {
//            return Files.readString(path);
//        } catch (IOException e) {
//            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
//            return null;
//        }
//    }
//
    private static List<String> readAllLines(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }
}













//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        StepTracker stepTracker = new StepTracker(scanner);
//        printMenu();
//        int userInput = scanner.nextInt();
//
//        while (userInput != 0) {
//            if (userInput == 1) {
//                stepTracker.stepsPerDay();
//
//            } else if (userInput == 2) {
//                stepTracker.outputStatisticResult();
//
//            } else if (userInput == 3) {
//                StepTracker.enteringSteps();
//
//            } else if (userInput == 4) {
//                System.out.println("Выход");
//                break;
//            } else {
//                System.out.println("Извините, такой команды пока нет.");
//            }
//
//            printMenu(); // печатем меню ещё раз перед завершением предыдущего действия
//            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
//        }
//        System.out.println("Программа завершена");
//    }
//
//    private static void printMenu() {
//        System.out.println("Что вы хотите сделать? ");
//        System.out.println("1 - Ввести количество шагов за определённый день");
//        System.out.println("2 - Напечатать статистику за определённый месяц");
//        System.out.println("3 - Изменить цель по количеству шагов в день");
//        System.out.println("4 - Выйти из приложения");
//    }
//}
//
//
//
//




