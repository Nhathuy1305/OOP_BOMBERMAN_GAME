package graphics;

public class Sprite {
    public static final int ORIGINAL_SIZE = 16;
    public static final int SCALED_SIZE = ORIGINAL_SIZE * 2;
    private static final int TRANSPARENT_COLOR = 0xffff00f;
    public final int SIZE;
    private int _x, _y;
    public int[] _pixels;
    protected int _realWidth;
    protected int _realHeight;
    private SpriteSheet _sheet;

    public Sprite(int SIZE, int _x, int _y, int _realWidth, int _realHeight, SpriteSheet _sheet) {
        this.SIZE = SIZE;
        this._x = _x * this.SIZE;
        this._y = _y * this.SIZE;
        this._realWidth = _realWidth;
        this._realHeight = _realHeight;
        this._sheet = _sheet;
        _pixels = new int[this.SIZE * this.SIZE];
        load();
    }

    public static Sprite transparent = new Sprite(ORIGINAL_SIZE, 15, 15, 16, 16, SpriteSheet.tiles);

    /* Board */
    public static Sprite grass = new Sprite(ORIGINAL_SIZE, 6, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite brick = new Sprite(ORIGINAL_SIZE, 7, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite portal = new Sprite(ORIGINAL_SIZE, 4, 0, 14, 14, SpriteSheet.tiles);
    public static Sprite wall = new Sprite(ORIGINAL_SIZE, 5, 0, 16, 16, SpriteSheet.tiles);

    /* Bomber */
    public static Sprite control_up = new Sprite(ORIGINAL_SIZE, 0, 0, 12, 16, SpriteSheet.tiles);
    public static Sprite control_down = new Sprite(ORIGINAL_SIZE, 2, 0, 12, 15, SpriteSheet.tiles);
    public static Sprite control_right = new Sprite(ORIGINAL_SIZE, 1, 0, 10, 16, SpriteSheet.tiles);
    public static Sprite control_left = new Sprite(ORIGINAL_SIZE, 3, 0, 10, 15, SpriteSheet.tiles);

    public static Sprite control_up_1 = new Sprite(ORIGINAL_SIZE, 0, 1, 12, 16, SpriteSheet.tiles);
    public static Sprite control_up_2 = new Sprite(ORIGINAL_SIZE, 0, 2, 12, 15, SpriteSheet.tiles);

    public static Sprite control_down_1 = new Sprite(ORIGINAL_SIZE, 2, 1, 12, 15, SpriteSheet.tiles);
    public static Sprite control_down_2 = new Sprite(ORIGINAL_SIZE, 2, 2, 12, 16, SpriteSheet.tiles);

    public static Sprite control_right_1 = new Sprite(ORIGINAL_SIZE, 1, 1, 11, 16, SpriteSheet.tiles);
    public static Sprite control_right_2 = new Sprite(ORIGINAL_SIZE, 1, 2, 12, 16, SpriteSheet.tiles);

    public static Sprite control_left_1 = new Sprite(ORIGINAL_SIZE, 3, 1, 11, 16, SpriteSheet.tiles);
    public static Sprite control_left_2 = new Sprite(ORIGINAL_SIZE, 3, 2, 12, 16, SpriteSheet.tiles);

    /* Death */
    public static Sprite player_dead_1 = new Sprite(ORIGINAL_SIZE, 4, 2, 14, 16, SpriteSheet.tiles);
    public static Sprite player_dead_2 = new Sprite(ORIGINAL_SIZE, 5, 2, 13, 15, SpriteSheet.tiles);
    public static Sprite player_dead_3 = new Sprite(ORIGINAL_SIZE, 6, 2, 16, 16, SpriteSheet.tiles);


    /* Character */

    // BALLOM
    public static Sprite ballom_right_1 = new Sprite(ORIGINAL_SIZE, 10, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite ballom_right_2 = new Sprite(ORIGINAL_SIZE, 10, 1, 16, 16, SpriteSheet.tiles);
    public static Sprite ballom_right_3 = new Sprite(ORIGINAL_SIZE, 10, 2, 16, 16, SpriteSheet.tiles);

    public static Sprite ballom_left_1 = new Sprite(ORIGINAL_SIZE, 9, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite ballom_left_2 = new Sprite(ORIGINAL_SIZE, 9, 1, 16, 16, SpriteSheet.tiles);
    public static Sprite ballom_left_3 = new Sprite(ORIGINAL_SIZE, 9, 2, 16, 16, SpriteSheet.tiles);

    public static Sprite ballom_dead = new Sprite(ORIGINAL_SIZE, 9, 3, 16, 16, SpriteSheet.tiles);

    // ONEAL
    public static Sprite oneal_right_1 = new Sprite(ORIGINAL_SIZE, 12, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite oneal_right_2 = new Sprite(ORIGINAL_SIZE, 12, 1, 16, 16, SpriteSheet.tiles);
    public static Sprite oneal_right_3 = new Sprite(ORIGINAL_SIZE, 12, 2, 16, 16, SpriteSheet.tiles);

    public static Sprite oneal_left_1 = new Sprite(ORIGINAL_SIZE, 11, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite oneal_left_2 = new Sprite(ORIGINAL_SIZE, 11, 1, 16, 16, SpriteSheet.tiles);
    public static Sprite oneal_left_3 = new Sprite(ORIGINAL_SIZE, 11, 2, 16, 16, SpriteSheet.tiles);

    public static Sprite oneal_dead = new Sprite(ORIGINAL_SIZE, 11, 3, 16, 16, SpriteSheet.tiles);

    // DOLL
    public static Sprite doll_right_1 = new Sprite(ORIGINAL_SIZE, 14, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite doll_right_2 = new Sprite(ORIGINAL_SIZE, 14, 1, 16, 16, SpriteSheet.tiles);
    public static Sprite doll_right_3 = new Sprite(ORIGINAL_SIZE, 14, 2, 16, 16, SpriteSheet.tiles);

    public static Sprite doll_left_1 = new Sprite(ORIGINAL_SIZE, 13, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite doll_left_2 = new Sprite(ORIGINAL_SIZE, 13, 1, 16, 16, SpriteSheet.tiles);
    public static Sprite doll_left_3 = new Sprite(ORIGINAL_SIZE, 13, 2, 16, 16, SpriteSheet.tiles);

    public static Sprite doll_dead = new Sprite(ORIGINAL_SIZE, 13, 3, 16, 16, SpriteSheet.tiles);

    // MINVO
    public static Sprite minvo_right_1 = new Sprite(ORIGINAL_SIZE, 9, 5, 16, 16, SpriteSheet.tiles);
    public static Sprite minvo_right_2 = new Sprite(ORIGINAL_SIZE, 9, 6, 16, 16, SpriteSheet.tiles);
    public static Sprite minvo_right_3 = new Sprite(ORIGINAL_SIZE, 9, 7, 16, 16, SpriteSheet.tiles);

    public static Sprite minvo_left_1 = new Sprite(ORIGINAL_SIZE, 8, 5, 16, 16, SpriteSheet.tiles);
    public static Sprite minvo_left_2 = new Sprite(ORIGINAL_SIZE, 8, 6, 16, 16, SpriteSheet.tiles);
    public static Sprite minvo_left_3 = new Sprite(ORIGINAL_SIZE, 8, 7, 16, 16, SpriteSheet.tiles);

    public static Sprite minvo_dead = new Sprite(ORIGINAL_SIZE, 8, 8, 16, 16, SpriteSheet.tiles);

    // KONDORIA
    public static Sprite kondoria_right_1 = new Sprite(ORIGINAL_SIZE, 11, 5, 16 ,16, SpriteSheet.tiles);
    public static Sprite kondoria_right_2 = new Sprite(ORIGINAL_SIZE, 11, 6, 16, 16, SpriteSheet.tiles);
    public static Sprite kondoria_right_3 = new Sprite(ORIGINAL_SIZE, 11, 7, 16, 16, SpriteSheet.tiles);

    public static Sprite kondoria_left_1 = new Sprite(ORIGINAL_SIZE, 10, 5, 16, 16, SpriteSheet.tiles);
    public static Sprite kondoria_left_2 = new Sprite(ORIGINAL_SIZE, 10, 6, 16, 16, SpriteSheet.tiles);
    public static Sprite kondoria_left_3 = new Sprite(ORIGINAL_SIZE, 10, 7, 16, 16, SpriteSheet.tiles);

    public static Sprite kondoria_dead = new Sprite(ORIGINAL_SIZE, 10, 8, 16, 16, SpriteSheet.tiles);

    // ALL
    public static Sprite mob_dead_1 = new Sprite(ORIGINAL_SIZE, 15, 0, 16, 16, SpriteSheet.tiles);
    public static Sprite mob_dead_2 = new Sprite(ORIGINAL_SIZE, 15, 1, 16, 16, SpriteSheet.tiles);
    public static Sprite mob_dead_3 = new Sprite(ORIGINAL_SIZE, 15, 2, 16, 16, SpriteSheet.tiles);

    // BOMB SPRITES
    public static Sprite bomb = new Sprite(ORIGINAL_SIZE, 0, 3, 15, 15, SpriteSheet.tiles);
    public static Sprite bomb_1 = new Sprite(ORIGINAL_SIZE, 1, 3, 13, 15, SpriteSheet.tiles);
    public static Sprite bomb_2 = new Sprite(ORIGINAL_SIZE, 2, 3, 12, 14, SpriteSheet.tiles);

    // FlameSegment Sprites
    public static Sprite bomb_exploded = new Sprite(ORIGINAL_SIZE, 0, 4, 16, 16, SpriteSheet.tiles);
    public static Sprite bomb_exploded_1 = new Sprite(ORIGINAL_SIZE, 0, 5, 16, 16, SpriteSheet.tiles);
    public static Sprite bomb_exploded_2 = new Sprite(ORIGINAL_SIZE, 0, 6, 16, 16, SpriteSheet.tiles);

    public static Sprite explosion_vertical = new Sprite(ORIGINAL_SIZE, 1, 5, 16, 16, SpriteSheet.tiles);
    public static Sprite explosion_vertical_1 = new Sprite(ORIGINAL_SIZE, 2, 5, 16, 16, SpriteSheet.tiles);
    public static Sprite explosion_vertical_2 = new Sprite(ORIGINAL_SIZE, 3, 5, 16, 16, SpriteSheet.tiles);


}