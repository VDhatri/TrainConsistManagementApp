import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainConsistManagementTest {

    TrainConsistManagement tcm = new TrainConsistManagement();

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(tcm.isValidTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(tcm.isValidTrainID("TRAIN12"));
        assertFalse(tcm.isValidTrainID("TRN12A"));
        assertFalse(tcm.isValidTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(tcm.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(tcm.isValidCargoCode("PET-ab"));
        assertFalse(tcm.isValidCargoCode("PET123"));
        assertFalse(tcm.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(tcm.isValidTrainID("TRN-123"));   // too short
        assertFalse(tcm.isValidTrainID("TRN-12345")); // too long
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(tcm.isValidCargoCode("PET-aa")); // lowercase not allowed
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(tcm.isValidTrainID(""));
        assertFalse(tcm.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(tcm.isValidTrainID("TRN-1234X")); // extra characters
        assertFalse(tcm.isValidCargoCode("PET-ABC")); // extra characters
    }
}