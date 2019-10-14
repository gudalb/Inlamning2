package se.nackademin;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GymUtilTest {

    @Test
    void testPersonnummerTest() {
        TestCase.assertFalse(GymUtil.testPersonnummer("awdawd"));
        TestCase.assertFalse(GymUtil.testPersonnummer("123"));
        TestCase.assertFalse(GymUtil.testPersonnummer("12345678910"));
        TestCase.assertTrue(GymUtil.testPersonnummer("1234567890"));
    }
}