package mapper;

import entity.EpochEntity;
import model.Epoch;

public class EpochMapper {

    public static Epoch mapEpochEntityToEpoch(EpochEntity epochEntity) {
        Epoch epoch = new Epoch();

        epoch.setEpochName(epochEntity.getEpoch());
        epoch.setEpochUrl(epochEntity.getUrlEpoch());

        return epoch;
    }

    public static EpochEntity mapEpochToEpochEntity(Epoch epoch) {
        EpochEntity epochEntity = new EpochEntity();

        epochEntity.setEpoch(epoch.getEpochName());
        epochEntity.setUrlEpoch(epoch.getEpochUrl());
        return epochEntity;
    }
}