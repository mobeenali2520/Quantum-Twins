
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/// This class controls keybord input  to handle movement of particles 
  public class GameController implements KeyListener{   // Interface of Keylistener required to handle particles movements through keyboard
    EntanglementManager object;  // for moving both particles as entagelment logic is there
    GamePanel gamePanel;
    int currentLevel;
    MainFrame mainFrame;
    int levelNumber;

    public GameController(EntanglementManager object , GamePanel gamePanel , MainFrame mainFrame,int levelNumber) {
         this.object = object;
         this.gamePanel = gamePanel;
         this.mainFrame = mainFrame;
         this.levelNumber = levelNumber;
    }
    public void keyPressed(KeyEvent e)
    {
       switch(e.getKeyCode()){
       case KeyEvent.VK_UP:{
       object.move(-1, 0);//move the row by -1 up and no movement in column
       gamePanel.repaint();    //repaint method redraws  GamePanel  
        if(object.isBothAtExit())
        {    
            mainFrame.showWinScreen(levelNumber);

        }
        break;
       }
       
       case KeyEvent.VK_DOWN:{
        object.move(1, 0);//move the row by 1 down and column remains same
        gamePanel.repaint();
        if(object.isBothAtExit())
        {        
         
             mainFrame.showWinScreen(levelNumber);
        }
        break;
       }
        case KeyEvent.VK_RIGHT:{
       object.move(0, 1);//move the row by 0 up and column by 1 down 
       gamePanel.repaint();
        if(object.isBothAtExit())
        {
           mainFrame.showWinScreen(levelNumber);
        }
        break;
        }
       case KeyEvent.VK_LEFT:{
       object.move(0, -1);//move the row by  down and column by 1 up
       gamePanel.repaint();
        if(object.isBothAtExit())
        {
             mainFrame.showWinScreen(levelNumber);
        }
        break;
       }
    }
    // mainFrame.showWinScreen(levelNumber);
    }
    @Override
    public void keyReleased(KeyEvent e) {  //as KeyListener is interfaced so we have to override there metohds here 
    }
 @Override
 public void keyTyped(KeyEvent e) {
 }      
}
