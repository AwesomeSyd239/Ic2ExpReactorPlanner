package Ic2ExpReactorPlanner;

/**
 * Represents a 10k Coolant Cell.
 * @author Brian McCloud
 */
public class CoolantCell60k extends ReactorComponent {
    
    /**
     * The filename for the image to show for the component.
     */
    private static final String imageFilename = "reactorCoolantSix.png";    
    
    public static final MaterialsList MATERIALS = new MaterialsList(2, CoolantCell30k.MATERIALS, "Iron Plate", 6, "Tin Plate");
    
    /**
     * Creates a new instance.
     */
    public CoolantCell60k() {
        setImage(TextureFactory.getImage(imageFilename));
        setMaxHeat(60000);
    }
    
    /**
     * Gets the name of the component.
     * @return the name of this component.
     */
    @Override
    public String toString() {
        String result = "60k Coolant Cell";
        if (getInitialHeat() > 0) {
            result += String.format(" (initial heat: %,d)", (int)getInitialHeat());
        }
        return result;
    }

    @Override
    public boolean isHeatAcceptor() {
        return !isBroken();
    }
    
    @Override
    public MaterialsList getMaterials() {
        return MATERIALS;
    }
    
    @Override
    public double adjustCurrentHeat(double heat) {
        currentCellCooling += heat;
        bestCellCooling = Math.max(currentCellCooling, bestCellCooling);
        return super.adjustCurrentHeat(heat);
    }
    
}
