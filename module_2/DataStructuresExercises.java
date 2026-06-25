package module_2;
import java.util.*;

public class DataStructuresExercises {

    // ---------------- Exercise 1 ----------------
    static class Product {
        int id;
        String name;
        int quantity;
        double price;
        String category;

        Product(int id, String name, int quantity, double price, String category) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
            this.category = category;
        }
    }

    static void inventoryManagement() {
        System.out.println("\nExercise 1: Inventory Management");

        HashMap<Integer, Product> map = new HashMap<>();

        map.put(1, new Product(1, "Laptop", 10, 50000, "Electronics"));
        map.put(2, new Product(2, "Mouse", 20, 500, "Accessories"));

        map.put(2, new Product(2, "Mouse", 30, 600, "Accessories"));

        map.remove(1);

        for (Product p : map.values()) {
            System.out.println(p.id + " " + p.name + " " + p.quantity + " " + p.price);
        }
    }

    // ---------------- Exercise 2 ----------------

    static void linearSearch(Product arr[], String key) {
        for (Product p : arr) {
            if (p.name.equalsIgnoreCase(key)) {
                System.out.println("Linear Search : Found");
                return;
            }
        }
        System.out.println("Linear Search : Not Found");
    }

    static void binarySearch(Product arr[], String key) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            int c = arr[m].name.compareToIgnoreCase(key);

            if (c == 0) {
                System.out.println("Binary Search : Found");
                return;
            }

            if (c < 0)
                l = m + 1;
            else
                r = m - 1;
        }

        System.out.println("Binary Search : Not Found");
    }

    static void searchExercise() {

        System.out.println("\nExercise 2: Search");

        Product arr[] = {
                new Product(1, "Camera", 0, 0, ""),
                new Product(2, "Laptop", 0, 0, ""),
                new Product(3, "Mouse", 0, 0, "")
        };

        linearSearch(arr, "Laptop");
        binarySearch(arr, "Mouse");
    }

    // ---------------- Exercise 3 ----------------

    static class Order {
        int id;
        String customer;
        double total;

        Order(int id, String customer, double total) {
            this.id = id;
            this.customer = customer;
            this.total = total;
        }
    }

    static int partition(Order arr[], int low, int high) {

        double pivot = arr[high].total;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].total < pivot) {
                i++;
                Order t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        Order t = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = t;

        return i + 1;
    }

    static void quickSort(Order arr[], int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static void sortingExercise() {

        System.out.println("\nExercise 3: Sorting");

        Order arr[] = {
                new Order(1, "Ravi", 5000),
                new Order(2, "Anu", 1500),
                new Order(3, "Raj", 9000)
        };

        quickSort(arr, 0, arr.length - 1);

        for (Order o : arr)
            System.out.println(o.id + " " + o.customer + " " + o.total);
    }

    // ---------------- Exercise 4 ----------------

    static class Employee {

        int id;
        String name;
        String position;
        double salary;

        Employee(int id, String name, String position, double salary) {
            this.id = id;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }
    }

    static void employeeExercise() {

        System.out.println("\nExercise 4: Employee");

        Employee emp[] = new Employee[5];

        emp[0] = new Employee(1, "Ravi", "Manager", 50000);
        emp[1] = new Employee(2, "Anu", "Developer", 40000);

        for (Employee e : emp)
            if (e != null)
                System.out.println(e.id + " " + e.name);

        emp[1] = null;

        System.out.println("After Delete");

        for (Employee e : emp)
            if (e != null)
                System.out.println(e.id + " " + e.name);
    }

    // ---------------- Exercise 5 ----------------

    static class Task {

        int id;
        String name;
        String status;
        Task next;

        Task(int id, String name, String status) {
            this.id = id;
            this.name = name;
            this.status = status;
        }
    }

    static Task head = null;

    static void addTask(int id, String name, String status) {

        Task t = new Task(id, name, status);

        if (head == null) {
            head = t;
            return;
        }

        Task temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = t;
    }

    static void taskExercise() {

        System.out.println("\nExercise 5: Linked List");

        addTask(1, "Coding", "Pending");
        addTask(2, "Testing", "Done");

        Task temp = head;

        while (temp != null) {
            System.out.println(temp.id + " " + temp.name + " " + temp.status);
            temp = temp.next;
        }
    }

    // ---------------- Exercise 6 ----------------

    static class Book {

        int id;
        String title;
        String author;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }
    }

    static void libraryExercise() {

        System.out.println("\nExercise 6: Library");

        Book books[] = {
                new Book(1, "C", "Dennis"),
                new Book(2, "Java", "James"),
                new Book(3, "Python", "Guido")
        };

        for (Book b : books)
            if (b.title.equalsIgnoreCase("Java"))
                System.out.println("Book Found : " + b.title);
    }

    // ---------------- Exercise 7 ----------------

    static double futureValue(double amount, double rate, int years) {

        if (years == 0)
            return amount;

        return futureValue(amount * (1 + rate), rate, years - 1);
    }

    static void financeExercise() {

        System.out.println("\nExercise 7: Financial Forecast");

        System.out.println(futureValue(10000, 0.10, 5));
    }

    // ---------------- Main ----------------

    public static void main(String[] args) {

        inventoryManagement();
        searchExercise();
        sortingExercise();
        employeeExercise();
        taskExercise();
        libraryExercise();
        financeExercise();
    }
}