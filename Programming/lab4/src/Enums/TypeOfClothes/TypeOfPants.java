package Enums.TypeOfClothes;

public enum TypeOfPants {
    JEANS("джинсы"),
    TROUSERS("брюки"),
    SPORT("спортивные");
    private final String rusType;
    TypeOfPants(String rusType){
        this.rusType = rusType;
    }
    public String getRusType(){
        return rusType;
    }
}
