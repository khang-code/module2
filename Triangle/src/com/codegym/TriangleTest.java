package com.codegym;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TriangleTest {
    @Test
    public void testEquilateralTriangle() {
        assertEquals("tam giác đều", Triangle.classifyTriangle(2, 2, 2));
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals("tam giác cân", Triangle.classifyTriangle(2, 2, 3));
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals("tam giác thường", Triangle.classifyTriangle(3, 4, 5));
    }

    @Test
    public void testNotATriangle() {
        assertEquals("không phải là tam giác", Triangle.classifyTriangle(8, 2, 3));
    }

    @Test
    public void testNegativeSides() {
        assertEquals("không phải là tam giác", Triangle.classifyTriangle(-1, 2, 1));
    }

    @Test
    public void testZeroSide() {
        assertEquals("không phải là tam giác", Triangle.triangle(0, 1, 1));
    }
}
}
