import decorator.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DecoratorTest {

    private static final String FILE_PATH = "src/test/resources/out/output.txt";
    private static final String INPUT_DATA = "Hello Mr. My Yesterday";

    @Test
    void fileDataSourceTest() {
        FileDataSource dataSource = new FileDataSource(FILE_PATH);
        dataSource.writeData(INPUT_DATA);
        String data = dataSource.readData();
        assertEquals(data, INPUT_DATA);
    }

    @Test
    void dataSourceDecorateTest() {
        DataSourceDecorator dataSource = new CompressionDecorator(
                                            new EncryptionDecorator(
                                                new FileDataSource(FILE_PATH)));
        dataSource.writeData(INPUT_DATA);
        DataSource plain = new FileDataSource(FILE_PATH);

        System.out.println("- Input ----------------");
        System.out.println(INPUT_DATA);
        System.out.println("\n- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("\n- Decoded --------------");
        System.out.println(dataSource.readData());

        assertNotEquals(plain.readData(), INPUT_DATA);
        assertEquals(dataSource.readData(), INPUT_DATA);
    }
}
