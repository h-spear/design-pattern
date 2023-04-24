package abstractfactory.product;

public class WindowsButton extends Button {

    public WindowsButton(String caption) {
        super(caption);
    }

    @Override
    public void render() {
        System.out.println("Draw " + this.caption + " button using Windows rendering API.");
    }
}
