import java.util.Random;

public enum Move {
    None,
    Left,
    Right,
    Up,
    Down;

    public Vector2D direction;

    static {
        None.direction = new Vector2D(0, 0);
        Left.direction = new Vector2D(-1, 0);
        Right.direction = new Vector2D(1, 0);
        Up.direction = new Vector2D(0, 1);
        Down.direction = new Vector2D(0, -1);
    }

    private static final Move[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Move getRandomMove()  {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}




