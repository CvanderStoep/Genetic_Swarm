import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class GeneticCode {
    public List<Moves> moves;
    public GeneticCode(){
        moves= new ArrayList<Moves>();
    }
    public static void main(String args[]){
        GeneticCode NGC = new GeneticCode();
        NGC.moves.add(Moves.Down);
        NGC.moves.add(Moves.Up);
        StdOut.println(NGC.moves);

    }
}


//Lex, ik zie hierboven al vast : - )


// VB code
//    Public Class GeneticCode
//        Public Property Moves As List(Of Moves)
//        Public Sub New()
//          Me.Moves = New List(Of Moves)
//        End Sub
//     End Class