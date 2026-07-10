import java.awt.*;
import javax.swing.*;
public class MainFrame extends JFrame{
    GamePanel gamePanel;  // for showing particles and mazes 
    StatusBar statusBar;  // for shoeing time and levels 
    SelectScreen selectScreen ;  // for selecting level 
    int currentLevel=1;
   // GameOverScreen gameOverScreen;
   // EntanglementManager manager;
    public MainFrame()
    {
       int[][][] levels =  Level.getLevel(1);
       selectScreen = new SelectScreen(this);
        Maze mazeA = new Maze(levels[0]); 
        Maze mazeB = new Maze(levels[1]);
        Particle alpha =new Particle(1,1,Color.CYAN);
        Particle beta = new Particle(1,4,Color.ORANGE);
        EntanglementManager manager = new EntanglementManager(alpha,beta,mazeA,mazeB);
      WellComeScreen  welcomeScreen = new WellComeScreen(this);
      gamePanel = new GamePanel(mazeA, mazeB, alpha, beta);
        GameController controller = new GameController(manager, gamePanel,this ,currentLevel);
       // gameOverScreen = new GameOverScreen(this , 1);
        ImageIcon icon = new ImageIcon("eagle.jpg");
        setIconImage(icon.getImage());
         statusBar  = new StatusBar(this ,1);
        gamePanel.addKeyListener(controller);
        setLayout(new BorderLayout());
       add(welcomeScreen,BorderLayout.CENTER);
        getContentPane().setBackground(Color.GREEN);
        pack();
        setTitle("Quantum Twins");
        setMinimumSize(new Dimension(900, 600));
          setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void startGame() {
    getContentPane().removeAll();
    add(gamePanel, BorderLayout.CENTER);
    add(statusBar, BorderLayout.SOUTH);
    gamePanel.requestFocusInWindow();
    revalidate();
    repaint();
}
public void showLevelSelect()
{
    getContentPane().removeAll();
    add(selectScreen,BorderLayout.CENTER);
    revalidate();
    repaint();
}
public void startLevel(int levelNumber)
{    
    if(statusBar != null && statusBar.countdownTimer != null)
    {
    statusBar.countdownTimer.stop();
    } 
    this.currentLevel = levelNumber;
   // loadLevel.getLevel(levelNumber);
    int[][][] levels =  Level.getLevel(levelNumber);
    Maze A = new Maze(levels[0]);
    Maze B = new Maze(levels[1]);
    Particle alpha  = new Particle(1, 1,Color.CYAN);
    Particle beta = new Particle(1,4, Color.ORANGE);
    EntanglementManager entanglementManager = new EntanglementManager(alpha, beta, A, B);
     gamePanel = new GamePanel(A, B, alpha, beta);
      statusBar = new StatusBar(this,levelNumber);
    GameController controller = new GameController(entanglementManager, gamePanel,this,levelNumber);
    getContentPane().removeAll();
    gamePanel.addKeyListener(controller);
    add(gamePanel, BorderLayout.CENTER);
    add(statusBar, BorderLayout.SOUTH);
     revalidate();
     repaint();
     pack();
     setLocationRelativeTo(null);
    // statusBar.resetTimer();  it finsihes time in double speed 
     gamePanel.requestFocusInWindow();
}
void showWinScreen(int levelNumber)
{
    statusBar.countdownTimer.stop();
    selectScreen.unlockNextLevel(levelNumber+1);
    getContentPane().removeAll();
    add(new WinScreen(this, levelNumber),BorderLayout.CENTER);
    revalidate();
    repaint();
}
public void showGameOver(int levelNumber) {
    if(statusBar != null && statusBar.countdownTimer != null)
    {
    statusBar.countdownTimer.stop();
     }
    getContentPane().removeAll();
    add(new GameOverScreen(this, levelNumber), BorderLayout.CENTER);
    revalidate();
    repaint();
}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new MainFrame());
    }
}
