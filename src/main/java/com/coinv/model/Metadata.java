package com.coinv.model;

/**
 * Created by lv-wei on 2018-03-19.
 */
public class Metadata {
    String type;
    int morphTargets;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMorphTargets() {
        return morphTargets;
    }

    public void setMorphTargets(int morphTargets) {
        this.morphTargets = morphTargets;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public int getMaterials() {
        return materials;
    }

    public void setMaterials(int materials) {
        this.materials = materials;
    }

    public int getColors() {
        return colors;
    }

    public void setColors(int colors) {
        this.colors = colors;
    }

    public int getFaces() {
        return faces;
    }

    public void setFaces(int faces) {
        this.faces = faces;
    }

    int version;
    int vertices;
    String generator = "io_three";
    int materials = 0;
    int colors = 1;
    int faces;
}
