package assignment_problem.week1;

public class WarehouseInventoryBalancer {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {

        int totalA = 0;
        int totalB = 0;

        // Calculate total of Section A
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
        }

        // Calculate total of Section B
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
        }

        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);

        // Check whether balanced
        if (totalA == totalB) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }

        // Find highest quantity
        int highestQuantity = sectionA[0];
        String highestSection = "A";
        int highestIndex = 0;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "A";
                highestIndex = i;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "B";
                highestIndex = i;
            }
        }

        System.out.println("Highest Quantity: " + highestQuantity);
        System.out.println("Section: " + highestSection);
        System.out.println("Index: " + highestIndex);
    }

    public static void main(String[] args) {

        int[] sectionA = {10, 20, 30};
        int[] sectionB = {20, 15, 25};

        analyzeInventory(sectionA, sectionB);
    }
}