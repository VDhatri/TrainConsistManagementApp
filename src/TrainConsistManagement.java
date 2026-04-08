import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TrainConsistManagement {

    public static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    public static class GoodsBogie {
        String type;   
        String cargo;  

        public GoodsBogie(String type) {
            this.type = type;
        }

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

    public static void main(String[] args) {
        GoodsBogie cylindricalBogie = new GoodsBogie("Cylindrical");
        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");

        System.out.println("UC15 - Safe Cargo Assignment Demo");
        System.out.println("---------------------------------");

        cylindricalBogie.assignCargo("Petroleum");  
        rectangularBogie.assignCargo("Petroleum");  

        System.out.println("Program continues safely...");
        System.out.println(cylindricalBogie);
        System.out.println(rectangularBogie);
    }
}
