/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javas.chart;

import java.awt.Color;

/**
 *
 * @author anace
 */
public class ModelPieChartALL {
  

    
     private String label;
    private double values[];
    private Color color[];
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double[] getValues() {
        return values;
    }

    public void setValues(double[] values) {
        this.values = values;
    }

      public ModelPieChartALL(String label, double[] values, Color[] color) {
        this.label = label;
        this.values = values;
        this.color = color;
    }
    
    public ModelPieChartALL(String label, double[] values) {
        this.label = label;
        this.values = values;
    }

  


   

    public double getMaxValues() {
        double max = 0;
        for (double v : values) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }
    
}
