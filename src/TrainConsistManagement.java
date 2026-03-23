import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagement {
    public static void main(String[] args){
        System.out.println("UC2 - Add Passenger Bogies to Train");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("After Adding Bogies: ");
        System.out.println("Passenger Bodies : " + passengerBogies);

        passengerBogies.remove("AC Chair");
        System.out.println("After Removing 'AC Chair': ");
        System.out.println("Passenger Bogies : " + passengerBogies);

        System.out.println("Checking if 'Sleeper' exists: ");
        System.out.println("Constains Sleeper? : " + passengerBogies.contains("Sleeper"));

        System.out.println("Final Train Passenger Consists: ");
        System.out.println(passengerBogies);

        System.out.println("UC2 operations completed successfully...");
    }
}
