package se.nackademin;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Attendance {
    private String personnummer;
    private String name;
    private LocalDateTime date;

    Attendance(String personnummer, String name) {
        this.personnummer = personnummer;
        this.name = name;
        this.date = LocalDateTime.now();
        GymUtil.attendanceList.add(this);
    }

    @Override
    public String toString() {
        return String.format("%-14s %s", "Personnummer:", this.personnummer) +
                String.format("\n%-14s %s", "Namn:", this.name) +
                String.format("\n%-14s %s\n", "På Gym:",
                        this.date.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));
    }

}