package se.nackademin;
import java.time.LocalDate;
import java.util.*;

public class GymUtil {
    public static List<Customer> customerList = new ArrayList<>();
    public static List<Attendance> attendanceList = new ArrayList<>();


    public static void addAttendance () {
        boolean klart = false;
        Scanner sc = new Scanner(System.in);
        String name = "";
        String pNr = "";

        while (!klart) {
            try {
                System.out.print("Ange namn: ");
                name = sc.nextLine();
                System.out.print("Ange personnummer: ");
                pNr = sc.nextLine();
                if (name.length() > 1 && pNr.length() > 1)
                    klart = true;

            } catch (Exception e) {
                System.out.println("fel när attendance");
            }
        }

        if (klart)
            attendanceList.add(new Attendance(pNr, name, LocalDate.now()));

    }

    public static void printCustomers () {
        for(Customer c:customerList) {
            System.out.println(c);
            System.out.println("----");
        }
    }
    public static void printAttendance () {
        for(Attendance a:attendanceList) {
            System.out.println(a);
            System.out.println("----");
        }
    }
}
