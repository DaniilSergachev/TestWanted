package by.DaniilSergachev;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        FirstTask submission = new FirstTask();
        Date nextDate = submission.getNextSubmissionDate();
        System.out.println(nextDate);

        System.out.println(SecondTask.convertDouble(99999.99));
    }
}