package kz.dev.triangle.service;


import kz.dev.triangle.model.Triangle;
import kz.dev.triangle.model.TriangleDTO;

public interface ITriangleCalculatorService {

    public TriangleDTO calculateAreaAndPerimeter(Triangle triangle);


}
