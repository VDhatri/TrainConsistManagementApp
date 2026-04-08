import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class TrainConsistManagementTest {

    @Test
    void testGrouping_BogiesGroupedByType() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<TrainConsistManagement.Bogie> bogies = tcm.createBogies();
        Map<String, List<TrainConsistManagement.Bogie>> grouped = tcm.groupBogiesByType(bogies);

        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("First Class"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("Executive"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<TrainConsistManagement.Bogie> bogies = tcm.createBogies();
        Map<String, List<TrainConsistManagement.Bogie>> grouped = tcm.groupBogiesByType(bogies);

        assertEquals(2, grouped.get("Sleeper").size()); // 72 and 60
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<TrainConsistManagement.Bogie> bogies = tcm.createBogies();
        Map<String, List<TrainConsistManagement.Bogie>> grouped = tcm.groupBogiesByType(bogies);

        assertEquals(1, grouped.get("First Class").size());
        assertEquals(1, grouped.get("AC Chair").size());
        assertEquals(1, grouped.get("Executive").size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        Map<String, List<TrainConsistManagement.Bogie>> grouped = tcm.groupBogiesByType(List.of());

        assertTrue(grouped.isEmpty());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<TrainConsistManagement.Bogie> bogies = tcm.createBogies();
        int originalSize = bogies.size();

        tcm.groupBogiesByType(bogies);
        assertEquals(originalSize, bogies.size());
    }
}