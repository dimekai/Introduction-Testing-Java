package util;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Jesus Diaz
 */
public class StringUtilTest {

    @Test
    public void repeat_string_once() {
        assertEquals("hello", StringUtil.repeat("hello", 1));
    }

    @Test
    public void repeat_string_multiple_times() {
        assertEquals("hellohellohello", StringUtil.repeat("hello", 3));
    }

    @Test
    public void repeat_string_zero_times() {
        assertEquals("", StringUtil.repeat("hello", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times() {
        StringUtil.repeat("hello", -1);
    }

    @Test
    public void no_empty_str() {
        assertFalse(StringUtil.isEmpty("No empty"));
    }

    @Test
    public void empty_str() {
        assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void blank_spaces_str() {
        assertTrue(StringUtil.isEmpty("      "));
    }

    @Test
    public void null_value_str() {
        assertTrue(StringUtil.isEmpty(null));
    }

}
