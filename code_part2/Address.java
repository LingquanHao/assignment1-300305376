package code_part2;

public class Address {
    String street;
    int number;
    String postal;

    public Address(String street, int number, String postal) {
        this.street = street;
        this.number = number;
        this.postal = postal;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", postal='" + postal + '\'' +
                '}';
    }
}
