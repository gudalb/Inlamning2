package se.nackademin;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        ReadCustomers.readToList();
//        GymUtil.printCustomers();
//        GymUtil.addAttendance();
//        GymUtil.printAttendance();

        GymUtil.getCustomersFromFile();
        GymUtil.printCustomers();
        GymUtil.addAttendance();
        GymUtil.printAttendance();
    }
}
