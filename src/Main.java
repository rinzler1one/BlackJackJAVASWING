import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //instantiate game objects
        Deck deck = new Deck();
        Player player = new Player(1000, 0, false);
        Dealer dealer = new Dealer(1000, 0, false);
        //instantiate the model and pass in game objects
        GameModel gameModel = new GameModel(player, dealer, deck);
        //instantiate the view model and pass in the model
        GameViewModel gameViewModel = new GameViewModel(gameModel);
        //instantiate the view and pass in the view model
        GameView gameView = new GameView(gameViewModel);
        //instantiate ButtonColor object
        ButtonColor buttonColor = new ButtonColor(gameView, gameViewModel);
        //set the size of the view, set the content pane, and make it visible
        gameView.setSize(11000, 1000);
        gameView.setContentPane(gameView.MainPanel);
        gameView.setVisible(true);
        //The view knows about the view model and the view model knows about the model

        //this while true loop constantly checks the fields of gameViewModel to see which buttons can be clicked
        //if the button can be clicked, it will display green text, otherwise it will display red text
        //this helps guide the user for a smooth game play
        while(true){
            if(gameViewModel.getGameModel().getDealer().getHand().size() > 0){
                gameView.checkDealerTurn();
            }
            gameViewModel.buttonCheck();
            if(!gameView.isVisible()){ //if user exits, this while true loop will break which will end the program
                break;
            }
            if(gameViewModel.isShuffleButtonCanClick()){
                buttonColor.canPressColor(gameView.getShuffleButton());
            }else{
                buttonColor.cannotPressColor(gameView.getShuffleButton());
            }
            if(gameViewModel.isBetButtonCanClick()){
                buttonColor.canPressColor(gameView.getBetButton());
            }else{
                buttonColor.cannotPressColor(gameView.getBetButton());
            }
            if(gameViewModel.isDealButtonCanClick()){
                buttonColor.canPressColor(gameView.getDealButton());
            }else{
                buttonColor.cannotPressColor(gameView.getDealButton());
            }
            if(gameViewModel.isHitButtonCanClick()){
                buttonColor.canPressColor(gameView.getHitButton());
            }else{
                buttonColor.cannotPressColor(gameView.getHitButton());
            }
            if(gameViewModel.isStayButtonCanClick()){
                buttonColor.canPressColor(gameView.getStayButton());
            }else{
                buttonColor.cannotPressColor(gameView.getStayButton());
            }
            if(gameViewModel.isSplitButtonCanClick()){
                buttonColor.canPressColor(gameView.getSplitButton());
            }else{
                buttonColor.cannotPressColor(gameView.getSplitButton());
            }
            if(gameViewModel.isDoubleDownCanClick()){
                buttonColor.canPressColor(gameView.getDoubleDownButton());
            }else{
                buttonColor.cannotPressColor(gameView.getDoubleDownButton());
            }
            if(gameViewModel.isCheckStatsButtonCanClick()){
                buttonColor.canPressColor(gameView.getCheckStatsButton());
            }else{
                buttonColor.cannotPressColor(gameView.getCheckStatsButton());
            }
            if(gameViewModel.isInsuranceButtonCanClick()){
                buttonColor.canPressColor(gameView.getInsuranceButton());
            }else{
                buttonColor.cannotPressColor(gameView.getInsuranceButton());
            }
            if(gameViewModel.isNewGameButtonCanClick()){
                buttonColor.canPressColor(gameView.getNewGameButton());
            }else{
                buttonColor.cannotPressColor(gameView.getNewGameButton());
            }
            if(gameViewModel.isNewRoundButtonCanClick()){
                buttonColor.canPressColor(gameView.getNewRoundButton());
            }else{
                buttonColor.cannotPressColor(gameView.getNewRoundButton());
            }
            if(gameViewModel.isNoInsuranceButtonCanClick()){
                buttonColor.canPressColor(gameView.getNoInsuranceButton());
            }else{
                buttonColor.cannotPressColor(gameView.getNoInsuranceButton());
            }
        }
    }


}
