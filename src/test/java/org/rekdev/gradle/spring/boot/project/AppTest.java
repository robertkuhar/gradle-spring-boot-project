/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.rekdev.gradle.spring.boot.project;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class AppTest {
    @Test public void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test public void testTheTest() {
        assertEquals(1,1);
    }

}