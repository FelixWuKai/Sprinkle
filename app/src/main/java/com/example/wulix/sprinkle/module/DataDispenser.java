package com.example.wulix.sprinkle.module;

public class DataDispenser {

    private int dispenserNumber;
    private String spiceName;
    private double teaspoonNumb;

    public DataDispenser(int dispenserNumber, String spiceName, double teaspoonNumb) {
        this.dispenserNumber = dispenserNumber;
        this.spiceName = spiceName;
        this.teaspoonNumb = teaspoonNumb;
    }

    public int getDispenserNumber() {
        return dispenserNumber;
    }



    public String getDispenserNumberString(){
        return String.valueOf(dispenserNumber);
    }

    public void setDispenserNumber(int dispenserNumber) {
        this.dispenserNumber = dispenserNumber;
    }

    public String getSpiceName() {
        return spiceName;
    }

    public void setSpiceName(String spiceName) {
        this.spiceName = spiceName;
    }

    public double getTeaspoonNumb() {
        return teaspoonNumb;
    }

    public String getTeaspoonNumbString(){
        return String.valueOf(teaspoonNumb);
    }

    public void setTeaspoonNumb(double teaspoonNumb) {
        this.teaspoonNumb = teaspoonNumb;
    }

    public String generalGetter(){
        return "Dispenser Number: " + getDispenserNumberString() + " Tea Spoons "+getTeaspoonNumbString()+" Spice Name" +getSpiceName();
    }
}
