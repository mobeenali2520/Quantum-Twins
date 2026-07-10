
//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameOverScreen  extends JPanel {

     MainFrame mainFrame;
     int levelNumber = 1; 
    public  GameOverScreen(MainFrame mainFrame , int levelNumber)
    {   
         this.mainFrame = mainFrame;
         this.levelNumber = levelNumber;
       JPanel buttonPanel = new JPanel();
       buttonPanel.setLayout(new FlowLayout());
        setSize(400, 400);
        this.setLayout(new FlowLayout());
        setBackground(Color.RED);
        JButton tryAgain = new JButton("Try Again");
        JButton selectLevel = new JButton("Select Level");
        JButton exit  = new JButton("Exit");
        tryAgain.setForeground(Color.BLUE.brighter());
        selectLevel.setForeground(Color.MAGENTA.darker());
        exit.setForeground(Color.red.brighter());
        //add(buttonPanel);
        buttonPanel.add(tryAgain);
        buttonPanel.add(selectLevel);
        buttonPanel.add(exit);
        add(buttonPanel);
        tryAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                mainFrame.startLevel(levelNumber);
            }
        }); 
        selectLevel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                mainFrame.showLevelSelect();
            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                 System.exit(0);
            }
        });   
    }
    protected void paintComponent(Graphics g)
    {    
        super.paintComponent(g);
        //setForeground(Color.GREEN.brighter());
        g.setFont(new Font("Arial ",Font.ITALIC,25));
        g.setColor(Color.WHITE);
        g.drawString("Game Over ",100,100);
        g.drawString("Time is UP", 150, 150);
        g.drawString("Level failed", 200, 200); 


    }
}
