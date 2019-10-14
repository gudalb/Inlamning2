package se.nackademin;

import java.time.LocalDate;

public class Customer {
    private String personnummer;
    private String name;
    private LocalDate date;

    Customer () {};

    Customer (String personnummer, String name, LocalDate date) {
        this.personnummer = personnummer;
        this.name = name;
        this.date = date;
        GymUtil.customerList.add(this);
    }

    public String getPersonnummer () {
        return personnummer;
    }
    public String getName () {
        return this.name;

    }
    public String getDate () {
        return date.toString();
    }

    @Override
    public String toString() {
        return String.format("%-20s %s","Personnummer:", this.personnummer) +
                String.format("\n%-20s %s","Namn:", this.name) +
                String.format("\n%-20s %s","Betalade:", this.date);
    }
}
