import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BSTreeTest {

    BSTree<Integer> test1;
//    Iterator<Integer> iter;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        test1 = new BSTree<>();
//        iter = test1.iterator();
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
            test1.insertData(25, 5);
        });
        test1.insert(25);
        test1.insertData(25, 5);
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
        test1.insertData(25, 5);
        assertEquals(true ,test1.findDataList(25).contains(5));

        test1.insertData(25, 6);
        assertEquals(true ,test1.findDataList(25).contains(6));

        test1.insert(30);
        test1.insertData(30, 4);
        assertEquals(false, test1.findDataList(25).contains(4));
        assertEquals(true, test1.findDataList(30).contains(4));
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

    @Test
    void iteratorTest(){
        test1.insert(8);
        test1.insert(3);
        test1.insert(1);
        Iterator<Integer> iter = test1.iterator();
        assertEquals(1, iter.next());
        assertEquals(3, iter.next());
        assertEquals(8, iter.next());
        assertFalse(iter.hasNext());
        Assertions.assertThrows(NoSuchElementException.class,()->{
            iter.next();
        });
        test1.insert(1);
        test1.insert(6);
        test1.insert(4);
        Iterator<Integer> iter2 = test1.iterator();
        assertEquals(1, iter2.next());
        assertEquals(3, iter2.next());
        assertEquals(4, iter2.next());
        test1.insert(7);
        test1.insert(14);
        test1.insert(13);
        Iterator<Integer> iter3 = test1.iterator();
        assertTrue(iter3.hasNext());
        assertEquals(1, iter3.next());
        assertEquals(3, iter3.next());
        assertEquals(4, iter3.next());
        assertEquals(6, iter3.next());
        assertEquals(7, iter3.next());
    }
}