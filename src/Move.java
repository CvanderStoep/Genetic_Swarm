import edu.princeton.cs.algs4.Vector;

import java.util.Random;

public enum Move {
    None,
    Left,
    Right,
    Up,
    Down;

    public Vector direction;

    static {
        None.direction = new Vector(0, 0);
        Left.direction = new Vector(-1, 0);
        Right.direction = new Vector(1, 0);
        Up.direction = new Vector(0, 1);
        Down.direction = new Vector(0, -1);
    }

    private static final Move[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Move getRandomMove()  {
        return VALUES[RANDOM.nextInt(SIZE)];
    }


}




