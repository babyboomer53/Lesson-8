package cse41321.container;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework8Test {

    @BeforeMethod
    public void setUp() {
        // Maze #1
        Homework8.Graph<Character, Integer> maze1 = new Homework8.Graph<>();
        // Maze #2
        Homework8.Graph<Character, Integer> maze2 = new Homework8.Graph<>();
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testIsExitReachable() {
    }
}