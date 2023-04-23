package adapter;

/**
 * 구조를 변경할 수 없으므로 어댑터를 사용
 */
public class ExcelFileStoreAdapter extends FileStore {

    private ExcelFileStore excelFileStore;

    public ExcelFileStoreAdapter(String path, String fileName) {
        super(path, fileName);
        excelFileStore = new ExcelFileStore();
    }

    @Override
    public boolean save() {
        String filePath = this.path + "/" + this.fileName + ".xlsx";
        excelFileStore.saveToExcel(filePath);
        return true;
    }
}
