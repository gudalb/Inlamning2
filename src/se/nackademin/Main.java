package se.nackademin;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ReadCustomers.readToList();

        GymUtil.printCustomers();


        GymUtil.addAttendance();

        GymUtil.printAttendance();
    }
}

// todo gör om inläsning från fil, använd scanner nextint etc med annan delimeter
// todo ändra formatering för datum sparat i fil
// todo sätt krav för personnummer, antal nr och som int