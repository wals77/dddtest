package com.disruptor;

import com.lmax.disruptor.WorkHandler;

public class Consumer implements WorkHandler<PcData> {

    public void onEvent(PcData pcData) throws Exception {
        System.out.println(Thread.currentThread().getId()+":Event: --"+pcData.getValue()*pcData.getValue()+"--");
    }
}
