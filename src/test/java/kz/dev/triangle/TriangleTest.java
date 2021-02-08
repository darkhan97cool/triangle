package kz.dev.triangle;

import kz.dev.triangle.model.Triangle;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;


@SpringBootTest
public class TriangleTest {

    @Test
    public void testArea() {
        Triangle triangle = new Triangle();
        triangle.setSide1(5);
        triangle.setSide2(3);
        triangle.setSide3(4);

        double area = triangle.getArea();
        assertEquals(6.0,area,0.001);


    }


    @Test
    public void testPerimeter() {
        Triangle triangle = new Triangle();
        triangle.setSide1(5);
        triangle.setSide2(3);
        triangle.setSide3(4);

        double perimeter = triangle.getPerimeter();
        assertEquals(12,perimeter,0.001);

    }
}
