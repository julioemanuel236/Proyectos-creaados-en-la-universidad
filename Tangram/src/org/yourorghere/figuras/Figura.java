/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere.figuras;

import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class Figura {    
    private ArrayList<Point> polygon;
    private float radio;
    private float x;
    private float y;
    private float rotacion;
    private float z = -6f;
    
    public Figura(ArrayList<Point> polygon){
        this.polygon = polygon;
    }
    
    public Figura(){}
    
    public boolean pointInPolygon(Point point) {
        Path2D path = new Path2D.Double();
 
        // Move to the first point in the polygon
        path.moveTo(polygon.get(0).x, polygon.get(0).y);
 
        // Connect the points in the polygon
        for (int i = 1; i < polygon.size(); i++) {
            path.lineTo(polygon.get(i).x, polygon.get(i).y);
        }
 
        // Close the path
        path.closePath();
 
        // Create a Point2D object for the test point
        Point2D testPoint = new Point2D.Double(point.x, point.y);
 
        // Check if the test point is inside the polygon
        return path.contains(testPoint);
    }    

    public ArrayList<Point> getPolygon() {
        return polygon;
    }

    public void setPolygon(ArrayList<Point> polygon) {
        this.polygon = polygon;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getRotacion() {
        return rotacion;
    }

    public void setRotacion(float rotacion) {
        this.rotacion = rotacion;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    
    public void mover(int dx, int dy) {
        x+=dx;
        y+=dy;
    }
    
}
