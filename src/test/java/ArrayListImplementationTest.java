import org.example.ArrayListImplementation;
import org.example.IntegerList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListImplementationTest {

    private IntegerList list;

    @BeforeEach
    public void setUp() {
        list = new ArrayListImplementation();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
    }

    @Test
    public void testAdd() {
        list.add(50);
        assertEquals(5, list.size());
        assertEquals(Integer.valueOf(50), list.get(4));
    }

    @Test
    public void testAddWithIndex() {
        list.add(2, 25);
        assertEquals(5, list.size());
        assertEquals(Integer.valueOf(25), list.get(2));
    }

    @Test
    public void testSet() {
        Integer oldValue = list.set(1, 15);
        assertEquals(Integer.valueOf(20), oldValue);
        assertEquals(Integer.valueOf(15), list.get(1));
        assertEquals(4, list.size());
    }

    @Test
    public void testRemoveByValue() {
        assertTrue(list.contains(30));
        Integer removedElement = list.remove(Integer.valueOf(30));
        assertFalse(list.contains(30));
        assertEquals(Integer.valueOf(30), removedElement);
        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveByIndex() {
        Integer removedElement = list.remove(2);
        assertEquals(Integer.valueOf(30), removedElement);
        assertEquals(3, list.size());
    }

    @Test
    public void testContains() {
        assertTrue(list.contains(40));
        assertFalse(list.contains(50));
    }

    @Test
    public void testIndexOf() {
        assertEquals(0, list.indexOf(10));
        assertEquals(2, list.indexOf(30));
        assertEquals(-1, list.indexOf(50));
    }

    @Test
    public void testLastIndexOf() {
        list.add(30);
        assertEquals(4, list.lastIndexOf(30));
        assertEquals(3, list.lastIndexOf(40));
        assertEquals(-1, list.lastIndexOf(50));
    }

    @Test
    public void testGet() {
        assertEquals(Integer.valueOf(20), list.get(1));
        assertEquals(Integer.valueOf(40), list.get(3));
    }

    @Test
    public void testEquals() {
        IntegerList newList = new ArrayListImplementation();
        newList.add(10);
        newList.add(20);
        newList.add(30);
        newList.add(40);

        assertTrue(list.equals(newList));

        newList.set(2, 35);
        assertFalse(list.equals(newList));
    }

    @Test
    public void testSize() {
        assertEquals(4, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testClear() {
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testToArray() {
        Integer[] expectedArray = {10, 20, 30, 40};
        assertArrayEquals(expectedArray, list.toArray());
    }
}
