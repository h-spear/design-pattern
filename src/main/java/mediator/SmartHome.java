package mediator;

public class SmartHome implements Mediator {

    public Door door = new Door(this);
    public Window window = new Window(this);
    public CoolAircon aircon = new CoolAircon(this);
    public HeatBoiler boiler = new HeatBoiler(this);

    /**
     * Mediate
     * Colleague(동료, 참여자) 객체간의 관계가 하나의 메서드에 집중되어 있다.
     * Colleague의 관계는 자주 변경될 수 있으므로 한 곳에 모아서 관리한다.
     */
    @Override
    public void colleagueChanged(Colleague colleague) {
        // 문이 열리면 에어컨과 보일러를 끈다
        if (colleague == door && !door.isClosed()) {
            aircon.off();
            boiler.off();
        }

        // 창문이 열리면 에어컨과 보일러를 끈다
        if (colleague == window && !window.isClosed()) {
            aircon.off();
            boiler.off();
        }

        // 에어컨이 켜지면 보일러를 끄고 창문과 문을 닫는다.
        if (colleague == aircon && aircon.isRunning()) {
            boiler.off();
            window.close();
            door.close();
        }

        // 보일러이 켜지면 에어컨을 끄고 창문과 문을 닫는다.
        if (colleague == boiler && boiler.isRunning()) {
            aircon.off();
            window.close();
            door.close();
        }
    }
}
