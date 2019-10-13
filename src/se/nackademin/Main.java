package se.nackademin;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Customer> test = ReadCustomers.read();

        int nr = 0;
//
//        for (String s: test) {
//            System.out.println(s);
//        }

        for(Customer c:test) {
            System.out.println(c.getPersonNummer());
            System.out.println(c.getName());
            System.out.println(c.getDate());
            System.out.println("---");
            nr++;
        }

    }
}
