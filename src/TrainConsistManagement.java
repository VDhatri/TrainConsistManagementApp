import java.util.Arrays;

public class TrainConsistManagement {

    public static void sortBogieNames(String[] bogieNames) {
        Arrays.sort(bogieNames);
    }

    public static void main(String[] args) {
        String[] bogieNames = {"Sleeper","AC Chair","First Class","General","Luxury"};

        System.out.println("UC17 - Bogie Names Before Sorting:");
        System.out.println(Arrays.toString(bogieNames));

        sortBogieNames(bogieNames);

        System.out.println("UC17 - Bogie Names After Sorting:");
        System.out.println(Arrays.toString(bogieNames));
    }
}
