package Enumerations.TypeOfClothes;

public enum TypeOfPants {
    JEANS("джинсы"),
    TROUSERS("брюки"),
    SPORT("спортивные");
    private String rusType;
    TypeOfPants(String rusType){
        this.rusType = rusType;
    }
    public String getRusType(){
        return rusType;
    }
}
