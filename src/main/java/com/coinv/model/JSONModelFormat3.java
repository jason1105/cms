package com.coinv.model;

import java.util.ArrayList;
import java.util.List;

/**
 * For Three.js, see https://github.com/mrdoob/three.js/wiki/JSON-Model-format-3.
 * Created by lv-wei on 2018-03-19.
 */
public class JSONModelFormat3 {

    private List<Float> vertices;
    private List<MorphTarget> morphTargets;
    private Metadata meatdata;
    private List<Material> materials;
    private List<Integer> colors;
    private List<Integer> faces;

    public JSONModelFormat3() {

        materials = new ArrayList();
        vertices = new ArrayList<Float>();
        morphTargets = new ArrayList<MorphTarget>();
        faces = new ArrayList<Integer>();
        colors = new ArrayList<Integer>();
        meatdata = new Metadata();
    }

    public JSONModelFormat3 addVertex(float vertex) {
        vertices.add(vertex);
        return this;
    }

    public JSONModelFormat3 addVertices(List<Float> vertices) {
        vertices.addAll(vertices);
        return this;
    }

    public JSONModelFormat3 addMorphTarget(MorphTarget morphTarget) {
        morphTargets.add(morphTarget);
        return this;
    }

    public JSONModelFormat3 addMorphTargets(List<MorphTarget> morphTargets) {
        morphTargets.addAll(morphTargets);
        return this;
    }

    public JSONModelFormat3 addColor(int red, int green, int blue) {
        this.colors.add((red << 16) + (green << 8) + blue);
        return this;
    }

    public JSONModelFormat3 addFace4(Face4 face) {
        this.faces.add(face.mode);
        this.faces.add(face.a);
        this.faces.add(face.b);
        this.faces.add(face.c);
        this.faces.add(face.d);
        this.faces.add(face.m);
        this.faces.add(face.ac);
        this.faces.add(face.bc);
        this.faces.add(face.cc);
        this.faces.add(face.dc);

        return this;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public JSONModelFormat3 setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
        return this;
    }

    public List<Float> getVertices() {
        return vertices;
    }

    public JSONModelFormat3 setVertices(ArrayList<Float> vertices) {
        this.vertices = vertices;
        return this;
    }

    public List<MorphTarget> getMorphTargets() {
        return morphTargets;
    }

    public JSONModelFormat3 setMorphTargets(ArrayList<MorphTarget> morphTargets) {
        this.morphTargets = morphTargets;
        return this;
    }

    public List<Integer> getFaces() {
        return faces;
    }

    public JSONModelFormat3 setFaces(ArrayList<Integer> faces) {
        this.faces = faces;
        return this;
    }

    public List<Integer> getColors() {
        return colors;
    }

    public JSONModelFormat3 setColors(ArrayList<Integer> colors) {
        this.colors = colors;
        return this;
    }

    public Metadata getMeatdata() {
        return meatdata;
    }

    public JSONModelFormat3 setMeatdata(Metadata meatdata) {
        this.meatdata = meatdata;
        return this;
    }

}

