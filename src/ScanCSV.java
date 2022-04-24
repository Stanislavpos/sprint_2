
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScanCSV {
    private final String[] month = new String[]{"01", "02", "03"}; // номера месяцев
    private static final HashMap<Integer, ArrayList<MonthlyReport>> mapMonthReport = new HashMap<>();
    // создаем хештаблицу
    private static final List<YearlyReport> yearlyReports = new ArrayList<>();
    // список для
    private boolean readYearFile = false;
    private boolean readMonthFile = false;

    public static List<YearlyReport> getList() {
        return yearlyReports;
    }

    public void readYearFile() {
        if (readYearFile) { //проверка
            System.out.println("Годовой отчет уже считан");
            return;
        }
        String address = "resources/y.2021.csv";
        File file = new File(address);
        BufferedReader fileBufferedReader = null;
        try { //
            fileBufferedReader = new BufferedReader(new FileReader(file));
            String fileLine = fileBufferedReader.readLine();

            while ((fileLine = fileBufferedReader.readLine()) != null) { // если строка не пустая
                String[] array = fileLine.split(","); // разделяем значения
                yearlyReports.add(new YearlyReport(Integer.parseInt(array[0]),
                        Integer.parseInt(array[1]), Boolean.parseBoolean(array[2])));
            }
        } catch (IOException e) {
            System.out.println("Не удалось считать годовой отчет");
        } finally {
            if (fileBufferedReader != null) {
                try {
                    fileBufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        readYearFile = true;
        System.out.println("Годовой отчет считан");
    }

    public void readMonthFile() {
        if (readMonthFile) {
            System.out.println("Месячный отчет уже считан ");
            return;
        }
        for (String actualMonth : month) {
            String address = "resources/m.2021" + actualMonth + ".csv"; // подбираем имя файла
            File file = new File(address);
            BufferedReader fileBufferedReader = null;
            try {
                fileBufferedReader = new BufferedReader(new FileReader(file));
                String fileLine = fileBufferedReader.readLine();
                ArrayList<MonthlyReport> monthList = new ArrayList<>();

                // читаем файл по строкам с разделителем, заносим в список
                while ((fileLine = fileBufferedReader.readLine()) != null) {
                    String[] array = fileLine.split(",");
                    monthList.add(new MonthlyReport(array[0], Boolean.parseBoolean(array[1]),
                            Integer.parseInt(array[2]), Integer.parseInt(array[3])));
                }
                mapMonthReport.put(Integer.parseInt(actualMonth), monthList);
            } catch (IOException e) {
                System.out.println("Не удалось считать месячный отчет");
            } finally {
                if (fileBufferedReader != null) {
                    try {
                        fileBufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        readMonthFile = true;
        System.out.println("Месячный отчет считан ");
    }

    public static HashMap<Integer, ArrayList<MonthlyReport>> getMap() {
        return mapMonthReport;
    }
}