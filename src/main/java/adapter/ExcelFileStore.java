package adapter;

/**
 * 구조를 변경할 수 없는 클래스라고 가정
 */
public class ExcelFileStore {

    public ExcelFileStore() {
    }

    public void saveToExcel(String fileName) {
        System.out.println("Excel file saved... " + fileName);
    }
}
