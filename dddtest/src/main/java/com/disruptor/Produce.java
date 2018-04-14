package com.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

public class Produce {

    private final RingBuffer<PcData> ringBuffer;

    public Produce(RingBuffer<PcData> ringBuffer){
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer bb){
        long sequence = ringBuffer.next();
        try {
            PcData pcData = ringBuffer.get(sequence);
            pcData.setValue(bb.getLong(0));
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}


















