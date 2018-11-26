package state;

public class SoldOutState implements State {

    transient GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("sorry ,there is no has Quater");
    }

    public void ejectQuarter() {
        System.out.println("sorry ,there is no has Quater");
    }

    public void turnCrank() {
        System.out.println("sorry ,there is no has Quater");
    }

    public void dispense() {
        System.out.println("sorry ,there is no has Quater");
    }
}
