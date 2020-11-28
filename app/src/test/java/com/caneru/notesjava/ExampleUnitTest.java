package com.caneru.notesjava;

import android.text.format.DateUtils;

import com.caneru.notesjava.model.Note;
import com.caneru.notesjava.service.LocalStore;
import com.caneru.notesjava.service.SharedPrefsLocalStore;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}