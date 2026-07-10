import java.awt.*;
import javax.swing.*;
public class WellComeScreen extends JPanel{
     public WellComeScreen(MainFrame mainFrame)
     {    
        setBackground(new Color(5,5,10));
        //setTitle("Quantum Twins");  it is method of JFrame
        setLayout(new BorderLayout());
        JButton button = new JButton("Start Game");
        button.setBackground(Color.MAGENTA);
        button.setForeground(Color.BLUE);
        button.setFont(new Font("Arial",Font.BOLD,24));
        button.setPreferredSize(new Dimension(200, 60));
        button.addActionListener(e->mainFrame.showLevelSelect());
        add(button,BorderLayout.SOUTH);
     }
      @Override
     protected void paintComponent(Graphics g) {  // Text on well come screen 
         super.paintComponent(g);
         g.setColor(Color.cyan);
         g.setFont(new Font("ARIAL",Font.BOLD,60));
         g.drawString("QUANTUM TWINS", 200, 150);
         g.setColor(Color.WHITE);
         g.setFont(new Font("Arial",Font.PLAIN,20));
         g.drawString("Second Semester OOP PROJECT", 280, 200);
          g.drawString("Use Arrow Keys to move both particles", 220, 350);
        g.drawString("Guide BOTH particles to EXIT to win! Stay away! from red tile", 220, 390);
     }
}
