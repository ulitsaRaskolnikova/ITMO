package Enums.TypeOfClothes;

public enum TypeOfJacket {
    CLASSIC("классический"),
    BLAZER("блейзер");
    private final String rusType;
    TypeOfJacket(String rusType){
        this.rusType = rusType;
    }
    public String getRusType(){
        return rusType;
    }
}
