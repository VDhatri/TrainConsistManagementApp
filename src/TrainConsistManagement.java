import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TrainConsistManagement {

    // --- UC15: Custom Runtime Exception ---
    public static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods bogie with safe cargo assignment
    public static class GoodsBogie {
        String type;   // Rectangular, Cylindrical
        String cargo;  // Petroleum, Coal, Grain

        public GoodsBogie(String type) {
            this.type = type;
        }

        // Assign cargo safely using try-catch-finally
        public void assignCargo(String cargo) {
            try {
                if (type.equals("Rectangular") && cargo.equals("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment: Petroleum cannot be assigned to Rectangular bogie");
                }
                this.cargo = cargo;
                System.out.println("Cargo assigned successfully: " + cargo + " -> " + type);
            } catch (CargoSafetyException e) {
                System.out.println("Exception caught: " + e.getMessage());
            } finally {
                System.out.println("Cargo assignment validation complete for bogie: " + type);
            }
        }

        @Override
        public String toString() {
            return type + " -> " + (cargo != null ? cargo : "No cargo assigned");
        }
    }

    // Sample main to demonstrate UC15
    public static void main(String[] args) {
        GoodsBogie cylindricalBogie = new GoodsBogie("Cylindrical");
        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");

        System.out.println("UC15 - Safe Cargo Assignment Demo");
        System.out.println("---------------------------------");

        cylindricalBogie.assignCargo("Petroleum");  // safe assignment
        rectangularBogie.assignCargo("Petroleum");  // unsafe assignment

        // Continue program
        System.out.println("Program continues safely...");
        System.out.println(cylindricalBogie);
        System.out.println(rectangularBogie);
    }
}