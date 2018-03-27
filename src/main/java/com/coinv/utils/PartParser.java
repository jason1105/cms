package com.coinv.utils;


import com.coinv.model.Face4;
import com.coinv.model.JSONModelFormat3;
import com.coinv.model.Metadata;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 转换一个部件到JSON
 * <p>
 * Created by lv-wei on 2018-03-19.
 */
public class PartParser {

    private JSONModelFormat3 ThreeModel;
    private File pointsFile; // #n.xyz
    private File pclFile; // .pcl
    private int coordinateType;
    private int partIndex;
    private int pointsNum;
    private int facesNum;
    private int lineNum;

    public PartParser(String nXyzFile, String pclFile, int partsIndex, int coordinateType, int pointsNum, int lineNum) {

        this.pointsFile = new File(nXyzFile);
        this.pclFile = new File(pclFile);
        this.partIndex = partsIndex;
        this.coordinateType = coordinateType;
        this.pointsNum = pointsNum;
        this.lineNum = lineNum;
        this.init();

    }

    /**
     * @return JSON type of Three.js
     * @throws IOException
     */
    public String getThreeModel() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(ThreeModel);
    }

    public void init() {
        ThreeModel = new JSONModelFormat3();

        try {
            addMetaInfo();
            transVertices();
            transMorphTargets();
            transMaterials();
            transColors();
            transFaces();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addMetaInfo() throws IOException {

        //
        Metadata meta = new Metadata();
        meta.setType("Geometry");
        meta.setMorphTargets(0);
        meta.setVersion(3);
        meta.setVertices(pointsNum);
        meta.setMaterials(0);
        meta.setColors(1);
        meta.setFaces(facesNum);
        ThreeModel.setMeatdata(meta);
    }

    /**
     * Load vertices from #n.xyz file
     *
     * @throws IOException
     */
    private void transVertices() throws IOException {
        // 根据modelType使用不同的方法

        List<String> lines = FileUtils.readLines(pointsFile);

        String line;
        for (int i = 0; i < lines.size(); i++) {
            line = lines.get(i);
            float[] fArrVertices = CoordinateSystemUtils.readCoordinate(coordinateType, line);
            for (int i1 = 0; i1 < fArrVertices.length; i1++) {
                ThreeModel.addVertex(fArrVertices[i1]);
            }
        }
    }

    private void transMorphTargets() throws Exception {
        // TODO
    }

    private void transMaterials() throws Exception {
        // TODO
    }

    private void transColors() throws Exception {
        ThreeModel.addColor(0, 255, 0); // Green
    }

    private void transFaces() throws IOException {

        List<String> lines = FileUtils.readLines(pclFile);

        facesNum = Integer.parseInt(lines.get(0));

        String line;
        for (int i = 2; i < lines.size(); i++) {
            line = lines.get(i);

            if (0 < StringUtils.trimToEmpty(line).length()) {

                String[] items = line.split(" ");

                Face4 face = new Face4(
                        131,
                        Integer.parseInt(items[2]) - 1,
                        Integer.parseInt(items[3]) - 1,
                        Integer.parseInt(items[4]) - 1,
                        Integer.parseInt(items[5]) - 1,
                        0,
                        0,
                        0,
                        0,
                        0);
                ThreeModel.addFace4(face);
            }
        }
    }
}

/**
 *
 */
class CoordinateSystemUtils {

    /**
     * @param mode    1 直角坐标， 2 柱坐标， 3 球坐标
     * @param xyzLine
     * @return 向量数组
     *
     */
    public static float[] readCoordinate(int mode, String xyzLine) {
        float[] fVectors = new float[3];

        if (1 == mode) {
            if (0 < StringUtils.trimToEmpty(xyzLine).length()) {
                String[] sArrVertices = xyzLine.split(" ");
                fVectors[0] = Float.parseFloat(sArrVertices[0]);
                fVectors[1] = Float.parseFloat(sArrVertices[2]);
                fVectors[2] = Float.parseFloat(sArrVertices[1]);
            }
        } else if (2 == mode) {
            // TODO
        } else if (3 == mode) {
            // TODO
        } else {
            // Error
        }

        return fVectors;
    }
}