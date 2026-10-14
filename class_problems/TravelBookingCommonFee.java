package class_problems;

import java.util.Scanner;

abstract class TravelBooking {
    double distance;
    static final double BOOKING_FEE = 50;

    TravelBooking(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    BusBooking(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 2;
    }
}

class TrainBooking extends TravelBooking {
    TrainBooking(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 1.5;
    }
}

class FlightBooking extends TravelBooking {
    FlightBooking(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 2500 + distance * 4;
    }
}

public class TravelBookingCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TravelBooking[] bookings = new TravelBooking[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            switch (mode) {
                case "BUS":
                    bookings[i] = new BusBooking(distance);
                    break;
                case "TRAIN":
                    bookings[i] = new TrainBooking(distance);
                    break;
                case "FLIGHT":
                    bookings[i] = new FlightBooking(distance);
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.printf(
                "%s: %.2f%n",
                getMode(bookings[i]),
                bookings[i].calculateTotal()
            );
        }

        sc.close();
    }

    static String getMode(TravelBooking booking) {
        if (booking instanceof BusBooking) {
            return "BUS";
        } else if (booking instanceof TrainBooking) {
            return "TRAIN";
        }

        return "FLIGHT";
    }
}