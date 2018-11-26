package state;

import java.io.Serializable;

public interface State extends Serializable {

    //投币
    void insertQuarter();

    //退币
    void ejectQuarter();

    //转动曲柄
    void turnCrank();

    //发放糖果
    void dispense();
}
