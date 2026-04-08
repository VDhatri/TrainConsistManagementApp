
import java.util.ArrayList;
import java.util.List;
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
        return bogies;
    }

    public List<Bogie> filterHighCapacityBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

     static void main(String[] args) {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<Bogie> bogies = tcm.createBogies();

        System.out.println("UC8 - Filter Passenger Boogies Using Streams");
        System.out.println("----------------------------------------------");
        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);

        int threshold = 60;
        List<Bogie> filtered = tcm.filterHighCapacityBogies(bogies, threshold);
        System.out.println("\nFiltered Bogies (capacity > " + threshold + "):");
        filtered.forEach(System.out::println);
    }
}