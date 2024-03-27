package Enums.TypeOfClothes;

public enum TypeOfSocks {
    LONG("длинные"),
    SHORT("короткие"),
    REGULAR("обычные"),
    KNEE("гольфы");
    private final String rusType;
    TypeOfSocks(String rusType) {
        this.rusType = rusType;
    }
    public String getRusType(){
        return rusType;
    }
}
