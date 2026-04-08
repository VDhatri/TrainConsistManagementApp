import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TrainConsistManagement {

    public static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    public static class PassengerBogie {
        String type;  // Sleeper, AC Chair, First Class
        int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity + " seats";
        }
    }

    public List<PassengerBogie> filterBogiesLoop(List<PassengerBogie> bogies, int minCapacity) {
        List<PassengerBogie> result = new ArrayList<>();
        for (PassengerBogie b : bogies) {
            if (b.capacity > minCapacity) {
                result.add(b);
            }
        }
        return result;
    }

    public List<PassengerBogie> filterBogiesStream(List<PassengerBogie> bogies, int minCapacity) {
        return bogies.stream()
                .filter(b -> b.capacity > minCapacity)
                .collect(Collectors.toList());
    }

    public long measureExecutionTime(Runnable action) {
        long start = System.nanoTime();
        action.run();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        TrainConsistManagement tcm = new TrainConsistManagement();
        try {
            PassengerBogie validBogie = new PassengerBogie("Sleeper", 72);
            System.out.println("Created bogie: " + validBogie);

            PassengerBogie invalidBogie = new PassengerBogie("AC Chair", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}