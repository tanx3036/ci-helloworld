import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsTest {

    @Test
    public void testFindLastNull() {
        // Do not execute fault
        assertThrows(NullPointerException.class, () -> {ArrayUtils.findLast(null, 3);});
    }

    @Test
    public void testFindLastEmpty() {
        // For any input where y appears in the second or later position, there is no error. Also,
        // if x is empty, there is no error.
        assertEquals(-1, ArrayUtils.findLast(new int[]{}, 3));
    }

    @Test
    public void testFindLastNonExistent() {
        assertEquals(-1, ArrayUtils.findLast(new int[]{1, 2}, 3));
    }

    @Test
    public void testFindLastExistsFirstElement() {
        assertEquals(0, ArrayUtils.findLast(new int[]{2, 3, 5}, 2));
    }

    @Test
    public void testOddOrPosNull() {
        // Do not execute fault
        assertThrows(NullPointerException.class, () -> {ArrayUtils.oddOrPos(null);});
    }

    @Test
    public void testOddOrPosAllPositives() {
        // Any nonempty x with only non-negative elements works, because the first part of the
        // compound if-test is not necessary unless the value is negative.
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{1, 2, 3}));
    }

    @Test
    public void testOddOrPositiveBothPositivesAndNegatives() {
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{-3, -2, 0, 1, 4}));
    }

    // ------------------- Additional Tests for countOf -------------------

    @Test
    public void testCountOfNull() {
        // Should throw NullPointerException when the array is null
        assertThrows(NullPointerException.class, () -> { ArrayUtils.countOf(null, 3); });
    }

    @Test
    public void testCountOfEmpty() {
        // When the array is empty, count should be 0 regardless of target value.
        assertEquals(0, ArrayUtils.countOf(new int[]{}, 3));
    }

    @Test
    public void testCountOfNoOccurrence() {
        // When the target does not occur in the array.
        assertEquals(0, ArrayUtils.countOf(new int[]{1, 2, 4}, 3));
    }

    @Test
    public void testCountOfSingleOccurrence() {
        // When the target occurs exactly once.
        assertEquals(1, ArrayUtils.countOf(new int[]{3, 4, 5}, 3));
    }

    @Test
    public void testCountOfMultipleOccurrences() {
        // When the target occurs multiple times.
        assertEquals(3, ArrayUtils.countOf(new int[]{3, 3, 3, 4}, 3));
    }

    @Test
    public void testCountOfMixedElements() {
        // Mixed array where target is present among other numbers.
        int[] array = {3, -1, 3, 0, 3, 5, -3};
        assertEquals(3, ArrayUtils.countOf(array, 3));
    }
}
