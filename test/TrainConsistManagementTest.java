import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TrainConsistManagementTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<TrainConsistManagement.Bogie> bogies = tcm.createBogies();
        List<TrainConsistManagement.Bogie> filtered = tcm.filterHighCapacityBogies(bogies, 70);

        assertTrue(filtered.stream().allMatch(b -> b.capacity > 70));
        assertEquals(2, filtered.size()); // Sleeper 72, Executive 80
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<TrainConsistManagement.Bogie> bogies = tcm.createBogies();
        List<TrainConsistManagement.Bogie> filtered = tcm.filterHighCapacityBogies(bogies, 72);

        assertTrue(filtered.stream().allMatch(b -> b.capacity > 72));
        assertEquals(1, filtered.size()); // Executive 80
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<TrainConsistManagement.Bogie> bogies = tcm.createBogies();
        List<TrainConsistManagement.Bogie> filtered = tcm.filterHighCapacityBogies(bogies, 100);

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<TrainConsistManagement.Bogie> bogies = tcm.createBogies();
        List<TrainConsistManagement.Bogie> filtered = tcm.filterHighCapacityBogies(bogies, 50);

        assertEquals(3, filtered.size()); // Sleeper 72, AC Chair 56, Executive 80
    }

    @Test
    void testFilter_NoBogiesMatching() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<TrainConsistManagement.Bogie> bogies = tcm.createBogies();
        List<TrainConsistManagement.Bogie> filtered = tcm.filterHighCapacityBogies(bogies, 200);

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<TrainConsistManagement.Bogie> bogies = tcm.createBogies();
        List<TrainConsistManagement.Bogie> filtered = tcm.filterHighCapacityBogies(bogies, 10);

        assertEquals(bogies.size(), filtered.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<TrainConsistManagement.Bogie> filtered = tcm.filterHighCapacityBogies(List.of(), 50);

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        TrainConsistManagement tcm = new TrainConsistManagement();
        List<TrainConsistManagement.Bogie> bogies = tcm.createBogies();
        int originalSize = bogies.size();

        tcm.filterHighCapacityBogies(bogies, 60);
        assertEquals(originalSize, bogies.size()); // original list remains unchanged
    }
}