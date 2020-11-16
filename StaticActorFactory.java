package p4_group_8_repo;

public class StaticActorFactory extends AbstractFactory {
    @Override
    public Actor getActor(String obstacleName, String imageLink, double size, double xPos, double yPos) {

        Actor staticType = null;

        if(obstacleName.equalsIgnoreCase("Digit")){
            staticType = new Digit(imageLink, size, xPos, yPos);
        }
        else if(obstacleName.equalsIgnoreCase("End")){
            staticType = new End(imageLink, size, xPos, yPos);
        }

        return staticType;
    }
}
