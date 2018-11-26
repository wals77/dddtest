package state;

public class HasQuarterState implements State {

    transient GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("you cant insert another quarter");
    }

    public void ejectQuarter() {
        System.out.println("quarter returned");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    public void turnCrank() {
        System.out.println("you turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    public void dispense() {
        System.out.println("no gumball dispensed");
    }
}
