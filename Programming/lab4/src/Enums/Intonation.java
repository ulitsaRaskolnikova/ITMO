package Enums;

public enum Intonation {
    DISGUSTING("отвратительный голос"),
    BEAUTIFUL("прекрасный голос"),
    LOUD("громкий голос"),
    QUIT("тихий голос"),
    NORMAL("обычный голос"),
    NOTHING("молчание");
    private final String intonationDescription;
    Intonation(String intonationDescription){
        this.intonationDescription = intonationDescription;
    }
    public String getIntonationDescription(){
        return intonationDescription;
    }
}
