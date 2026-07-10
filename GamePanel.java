import java.awt.*;
import javax.swing.*;
public class GamePanel extends JPanel {  // to draw mazes and particles above mazes 
    Maze mazeA;
    Maze mazeB;
    Particle alpha;
    Particle beta;
    EntanglementManager manager;
    public GamePanel(Maze mazeA , Maze mazeB ,Particle alpha , Particle beta)
    {
               this.mazeA = mazeA;
               this.mazeB= mazeB;
               this.alpha = alpha;
               this.beta=beta;
               setBackground(new Color(10,15,60));//
               setFocusable(true);
               setPreferredSize(new Dimension(
    2 * mazeA.grid[0].length * Maze.TILE_SIZE,
    mazeA.grid.length * Maze.TILE_SIZE
));
    }
     @Override
               protected void paintComponent(Graphics g)
               {
                super.paintComponent(g);
                mazeA.draw(g,0,0);
                mazeB.draw(g,mazeA.grid[0].length*Maze.TILE_SIZE,0);  // beside mazeA 
                alpha.draw(g,0,0);  
                beta.draw(g,mazeA.grid[0].length*Maze.TILE_SIZE,0);
               }
}
