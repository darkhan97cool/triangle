package kz.dev.triangle.rest;

import kz.dev.triangle.model.Triangle;
import kz.dev.triangle.model.TriangleDTO;
import kz.dev.triangle.service.ITriangleCalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@Slf4j
@RequestMapping("triangle")
public class RestController {


    @Autowired
    private ITriangleCalculatorService calculatorService;

    @PostMapping(value = "calculate/areaAndPerimeter")
    ResponseEntity<TriangleDTO> getProcessHistory(@RequestBody Triangle triangle) {

        log.info("Received POST calculate/areaAndPerimeter of triangle with params: {}", triangle);

        TriangleDTO triangleDTO = calculatorService.calculateAreaAndPerimeter(triangle);

        return new ResponseEntity<>(triangleDTO, HttpStatus.OK);

    }
}
