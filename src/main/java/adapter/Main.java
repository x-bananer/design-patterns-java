package adapter;

public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setYear(2026);
        date.setMonth(11);
        date.setDay(6);

        System.out.println(date.getDay() + "/" + date.getMonth() + "/" + date.getYear());

        date.advanceDays(3);
        System.out.println(date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
    }
}
