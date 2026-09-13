package br.com.gabriel.ifsp.exercises.inheritance.employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class PerHourEmployee extends Employee {
    private double hourlyRate;
    private int workedHour;

    public PerHourEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double hourlyRate, int workedHour) {
        super(id, name, jobTitle, dateOfEmployment);
        this.hourlyRate = hourlyRate;
        this.workedHour = workedHour;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getWorkedHour() {
        return workedHour;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setWorkedHour(int workedHour) {
        this.workedHour = workedHour;
    }

    @Override
    public double salary() {
        return hourlyRate * workedHour;
    }

    @Override
    public String toString() {
        return "PerHourEmployee{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", jobTitle='" + getJobTitle() + '\'' +
                ", dateOfEmployment=" + getDateOfEmployment().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) +
                ", hourlyRate=" + getHourlyRate() +
                ", workedHour=" + getWorkedHour() +
                '}';
    }
}
