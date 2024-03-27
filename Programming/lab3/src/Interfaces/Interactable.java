package Interfaces;

import Enumerations.Intonation;
import Enumerations.WaveStyle;

public interface Interactable {
    void setWaveStyle(WaveStyle style);
    WaveStyle getWaveStyle();
    void setIntonation(Intonation intonation);
    Intonation getIntonation();
}
