import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

public class TrainConsistManagementTest {

    TrainConsistManagement tcm = new TrainConsistManagement();

    // --- UC12: Safety Compliance Check Tests ---

    @Test
    void testSafetyCompliant_AllValidCylindricalPetroleum() {
        List<TrainConsistManagement.GoodsBogie> bogies = List.of(
                new TrainConsistManagement.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistManagement.GoodsBogie("Rectangular", "Coal")
        );
        assertTrue(tcm.isTrainSafetyCompliant(bogies));
    }

    @Test
    void testSafetyNonCompliant_InvalidCylindricalCargo() {
        List<TrainConsistManagement.GoodsBogie> bogies = List.of(
                new TrainConsistManagement.GoodsBogie("Cylindrical", "Coal"),
                new TrainConsistManagement.GoodsBogie("Rectangular", "Grain")
        );
        assertFalse(tcm.isTrainSafetyCompliant(bogies));
    }

    @Test
    void testSafetyCompliant_EmptyBogieList() {
        List<TrainConsistManagement.GoodsBogie> bogies = new ArrayList<>();
        assertTrue(tcm.isTrainSafetyCompliant(bogies), "Empty list should be compliant by default");
    }

    @Test
    void testSafetyCompliant_MixedValidBogieTypes() {
        List<TrainConsistManagement.GoodsBogie> bogies = List.of(
                new TrainConsistManagement.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistManagement.GoodsBogie("Rectangular", "Coal"),
                new TrainConsistManagement.GoodsBogie("Flatbed", "Steel")
        );
        assertTrue(tcm.isTrainSafetyCompliant(bogies));
    }

    @Test
    void testSafetyNonCompliant_MultipleInvalidCylindricalBogies() {
        List<TrainConsistManagement.GoodsBogie> bogies = List.of(
                new TrainConsistManagement.GoodsBogie("Cylindrical", "Grain"),
                new TrainConsistManagement.GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(tcm.isTrainSafetyCompliant(bogies));
    }
}