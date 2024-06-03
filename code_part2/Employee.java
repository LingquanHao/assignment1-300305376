package code_part2;

public class Employee {
    String name;
    int hours;
    double rate;
    Address address;

    public Employee(String name, int hours, double rate, Address address) {
        this.name = name;
        this.hours = hours;
        this.rate = rate;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", hours=" + hours +
                ", rate=" + rate +
                ", address=" + address +
                '}';
    }
}
