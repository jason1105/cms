package com.coinv.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lv-wei on 2018-03-19.
 */
public class MorphTarget {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Float> getVertices() {
        return vertices;
    }

    public void setVertices(List<Float> vertices) {
        this.vertices = vertices;
    }

    String name;
    List<Float> vertices = new ArrayList<Float>();
}
