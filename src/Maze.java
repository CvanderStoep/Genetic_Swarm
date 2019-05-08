import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.List;

public class Maze {
    private boolean[][] field;
    public int sizeX;
    public int sizeY;

    public Maze(int nX, int nY) {
        this.sizeX = nX;
        this.sizeY = nY;
        field = new boolean[nX][nY];
        for (int i = 0; i < nX; i++) {
            for (int j = 0; j < nY; j++) {
                field[i][j] = true;
            }
        }
    }

    public boolean isOpen(int i, int j) {
        if (i < 0 || j < 0) {
            return true;
        }
        if (i >= sizeX || j >= sizeY) {
            return false;
        }
        return field[i][j];
    }

    public void setOpen(int i, int j, boolean isOpen) {
        if (i >= 0 && i < sizeX && j >= 0 && j >= sizeY) {
            field[i][j] = isOpen;
        } else {
            throw new IllegalArgumentException("The indices given (" + i + "," + j + ") were out of bounds.");
        }
    }

    public void plot(List<Individual> individuals) {
        //TODO design plotting output
        StdOut.println("plotting...");
        for (Individual in : individuals) {
            StdOut.println("fitness: " + in.fitness());
            StdOut.println(in.geneticCode.moves);
        }


        // read in bounding box and rescale
        double x0 = 0;
        double y0 = 0;
        double x1 = 300;
        double y1 = 300;
        StdDraw.setXscale(x0, x1);
        StdDraw.setYscale(y0, y1);
        StdDraw.clear();

        StdDraw.enableDoubleBuffering();

        StdDraw.setPenRadius(0.005);
        StdDraw.filledCircle(20,20,5);
        StdDraw.point(50,50);
        String outputText = String.format("%.2f",individuals.get(0).fitness());
        StdDraw.text(60,60,outputText);


        // display all of the points now
        StdDraw.show();



    }
}
