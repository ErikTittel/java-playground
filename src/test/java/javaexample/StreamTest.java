package javaexample;

import static java.util.stream.Collectors.toMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class StreamTest {

    @Test
    public void listToMap() {
        Customer customer1 = new Customer("1", "Fred");
        Customer customer2 = new Customer("2", "Sally");
        Customer customer3 = new Customer("3", "Tom");
        List<Customer> customers = Arrays.asList(customer1, customer2, customer3);

        Map<String, Customer> map = customers.stream().collect(toMap(Customer::getId, Function.identity()));

        assertThat(map.get("1").name, is("Fred"));
        assertThat(map.get("2").name, is("Sally"));
        assertThat(map.get("3").name, is("Tom"));
    }

    private static class Customer {
        private String id;
        private String name;

        public Customer(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }
    }
}
