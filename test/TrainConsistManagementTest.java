import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TrainConsistManagementTest {

    @Test
    void testReduce_TotalSeatCalculation() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<TrainConsistManagement.Bogie> bogies = tcm.createBogies();
        int total = tcm.totalSeats(bogies);

        assertEquals(24 + 72 + 56 + 80 + 60, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<TrainConsistManagement.Bogie> bogies = tcm.createBogies();
        int total = tcm.totalSeats(bogies);

        assertTrue(total > 0);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<TrainConsistManagement.Bogie> bogies = List.of(new TrainConsistManagement.Bogie("Single", 50));
        int total = tcm.totalSeats(bogies);

        assertEquals(50, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        int total = tcm.totalSeats(List.of());

        assertEquals(0, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<TrainConsistManagement.Bogie> bogies = tcm.createBogies();
        int originalSize = bogies.size();

        tcm.totalSeats(bogies);
        assertEquals(originalSize, bogies.size());
    }
}