package abstractfactory.product;

/**
 * Abstract Product
 */
public abstract class Button {
    protected String caption;

    public Button(String caption) {
        this.caption = caption;
    }

    public void clickEvent() {
        System.out.println("You clicked the '" + caption + "' button.");
    }

    public abstract void render();

}
