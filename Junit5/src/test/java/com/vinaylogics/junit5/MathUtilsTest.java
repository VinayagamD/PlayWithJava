package com.vinaylogics.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

    MathUtils instance;

    int cachedValue = 0;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        instance = new MathUtils();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Adding a method")
    void testAdd() {
        int expected = 2;
        cachedValue = 10;
        int actual = instance.add(1,1);
        assertEquals(expected,actual,  "This add method should add two numbers");
    }

    @Test
    void testComputeCircleArea() {
        assertEquals(314.1592653589793, instance.computeCircleArea(10), "Should return circle area");
    }

    @Test
    @Tag("Math")
//    @EnabledOnOs(OS.LINUX)
    void testDivide() {
        boolean isServerUp = false;
        assumeTrue(isServerUp);
       var exception  = assertThrows(ArithmeticException.class, () -> instance.divide(1,0), "Divide by zero should throw");
//       exception  = assertThrows(ArithmeticException.class, () -> instance.divide(1,2), "Divide by zero should throw");
//        assertThrows(NullPointerException.class, () -> instance.divide(1,0), "Divide by zero should throw");

    }

    @Test
    @DisplayName("multiply method")
    @Tag("Math")
    void testMultiply(){
        testReporter.publishEntry("Running "+testInfo.getDisplayName()+" with tags "+ testInfo.getTags());
        assertAll(
                ()-> assertEquals(4, instance.multiply(2,2)),
                ()-> assertEquals(0, instance.multiply(2,0)),
                ()-> assertEquals(-2, instance.multiply(2,-1))
        );
    }

    @Nested
    @DisplayName("add method")
    @Tag("Math")
    class AddTest {
        @Test
        @DisplayName("when adding two positive numbers")
        void testAddPositive() {
            assertEquals(2,instance.add(1,1), "should return the right sum");
        }
        @Test
        @DisplayName("when adding two negative numbers")
        void testAddNegative() {
            int expected = -2;
            int actual = instance.add(-1,-1);
            assertEquals(expected,actual, "should return sum "+expected+" but returned "+ actual);
        }

    }

    @Test
    @DisplayName("TDD method should not run")
    @Disabled
    void testDisabled(){
        fail("This test should be disabled");
    }

    @RepeatedTest(3)
    @Tag("Circle")
    void testComputeCircleAreaRepeated( RepetitionInfo repetitionInfo) {
        assertEquals(314.1592653589793, instance.computeCircleArea(10), "Should return circle area");
    }

}