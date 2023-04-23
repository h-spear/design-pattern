package bridge.device;

public class Radio implements Device {

    private boolean on = false;
    private int volume;
    private int channel;

    public Radio(int volume, int channel) {
        this.volume = volume;
        this.channel = channel;
    }

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public void setVolume(int volume) {
        volume = Math.min(volume, 100);
        volume = Math.max(volume, 0);
        this.volume = volume;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public int getChannel() {
        return this.channel;
    }

    @Override
    public void printStatus() {
        System.out.println("===============================");
        System.out.println("* Radio");
        System.out.println("* Power : " + (on ? "On" : "Off"));
        System.out.println("* Volume : " + this.volume + "%");
        System.out.println("* Channel : " + this.channel);
        System.out.println("===============================");
    }
}
