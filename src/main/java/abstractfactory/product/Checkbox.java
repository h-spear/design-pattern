package abstractfactory.product;

/**
 * Abstract Product
 */
public abstract class Checkbox {
    protected boolean checked;

    public Checkbox(boolean checked) {
        this.checked = checked;
    }

    public void setChecked(boolean checked) {
        if (this.checked != checked) {
            this.checked = checked;
            render();
        }
    }

    public abstract void render();
}
