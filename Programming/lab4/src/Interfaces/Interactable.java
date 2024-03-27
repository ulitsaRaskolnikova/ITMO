package Interfaces;

import Enums.Intonation;
import Enums.WaveStyle;

public interface Interactable {
    void setWaveStyle(WaveStyle style);
    WaveStyle getWaveStyle();
    void setIntonation(Intonation intonation);
    Intonation getIntonation();
}
