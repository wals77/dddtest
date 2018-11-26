package state;

public class GumballMachine {

    State soldOutState;

    State noQuarteState;

    State hasQuarterState;

    State soldState;

    State state = soldOutState;
    int count = 0;

    public GumballMachine(int numberGumballs){
        soldOutState = new SoldOutState(this);
        noQuarteState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        if (numberGumballs > 0){
            state = noQuarteState;
        }
    }


    //投币代码
    public void insertQuarter(){
        state.insertQuarter();
    }

    //退币
    public void ejectQuarter(){
        state.ejectQuarter();
    }

    //转动曲柄
    public void turnCrank(){
        state.turnCrank();
        state.dispense();
    }

    void setState(State state){
        this.state = state;
    }

    void releaseBall(){
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0){
            count = count -1;
        }
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarteState() {
        return noQuarteState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public int getCount() {
        return count;
    }
}


























