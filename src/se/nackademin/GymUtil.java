package se.nackademin;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class GymUtil {
    public static List<Customer> customerList = new ArrayList<>();
    public static List<Attendance> attendanceList = new ArrayList<>();


    public static void addAttendance () {
        boolean persOk = false;
        boolean namnOk = false;
        String name = "";
        String personnummer = "";
        Scanner sc = new Scanner(System.in);

        while (!namnOk) {
            System.out.print("Ange namn: ");
            name = sc.nextLine();

            if (name.length() < 3)
                System.out.println("Namn måste innehålla minst 3 bokstäver.");
            else
                namnOk = true;
        }

        while (!persOk) {
            System.out.print("Ange personnummer: ");

            try {
                personnummer = sc.nextLine();
                if (personnummer.length() != 10 && Integer.parseInt(personnummer) > 0)
                    throw new IncorrectPersonnummerException();
                else
                    persOk = true;

            } catch(IncorrectPersonnummerException e){
                System.out.println("Personnummer måste innehålla 10 siffror.");
            } catch(NumberFormatException e){
                System.out.println("Personnummer kan endast innehålla siffror.");
            }
        }

        Attendance tempAttendance = new Attendance(personnummer, name);
        attendanceList.add(tempAttendance);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("attendance.txt", true))) {
            bw.write(tempAttendance.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error when printing attendance to file.");
        } ;
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
