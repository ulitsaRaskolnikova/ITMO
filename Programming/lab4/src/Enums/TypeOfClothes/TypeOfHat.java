package Enums.TypeOfClothes;

public enum TypeOfHat {
    TOP_HAT("цилиндр"),
    COWBOY("ковбойская");
    private String rusType;
    TypeOfHat(String rusType){
        this.rusType = rusType;
    }
    public String getRusType(){
        return rusType;
    }
}
