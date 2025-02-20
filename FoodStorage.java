public class FoodStorage {

    private int foodAmount;

    public FoodStorage(int amount) {
        this.foodAmount = amount;
    }
    public void addFood(int amount) {
        foodAmount += amount;
    }
    public boolean consumeFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }
    public int getFoodAmount() {
        return foodAmount;
    }
}
