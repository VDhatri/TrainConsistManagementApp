import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrainConsistManagementTest {

    TrainConsistManagement tcm = new TrainConsistManagement();

    @Test
    void testSort_BasicSorting() {
        int[] arr = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};

        TrainConsistManagement.bubbleSortCapacities(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] arr = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};

        TrainConsistManagement.bubbleSortCapacities(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_DuplicateValues() {
        int[] arr = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};

        TrainConsistManagement.bubbleSortCapacities(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_SingleElementArray() {
        int[] arr = {50};
        int[] expected = {50};

        TrainConsistManagement.bubbleSortCapacities(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_AllEqualValues() {
        int[] arr = {40, 40, 40};
        int[] expected = {40, 40, 40};

        TrainConsistManagement.bubbleSortCapacities(arr);
        assertArrayEquals(expected, arr);
    }
}