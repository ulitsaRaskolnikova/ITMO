package Enums;

public enum Color {
    DEFAULT("невзрачный"),
    BLACK("чёрный"),
    WHITE("белый"),
    BLUE("синий"),
    RED("красный");
    private final String rusColor;
    Color(String rusColor){
        this.rusColor = rusColor;
    }
    public String getRusColor(){
        return rusColor;
    }
}
