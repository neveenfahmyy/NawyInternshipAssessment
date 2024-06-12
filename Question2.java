import java.util.ArrayList;
import java.util.List;

public class Question2 {

    public static List<String> transformDateFormat(List<String> dates) {
        List<String> result = new ArrayList<>();

        // Define regex patterns for different date formats
        String yyyyMMddPattern = "^\\d{4}/\\d{2}/\\d{2}$";
        String ddMMyyyyPattern = "^\\d{2}/\\d{2}/\\d{4}$";
        String mmDdYyyyPattern = "^\\d{2}-\\d{2}-\\d{4}$";

        for (String date : dates) {
            String formattedDate = "";

            // Match YYYY/MM/DD
            if (date.matches(yyyyMMddPattern)) {
                String[] parts = date.split("/");
                String year = parts[0];
                String month = parts[1];
                String day = parts[2];
                formattedDate = year + month + day;
            }
            // Match DD/MM/YYYY
            else if (date.matches(ddMMyyyyPattern)) {
                String[] parts = date.split("/");
                String day = parts[0];
                String month = parts[1];
                String year = parts[2];
                formattedDate = year + month + day;
            }
            // Match MM-DD-YYYY
            else if (date.matches(mmDdYyyyPattern)) {
                String[] parts = date.split("-");
                String month = parts[0];
                String day = parts[1];
                String year = parts[2];
                formattedDate = year + month + day;
            }

            // Add to result if formattedDate is not empty
            if (!formattedDate.isEmpty()) {
                result.add(formattedDate);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> dates1 = List.of("2010/02/20", "19/12/2016", "11-18-2012", "20130720");
        List<String> dates2 = List.of("23/04/2024", "2019/10/02", "07-16-2002", "20130720", "20190808");
        List<String> formattedDates1 = transformDateFormat(dates1);
        List<String> formattedDates2 = transformDateFormat(dates2);
        System.out.println(formattedDates1);
        System.out.println(formattedDates2);
    }
}
