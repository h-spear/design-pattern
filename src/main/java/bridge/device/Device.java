package bridge.device;

public interface Device {

    boolean isEnabled();
    void enable();
    void disable();

    void setVolume(int percent);
    int getVolume();

    void setChannel(int channel);
    int getChannel();

    void printStatus();
}
