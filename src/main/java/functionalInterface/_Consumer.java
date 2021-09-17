package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        Customer mateo = new Customer("Mateo","666000111");
        //Normal Java
        greetCustomer(mateo);

        //Consumer Functional Interface
        greetCustomerConsumer.accept(mateo);
        greetCustomerConsumerV2.accept(mateo,true);
        greetCustomerConsumerV2.accept(mateo,false);
    }

    static void greetCustomer (Customer customer){
        System.out.println(customer.toString());
    }

    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println(customer.toString());

    static BiConsumer<Customer,Boolean> greetCustomerConsumerV2 =
            (customer, showPhoneNumber) -> System.out.println(
                    "Customer{" +
                    "customerName='" + customer.customerName + '\'' +
                    ", customerPhoneNumber='" + (showPhoneNumber ?customer.customerPhoneNumber:"*********") + '\'' +
                    '}');

    static class Customer {
        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        private final String customerName;
        private final String customerPhoneNumber;

        @Override
        public String toString() {
            return "Customer{" +
                    "customerName='" + customerName + '\'' +
                    ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                    '}';
        }
    }
}
