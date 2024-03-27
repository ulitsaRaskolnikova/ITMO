package Enumerations.TypeOfClothes;

public enum TypeOfJacket {
    CLASSIC("классический"),
    BLAZER("блейзер");
    private String rusType;
    TypeOfJacket(String rusType){
        this.rusType = rusType;
    }
    public String getRusType(){
        return rusType;
    }
}
