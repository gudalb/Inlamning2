package se.nackademin;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GymUtilTest {

    @Test
    void validatePersonnummerTest() {
        TestCase.assertFalse(GymUtil.validatePersonnummer("awdawd"));
        TestCase.assertFalse(GymUtil.validatePersonnummer("123"));
        TestCase.assertFalse(GymUtil.validatePersonnummer("12345678910"));
        TestCase.assertTrue(GymUtil.validatePersonnummer("1234567890"));
    }

    @Test
    void validateNameTest() {
        TestCase.assertFalse(GymUtil.validateName("ab"));
        TestCase.assertTrue(GymUtil.validateName("alf"));
        TestCase.assertTrue(GymUtil.validateName("dawdawdawdawdawd wdawdawd"));
    }

    @Test
    void addingAttendanceObjAddsToList () {
        int sizeStart = GymUtil.attendanceList.size();
        new Attendance("1234567890", "Klas");
        TestCase.assertTrue(GymUtil.attendanceList.size() > sizeStart);
    }
}