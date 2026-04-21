//Railway Reservation  System 

  import java.util.*;

class Passenger {
    String name;
    int age;

    Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class RailwayReservation {
    static final int TOTAL_SEATS = 3;

    static ArrayList<Passenger> confirmedList = new ArrayList<>();
    static Queue<Passenger> waitingList = new LinkedList<>();

    // Book Ticket
    public static void bookTicket(String name, int age) {
        Passenger p = new Passenger(name, age);

        if (confirmedList.size() < TOTAL_SEATS) {
            confirmedList.add(p);
            System.out.println("✅ Ticket Confirmed for " + name);
        } else {
            waitingList.add(p);
            System.out.println("⏳ Added to Waiting List: " + name);
        }
    }

    // Cancel Ticket
    public static void cancelTicket(String name) {
        boolean found = false;

        Iterator<Passenger> it = confirmedList.iterator();

        while (it.hasNext()) {
            Passenger p = it.next();
            if (p.name.equalsIgnoreCase(name)) {
                it.remove();
                found = true;
                System.out.println("❌ Ticket Cancelled for " + name);

                // Move from waiting to confirmed
                if (!waitingList.isEmpty()) {
                    Passenger wp = waitingList.poll();
                    confirmedList.add(wp);
                    System.out.println("🔄 Waiting passenger confirmed: " + wp.name);
                }
                break;
            }
        }

        if (!found) {
            System.out.println("⚠️ Passenger not found!");
        }
    }

    // Display Status
    public static void display() {
        System.out.println("\n--- Confirmed Tickets ---");
        for (Passenger p : confirmedList) {
            System.out.println(p.name + " (" + p.age + ")");
        }

        System.out.println("\n--- Waiting List ---");
        for (Passenger p : waitingList) {
            System.out.println(p.name + " (" + p.age + ")");
        }
    }

    public static void main(String[] args) {
        bookTicket("Aman", 25);
        bookTicket("Riya", 22);
        bookTicket("Rahul", 30);
        bookTicket("Sneha", 28); // goes to waiting
        bookTicket("Karan", 35); // waiting

        display();

        cancelTicket("Riya"); // move waiting to confirmed

        display();
    }
}


