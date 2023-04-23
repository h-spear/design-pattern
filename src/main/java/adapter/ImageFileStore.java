package adapter;

public class ImageFileStore extends FileStore {

    public ImageFileStore(String path, String fileName) {
        super(path, fileName);
    }

    @Override
    public boolean save() {
        String filePath = this.path + "/" + this.fileName + ".png";
        System.out.println("Image file saved... " + filePath);
        return true;
    }
}
