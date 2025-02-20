public class ColonyMember implements NeedObserver {
    private String name;
    private boolean isEating;
    private boolean isDrinking;
    public ColonyMember(String name) {
        this.name = name;
        this.isEating = false;
        this.isDrinking = false;
    }

    @Override
    public void onNeedChanged(String needType, int level){
        System.out.println("ColonyMember " + name + " needs " + needType + " level " + level);
        if (needType.equals("hunger")){
            if (level < 30){
                System.out.println("ColonyMember " + name + " is starving");
            }
            else if (needType.equals("thirst")){
                if (level < 30){
                    System.out.println("ColonyMember " + name + " is dehydrated");
                }
            }
        }
    }
    public void eat(FoodStorage storage){
        if (storage.consumeFood(10)){
            System.out.println("ColonyMember " + name + " is eating");
        }
        else {
            System.out.println("ColonyMember " + name + " has no food left!");
        }

    }
    public void drink(WaterStorage storage){
        if (storage.consumeWater(10)){
            System.out.println("ColonyMember " + name + " is drinking water");
        }
        else {
            System.out.println("ColonyMember " + name + " has no water left!");
        }
    }
}
