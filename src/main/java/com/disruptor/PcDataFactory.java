package com.disruptor;

import com.lmax.disruptor.EventFactory;

public class PcDataFactory implements EventFactory<PcData> {
    public PcData newInstance() {
        return new PcData();
    }
}
