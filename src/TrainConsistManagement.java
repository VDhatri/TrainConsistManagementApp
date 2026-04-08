import java.util.List;

public class TrainConsistManagement {

    // Static class for Goods Bogies
    public static class GoodsBogie {
        String type;   // e.g., Cylindrical, Rectangular
        String cargo;  // e.g., Petroleum, Coal, Grain

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    // UC12: Safety Compliance Check
    public boolean isTrainSafetyCompliant(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));
    }

    public static void main(String[] args) {
        TrainConsistManagement tcm = new TrainConsistManagement();

        // Sample goods bogies
        List<GoodsBogie> goodsBogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Rectangular", "Coal"),
                new GoodsBogie("Cylindrical", "Petroleum")
        );

        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("-----------------------------------------------");
        goodsBogies.forEach(System.out::println);

        boolean isSafe = tcm.isTrainSafetyCompliant(goodsBogies);
        System.out.println("\nIs train safety compliant? " + isSafe);
    }
}