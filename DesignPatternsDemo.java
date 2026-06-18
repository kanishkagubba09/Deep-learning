import java.util.*;

// Singleton
class Logger {
    private static Logger obj = new Logger();

    private Logger() {
    }

    public static Logger getObj() {
        return obj;
    }

    void print(String s) {
        System.out.println(s);
    }
}

// Factory
interface Document {
    void open();
}

class PdfDoc implements Document {
    public void open() {
        System.out.println("PDF Opened");
    }
}

class WordDoc implements Document {
    public void open() {
        System.out.println("Word Opened");
    }
}

abstract class DocFactory {
    abstract Document create();
}

class PdfFactory extends DocFactory {
    Document create() {
        return new PdfDoc();
    }
}

// Builder
class Computer {
    String cpu;
    int ram;

    private Computer(Builder b) {
        cpu = b.cpu;
        ram = b.ram;
    }

    static class Builder {
        String cpu;
        int ram;

        Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        Builder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        Computer build() {
            return new Computer(this);
        }
    }

    void show() {
        System.out.println(cpu + " " + ram + "GB");
    }
}

// Adapter
interface PaymentProcessor {
    void pay(int amt);
}

class Paytm {
    void makePayment(int amt) {
        System.out.println("Paytm Payment " + amt);
    }
}

class PaytmAdapter implements PaymentProcessor {
    Paytm p = new Paytm();

    public void pay(int amt) {
        p.makePayment(amt);
    }
}

// Decorator
interface Notifier {
    void send();
}

class Email implements Notifier {
    public void send() {
        System.out.println("Email Sent");
    }
}

abstract class NotifierDec implements Notifier {
    Notifier n;

    NotifierDec(Notifier n) {
        this.n = n;
    }
}

class Sms extends NotifierDec {

    Sms(Notifier n) {
        super(n);
    }

    public void send() {
        n.send();
        System.out.println("SMS Sent");
    }
}

// Proxy
interface Image {
    void display();
}

class RealImage implements Image {
    String name;

    RealImage(String name) {
        this.name = name;
        System.out.println("Loading Image");
    }

    public void display() {
        System.out.println("Showing " + name);
    }
}

class ProxyImage implements Image {
    RealImage r;
    String name;

    ProxyImage(String name) {
        this.name = name;
    }

    public void display() {
        if (r == null) {
            r = new RealImage(name);
        }
        r.display();
    }
}

// Observer
interface Observer {
    void update(int p);
}

class MobileApp implements Observer {
    public void update(int p) {
        System.out.println("Price : " + p);
    }
}

class StockMarket {
    ArrayList<Observer> list = new ArrayList<>();

    void add(Observer o) {
        list.add(o);
    }

    void notifyAllObs(int p) {
        for (Observer x : list) {
            x.update(p);
        }
    }
}

// Strategy
interface PaymentStrategy {
    void pay(int amt);
}

class CardPay implements PaymentStrategy {
    public void pay(int amt) {
        System.out.println("Card Payment " + amt);
    }
}

class PaymentContext {
    PaymentStrategy p;

    PaymentContext(PaymentStrategy p) {
        this.p = p;
    }

    void doPay(int amt) {
        p.pay(amt);
    }
}

// Command
interface Command {
    void execute();
}

class Light {
    void on() {
        System.out.println("Light ON");
    }

    void off() {
        System.out.println("Light OFF");
    }
}

class LightOn implements Command {
    Light l;

    LightOn(Light l) {
        this.l = l;
    }

    public void execute() {
        l.on();
    }
}

class Remote {
    Command c;

    void set(Command c) {
        this.c = c;
    }

    void press() {
        c.execute();
    }
}

// MVC
class Student {
    String name;
    int id;
}

class StudentView {
    void show(Student s) {
        System.out.println(s.name + " " + s.id);
    }
}

class StudentController {
    Student s;
    StudentView v;

    StudentController(Student s, StudentView v) {
        this.s = s;
        this.v = v;
    }

    void update() {
        v.show(s);
    }
}

// Dependency Injection
interface CustomerRepository {
    String find(int id);
}

class CustomerRepoImpl implements CustomerRepository {
    public String find(int id) {
        return "Customer " + id;
    }
}

class CustomerService {
    CustomerRepository c;

    CustomerService(CustomerRepository c) {
        this.c = c;
    }

    void get(int id) {
        System.out.println(c.find(id));
    }
}

// Main Class
public class DesignPatternsDemo {

    public static void main(String[] args) {

        Logger.getObj().print("Singleton");

        DocFactory d = new PdfFactory();
        d.create().open();

        Computer.Builder b = new Computer.Builder();
        b.setCpu("i7");
        b.setRam(16);
        Computer c = b.build();
        c.show();

        PaymentProcessor p = new PaytmAdapter();
        p.pay(1000);

        Notifier n = new Sms(new Email());
        n.send();

        Image i = new ProxyImage("pic.jpg");
        i.display();

        StockMarket m = new StockMarket();
        m.add(new MobileApp());
        m.notifyAllObs(500);

        PaymentContext pc = new PaymentContext(new CardPay());
        pc.doPay(2000);

        Light l = new Light();
        Remote r = new Remote();
        r.set(new LightOn(l));
        r.press();

        Student s = new Student();
        s.name = "Kanishka";
        s.id = 101;

        StudentController sc = new StudentController(s, new StudentView());
        sc.update();

        CustomerService cs = new CustomerService(new CustomerRepoImpl());
        cs.get(201);
    }
}