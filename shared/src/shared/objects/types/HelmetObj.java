package shared.objects.types;

import entity.character.equipment.Helmet;
import org.ini4j.Profile;
import shared.objects.factory.ObjectFactory;

public class HelmetObj extends ObjWithClasses {

    public HelmetObj(){}
    public int getBodyNumber() {
        return bodyNumber;
    }

    public void setBodyNumber(int bodyNumber) {
        this.bodyNumber = bodyNumber;
    }

    public int getAnimationId() {
        return animationId;
    }

    public void setAnimationId(int animationId) {
        this.animationId = animationId;
    }

    public int getMinDef() {
        return minDef;
    }

    public void setMinDef(int minDef) {
        this.minDef = minDef;
    }

    public int getMaxDef() {
        return maxDef;
    }

    public void setMaxDef(int maxDef) {
        this.maxDef = maxDef;
    }

    private int bodyNumber;
    private int animationId;
    private int minDef, maxDef;

    public HelmetObj(int id, String name, int grhIndex) {
        super(id, name, grhIndex);
    }

    @Override
    public Type getType() {
        return Type.HELMET;
    }

    @Override
    public void fillObject(Profile.Section section) {
        super.fillObject(section);
        ObjectFactory.fill(this, section);
    }
}
