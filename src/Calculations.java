import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculations {
    private final List<YearlyReport> yearlyReports = ScanCSV.getList();
    private final Map<Integer, ArrayList<MonthlyReport>> mapMonthReport = ScanCSV.getMap();
    private final Map<Integer, String> mapMonth = fillMap();


    // ищем прибыльные и убыточные товары за итерацию
    public void infoMonth() {
        if (checkListAndMap()) {
            System.out.println("Файлы еще не считаны");
            return;
        }
        String nameIncome = "";
        String nameBadIncome = "";
        int monthIncome ;
        for (Map.Entry<Integer, ArrayList<MonthlyReport>> e : mapMonthReport.entrySet()) {
            monthIncome = e.getKey();
            int sumIncome = 0;
            int sumBadIncome = 0;
            for (int i = 0; i < e.getValue().size(); i++) {
                MonthlyReport month = e.getValue().get(i);
                int sum = month.getQuantity() * month.getSumOfOne();
                if (!month.expenseOrIncome() && sum > sumIncome) {
                    sumIncome = sum;
                    nameIncome = month.getItemName();
                } else if (month.expenseOrIncome() && sum > sumBadIncome) {
                    sumBadIncome = sum;
                    nameBadIncome = month.getItemName();
                }
            }
            System.out.println(mapMonth.get(monthIncome));
            System.out.println("Cамый прибыльный товар " + sumIncome + " " + nameIncome);
            System.out.println("Cамый убыточный товар  " + sumBadIncome + " " + nameBadIncome);
        }
    }

    public boolean checkListAndMap() {
        return yearlyReports.isEmpty() || mapMonthReport.isEmpty();
    }

    public void infoYear() {
        if (checkListAndMap()) {
            System.out.println("Файлы еще не считаны");
            return;
        }
        int income = 0;
        int incomeSum = 0;
        int badIncome = 0;
        int badIncomeSum = 0;
        int count = 0;
        for (YearlyReport y : yearlyReports) {
            if (y.isIsExpense()) {
                badIncome += y.getAmount();
                badIncomeSum += y.getAmount();
            } else {
                income += y.getAmount();
                incomeSum += y.getAmount();
            }
            count++;
            if (count == 2) {
                count = 0;
                System.out.println("Доход за месяц " + mapMonth.get(y.getMonth()) + " " +
                        (income - badIncome));
                income = 0;
                badIncome = 0;
            }
        }
        System.out.println("Средний  расход " + badIncomeSum / (yearlyReports.size() / 2));
        System.out.println("Средний  доход " + incomeSum / (yearlyReports.size() / 2));
    }

    public void compareReports() {
        if (checkListAndMap()) {
            System.out.println("Файлы еще не считаны");
            return;
        }
        Calculations calculations = new Calculations();
        for (Map.Entry<Integer, ArrayList<MonthlyReport>> e : mapMonthReport.entrySet()) {
            int income = 0;
            int badIncome = 0;
            for (int i = 0; i < e.getValue().size(); i++) {
                MonthlyReport monthlyReport = e.getValue().get(i);
                int count = monthlyReport.getSumOfOne() * monthlyReport.getQuantity();
                if (monthlyReport.expenseOrIncome()) {
                    badIncome += count;
                } else {
                    income += count;
                }
            }
            int sum = income - badIncome;
            if (calculations.getSumFromMonth(e.getKey()) != sum) {
                System.err.println("Ошибка в отчете за " + mapMonth.get(e.getKey()) + " месяц ");
                return;
            }
        }
        System.out.println("Отчет верный!");
    }

    private int getSumFromMonth(int i) {
        int sumIn = 0;
        int sumBad = 0;
        for (YearlyReport report : yearlyReports) {
            if (report.getMonth() == i && report.isIsExpense()) {
                sumBad += report.getAmount();
            } else if (report.getMonth() == i && !report.isIsExpense()) {
                sumIn += report.getAmount();
            }
        }
        return sumIn - sumBad;
    }

    private Map<Integer, String> fillMap() {
        Map<Integer, String> monthMap = new HashMap<>();
        monthMap.put(1, "Январь");
        monthMap.put(2, "Февраль");
        monthMap.put(3, "Март");
        monthMap.put(4, "Апрель");
        monthMap.put(5, "Май");
        monthMap.put(6, "Июнь");
        monthMap.put(7, "Июль");
        monthMap.put(8, "Август");
        monthMap.put(9, "Сентябрь");
        monthMap.put(10, "Октябрь");
        monthMap.put(11, "Ноябрь");
        monthMap.put(12, "Декабрь");
        return monthMap;
    }

}