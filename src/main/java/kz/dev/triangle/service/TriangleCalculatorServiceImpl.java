package kz.dev.triangle.service;

import kz.dev.triangle.kafka.stream.ITriangleEventStream;
import kz.dev.triangle.model.Triangle;
import kz.dev.triangle.model.TriangleDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class TriangleCalculatorServiceImpl implements ITriangleCalculatorService {


    @Autowired
    private ITriangleEventStream iTriangleEventStream;

    @Override
    public TriangleDTO calculateAreaAndPerimeter(Triangle triangle) {

        TriangleDTO triangleDTO = new TriangleDTO();

        if (triangle.checkValidity()) {

            int perimeter = triangle.getPerimeter();

            double area = triangle.getArea();


            triangleDTO.setSide1(triangle.getSide1());
            triangleDTO.setSide2(triangle.getSide2());
            triangleDTO.setSide3(triangle.getSide3());
            triangleDTO.setArea(area);
            triangleDTO.setPerimeter(perimeter);

            Message<TriangleDTO> message = MessageBuilder.withPayload(triangleDTO)
                    .setHeader("type", "triangleEvent")
                    .build();

            iTriangleEventStream.activeChangeProcess().send(message);

            return triangleDTO;
        }
        else{

            Message<String> message = MessageBuilder.withPayload("Given sides could not form triangle!")
                    .setHeader("type", "triangleEventErrorMessage")
                    .build();

            iTriangleEventStream.activeChangeProcess().send(message);
            throw new ResponseStatusException(  HttpStatus.BAD_REQUEST, "Given sides could not form triangle!");
        }
    }
}
