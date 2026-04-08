import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TrainConsistManagement {

    // Passenger bogie class
    public static class PassengerBogie {
        String type;  // Sleeper, AC Chair, First Class
        int capacity;

        public PassengerBogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity + " seats";
        }
    }

    // --- UC13: Loop-based filtering ---
    public List<PassengerBogie> filterBogiesLoop(List<PassengerBogie> bogies, int minCapacity) {
        List<PassengerBogie> result = new ArrayList<>();
        for (PassengerBogie b : bogies) {
            if (b.capacity > minCapacity) {
                result.add(b);
            }
        }
        return result;
    }

    // --- UC13: Stream-based filtering ---
    public List<PassengerBogie> filterBogiesStream(List<PassengerBogie> bogies, int minCapacity) {
        return bogies.stream()
                .filter(b -> b.capacity > minCapacity)
                .collect(Collectors.toList());
    }

    // --- UC13: Performance measurement utility ---
    public long measureExecutionTime(Runnable action) {
        long start = System.nanoTime();
        action.run();
        long end = System.nanoTime();
        return end - start;  // elapsed time in nanoseconds
    }

    // --- Sample main to demonstrate UC13 ---
    public static void main(String[] args) {
        TrainConsistManagement tcm = new TrainConsistManagement();

        // Sample passenger bogies
        List<PassengerBogie> bogies = List.of(
                new PassengerBogie("Sleeper", 72),
                new PassengerBogie("AC Chair", 50),
                new PassengerBogie("First Class", 80),
                new PassengerBogie("Sleeper", 60)
        );

        System.out.println("UC13 - Performance Comparison: Loops vs Streams");
        System.out.println("------------------------------------------------");

        long loopTime = tcm.measureExecutionTime(() -> {
            List<PassengerBogie> filteredLoop = tcm.filterBogiesLoop(bogies, 60);
            System.out.println("Loop Filtered Bogies: " + filteredLoop);
        });

        long streamTime = tcm.measureExecutionTime(() -> {
            List<PassengerBogie> filteredStream = tcm.filterBogiesStream(bogies, 60);
            System.out.println("Stream Filtered Bogies: " + filteredStream);
        });

        System.out.println("\nExecution Time (Loop): " + loopTime + " ns");
        System.out.println("Execution Time (Stream): " + streamTime + " ns");
    }
}