package p4_group_8_repo;

public class FactoryProducer {
    // Allowing an instance of the FactoryProducer to be created
    private static FactoryProducer factory = new FactoryProducer();
    private FactoryProducer() {}
    public static FactoryProducer getActorFactoryProducer() {
        return factory;
    }


    /**
     * <h1>Factory to produce factories</h1>
     * <p>Using this we can create factory objects as by the Abstract Factory design </p>
     * @param factoryType Name of factory
     * @return Factory
     */
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
