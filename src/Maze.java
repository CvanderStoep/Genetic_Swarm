import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;
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
        if (i >= 0 && i < sizeX && j >= 0 && j < sizeY) {
            field[i][j] = isOpen;
        } else {
            throw new IllegalArgumentException("The indices given (" + i + "," + j + ") were out of bounds.");
        }
    }

    public void plot(List<Individual> individuals, int generation) {
        StdOut.println("plotting...");

        // read in bounding box and rescale
        double x0 = 0;
        double y0 = 0;
        double x1 = sizeX + 5;
        double y1 = sizeY + 5;
        StdDraw.setXscale(x0, x1);
        StdDraw.setYscale(y0, y1);
        StdDraw.clear();

        StdDraw.enableDoubleBuffering();

        StdDraw.setPenRadius(0.0005);
        StdDraw.setPenColor();

        for (Individual in : individuals) {
            int xCoorStart = (int) in.startLocation.getX();
            int yCoordStart = (int) in.startLocation.getY();
            StdDraw.setPenColor(Color.blue);
            StdDraw.filledCircle(xCoorStart,yCoordStart,0.2);

            // Draw the end location of an individual
            int xCoorEnd = (int) in.endLocation.getX();
            int yCoordEnd = (int) in.endLocation.getY();
            StdDraw.setPenColor(Color.black);
            StdDraw.filledCircle(xCoorEnd,yCoordEnd,0.2);

            // Draw the target location of an individual
            int xCoorTarget = (int) in.targetLocation.getX();
            int yCoordTarget = (int) in.targetLocation.getY();
            StdDraw.setPenColor(Color.green);
            StdDraw.filledCircle(xCoorTarget,yCoordTarget,0.2);


            // Draw the trajectory of an individual
            for (Vector2D cp: in.trajectoryOfPositions){
                int xcp = (int) cp.getX();
                int ycp = (int) cp.getY();
                StdDraw.setPenColor(Color.blue);
                StdDraw.line(xCoorStart,yCoordStart,xcp,ycp);
                xCoorStart = xcp;
                yCoordStart = ycp;
            }
        }

        StdDraw.setPenColor(Color.black);
        String outputText = String.format("fitness: " + "%.2f", individuals.get(0).fitness());
        StdDraw.text(sizeX/2, sizeY, outputText);
        StdDraw.text(sizeX/2, sizeY+1, String.format("generation: " + "%d", generation));

        StdDraw.setPenColor(Color.red);
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (!this.isOpen(i, j)) {
                    StdDraw.filledCircle(i, j, 0.2);
                }
            }
        }

        // display all of the points now
        StdDraw.show();


    }
}
