import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

public class TrainConsistManagementTest {

    TrainConsistManagement tcm = new TrainConsistManagement();


    @Test
    void testException_ValidCapacityCreation() throws TrainConsistManagement.InvalidCapacityException {
        TrainConsistManagement.PassengerBogie bogie = new TrainConsistManagement.PassengerBogie("Sleeper", 72);
        assertEquals("Sleeper", bogie.type);
        assertEquals(72, bogie.capacity);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagement.InvalidCapacityException.class,
                () -> new TrainConsistManagement.PassengerBogie("AC Chair", -10)
        );
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagement.InvalidCapacityException.class,
                () -> new TrainConsistManagement.PassengerBogie("First Class", 0)
        );
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws TrainConsistManagement.InvalidCapacityException {
        TrainConsistManagement.PassengerBogie bogie = new TrainConsistManagement.PassengerBogie("Sleeper", 50);
        assertEquals("Sleeper", bogie.type);
        assertEquals(50, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws TrainConsistManagement.InvalidCapacityException {
        TrainConsistManagement.PassengerBogie b1 = new TrainConsistManagement.PassengerBogie("Sleeper", 72);
        TrainConsistManagement.PassengerBogie b2 = new TrainConsistManagement.PassengerBogie("AC Chair", 80);
        TrainConsistManagement.PassengerBogie b3 = new TrainConsistManagement.PassengerBogie("First Class", 100);

        assertEquals(72, b1.capacity);
        assertEquals(80, b2.capacity);
        assertEquals(100, b3.capacity);
    }
}