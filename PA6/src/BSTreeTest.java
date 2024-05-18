import org.junit.jupiter.api.Assertions;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BSTreeTest {

    BSTree<Integer> test1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        test1 = new BSTree<>();
        Iterator<Integer> iter = test1.iterator();
    }

    @org.junit.jupiter.api.Test
    void getRoot() {
        assertEquals(null, test1.getRoot());
    }

    @org.junit.jupiter.api.Test
    void getSize() {
        assertEquals(0, test1.getSize());
    }

    @org.junit.jupiter.api.Test
    void insert() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            test1.insert(null);
        });
        assertEquals(true, test1.insert(25));
        assertEquals(1, test1.getSize());
        assertEquals(false, test1.insert(25));
        assertEquals(1, test1.getSize());
        assertEquals(true, test1.insert(30));
        assertEquals(2, test1.getSize());
    }

    @org.junit.jupiter.api.Test
    void findKey() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            test1.findKey(null);
        });
        test1.insert(25);
        assertEquals(true, test1.findKey(25));
        test1.insert(30);
        assertEquals(true, test1.findKey(30));
        assertEquals(false, test1.findKey(26));

    }

    @org.junit.jupiter.api.Test
    void insertData() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            test1.insertData(25, null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            test1.insertData(25, "Mickey Mouse");
        });
        test1.insert(25);
        test1.insertData(25, "Movies");
    }

    @org.junit.jupiter.api.Test
    void findDataList() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            test1.findDataList(null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            test1.findDataList(25);
        });
        test1.insert(25);
        test1.insertData(25, "Movies");
        assertEquals(true ,test1.findDataList(25).contains("Movies"));

        test1.insertData(25, "Movies2");
        assertEquals(true ,test1.findDataList(25).contains("Movies2"));

        test1.insert(30);
        test1.insertData(30, "Favorite Movie");
        assertEquals(false, test1.findDataList(25).contains("Favorite Movie"));
        assertEquals(true, test1.findDataList(30).contains("Favorite Movie"));
    }

    @org.junit.jupiter.api.Test
    void findHeight() {
        assertEquals(-1, test1.findHeight());
        test1.insert(25);
        assertEquals(0, test1.findHeight());
        test1.insert(20);
        test1.insert(19);
        assertEquals(2, test1.findHeight());
        test1.insert(30);
        assertEquals(2, test1.findHeight());
    }
}