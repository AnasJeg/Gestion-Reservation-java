/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javas.chart;

import java.awt.Color;
import java.util.Date;

/**
 *
 * @author anace
 */
public class ModelPieChart2 {
     private String name;
    private double values;
    private Color color;

    public ModelPieChart2(String name, double values, Color color) {
        this.name = name;
        this.values = values;
        this.color = color;
    }

   
   
    public String getName() {
        return name;
    }

    public double getValues() {
        return values;
    }

    public Color getColor() {
        return color;
    }
    
    
}
