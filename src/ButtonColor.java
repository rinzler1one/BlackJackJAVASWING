import javax.swing.*;
import java.awt.*;

public class ButtonColor {
    ///This class is responsible for coloring the buttons that are clickable to green and
    ///coloring the buttons that are not clickable to red
    ///This helps guide the player in pressing the correct buttons for a smoother gameplay
    //fields
    GameView gameView;
    GameViewModel gameViewModel;
    public ButtonColor(GameView gameView, GameViewModel gameViewModel) {
        this.gameView = gameView;
        this.gameViewModel = gameViewModel;
    }
    //instance methods
    public void canPressColor(JButton button){
        Color green = Color.green;
        button.setForeground(green);

    }
    public void cannotPressColor(JButton button){
        Color red = Color.RED;
        button.setForeground(red);

    }



}
