 public class EntanglementManager   //This class is just for entagelment logic of particles 
{
  Particle alpha;
  Particle beta;
  Maze mazeA;
  Maze mazeB;
  boolean reversed;
  public EntanglementManager(Particle alpha , Particle beta , Maze mazeA , Maze mazeB)
  {
     this.alpha = alpha;
     this.beta = beta;
     this.mazeA =mazeA;
     this.mazeB = mazeB;
  }
  public void move(int dRow  , int dCol)  // for movement of direction 
  {
    if(!reversed)
    {
        alpha.move(dRow, dCol, mazeA);  // calls particle move method if the beta is not in decoherence zone"Red Tile" in mazeB
        beta.move(dRow, dCol, mazeB);
    }
    else{   // Quantum entangelment  destruction 
         alpha.move(-dRow, -dCol, mazeA); // calls particle move method ,if beta is in decoherence zone"Red tile" in mazeB
        beta.move(-dRow, -dCol, mazeB);
    }
    if(mazeB.grid[beta.getRow()][beta.getColumn()]==3)  
    {
        reversed = true;
    }
  }
  public boolean isBothAtExit()
  {
    if(alpha.isAtExit(mazeA)&&beta.isAtExit(mazeB))  // calls paticles class isAtExit() method  
        return true;
    return false;
  }
}

