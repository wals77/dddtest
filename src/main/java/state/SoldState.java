package state;

public class SoldState implements State {

    transient GumballMachine gumballMachine;    //不需要序列化此对象

    public SoldState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("please wait, we are already giving you a gumball");
    }

    public void ejectQuarter() {
        System.out.println("sorry, you already turned the crank");
    }

    public void turnCrank() {
        System.out.println("Turning twice dosent get you another gumball");
    }

    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0){
            gumballMachine.setState(gumballMachine.getNoQuarteState());
        } else {
            System.out.println("oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }

    }
}
