import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

public class TrainConsistManagementTest {

    TrainConsistManagement tcm = new TrainConsistManagement();

    // --- UC13: Loop vs Stream Tests ---

    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistManagement.PassengerBogie> bogies = List.of(
                new TrainConsistManagement.PassengerBogie("Sleeper", 72),
                new TrainConsistManagement.PassengerBogie("AC Chair", 50),
                new TrainConsistManagement.PassengerBogie("First Class", 80)
        );
        List<TrainConsistManagement.PassengerBogie> filtered = tcm.filterBogiesLoop(bogies, 60);
        assertEquals(2, filtered.size());
        assertTrue(filtered.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistManagement.PassengerBogie> bogies = List.of(
                new TrainConsistManagement.PassengerBogie("Sleeper", 72),
                new TrainConsistManagement.PassengerBogie("AC Chair", 50),
                new TrainConsistManagement.PassengerBogie("First Class", 80)
        );
        List<TrainConsistManagement.PassengerBogie> filtered = tcm.filterBogiesStream(bogies, 60);
        assertEquals(2, filtered.size());
        assertTrue(filtered.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistManagement.PassengerBogie> bogies = List.of(
                new TrainConsistManagement.PassengerBogie("Sleeper", 72),
                new TrainConsistManagement.PassengerBogie("AC Chair", 50),
                new TrainConsistManagement.PassengerBogie("First Class", 80)
        );
        List<TrainConsistManagement.PassengerBogie> loopFiltered = tcm.filterBogiesLoop(bogies, 60);
        List<TrainConsistManagement.PassengerBogie> streamFiltered = tcm.filterBogiesStream(bogies, 60);
        assertEquals(loopFiltered.size(), streamFiltered.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long elapsed = tcm.measureExecutionTime(() -> {
            tcm.filterBogiesLoop(new ArrayList<>(), 60);
        });
        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistManagement.PassengerBogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new TrainConsistManagement.PassengerBogie("Sleeper", i % 100));
        }
        List<TrainConsistManagement.PassengerBogie> loopFiltered = tcm.filterBogiesLoop(bogies, 60);
        List<TrainConsistManagement.PassengerBogie> streamFiltered = tcm.filterBogiesStream(bogies, 60);
        assertEquals(loopFiltered.size(), streamFiltered.size());
        assertTrue(loopFiltered.stream().allMatch(b -> b.capacity > 60));
    }
}