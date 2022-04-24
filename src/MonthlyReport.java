public class MonthlyReport {
    private final String itemName;
    private final boolean isExpense;
    private final int quantity;
    private final int sum;

    public MonthlyReport(String item_name, boolean isExpense, int quantity, int sum) {
        this.itemName = item_name;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sum = sum;
    }

    public String getItemName() {
        return itemName;
    }

    public boolean expenseOrIncome() {
        return isExpense;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "MonthlyReport{" +
                "item_name='" + itemName + '\'' +
                ", is_expense=" + isExpense +
                ", quantity=" + quantity +
                ", sumOfOne=" + sum +
                '}';
    }
}
