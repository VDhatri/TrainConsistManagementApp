import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainConsistManagementTest {

    @Test
    void testSearch_BogieFound() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistManagement.searchBogieByID(bogies, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(TrainConsistManagement.searchBogieByID(bogies, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistManagement.searchBogieByID(bogies, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistManagement.searchBogieByID(bogies, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] bogies = {"BG101"};
        assertTrue(TrainConsistManagement.searchBogieByID(bogies, "BG101"));
        assertFalse(TrainConsistManagement.searchBogieByID(bogies, "BG999"));
    }
}