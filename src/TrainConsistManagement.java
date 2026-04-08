import java.util.Arrays;

public class TrainConsistManagement {

    public static boolean binarySearchBogieID(String[] bogieIDs, String searchKey) {
        if (bogieIDs == null || bogieIDs.length == 0) {
            return false;
        }

        Arrays.sort(bogieIDs);

        int low = 0;
        int high = bogieIDs.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = bogieIDs[mid].compareTo(searchKey);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[] bogieIDs = {"BG309","BG101","BG550","BG205","BG412"};

        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("---------------------------------");
        System.out.println("Bogie IDs (unsorted): " + Arrays.toString(bogieIDs));

        String searchKey = "BG205";
        boolean found = binarySearchBogieID(bogieIDs, searchKey);
        System.out.println("Searching for " + searchKey + ": " + (found ? "Found" : "Not Found"));

        searchKey = "BG999";
        found = binarySearchBogieID(bogieIDs, searchKey);
        System.out.println("Searching for " + searchKey + ": " + (found ? "Found" : "Not Found"));

        searchKey = "BG101";
        found = binarySearchBogieID(bogieIDs, searchKey);
        System.out.println("Searching for " + searchKey + ": " + (found ? "Found" : "Not Found"));
    }
}