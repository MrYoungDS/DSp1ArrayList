import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyArrayListTest {

    private MyArrayList smallMAL;
    private MyArrayList bigMAL;

    @BeforeEach
    public void setup() {
        smallMAL = new MyArrayList();
        bigMAL = new MyArrayList();
    }

    @Test
    public void testSmallSimple() {
        assertTrue(smallMAL.isEmpty(), "Array list should be empty after being constructed.");
        assertEquals(0, smallMAL.size(), "Array list should contain zero elements after being constructed.");

        smallMAL.add(100);
        assertFalse(smallMAL.isEmpty(), "Array list should not be empty.");
        assertEquals(100, smallMAL.get(0), "The element at index 0 should be 100.");
        assertEquals(1, smallMAL.size(), "The array list should contain one element.");

        smallMAL.add(101);
        assertEquals(100, smallMAL.get(0), "The element at index 0 should be 100.");
        assertEquals(101, smallMAL.get(1), "The element at index 1 should be 101.");
        assertEquals(2, smallMAL.size(), "The array list should contain two elements.");

        smallMAL.add(102);
        assertEquals(100, smallMAL.get(0), "The element at index 0 should be 100.");
        assertEquals(101, smallMAL.get(1), "The element at index 1 should be 101.");
        assertEquals(102, smallMAL.get(2), "The element at index 2 should be 102.");
        assertEquals(3, smallMAL.size(), "The array list should contain three elements.");

        smallMAL.set(1, 201);
        assertEquals(201, smallMAL.get(1), "The element at index 1 should have updated to 202.");

        assertEquals(102, smallMAL.remove(2));
        assertEquals(100, smallMAL.get(0), "The element at index 0 after remove should be 100.");
        assertEquals(201, smallMAL.get(1), "The element at index 1 after remove should be 201.");
        assertEquals(2, smallMAL.size(), "The array list after remove should contain two elements.");

        assertEquals(201, smallMAL.remove(1));
        assertEquals(100, smallMAL.get(0), "The element at index 0 after remove should be 100.");
        assertEquals(1, smallMAL.size(), "The array list after remove should contain two elements.");

        assertEquals(100, smallMAL.remove(0));
        assertTrue(smallMAL.isEmpty(), "Array list should be empty after remove.");
        assertEquals(0, smallMAL.size(), "Array list should contain zero elements after remove.");
    }

    @Test
    public void testSmallComplex() {
        smallMAL.add(18);
        smallMAL.add(45);
        smallMAL.add(67);
        smallMAL.add(73);
        smallMAL.add(88); // 18, 45, 67, 73, 88

        assertEquals(5, smallMAL.size());
        assertEquals(18, smallMAL.get(0));
        assertEquals(45, smallMAL.get(1));
        assertEquals(67, smallMAL.get(2));
        assertEquals(73, smallMAL.get(3));
        assertEquals(88, smallMAL.get(4));

        smallMAL.add(1, 34);
        smallMAL.add(1, 22);
        smallMAL.add(0, 9);
        smallMAL.add(8, 91);
        smallMAL.add(5, 56); // 9, 18, 22, 34, 45, 56, 67, 73, 88, 91

        assertEquals(10, smallMAL.size());
        assertEquals(9, smallMAL.get(0));
        assertEquals(18, smallMAL.get(1));
        assertEquals(22, smallMAL.get(2));
        assertEquals(34, smallMAL.get(3));
        assertEquals(45, smallMAL.get(4));
        assertEquals(56, smallMAL.get(5));
        assertEquals(67, smallMAL.get(6));
        assertEquals(73, smallMAL.get(7));
        assertEquals(88, smallMAL.get(8));
        assertEquals(91, smallMAL.get(9));

        smallMAL.remove(7); // remove 73
        smallMAL.remove(3); // remove 34
        smallMAL.remove(0); // remove 9
        smallMAL.remove(6); // remove 91
        smallMAL.remove(2); // 18, 22, 56, 67, 88

        assertEquals(5, smallMAL.size());
        assertEquals(18, smallMAL.get(0));
        assertEquals(22, smallMAL.get(1));
        assertEquals(56, smallMAL.get(2));
        assertEquals(67, smallMAL.get(3));
        assertEquals(88, smallMAL.get(4));

        smallMAL.remove(3); // remove 67
        smallMAL.remove(3); // remove 88
        smallMAL.remove(0); // remove 18
        smallMAL.remove(1); // remove 56
        smallMAL.remove(0); // remove 22

        assertTrue(smallMAL.isEmpty());
        assertEquals(0, smallMAL.size());
    }

    @Test
    public void testLargeSimple() {
        int max = 100000;
        for(int i = 0; i < max; i++){
            assertEquals(i, bigMAL.size());
            bigMAL.add(i);
        }
        for(int i = max; i > 0; i--){
            assertEquals(i, bigMAL.size());
            bigMAL.remove(i - 1);
        }
    }

    @Test
    public void testFinders() {
        smallMAL.add(21);
        smallMAL.add(-64);
        smallMAL.add(94);
        smallMAL.add(-72);
        smallMAL.add(84);
        smallMAL.add(-28);

        assertTrue(smallMAL.contains(21), "Contains cannot find element 21.");
        assertTrue(smallMAL.contains(-64), "Contains cannot find element -64.");
        assertTrue(smallMAL.contains(94), "Contains cannot find element 94.");
        assertTrue(smallMAL.contains(-72), "Contains cannot find element -72.");
        assertTrue(smallMAL.contains(84), "Contains cannot find element 84.");
        assertTrue(smallMAL.contains(-28), "Contains cannot find element -28.");

        assertFalse(smallMAL.contains(0), "Contains thinks it found element 0.");
        assertFalse(smallMAL.contains(-55), "Contains thinks it found element -55.");
        assertFalse(smallMAL.contains(60), "Contains thinks it found element 60.");
        assertFalse(smallMAL.contains(-38), "Contains thinks it found element -38.");
        assertFalse(smallMAL.contains(93), "Contains thinks it found element 93.");
        assertFalse(smallMAL.contains(Integer.MAX_VALUE), "Contains thinks it found a big element.");

        assertEquals(0, smallMAL.indexOf(21), "IndexOf cannot find element 21.");
        assertEquals(1, smallMAL.indexOf(-64), "IndexOf cannot find element -64.");
        assertEquals(2, smallMAL.indexOf(94), "IndexOf cannot find element 94.");
        assertEquals(3, smallMAL.indexOf(-72), "IndexOf cannot find element -72.");
        assertEquals(4, smallMAL.indexOf(84), "IndexOf cannot find element 84.");
        assertEquals(5, smallMAL.indexOf(-28), "IndexOf cannot find element -28.");

        assertEquals(-1, smallMAL.indexOf(0), "IndexOf thinks it found element 0.");
        assertEquals(-1, smallMAL.indexOf(-55), "IndexOf thinks it found element -55.");
        assertEquals(-1, smallMAL.indexOf(60), "IndexOf thinks it found element 60.");
        assertEquals(-1, smallMAL.indexOf(-38), "IndexOf thinks it found element -38.");
        assertEquals(-1, smallMAL.indexOf(93), "IndexOf thinks it found element 93.");
        assertEquals(-1, smallMAL.indexOf(Integer.MAX_VALUE), "IndexOf thinks it found a big element.");
    }

    @Test
    public void testIndexOutOfBoundsException(){
        assertThrows(IndexOutOfBoundsException.class,
                () -> smallMAL.add(-1, 102),
                "Trying to add at index -1 should throw OOB.");
        assertThrows(IndexOutOfBoundsException.class,
                () -> smallMAL.add(2, 102),
                "Trying to add at index 2 after being constructed should throw OOB.");
        smallMAL.add(100);
        smallMAL.add(101);
        smallMAL.add(102);
        assertThrows(IndexOutOfBoundsException.class,
                () -> smallMAL.add(5, 105),
                "Trying to add at index 5 when size is three should throw OOB.");
    }
}
