package p4_group_8_repo;

public abstract class StaticActor extends Actor{
    public StaticActor(String ImageLink, double size, double xPos, double yPos) {
        super(ImageLink, size, xPos, yPos);
    }

    /**
     * <h1>StaticActor</h1>
     * Used to identify all static elements and differentiate them from Moving and Player Actor
     * @return className
     */
    @Override
    public String getActorClassName() {
        return "StaticActor";
    }

    @Override
    public void act() {
        // Do nothing
    }
}
