import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
public class  WinScreen  extends JPanel {// winScreen appears when both particle reach exittile
    int levelNumber;
    
    public WinScreen(MainFrame mainFrame ,int levelNumber)
    {        
             setBackground(new Color(0,0,0));
             setLayout(new BorderLayout() );
               String nextText = (levelNumber==10)?"All Levels Complete":"Next Level";
             JButton   nextLevel = new JButton(nextText);
            //JButton nextLevel = new JButton("Next Level ");
            JButton exit = new JButton("EXIT ");
           // exit.System.exit(0);
           // nextLevel.mainFrame.startLevel(levelNumber+1);
           exit.addActionListener(e->System.exit(0));
         //  nextLevel.addActionListener(e->mainFrame.showLevelSelect());
           nextLevel.addActionListener(e -> mainFrame.startLevel(levelNumber + 1));
           // add(nextLevel,BorderLayout.SOUTH);
           // add(exit,BorderLayout.SOUTH);
           // nextLevel.addKeyListener(e->mainFrame.startLevel(levelNumber+1));
                JPanel buttonPanel = new JPanel();
               // setLayout(new BorderLayout());
               // add(nextLevel,BorderLayout.SOUTH);
               add(buttonPanel,BorderLayout.SOUTH);
                buttonPanel.add(nextLevel);
                buttonPanel.add(exit);
                setFocusable(true);
                addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e)
                    {
                        if(e.getKeyCode()==KeyEvent.VK_ENTER)
                        {
                            mainFrame.startLevel(levelNumber+1);
                        }
                    }
                });
                this.levelNumber = levelNumber ;
    }
     @Override
       protected  void paintComponent(Graphics g)
    {         
             super.paintComponent(g);
            g.setColor(Color.CYAN);
           // g.setFont(new Font(TOOL_TIP_TEXT_KEY, ALLBITS, 40));
           g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Congratalations You Win", 200, 100);
            g.drawString("Level " + levelNumber + " Complete!", 200, 150);
    }
}

