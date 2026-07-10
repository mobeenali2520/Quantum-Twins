import java.awt.Color;
import java.awt.Graphics;
 public class Maze   {
    public static int TILE_SIZE=50;  // for designing walls ,paths ,decoj=herence effect,and green tile for winning
   public int grid[][];
   public Maze(int grid[][])    // receives level from Level Class
   {
         this.grid = grid;
   }
  public boolean isWall(int row, int column)
{
    if(row < 0 || row >= grid.length ||
       column < 0 || column >= grid[0].length)
    {
        return true;
    }

    return grid[row][column] == 1;
}
public void draw(Graphics graphics , int offsetX , int offsetY)  // for drawing complete maze
{
         graphics.setColor(new Color(10, 15, 60));
         graphics.fillRect(offsetX, offsetY, grid[0].length * TILE_SIZE, grid.length * TILE_SIZE);   // entire maze
     for(int i=0; i<grid.length; i++)
     {
        for(int j=0; j<grid[i].length; j++)
        {
             switch(grid[i][j]) {
              case 0 :{
                graphics.setColor(Color.PINK); // path is Pink   ")"  for path so that particle can move
                break; 
              }
                
            case 1 :{
             
                graphics.setColor(Color.orange);// wall  color is orange    particle cannot move through wall
                break ; 
             }
             case 2 :
             {
                graphics.setColor(Color.green);  // for exit green  
                break;
             }
                  
             case 3 :
             {
                graphics.setColor(Color.red);  // decoherence zone which break entangelment of particles 
                break ; 
             }
            }
            graphics.fillRect((j*TILE_SIZE)+offsetX, (i*TILE_SIZE)+offsetY, TILE_SIZE, TILE_SIZE); // for colouring each part of miz
             }
     }
}
}
    

