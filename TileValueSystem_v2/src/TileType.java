public enum TileType {
    MUD(5),
    GRASS(3),
    MEADOW(5),
    RUBBLE(2),
    CLAY(4),
    STONE_DIRT(3),
    STONE_PATH(3),
    ROAD(0),
    WATER(10),
    DIRT(1);

    private final int value;

    TileType(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
    public static class Mud implements Tile {
        @Override
        public TileType getType(){
            return TileType.MUD;
        }
    }
    public static class Grass implements Tile {
        @Override
        public TileType getType(){
            return TileType.GRASS;
        }
    }
    public static class Meadow implements Tile {
        @Override
        public TileType getType(){
            return TileType.MEADOW;
        }
    }
    public static class Rubble implements Tile {
        @Override
        public TileType getType(){
            return TileType.RUBBLE;
        }
    }
    public static class Clay implements Tile {
        @Override
        public TileType getType(){
            return TileType.CLAY;
        }
    }
    public static class Stone_Dirt implements Tile {
        @Override
        public TileType getType(){
            return TileType.STONE_DIRT;
        }
    }
    public static class Stone_Path implements Tile {
        @Override
        public TileType getType(){
            return TileType.STONE_PATH;
        }
    }
    public static class Water implements Tile{
        @Override
        public TileType getType(){
            return TileType.WATER;
        }
    }
    public static class Road implements Tile {
        @Override
        public TileType getType(){
            return TileType.ROAD;
        }
    }
    public static class Dirt implements Tile {
        @Override
        public TileType getType(){
            return TileType.DIRT;
        }
    }
    }
