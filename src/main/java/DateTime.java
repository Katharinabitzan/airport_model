import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;
import java.text.ParseException;


//public class DateObject {
//    public static void main(String[] args)throws Exception {
//        String string="12.08.1992 22:40";
//        Date date1=new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(string);
//        return date1;
//    }
//}

public class DateTime {

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;

    public DateTime (int day, int month, int year, int hour, int minute) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    public String getDateTime() {
        return day + "." + month + "." + year + " at " + hour + "." + minute;
    }
}
