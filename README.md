# triangle

This restful api service receives triangle params as HTTP request and checks for triangle params for composing triangle if given params able to compose triangle calculates its area and perimeter.

## Usages

You have to pull this project and run locally.
Then make HTTP requests as bellow

link = http://localhost:8089/triangle/areaAndPerimeter

request body


{
    "side1": 33,
    "side2": 44,
    "side3": 55
}

Expected result


{
    "side1": 33,
    "side2": 44,
    "side3": 55,
    "perimeter": 132,
    "area": 726.0
}

If triangle params can not composing triangle

Reponds with 

{
    "timestamp": "2021-02-08T14:19:16.177+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "Given sides could not form triangle!",
    "path": "/triangle/areaAndPerimeter"
}



## Prerequsites 

Running locally kafka.

