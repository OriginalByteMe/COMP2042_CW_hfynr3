package p4_group_8_repo;

public class FactoryProducer {
    // Allowing an instance of the FactoryProducer to be created
    private static FactoryProducer factory = new FactoryProducer();
    private FactoryProducer() {}
    public static FactoryProducer getActorFactoryProducer() {
        return factory;
    }



    public static AbstractFactory getFactory(String factoryType){
        AbstractFactory factory = null;


        if(factoryType.equalsIgnoreCase("ObstacleFactory")){
            factory = new ObstacleFactory();
        }
        else if(factoryType.equalsIgnoreCase("StaticActorFactory")){
            factory = new StaticActorFactory();
        }
        else if(factoryType.equalsIgnoreCase("PlayerFactory")){
            factory = new PlayerFactory();
        }
        return factory;


    }
}
