package se.nackademin;
import java.io.*;
import java.time.LocalDate;
import java.util.*;


// skapa Customer-objekt från textfil och spara i Customer-lista.

public class ReadCustomers {

    public static void readToList (){
        List<String> customers = new ArrayList<>();
        List<String> customersSep = new ArrayList<>();

        try(Scanner sc = new Scanner(new File("customers.txt"))){
            while (sc.hasNextLine()) {
                String tempStr = sc.nextLine();
                if (!tempStr.isBlank()) {
                    customers.add(tempStr);
                }
            }
        } catch (Exception e) {
            System.out.println("Fel vid inläsning av fil.");
        }

        try {
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).contains(",")) {
                    customersSep.add(customers.get(i).substring(0, customers.get(i).indexOf(",")));
                    customersSep.add(customers.get(i).substring(customers.get(i).indexOf(",") + 2));
                } else
                    customersSep.add(customers.get(i));
            }
        } catch (Exception e) {
            System.out.println("Fel vid sträng-delning");
        }

        try {
            for (int i = 0;i < customersSep.size();i++)
            {
                String pNr = customersSep.get(i);
                i++;
                String name = customersSep.get(i);
                i++;
                LocalDate date = LocalDate.parse(customersSep.get(i));

                GymUtil.customerList.add(new Customer(pNr,name,date));
            }
        }
        catch (Exception e) {
            System.out.println("Fel vid skapande av Customer-objekt.");
        }

    }

}
