package decorator;

/**
 * Component
 */
public interface DataSource {
    void writeData(String data);
    String readData();
}
