package Enums;

public enum WaveStyle {
    HUG("раскрыл(а) широкие объятия"),
    SHAKE_HAND("пожал(а) руку"),
    KISS("поцеловал(а)"),
    NOTHING("ничего не сделал(а)");
    final String actionDescription;
    WaveStyle(String actonDescription){
        this.actionDescription = actonDescription;
    }
    public String getActionDescription(){
        return actionDescription;
    }
}
