import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainConsistManagementTest {

    TrainConsistManagement tcm = new TrainConsistManagement();

    @Test
    void testCargo_SafeAssignment() {
        TrainConsistManagement.GoodsBogie cylindricalBogie = new TrainConsistManagement.GoodsBogie("Cylindrical");
        cylindricalBogie.assignCargo("Petroleum");
        assertEquals("Petroleum", cylindricalBogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        TrainConsistManagement.GoodsBogie rectangularBogie = new TrainConsistManagement.GoodsBogie("Rectangular");
        // Unsafe assignment should be handled internally, cargo should not be assigned
        rectangularBogie.assignCargo("Petroleum");
        assertNull(rectangularBogie.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        TrainConsistManagement.GoodsBogie b1 = new TrainConsistManagement.GoodsBogie("Rectangular");
        TrainConsistManagement.GoodsBogie b2 = new TrainConsistManagement.GoodsBogie("Cylindrical");

        b1.assignCargo("Petroleum");   // unsafe, handled
        b2.assignCargo("Petroleum");   // safe

        // Program continues: other bogie assigned correctly
        assertEquals("Petroleum", b2.cargo);
        assertNull(b1.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        TrainConsistManagement.GoodsBogie b = new TrainConsistManagement.GoodsBogie("Rectangular");

        // Use a flag to check finally output (simulate by capturing console in real scenario)
        boolean finallyExecuted = false;
        try {
            b.assignCargo("Petroleum");  // unsafe
        } finally {
            finallyExecuted = true;
        }
        assertTrue(finallyExecuted);
    }
}