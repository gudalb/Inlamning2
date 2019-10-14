package se.nackademin;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class GymUtil {
    public static List<Customer> customerList = new ArrayList<>();
    public static List<Attendance> attendanceList = new ArrayList<>();


    public static void addAttendance() {
        String name;
        String personnummer;
        Scanner sc = new Scanner(System.in);

        do  {
            System.out.print("Ange namn: ");
            name = sc.nextLine();
        } while (!validateName(name));

        do {
            System.out.print("Ange personnummer: ");
            personnummer = sc.nextLine();
        } while (!validatePersonnummer(personnummer));

        Attendance tempAttendance = new Attendance(personnummer, name);

        System.out.println("Attendance added for:\n" + tempAttendance);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("attendance.txt", true))) {
            bw.write(tempAttendance.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error when printing attendance to file.");
        }
    }

    public static void getCustomersFromFile() {
        try (Scanner sc = new Scanner(new File("customers.txt"))) {
            String temp;
            String personnummer;
            String name;
            LocalDate date;

            while (sc.hasNextLine()) {

                try {
                    temp = sc.nextLine();
                    personnummer = temp.substring(0, temp.indexOf(","));
                    name = temp.substring(temp.indexOf(",") + 2);
                    date = LocalDate.parse(sc.nextLine());

                    new Customer(personnummer,name,date);

                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("end of file.");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean validateName (String s) {
        if (s.length() > 2 )
            return true;
        else
            System.out.println("Namn måste innehålla minst 3 bokstäver.");
            return false;
    }

    public static boolean validatePersonnummer (String s) {
        boolean test = false;

        try {
            if (s.length() != 10 && Integer.parseInt(s) > 0)
                throw new IncorrectPersonnummerException();
            else
                test = true;

        } catch (IncorrectPersonnummerException e) {
            System.out.println("Personnummer måste innehålla 10 siffror.");
        } catch (NumberFormatException e) {
            System.out.println("Personnummer kan endast innehålla siffror.");
        }

        return test;
    }

    public static void printCustomers() {
        for (Customer c : customerList) {
            System.out.println(c);
            System.out.println("----");
        }
    }

    public static void printAttendance() {
        for (Attendance a : attendanceList) {
            System.out.println(a);
            System.out.println("----");
        }
    }
}
