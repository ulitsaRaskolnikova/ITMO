package Enumerations;

public enum Emotion {
    UNPROMISING("бесперспективность"),
    HAPPY("счастье"),
    CURIOS("любопытство");
    private String rusEmotion;
    Emotion(String rusEmotion){
        this.rusEmotion = rusEmotion;
    }
    public String getRusEmotion(){
        return rusEmotion;
    }
}
