package com.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newCachedThreadPool();
        PcDataFactory factory = new PcDataFactory();
        int bufferSize = 16;
        Disruptor<PcData> disruptor = new Disruptor<PcData>(factory,bufferSize,executor,ProducerType.MULTI, new BlockingWaitStrategy());
        disruptor.handleEventsWithWorkerPool(new Consumer(),new Consumer(),new Consumer(),new Consumer());
        disruptor.start();
        RingBuffer<PcData> ringBuffer = disruptor.getRingBuffer();
        Produce produce = new Produce(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++){
            bb.putLong(0,l);
            produce.pushData(bb);
            Thread.sleep(100);
            System.out.println("add data "+l);
        }
    }
}
