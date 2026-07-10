import java.awt.Color;
import java.awt.Graphics;
 public class Particle {
    private static final int TILE_SIZE = 50;
   private int row;
   private int column;
   private Color color;   // for coloring Particles
   public Particle( int row , int column ,Color color)
   {
         this.row =row;
         this.column = column;
         this.color =color;
   }  
   public int getRow()
   {
    return row;
   } 
   public int getColumn()
   {
    return column;
   }
   public void move(int dRow , int dCol ,  Maze maze)
   {  
    int newRow =row+dRow , newCol=column+dCol;
        if(!maze.isWall(newRow,newCol)) // if tile is not wall ,then I have to update row and col
        {                               // for moving particles
            this.row=row+dRow;
            this.column=column+dCol;
        }
   }
   public void draw(Graphics graphics, int offsetX , int offsetY)  //for drawing Alha and Beta partiles
   {
     graphics.setColor(color.brighter());
     graphics.fillOval(column * TILE_SIZE + offsetX, row * TILE_SIZE + offsetY, TILE_SIZE, TILE_SIZE); 
   }
   public boolean isAtExit(Maze maze)  //  winnig condition
   {
      if(maze.grid[row][column]==2)
      {
        return true;
      }
      return false;
   }
}
