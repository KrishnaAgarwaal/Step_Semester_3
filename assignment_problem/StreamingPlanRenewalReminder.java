package assignment_problem;

import java.time.LocalDate;
import java.util.Scanner;

abstract class SubscriptionPlan {
    LocalDate startDate;

    SubscriptionPlan(LocalDate startDate) {
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends SubscriptionPlan {
    BasicPlan(LocalDate startDate) {
        super(startDate);
    }

    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    StandardPlan(LocalDate startDate) {
        super(startDate);
    }

    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    PremiumPlan(LocalDate startDate) {
        super(startDate);
    }

    int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            SubscriptionPlan plan;

            if (type.equals("BASIC")) {
                plan = new BasicPlan(startDate);
            } else if (type.equals("STANDARD")) {
                plan = new StandardPlan(startDate);
            } else {
                plan = new PremiumPlan(startDate);
            }

            System.out.println(name + ": " + plan.getRenewalDate());
        }

        sc.close();
    }
}