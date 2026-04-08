import java.util.Arrays;

public class TrainConsistManagement {

    public static boolean searchBogieWithValidation(String[] bogieIDs, String searchKey) {
        if (bogieIDs == null || bogieIDs.length == 0) {
            throw new IllegalStateException("Cannot search: No bogies available in the train consist.");
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
        System.out.println("UC20 - Exception Handling During Search Operations");
        System.out.println("-------------------------------------------------");

        String[] emptyBogieArray = {};
        String[] bogieIDs = {"BG101","BG205","BG309"};

        try {
            searchBogieWithValidation(emptyBogieArray, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("Expected exception: " + e.getMessage());
        }

        System.out.println("Searching BG205: " + searchBogieWithValidation(bogieIDs, "BG205"));
        System.out.println("Searching BG999: " + searchBogieWithValidation(bogieIDs, "BG999"));
    }
}