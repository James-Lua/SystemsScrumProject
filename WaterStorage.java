public class WaterStorage {
    private int waterAmount;

    public WaterStorage (int amount) {
        waterAmount = amount;
    }
    public int addWater (int amount) {
        waterAmount += amount;
    }
    public boolean consumeWater (int amount) {
        if (waterAmount >= amount) {
            waterAmount -= amount;
            return true;
        }
        return false;
    }
    public int getWaterAmount () {
        return waterAmount;
    }
}
