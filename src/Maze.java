public class Maze {
    private boolean[][] field;
    public int sizeX;
    public int sizeY;

    public Maze(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        field = new boolean[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
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
}


// VB code
//    Public Class Maze
//        Private Property Opened As Boolean(,)
//        Public Property sizeX
//        Public Property sizeY
//
//        Public Sub New(ByVal sizeX As Integer, sizeY As Integer)
//        ReDim Opened(sizeX - 1, sizeY - 1)
//        Me.sizeX = sizeX
//        Me.sizeY = sizeY
//        For i As Integer = 0 To (sizeX - 1)
//        For j As Integer = 0 To (sizeY - 1)
//          Me.Opened(i, j) = True
//        Next
//        Next
//        End Sub
//
//        Public Function IsOpen(i As Integer, j As Integer) As Boolean
//        If (i < 0 Or j < 0) Then Return True
//        If (i > sizeX - 1 Or j > sizeX - 1) Then Return False
//        Return Me.Opened(i, j)
//        End Function
//
//        Public Sub SetOpenStatus(i As Integer, j As Integer, open As Boolean)
//          Opened(i, j) = open
//        End Sub
//
//      End Class

