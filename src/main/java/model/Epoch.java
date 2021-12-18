package model;

import lombok.Data;

@Data
public class Epoch {
    private String EpochName;
    private String EpochUrl;

    public Epoch() {
    }

    public Epoch(String epochName, String epochUrl) {
        EpochName = epochName;
        EpochUrl = epochUrl;
    }
}