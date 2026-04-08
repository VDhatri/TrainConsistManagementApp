import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class TrainConsistManagementTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] bogies = {"Sleeper","AC Chair","First Class","General","Luxury"};
        String[] expected = {"AC Chair","First Class","General","Luxury","Sleeper"};

        TrainConsistManagement.sortBogieNames(bogies);
        assertArrayEquals(expected, bogies);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] bogies = {"Luxury","General","Sleeper","AC Chair"};
        String[] expected = {"AC Chair","General","Luxury","Sleeper"};

        TrainConsistManagement.sortBogieNames(bogies);
        assertArrayEquals(expected, bogies);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] bogies = {"AC Chair","First Class","General"};
        String[] expected = {"AC Chair","First Class","General"};

        TrainConsistManagement.sortBogieNames(bogies);
        assertArrayEquals(expected, bogies);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] bogies = {"Sleeper","AC Chair","Sleeper","General"};
        String[] expected = {"AC Chair","General","Sleeper","Sleeper"};

        TrainConsistManagement.sortBogieNames(bogies);
        assertArrayEquals(expected, bogies);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] bogies = {"Sleeper"};
        String[] expected = {"Sleeper"};

        TrainConsistManagement.sortBogieNames(bogies);
        assertArrayEquals(expected, bogies);
    }
}