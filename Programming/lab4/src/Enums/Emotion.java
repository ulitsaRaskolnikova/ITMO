package Enums;

public enum Emotion {
    UNPROMISING("бесперспективность"),
    HAPPY("счастье"),
    ANGRY("злость"),

    CURIOS("любопытство"),
    DESPONDENCY("уныние"),
    FINE("ничего необычного"),
    DISGUSTING("отвращение");
    private String rusEmotion;
    Emotion(String rusEmotion){
        this.rusEmotion = rusEmotion;
    }
    public String getRusEmotion(){
        return rusEmotion;
    }
}
