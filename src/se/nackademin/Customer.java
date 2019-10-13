package se.nackademin;

import java.time.LocalDate;

public class Customer {
    private String personNummer;
    private String name;
    private LocalDate date;

    Customer () {};

    Customer (String personNummer, String name, LocalDate date) {
        this.personNummer = personNummer;
        this.name = name;
        this.date = date;
    }

    public String getPersonNummer () {
        return personNummer;
    }
    public String getName () {
        return this.name;
    }
    public String getDate () {
        return date.toString();
    }
}
