package p4_group_8_repo;

public class PlayerFactory extends AbstractFactory {
    @Override
    public Actor getActor(String obstacleName, String imageLink, double size, double xPos, double yPos) {
        Actor player = null;

        if(obstacleName.equalsIgnoreCase("Log")){
            player = new Animal(imageLink, size, xPos, yPos);
        }

        return player;
    }
}
