package decorator;

/**
 * Decorator
 *  - Component를 구현하면서도 Component를 wrapping
 *  - Decorator를 Decorate할 수 있다.
 */
public abstract class DataSourceDecorator implements DataSource {

    private DataSource wrappee;

    public DataSourceDecorator(DataSource wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}
