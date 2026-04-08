import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainConsistManagementTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] emptyArray = {};
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            TrainConsistManagement.searchBogieWithValidation(emptyArray, "BG101");
        });
        assertEquals("Cannot search: No bogies available in the train consist.", exception.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogies = {"BG101","BG205"};
        assertDoesNotThrow(() -> TrainConsistManagement.searchBogieWithValidation(bogies, "BG101"));
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogies = {"BG101","BG205","BG309"};
        assertTrue(TrainConsistManagement.searchBogieWithValidation(bogies, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogies = {"BG101","BG205","BG309"};
        assertFalse(TrainConsistManagement.searchBogieWithValidation(bogies, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogies = {"BG101"};
        assertTrue(TrainConsistManagement.searchBogieWithValidation(bogies, "BG101"));
        assertFalse(TrainConsistManagement.searchBogieWithValidation(bogies, "BG999"));
    }
}