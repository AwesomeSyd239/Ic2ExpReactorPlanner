package Ic2ExpReactorPlanner;

/**
 * Represents some containment reactor plating.
 * @author Brian McCloud
 */
public class ContainmentReactorPlating extends ReactorComponent {
    
    /**
     * The filename for the image to show for the component.
     */
    private final static String imageFilename = "reactorPlatingExplosive.png";    
    
    /**
     * Creates a new instance.
     */
    public ContainmentReactorPlating() {
        setImage(TextureFactory.getImage(imageFilename));
    }
    
    /**
     * Gets the name of the component.
     * @return the name of this component.
     */
    @Override
    public String toString() {
        return "Containment Reactor Plating";
    }
    
    @Override
    public void addToReactor() {
        getParent().adjustMaxHeat(500);
    }

    @Override
    public void removeFromReactor() {
        getParent().adjustMaxHeat(-500);
    }
    
}