package se.nackademin;
import java.time.*;

public class Attendance {
    private String personnummer;
    private String name;
    private LocalDate date;

    Attendance(String personnummer, String name, LocalDate date) {
        this.personnummer = personnummer;
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%-20s %s", "Personnummer:", this.personnummer) +
                String.format("\n%-20s %s", "Namn:", this.name) +
                String.format("\n%-20s %s", "På Gym:", this.date);
    }

}