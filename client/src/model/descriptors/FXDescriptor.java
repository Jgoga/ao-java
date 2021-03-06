package model.descriptors;

public class FXDescriptor extends Descriptor {

    private int offsetX;
    private int offsetY;

    public FXDescriptor() {
    }

    public FXDescriptor(int fxIndex, int offsetX, int offsetY) {
        super(new int[]{fxIndex});
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public int getOffsetX() {
        return offsetX;
    }
}
