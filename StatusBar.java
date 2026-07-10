    import java.awt.*;
    import javax.swing.*;
    public class StatusBar extends JPanel{
    public  int level ;
    public int moves ;
    public int timeLeft;
    public boolean entangled;
        public  javax.swing.Timer countdownTimer;
        // JLabel levelLable ,moveLable,timeLable,statusLabel;
        JLabel   levelLabel = new JLabel("Level: 1");
      //   JLabel  moveLabel = new JLabel("Moves: 0");
        JLabel  timeLabel = new JLabel("Time: 01:00");
      //  JLabel statusLabel = new JLabel("Entanglement: ACTIVE");
        public StatusBar(MainFrame mainFrame  , int level)
        {          
            this.level = level;
            this.moves=0;
            if(this.level == 1) {this.timeLeft = 90;}
        else if(this.level == 2) {this.timeLeft = 90;}
        else if(this.level == 3) {this.timeLeft = 90;}
        else if(this.level == 4) {this.timeLeft = 90;}
        else if(this.level == 5) {this.timeLeft = 90;}
        else if(this.level == 6) {this.timeLeft = 90;}
        else if(this.level == 7) {this.timeLeft = 90;}
        else if(this.level == 8) {this.timeLeft = 90;}
        else if(this.level == 9) {this.timeLeft = 90;}
        else if(this.level == 10) {this.timeLeft = 90;}
            this.entangled = true;
            add(levelLabel);
       // add(moveLabel);
        add(timeLabel);
           // add(statusLabel);

                setBackground(new Color(0,0,0));
                setPreferredSize(new Dimension(0,60));
                levelLabel.setForeground(Color.CYAN);
              //  moveLabel.setForeground(Color.CYAN);
                timeLabel.setForeground(Color.CYAN);
               // statusLabel.setForeground(Color.CYAN);
                //mainFrame.showWinScreen(currentLevel);
                countdownTimer = new javax.swing.Timer(1000, e -> {  // Anonyumus class
                if (timeLeft > 0) {
                    timeLeft--;
                    timeLabel.setText("Time: " + timeLeft);
                } else {
                    countdownTimer.stop();
                // mainFrame.showWinScreen(mainFrame.currentLevel);
                mainFrame.showGameOver(mainFrame.currentLevel);
                    // Handle Game Over logic here
                }
            });
            countdownTimer.start();
            updateLabels();  // Onw method of StatusBar class
        }
    public void incrementMoves()
    {
        this.moves++;
        updateLabels();
    }
    public void nextLevel()
    {    
        this.level++;
        resetTimer();
        updateLabels();
    }
    public void setEntangled(boolean entangled)
    {
        this.entangled = entangled;
        updateLabels();
    }
    public int getTimeLeft()
    {
        return timeLeft;
    }
    public void resetTimer()
    {    countdownTimer.stop();
       // this.timeLeft =this.timeLeft;
        countdownTimer.start();
    }
    public void updateLabels()  // to update labels 
    {
        levelLabel.setText("Level: " + level);
      //  moveLabel.setText("Moves: " + moves);
        timeLabel.setText("Time: " + String.format("%02d:%02d", timeLeft/60, timeLeft%60));
      //  statusLabel.setText("Entanglement: "+(entangled ? "ACTIVE" : "BROKEN"));
    }
    }
