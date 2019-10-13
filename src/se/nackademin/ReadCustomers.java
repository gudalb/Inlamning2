package se.nackademin;
import java.io.*;
import java.util.*;

public class ReadCustomers {
    public static List<String[]> read () throws IOException{
        List<String[]> customers = new ArrayList<>();

        try(Scanner sc = new Scanner(new File("customers.txt"))){
            while (sc.hasNextLine()) {
                String tempLine = sc.nextLine();
                String tempLine2 = sc.nextLine();
                String[] strArr = {tempLine, tempLine2};
                customers.add(strArr);
            }

        }

        return customers;
    }

}
