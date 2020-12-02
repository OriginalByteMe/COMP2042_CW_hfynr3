package p4_group_8_repo;

public class PlayerFactory extends AbstractFactory {
    @Override
    public Actor getActor(String playerName, String imageLink, double size, double xPos, double yPos) {
        Actor player = null;



        if(playerName.equalsIgnoreCase("Animal")){
            player = new Animal(imageLink, size, xPos, yPos);
        }

        return player;
    }
}
