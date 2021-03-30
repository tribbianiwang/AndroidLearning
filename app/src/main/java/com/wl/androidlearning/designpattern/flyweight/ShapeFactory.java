package com.wl.androidlearning.designpattern.flyweight;

import java.util.HashMap;

public class ShapeFactory {

    private static final HashMap<String,Shape> circleMap = new HashMap();

    public static Circle createCircle(Circle circle){

        Circle resultCircle=(Circle)circleMap.get(circle.getColor());
        if(resultCircle==null){
            resultCircle = circle;
            circleMap.put(circle.getColor(),circle);
        }
        return resultCircle;


    }

}
