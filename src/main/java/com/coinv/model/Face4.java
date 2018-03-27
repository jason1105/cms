package com.coinv.model;

/**
 * Created by lv-wei on 2018-03-19.
 */
public class Face4 {
    int mode = 131; // Three.js format
    int a, b, c, d; // index of vertices
    int m; // index of material
    int ac, bc, cc, dc; // index of colors

    public Face4(int mode, int a, int b, int c, int d, int m, int ac, int bc, int cc, int dc) {
        this.mode = mode;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.m = m;
        this.ac = ac;
        this.bc = bc;
        this.cc = cc;
        this.dc = dc;
    }
}
