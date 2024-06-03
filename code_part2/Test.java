package code_part2;

public class Test {
    public static void main(String[] args) {
        Address address1 = new Address("Queen", 48, "K1P1N2");
        Address address2 = new Address("King Edward", 800, "K1N6N5");

        Employee employee = new Employee("Falcao", 40, 15.50, address1);

        // Print instances to verify initialization
        System.out.println(employee);
        System.out.println(address2);
    }
}
