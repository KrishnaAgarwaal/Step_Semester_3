package class_problems;

import java.util.Scanner;

abstract class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();
}

class CardPayment extends Payment {
    CardPayment(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 1.02;
    }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 1.01;
    }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount;
    }
}

public class PaymentSystemFeeCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Payment payment;

            switch (type) {
                case "CARD":
                    payment = new CardPayment(amount);
                    break;
                case "WALLET":
                    payment = new WalletPayment(amount);
                    break;
                default:
                    payment = new BankTransferPayment(amount);
            }

            double adjusted = payment.calculateAmount();

            System.out.printf("%s: %.2f%n", type, adjusted);
            total += adjusted;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}