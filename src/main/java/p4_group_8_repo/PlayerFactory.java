package p4_group_8_repo;

public class PlayerFactory extends AbstractFactory {
    /**
     * <h1>Player Factory</h1>
     * <p>Creates player object</p>
     * @param playerName Name of player
     * @param imageLink Image of player
     * @param size Size of player
     * @param xPos Starting X-Position
     * @param yPos Starting Y-Position
     * @return Player
     */
    @Override
    public Actor getActor(String playerName, String imageLink, double size, double xPos, double yPos) {
        Actor player = null;



        if(playerName.equalsIgnoreCase("Animal")){
            player = new Animal(imageLink, size, xPos, yPos);
        }

        return player;
    }
}
