package adapter;

public abstract class FileStore {

    protected String path;
    protected String fileName;

    public FileStore(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }

    public abstract boolean save();
}
