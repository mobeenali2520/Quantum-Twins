import java.awt.*;
import javax.swing.*;
public class SelectScreen extends JPanel{  // Select screen appears after clicking on start button in wellCome screen 
    MainFrame mainFrame;
    int unlockedLevel =1;
    Level level;
   // int level =1;
    JButton[] levelButtons = new JButton[10]; // 5 uttons for 5 level
    public SelectScreen(MainFrame mainFrame)
    {       
         this.mainFrame = mainFrame;
          setBackground(new Color(5,5,10));
          setLayout(new BorderLayout());
          JLabel title = new JLabel(" Select Level",JLabel.CENTER);
          title.setFont(new Font("Italic",Font.ITALIC,20));
          title.setForeground( Color.CYAN);
          add(title,BorderLayout.NORTH);
          JPanel buttonPanel = new JPanel();
          buttonPanel.setBackground(new Color(5,5,10));
          buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,50));
          for(int i=0; i<levelButtons.length; i++)
          {
            if((i+1)<=unlockedLevel)
            {
                levelButtons[i] = new JButton();
                levelButtons[i].setText("Level"+(i+1));
                levelButtons[i].setBackground(Color.cyan);
                levelButtons[i].setForeground(Color.BLACK);
                int level = i+1;
                levelButtons[i].addActionListener(e->mainFrame.startLevel(level));
                Font font = new Font("Arial",Font.BOLD,20);
                levelButtons[i].setFont(font);
              //  buttonPanel[i].setFont(new Font("Arila",Font.ITALIC,20));
                buttonPanel.add(levelButtons[i]);
            }
            else{
                         levelButtons[i]= new JButton();
                         levelButtons[i].setText("Level"+(i+1)+" 🔒");
                         levelButtons[i].setBackground(Color.GRAY);
                         levelButtons[i].setForeground(Color.darkGray);
                         Font font = new Font("Arial",Font.BOLD,20);
                         levelButtons[i].setFont(font);
                         levelButtons[i].setEnabled(false);
                         buttonPanel.add(levelButtons[i]);
            }
          }
          add(buttonPanel,BorderLayout.CENTER);

    }
    public void unlockNextLevel(int level) // For unlocking next level
    {
    if(level > unlockedLevel) {
        unlockedLevel = level;
    }
    refreshButtons();
   }
   public void refreshButtons()
   {      //level =1;
    for(int i=0; i<=4; i++)
    {
        if((i+1)<=unlockedLevel)
        {    
            //levelButtons[i] = new JButton();
             levelButtons[i].setEnabled(true);
             levelButtons[i].setBackground(Color.CYAN);
             levelButtons[i].setText("Level " + (i+1));
              int level = i + 1;
            for(var al : levelButtons[i].getActionListeners()) {
                levelButtons[i].removeActionListener(al);
             
        }
         levelButtons[i].addActionListener(e -> mainFrame.startLevel(level));
    }
        else{
             levelButtons[i].setEnabled(false);
            levelButtons[i].setBackground(Color.GRAY);
        }
    }
   }
}
