package kz.dev.triangle.model;

import lombok.*;

@Data
public class Triangle {

    private int side1;

    private int side2;

    private int side3;


    public int getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getArea() {
        double p = 1.0 * getPerimeter() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    public Boolean checkValidity()
    {
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1)
            return false;
        else
            return true;
    }
}
