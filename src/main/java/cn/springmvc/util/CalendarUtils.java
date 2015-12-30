package cn.springmvc.util;

import java.util.Calendar;

public class CalendarUtils {
    public static String getYmd(long time) {
        StringBuffer sb = new StringBuffer();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        int year = calendar.get(Calendar.YEAR);
        sb.append(year).append("-");

        int month = calendar.get(Calendar.MONTH) + 1;
        if (month < 10) {
            sb.append("0");
        }
        sb.append(month);

        int date = calendar.get(Calendar.DATE);
        sb.append("-");
        if (date < 10) {
            sb.append("0");
        }
        sb.append(date);

        return sb.toString();
    }

    /**
     * 0:今天 -1:昨天 1:明天 ...
     * 
     * @param days
     * @return
     */
    public static String getYmdToNow(int days) {
        long now = System.currentTimeMillis();
        // 注意越界 1000l
        long time = now + (24 * 60 * 60 * 1000l * days);
        return getYmd(time);
    }

    public static String getHms(long time) {
        StringBuffer sb = new StringBuffer();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour < 10) {
            sb.append(0);
        }
        sb.append(hour);

        int minute = calendar.get(Calendar.MINUTE);
        sb.append(':');
        if (minute < 10) {
            sb.append(0);
        }
        sb.append(minute);

        int second = calendar.get(Calendar.SECOND);
        sb.append(':');
        if (second < 10) {
            sb.append(0);
        }
        sb.append(second);

        return sb.toString();
    }

    // 时区+8
    public static long getDaysFromOrigin(long time) {
        long day = (time + (1000 * 60 * 60 * 8l)) / (1000 * 60 * 60 * 24l);
        return day;
    }

    public static void main(String[] args) {
        long daysFromOrigin = getDaysFromOrigin(System.currentTimeMillis() - 60
                * 60 * 1000l * 18);
        System.out.println(daysFromOrigin);
    }

}
