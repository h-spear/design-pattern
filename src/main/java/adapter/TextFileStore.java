package adapter;

public class TextFileStore extends FileStore {

    public TextFileStore(String path, String fileName) {
        super(path, fileName);
    }

    @Override
    public boolean save() {
        String filePath = this.path + "/" + this.fileName + ".txt";
        System.out.println("Image file saved... " + filePath);
        return true;
    }
}
