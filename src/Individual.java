public class Individual {
}


// VB code
//        Public Property Startlocation As Vector2
//        Public Class Individual
//        Public Property Endlocation As Vector2
//        Public Property Targetlocation As Vector2
//        Public Property GeneticCode As GeneticCode
//        Public Property Fitness As Double
//        Get
//        Fitness = Vector2.Distance(Endlocation, Targetlocation)
//        End Get
//        Set(value As Double)
//        End Set
//        End Property
//        Public Sub New()
//        Me.Startlocation = New Vector2(0.2 * MazeSize, 0.2 * MazeSize)
//        Me.Targetlocation = New Vector2(MazeSize - 1, MazeSize - 1)
//        Me.GeneticCode = New GeneticCode
//        End Sub
//        Public Sub UpdatePosition(geneticcode As GeneticCode, maze As Maze)
//        Endlocation = Startlocation
//        For Each move As Moves In geneticcode.Moves
//        Dim OldEndlocation As Vector2 = Endlocation
//        Select Case move
//        Case Moves.Left
//        Endlocation = Vector2.Add(New Vector2(-1, 0), Endlocation)
//        Case Moves.Right
//        Endlocation = Vector2.Add(New Vector2(1, 0), Endlocation)
//        Case Moves.Up
//        Endlocation = Vector2.Add(New Vector2(0, 1), Endlocation)
//        Case Moves.Down
//        Endlocation = Vector2.Add(New Vector2(0, -1), Endlocation)
//        End Select
//
//        If Not maze.IsOpen(Endlocation.X, Endlocation.Y) Then
//        Endlocation = OldEndlocation
//        End If
//        Next
//        End Sub
//        'Public Sub CalculateFitness()
//        '    Dim fitness As Double = Vector2.Distance(Endlocation, Targetlocation)
//        '    Me.Fitness = fitness
//        'End Sub
//        Public Sub RandomMutation()
//        Dim MoveLocation As Integer = 0
//        Dim MutationLocation As Integer = -1
//        Dim p As Integer = random.Next(0, 100)
//        Dim MutatedCode As New GeneticCode
//
//        For Each move As Moves In GeneticCode.Moves
//        p = random.Next(0, 100)
//        If p < 5 Then
//        Dim randommove As Integer = random.Next(0, 5)
//        MutatedCode.Moves.Add(randommove)
//        Else
//        MutatedCode.Moves.Add(move)
//        End If
//        Next
//        GeneticCode = MutatedCode
//
//        ''TODO
//        ''p wordt nog meegegeven als variable
//        ''mutatie per gen ipv per individue nog uitwerken
//        'If p < 5 Then
//        '    Dim randomlocation As Integer = random.Next(0, NumberOfMoves)
//        '    Dim randommove As Integer = random.Next(0, 5)
//        '    GeneticCode.Moves.Item(randomlocation) = randommove
//        '    'Console.WriteLine("mutated, p, mutationlocation: " & p & " " & randomlocation)
//
//        'End If
//
//
//        End Sub
//
//        Public Function CrossOver(individual2 As Individual, crossoverpoint As Integer) As List(Of Individual)
//        Dim child1, child2 As New Individual
//        Dim ChildList As New List(Of Individual)
//
//        Dim NextMove1, NextMove2 As New Moves
//
//        Dim NextMoveIndex As Integer = 0
//        Do While NextMoveIndex < Me.GeneticCode.Moves.Count
//        NextMove1 = Me.GeneticCode.Moves.Item(NextMoveIndex)
//        NextMove2 = individual2.GeneticCode.Moves.Item(NextMoveIndex)
//        If NextMoveIndex < crossoverpoint Then
//        child1.GeneticCode.Moves.Add(NextMove1)
//        child2.GeneticCode.Moves.Add(NextMove2)
//        Else
//        child2.GeneticCode.Moves.Add(NextMove1)
//        child1.GeneticCode.Moves.Add(NextMove2)
//        End If
//        NextMoveIndex += 1
//        Loop
//
//        child1.RandomMutation()
//
//        ChildList.Add(child1)
//        ChildList.Add(child2)
//
//        Return ChildList
//        End Function
//
//
//
//        End Class
//
