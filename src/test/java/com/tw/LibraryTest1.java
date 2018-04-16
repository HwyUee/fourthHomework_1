package com.tw;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by HwyUee on 2018/4/16.
 */
public class LibraryTest1 {

    @Test
    public void testCheck_StuInfo_Format() throws Exception {
         Library library =new Library();
        String input1 ="张三,123,数学:76,语文:87,英语:65,编程:98";
         assertTrue(library.check_StuInfo_Format(input1));
        String input2 ="张三,123,数学:,语文:87,英语:65,编程:98";
        assertFalse(library.check_StuInfo_Format(input2));
    }

    @Test
    public void testCheck_StuID_Format() throws Exception {
        Library library =new Library();
        String input1 ="123,234,456";
        assertTrue(library.check_StuID_Format(input1));
        String input2 ="1.23,345";
        assertFalse(library.check_StuID_Format(input2));
    }

    @Test
    public void testSaveInfo() throws Exception {

    }

    @Test
    public void testDiffCase() throws Exception {

    }
}