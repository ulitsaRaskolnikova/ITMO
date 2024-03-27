package Enums;

public enum Aroma {
    MINT("мята"),
    STRAWBERRY("клубника"),
    NOTHING("ничего");
    String rusType;
    Aroma(String rusType){
        this.rusType = rusType;
    }
    public String getRusType(){
        return rusType;
    }
}
