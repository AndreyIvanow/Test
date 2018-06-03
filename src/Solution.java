import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Андрей on 03.10.2017.
 */
public class Solution {

    public static void main(String[] args) {
        List rawList = new ArrayList();
        List<String> list = new ArrayList<>();

        rawList = list;

        rawList.add(4);

       String a = list.get(0);

    }

    private static void getDays(java.util.Date date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        long days = ChronoUnit.DAYS.between(calendar.toInstant(), calendar.toInstant());
        System.out.println(days);
    }
}
