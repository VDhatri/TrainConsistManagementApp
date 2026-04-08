import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistManagement {

    // UC11: Validate Train ID
    public boolean isValidTrainID(String trainID) {
        String trainPattern = "TRN-\\d{4}"; // Format: TRN-1234
        Pattern pattern = Pattern.compile(trainPattern);
        Matcher matcher = pattern.matcher(trainID);
        return matcher.matches();
    }

    // UC11: Validate Cargo Code
    public boolean isValidCargoCode(String cargoCode) {
        String cargoPattern = "PET-[A-Z]{2}"; // Format: PET-AB
        Pattern pattern = Pattern.compile(cargoPattern);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        TrainConsistManagement tcm = new TrainConsistManagement();

        // Sample inputs
        String trainID1 = "TRN-1234";
        String trainID2 = "TRN12A";
        String cargo1 = "PET-AB";
        String cargo2 = "PET-ab";

        System.out.println("UC11 - Validate Train ID & Cargo Codes (Regex)");
        System.out.println("-----------------------------------------------");

        System.out.println(trainID1 + " valid? " + tcm.isValidTrainID(trainID1));
        System.out.println(trainID2 + " valid? " + tcm.isValidTrainID(trainID2));
        System.out.println(cargo1 + " valid? " + tcm.isValidCargoCode(cargo1));
        System.out.println(cargo2 + " valid? " + tcm.isValidCargoCode(cargo2));
    }
}