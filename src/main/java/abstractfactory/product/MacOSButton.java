package abstractfactory.product;

public class MacOSButton extends Button {

    public MacOSButton(String caption) {
        super(caption);
    }

    @Override
    public void render() {
        System.out.println("Draw " + this.caption + " button using Mac OS rendering API.");
    }
}
