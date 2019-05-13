class MazeTest {

    @org.junit.jupiter.api.Test
    void isOpen() {
        Maze aMaze = new Maze(10,10);

        assert aMaze.isOpen(0,0);
        assert aMaze.isOpen(1,1);
        assert aMaze.isOpen(9,9);
        assert !aMaze.isOpen(10,10);
        assert aMaze.isOpen(-1,0);
    }

    @org.junit.jupiter.api.Test
    void setOpen() {
        Maze aMaze = new Maze(10,10);

        aMaze.setOpen(0,0, false);
        assert !aMaze.isOpen(0,0);
        aMaze.setOpen(0,0, true);
        assert aMaze.isOpen(0,0);

        aMaze.setOpen(9,9, false);
        assert !aMaze.isOpen(9,9);
        aMaze.setOpen(9,9, true);
        assert aMaze.isOpen(9,9);
    }
}