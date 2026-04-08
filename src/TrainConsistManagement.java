import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrainConsistManagement {

    public static class Bogie {
        String type;
        int capacity;

        public Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    public List<Bogie> createBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Executive", 80));
        bogies.add(new Bogie("Sleeper", 60));
        return bogies;
    }

    public Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));
    }

    public List<Bogie> filterHighCapacityBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    // UC10: Compute total seats
    public int totalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    static void main(String[] args) {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<Bogie> bogies = tcm.createBogies();

        System.out.println("UC10 - Count Total Seats in Train Using reduce()");
        System.out.println("-----------------------------------------------");
        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);

        int totalSeats = tcm.totalSeats(bogies);
        System.out.println("\nTotal Seats in Train: " + totalSeats);
    }
}