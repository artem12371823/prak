import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class car {
    private String marka;
    private String model;
    private String color;

    public String getMarka(int marka) {
        String[] carSplit = carArray[marka-1].split(";");
        return carSplit[0];
    }
    public String getColor(int color) {
        String[] carSplit = carArray[color-1].split(";");
        return carSplit[2];
    }
    public String getModel(int model) {
        String[] carSplit = carArray[model-1].split(";");
        return carSplit[1];
    }
    public void setMarka(String marka) {
        this.marka = marka;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getMarka() {
        return marka;
    }
    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }
    private String[] carArray=new String[1000];
    public String[] getCarArray() {
        return carArray;
    }
    public void setCarArray(String[] carArray) {
        this.carArray = carArray;
    }
}
