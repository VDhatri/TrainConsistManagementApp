import java.util.Arrays;

public class TrainConsistManagement {

    public static boolean searchBogieByID(String[] bogieIDs, String searchKey) {
        for (String id : bogieIDs) {
            if (id.equals(searchKey)) {
                return true; 
            }
        }
        return false; 
    }

    public static void main(String[] args) {
        String[] bogieIDs = {"BG101","BG205","BG309","BG412","BG550"};

        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("---------------------------------");
        System.out.println("Bogie IDs: " + Arrays.toString(bogieIDs));

        String searchKey = "BG309";
        boolean found = searchBogieByID(bogieIDs, searchKey);
        System.out.println("Searching for " + searchKey + ": " + (found ? "Found" : "Not Found"));

        searchKey = "BG999";
        found = searchBogieByID(bogieIDs, searchKey);
        System.out.println("Searching for " + searchKey + ": " + (found ? "Found" : "Not Found"));
    }
}
