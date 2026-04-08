import java.util.List;
import java.util.ArrayList;

public class TrainConsistManagement {

    public static void bubbleSortCapacities(int[] capacities) {
        int n = capacities.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("UC16 - Passenger Bogie Capacities Before Sorting:");
        for (int c : capacities) System.out.print(c + " ");
        System.out.println();

        bubbleSortCapacities(capacities);

        System.out.println("UC16 - Passenger Bogie Capacities After Sorting:");
        for (int c : capacities) System.out.print(c + " ");
        System.out.println();
    }
}
