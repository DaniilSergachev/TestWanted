package by.DaniilSergachev;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class FirstTask {

    private static final Set<Date> holidays = new HashSet<>();

    static {
        holidays.add(Date.valueOf("2024-01-01"));
        holidays.add(Date.valueOf("2024-05-01"));
        holidays.add(Date.valueOf("2024-06-12"));
    }

    public Date getVacCheck(Date modDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(modDate);

        while (isHoliday(calendar.getTime()) || isWeekend(calendar.getTime())) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }

        return new Date(calendar.getTimeInMillis());
    }

    private boolean isWeekend(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);
    }

    private boolean isHoliday(java.util.Date date) {
        return holidays.contains(new Date(date.getTime()));
    }

    public Date getNextSubmissionDate() {
        Calendar calendar = Calendar.getInstance();
        // Установим время в 18:00
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date currentDate = new Date(System.currentTimeMillis());

        for (int day : new int[]{1, 10, 20}) {
            calendar.set(Calendar.DAY_OF_MONTH, day);

            if (calendar.getTime().before(currentDate)) {
                calendar.add(Calendar.MONTH, 1);
            }

            Date submissionDate = new Date(calendar.getTimeInMillis());
            Date nearestWorkDay = getVacCheck(submissionDate);

            if (nearestWorkDay.equals(submissionDate)) {
                return submissionDate;
            } else {
                return nearestWorkDay;
            }
        }

        return null;
    }


}
