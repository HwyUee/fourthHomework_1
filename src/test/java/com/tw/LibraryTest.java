package com.tw;

import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTest {
    @Test
    public void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }

    @Test
    public void testMockClass() throws Exception {
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);
        // stubbing appears before the actual execution
        String value = "first";
        when(mockedList.get(0)).thenReturn(value);

        assertEquals(mockedList.get(0), value);

    }

    @Test
    public void testCheck_StuInfo_Format() throws Exception {
        Library library = new Library();
        String input1 = "张三,123,数学:76,语文:87,英语:65,编程:98";
        assertTrue(library.check_StuInfo_Format(input1));
        String input2 = "张三,123,数学:,语文:87,英语:65,编程:98";
        assertFalse(library.check_StuInfo_Format(input2));
    }

    @Test
    public void testCheck_StuID_Format() throws Exception {
        Library library = new Library();
        String input1 = "123,234,456";
        assertTrue(library.check_StuID_Format(input1));
        String input2 = "1.23,345";


    }
}
