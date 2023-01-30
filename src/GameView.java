import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class GameView extends JFrame {

    ///This class represents the user interface and takes input from the user and updates the GameViewModel.
    ///This class manipulates the user interface based on the data contained in the GameModel
    private GameViewModel gameViewModel;
    public JPanel MainPanel;
    private JLabel playerFirstCardLabel;
    private JLabel playerSecondCardLabel;
    private JLabel playerThirdCardLabel;
    private JLabel playerFourthCardLabel;
    private JLabel playerFifthCardLabel;
    private JLabel playerSixthCardLabel;
    private JLabel playerSeventhCardLabel;
    private JLabel playerEigthCardLabel;
    private JLabel playerNinthCardLabel;
    private JLabel playerTenthCardLabel;

    private JLabel dealerFirstCardLabel;
    private JLabel dealerSecondCardLabel;
    private JLabel dealerThirdCardLabel;
    private JLabel dealerFourthCardLabel;
    private JLabel dealerFifthCardLabel;
    private JLabel dealerSixthCardLabel;
    private JLabel dealerSeventhCardLabel;
    private JLabel dealerEigthCardLabel;
    private JLabel dealerNinthCardLabel;
    private JLabel dealerTenthCardLabel;
    private JLabel dealerPersonLabel;
    private JLabel dealerActionLabel;
    private JLabel statsLabel;

    private JButton hitButton;
    private JButton stayButton;
    private JButton dealButton;
    private JButton betButton;
    private JButton shuffleButton;
    private JButton doubleDownButton;
    private JButton splitButton;
    private JButton checkStatsButton;
    private JButton insuranceButton;
    private JButton newGameButton;

    private JTextField betAmountTextField;
    private JButton newRoundButton;
    private JButton noInsuranceButton;


    public GameView(GameViewModel gameViewModel) {
    this.gameViewModel = gameViewModel;
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    //JButton action listeners anonymous classes calls corresponding instance methods
    hitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            hitButton();
        }
    });

    stayButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            stayButton();
        }
    });
    dealButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dealButton();
        }
    });
    betButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            betButton();

        }
    });
    shuffleButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            shuffleButton();
        }
    });
    doubleDownButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            doubleDownButton();
        }
    });
    splitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            splitButton();
        }
    });
    checkStatsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            checkStatsButton();
        }
    });
    insuranceButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            insuranceButton();
        }
    });
    newGameButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            newGameButton();
        }
    });
        newRoundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newRound();
            }
        });
        noInsuranceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noInsuranceButton();
            }
        });
    }

    //getter methods
    public JButton getHitButton() {
        return hitButton;
    }

    public JButton getStayButton() {
        return stayButton;
    }

    public JButton getDealButton() {
        return dealButton;
    }

    public JButton getNoInsuranceButton() {
        return noInsuranceButton;
    }

    public JButton getBetButton() {
        return betButton;
    }

    public JButton getShuffleButton() {
        return shuffleButton;
    }

    public JButton getDoubleDownButton() {
        return doubleDownButton;
    }

    public JButton getSplitButton() {
        return splitButton;
    }

    public JButton getCheckStatsButton() {
        return checkStatsButton;
    }

    public JButton getInsuranceButton() {
        return insuranceButton;
    }

    public JButton getNewGameButton() {
        return newGameButton;
    }

    public JButton getNewRoundButton() {
        return newRoundButton;
    }

    //setter methods
    public void setGameViewModel(GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
    }


    //instance methods
    public void hitButton(){
    if(gameViewModel.hitButtonClicked()){
        //figure out the label that the card should be displayed on
        ArrayList<JLabel> playerCardLabelsList = new ArrayList<JLabel>(); //this array list holds the labels that displays the card icons
        playerCardLabelsList.add(playerFirstCardLabel);
        playerCardLabelsList.add(playerSecondCardLabel);
        playerCardLabelsList.add(playerThirdCardLabel);
        playerCardLabelsList.add(playerFourthCardLabel);
        playerCardLabelsList.add(playerFifthCardLabel);
        playerCardLabelsList.add(playerSixthCardLabel);
        playerCardLabelsList.add(playerSeventhCardLabel);
        playerCardLabelsList.add(playerEigthCardLabel);
        playerCardLabelsList.add(playerNinthCardLabel);
        playerCardLabelsList.add(playerTenthCardLabel);
        //timer objects
        Timer showNextHandTimer = new Timer(1000, new ActionListener() {
            int count = 0;
            public void actionPerformed(ActionEvent e) {
                count++;
                if(count==2){
                    for(int i=0; i<gameViewModel.getGameModel().getPlayer().getSplitHand().size(); i++){
                        if(!gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).contains(-1)){
                            //clear all the labels first
                            for(int a=0; a<playerCardLabelsList.size(); a++){
                                ImageIcon blank = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\Untitled.png");
                                playerCardLabelsList.get(a).setIcon(blank);
                            }
                            for(int x=0; x<gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).size(); x++){ //display the card icons for each split hand in the appropiate label
                                if(gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).get(x) != -1){
                                    playerCardLabelsList.get(x).setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).get(x)));

                                }
                            }
                            break;
                        }
                    }
                    ((Timer)e.getSource()).stop(); //stops the timer
                }
            }
        });


        //check whether the hit card is in hand or splitHand (if the player split the hand)
        int card = 0;
        int indexOfLabel = 0;
        if(gameViewModel.getGameModel().getPlayer().getSplitHand().size() > 0){ //if the hand was split
            for(int i=0; i<gameViewModel.getGameModel().getPlayer().getSplitHand().size(); i++){
                if(gameViewModel.getShowedHandsList().contains(i)){ //if the hand stayed or busted, skip it and display the card icons for the next hand
                    continue;
                }
                //clear all the labels first
                for(int a=0; a<playerCardLabelsList.size(); a++){
                    ImageIcon blank = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\Untitled.png");
                    playerCardLabelsList.get(a).setIcon(blank);
                }
                //display the card icons of the current split hand in the appropiate labels
                for(int x=0; x<gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).size(); x++){ //display the card icons for each split hand in the appropiate label
                    if(gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).get(x) != -1){
                        playerCardLabelsList.get(x).setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).get(x)));

                    }
                }
                if(gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).contains(-1)){ //if the hand contains a -1 that means it busted
                    gameViewModel.getShowedHandsList().add(i); //add the index position of the split hand that contains -1 so it will skip this index and not display the split hand in this index
                    //display busted message
                    JDialogMessage bustedMessage = new JDialogMessage(100, 150, "You busted!",this);
                    bustedMessage.create();
                    //start timer object and inside timer object, display the cards of the next hand
                    showNextHandTimer.start();

                }
                break;


            }
        }else{
            card = gameViewModel.getGameModel().getPlayer().getHand().get(gameViewModel.getGameModel().getPlayer().getHand().size()-1);
            //get the index of the label of where this card should be displayed
            indexOfLabel = gameViewModel.getGameModel().getPlayer().getHand().size()-1;
            if(gameViewModel.getGameModel().getPlayer().getHand().contains(-1)){ //if player busted
                indexOfLabel = gameViewModel.getGameModel().getPlayer().getHand().size()-2;
                card = gameViewModel.getGameModel().getPlayer().getHand().get(gameViewModel.getGameModel().getPlayer().getHand().size()-2);

            }
            //display the card on the label
            playerCardLabelsList.get(indexOfLabel).setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(card));
            if(gameViewModel.getGameModel().getPlayer().getHand().contains(-1)){ //if player busted, show busted message
                JDialogMessage bustedMessage = new JDialogMessage(100, 150, "You busted!",this);
                bustedMessage.create();
            }

        }
    }else{
        //error message either not your turn or deck needs to be shuffled again
        JDialogMessage notYourTurnOrDeckNeedsToBeShuffledMessage = new JDialogMessage(700, 200, "Either it is not your turn or deck needs to be shuffled. Please check the color of the buttons for guidance.", this);
        notYourTurnOrDeckNeedsToBeShuffledMessage.create();
    }

    }
    public void stayButton(){
    if(gameViewModel.stayButtonClicked()){
        //timer objects
        Timer checkBlackJackTimer = new Timer(1000, new ActionListener() {
            int count = 0;
            public void actionPerformed(ActionEvent e) {
                count++;
                if(count==2){
                    if(checkPlayerAndDealerForBlackJack()){ //if player has blackjack
                        stayButton();
                    }else{
                        //reveal dealer's first card if you are on the last hand if player stayed on all hands
                        boolean stayedOnAllHands = true;
                        for(int i=0; i<gameViewModel.getGameModel().getPlayer().getSplitHand().size(); i++){
                            if(!gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).contains(-1)){
                                stayedOnAllHands = false;
                                break;
                            }
                        }
                        if(stayedOnAllHands){ //only reveal dealer's first card when player stayed on all hands
                            dealerFirstCardLabel.setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(gameViewModel.getGameModel().getDealer().getHand().get(0)));

                        }
                    }

                    ((Timer)e.getSource()).stop(); //stops the timer
                }
            }
        });


        //figure out the label that the card should be displayed on
        ArrayList<JLabel> playerCardLabelsList = new ArrayList<JLabel>(); //this array list holds the labels that displays the card icons
        playerCardLabelsList.add(playerFirstCardLabel);
        playerCardLabelsList.add(playerSecondCardLabel);
        playerCardLabelsList.add(playerThirdCardLabel);
        playerCardLabelsList.add(playerFourthCardLabel);
        playerCardLabelsList.add(playerFifthCardLabel);
        playerCardLabelsList.add(playerSixthCardLabel);
        playerCardLabelsList.add(playerSeventhCardLabel);
        playerCardLabelsList.add(playerEigthCardLabel);
        playerCardLabelsList.add(playerNinthCardLabel);
        playerCardLabelsList.add(playerTenthCardLabel);


        Timer dealNextHandTimer = new Timer(1000, new ActionListener() {
            int count = 0;
            public void actionPerformed(ActionEvent e) {
                count++;
                if(count==1){
                    //display the cards in the hand
                    for(int i=0; i<gameViewModel.getGameModel().getPlayer().getSplitHand().size(); i++){
                        if(!gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).contains(-1)){ //if the hand doesn't contain -1, that means it is the hand that didn't stay which means it is the next hand
                            //clear all the labels
                            for(int a=0; a<playerCardLabelsList.size(); a++){
                                URL imageUrl = getClass().getResource("/images/Untitled.png");
                                ImageIcon blank = new ImageIcon(imageUrl);
                                playerCardLabelsList.get(a).setIcon(blank);
                            }
                            //display the cards for the next hand
                            for(int x=0; x<gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).size(); x++){
                                playerCardLabelsList.get(x).setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).get(x)));
                            }
                            break;
                        }
                    }


                    ((Timer)e.getSource()).stop(); //stops the timer
                }
            }
        });


        //check if player split the hand
        if(gameViewModel.getGameModel().getPlayer().getSplitHand().size() > 0){
            //iterate through the split hands to see which one didn't stay (which is the next hand that should be displayed)and then display the cards for that hand
            dealNextHandTimer.start();
            checkBlackJackTimer.start();

        }else{ //if player didn't split the hand

            //clear all the labels first
            for(int a=0; a<playerCardLabelsList.size(); a++){
                URL imageUrl = getClass().getResource("/images/Untitled.png");
                ImageIcon blank = new ImageIcon(imageUrl);
                playerCardLabelsList.get(a).setIcon(blank);
            }



            //display your cards
            for(int i=0; i<gameViewModel.getGameModel().getPlayer().getHand().size(); i++){
                playerCardLabelsList.get(i).setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(gameViewModel.getGameModel().getPlayer().getHand().get(i)));

            }

        }
    }else{
        //error message it is not your turn
        JDialogMessage notYourTurnMessage = new JDialogMessage(200, 200, "It is not your turn.", this);
        notYourTurnMessage.create();

    }
    }
    public void dealButton(){
    //timer objects
        Timer dealTimer = new Timer(1000, new ActionListener() { //deals player's cards and dealer's cards one at a time.
            int count = 0;
            public void actionPerformed(ActionEvent e) {
                count++;
                if(count == 1){
                    //display player's first card face up
                    playerFirstCardLabel.setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(gameViewModel.getGameModel().getPlayer().getHand().get(0)));
                }else if(count == 2){
                    //display dealer's first card face down
                    dealerFirstCardLabel.setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(0));
                }else if(count == 3){
                    //display player's second card face up
                    playerSecondCardLabel.setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(gameViewModel.getGameModel().getPlayer().getHand().get(1)));
                }else if(count == 4){
                    //display dealer's second card face up
                    dealerSecondCardLabel.setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(gameViewModel.getGameModel().getDealer().getHand().get(1)));
                    gameViewModel.getGameModel().getPlayer().calculateHandValue(gameViewModel.getGameModel().getDeck()); //calculate player's hand value after dealing
                    gameViewModel.getGameModel().getDealer().calculateSelf(gameViewModel.getGameModel().getDeck()); //calculate dealer's hand value after dealing
                    checkPlayerAndDealerForBlackJack(); //check player and dealer for blackjack
                    gameViewModel.getGameModel().getDealer().checkIfShowingAce(); //checks to see if dealer is showing ace. toggles the showingAce of dealer to true or false

                    ((Timer)e.getSource()).stop();
                }
            }
        });

    if(gameViewModel.dealButtonClicked()){
        dealTimer.start();
    }else{
        //error message refer to the color of the buttons
        JDialogMessage referToColorOfButtonsMessage = new JDialogMessage(750, 200, "Please check the color of the buttons to see which ones need to be clicked before clicking the deal button.", this);
        referToColorOfButtonsMessage.create();

    }

    }
    public void betButton(){
    if(gameViewModel.betButtonClicked(betAmountTextField).equals("AmountAccepted")){
        //display bet amount
        JDialogMessage betAmountMessage = new JDialogMessage(200,200, "You bet " + gameViewModel.getGameModel().getPlayer().getBetAmount(),this);
        betAmountMessage.create();
    }else if(gameViewModel.betButtonClicked(betAmountTextField).equals("AmountUnaccepted")){
        //error message invalid amount. user did not enter correct min/max bet amount or does not have enough money for this bet amount
        JDialogMessage invalidAmountMessage = new JDialogMessage(1200, 250,"The amount you entered is not valid. Note that the bet amount has to be within the min and max range, your total amount has to cover this amount, and your bet amount has to be in 10's (divisble by 10).", this);
        invalidAmountMessage.create();
    }else if(gameViewModel.betButtonClicked(betAmountTextField).equals("Invalid")){
        //error message invalid input. user did not enter a valid integer, the input contains a string/character
        JDialogMessage invalidInputMessage = new JDialogMessage(250, 250, "You did not enter a valid number.", this);
        invalidInputMessage.create();
    }else if(gameViewModel.betButtonClicked(betAmountTextField).equals("Empty")){
        //error message no input. user did not enter anything in the bet amount text field before pressing the bet button.
        JDialogMessage noInputMessage = new JDialogMessage(300, 250, "You did not enter a number to make a bet.", this);
        noInputMessage.create();
    }else if(gameViewModel.betButtonClicked(betAmountTextField).equals("CannotPressYet")){
        //error message wait until new round to make bet or shuffle the cards
        JDialogMessage cannotPressYetMessage = new JDialogMessage(750, 250, "Please wait until a new round to make a bet or if the shuffle button is green then you need to press shuffle before betting.", this);
        cannotPressYetMessage.create();
    }

    }
    public void shuffleButton(){
    //timer objects
        Timer eraseShuffleTextTimer = new Timer(1000, new ActionListener() {
            int count = 0;
            public void actionPerformed(ActionEvent e) {
                count++;
                if(count==3){
                    dealerActionLabel.setText("");
                    ((Timer)e.getSource()).stop(); //stops the timer
                }
            }
        });

        if(gameViewModel.shuffleButtonClicked()){
            dealerActionLabel.setText("Shuffling");
            eraseShuffleTextTimer.start();
        }else{
            //error message using JDialog
            String text = "Dealer cannot shuffle again until there is less than 19 cards in the deck.";
            JDialogMessage cantShuffleErrorMessage = new JDialogMessage(450, 200, text,this);
            cantShuffleErrorMessage.create();
        }
    }

    public void doubleDownButton(){
    if(gameViewModel.doubleDownButtonClicked()){
        //figure out the label that the card should be displayed on
        ArrayList<JLabel> playerCardLabelsList = new ArrayList<JLabel>(); //this array list holds the labels that displays the card icons
        playerCardLabelsList.add(playerFirstCardLabel);
        playerCardLabelsList.add(playerSecondCardLabel);
        playerCardLabelsList.add(playerThirdCardLabel);
        playerCardLabelsList.add(playerFourthCardLabel);
        playerCardLabelsList.add(playerFifthCardLabel);
        playerCardLabelsList.add(playerSixthCardLabel);
        playerCardLabelsList.add(playerSeventhCardLabel);
        playerCardLabelsList.add(playerEigthCardLabel);
        playerCardLabelsList.add(playerNinthCardLabel);
        playerCardLabelsList.add(playerTenthCardLabel);

        //display double downed card
        if(gameViewModel.getGameModel().getPlayer().getSplitHand().size() > 0){
            for(int i=0; i<gameViewModel.getGameModel().getPlayer().getSplitHand().size(); i++){
                if(gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).size() == 3){
                    playerCardLabelsList.get(2).setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).get(2)));
                    break;
                }
            }
        }else{
            playerCardLabelsList.get(2).setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(gameViewModel.getGameModel().getPlayer().getHand().get(2)));

        }
        stayButton();

    }else{
        //error message not your turn or your current hand isn't on the third card or player doesn't have enough money for double down
        //check if player doesn't have enough money for double down
        if(gameViewModel.getGameModel().getPlayer().getTotalAmount() < gameViewModel.getGameModel().getPlayer().getBetAmount() * 2){
            JDialogMessage notEnoughMoney = new JDialogMessage(300, 200, "You do not have enough to double down.", this);
            notEnoughMoney.create();
        }else{
            JDialogMessage notYourTurnOrCurrentHandNotOnThirdCard = new JDialogMessage(500, 200, "Either it is not your turn or your current hand isn't on the third card.", this);
            notYourTurnOrCurrentHandNotOnThirdCard.create();
        }

    }

    }
    public void splitButton(){
    if(gameViewModel.splitButtonClicked()){
        //needs timer object here that counts to 1 second and then tests to see if the hand has blackjack
        Timer checkBlackJackTimer = new Timer(1000, new ActionListener() {
            int count = 0;
            public void actionPerformed(ActionEvent e) {
                count++;
                if(count==2){
                    if(checkPlayerAndDealerForBlackJack()){ //if player has blackjack
                        stayButton();
                    }

                    ((Timer)e.getSource()).stop(); //stops the timer
                }
            }
        });


        //display the first split hand on playerFirstCardLabel and playerSecondCardLabel
        playerFirstCardLabel.setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(gameViewModel.getGameModel().getPlayer().getSplitHand().get(0).get(0)));
        playerSecondCardLabel.setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(gameViewModel.getGameModel().getPlayer().getSplitHand().get(0).get(1)));

        checkBlackJackTimer.start();





    }else{
        //error message cannot split this hand
        //determine if hand can't split because player doesn't have enough cash or because the hand cannot split
        boolean notEnoughMoney = false;
        if(gameViewModel.getGameModel().getPlayer().getSplitHand().size() > 0){
            int totalNumberOfHands = 0;
            for(int i=0; i<gameViewModel.getGameModel().getPlayer().getSplitHand().size(); i++){
                totalNumberOfHands += gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).size();
            }
            if(gameViewModel.getGameModel().getPlayer().getTotalAmount() < totalNumberOfHands * gameViewModel.getGameModel().getPlayer().getBetAmount()){
                notEnoughMoney = true;
            }
        }else{
            if(gameViewModel.getGameModel().getPlayer().getTotalAmount() < gameViewModel.getGameModel().getPlayer().getHand().size() * gameViewModel.getGameModel().getPlayer().getBetAmount()){
                notEnoughMoney = true;
            }
        }
        if(notEnoughMoney){
            JDialogMessage notEnoughMoneyMessage = new JDialogMessage(250, 300, "You do not have enough to split.", this);
            notEnoughMoneyMessage.create();
        }else{
            JDialogMessage cannotSplitMessage = new JDialogMessage(200, 200, "You cannot split this hand.", this);
            cannotSplitMessage.create();
        }

    }

    }
    public void checkStatsButton(){
    //This is the only method in GameView that doesn't update GameViewModel because it just displays the data inside GameModel in the UI
        int minBet = 10;
        int maxBet = 50;
        int playerTotal = gameViewModel.getGameModel().getPlayer().getTotalAmount();
        int playerBetAmount = gameViewModel.getGameModel().getPlayer().getBetAmount();
        int playerHandValue = gameViewModel.getGameModel().getPlayer().getHandValue();
        int playerSecondHandValue = gameViewModel.getGameModel().getPlayer().getSecondHandValue();
        int playerFinalHandValue = gameViewModel.getGameModel().getPlayer().getFinalHandValue();
        int playerInsuranceBetAmount = gameViewModel.getGameModel().getPlayer().getInsuranceBetAmount();

        //if player split the hand then show the hand value, second hand value, and final hand value for the current hand
        if(gameViewModel.getGameModel().getPlayer().getSplitHand().size() > 0){
            for(int i=0; i<gameViewModel.getGameModel().getPlayer().getSplitHand().size(); i++){
                if(!gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).contains(-1)){
                    playerFinalHandValue = gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i);
                    //if the current hand has an ace then figure out the values for playerHandValue and playerSecondHandValue
                    if(gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).contains(1) || gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).contains(2) || gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).contains(3) || gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).contains(4)){
                        int value = 0;
                        int secondValue = 0;
                        for(int x=0; x<gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).size(); x++){
                            value += gameViewModel.getGameModel().getDeck().getCardStrengthsLinkedHashMap().get(gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).get(x));
                        }
                        secondValue = value + 10;
                        if(playerFinalHandValue == value){
                            playerHandValue = value;
                            playerSecondHandValue = 0;
                        }else if(playerFinalHandValue == secondValue){
                            playerHandValue = value;
                            playerSecondHandValue = secondValue;
                        }
                    }
                    break;
                }
            }
        }
        int playerNumberOfHands = 0;
        if(gameViewModel.getGameModel().getPlayer().getSplitHand().size() > 0){
            playerNumberOfHands = gameViewModel.getGameModel().getPlayer().getSplitHand().size();
        }else{
            if(gameViewModel.getGameModel().getPlayer().getHand().size() > 0){
                playerNumberOfHands = 1;
            }else{
                playerNumberOfHands = 0;
            }
        }


        //if it is dealer's turn then set all the values to 0
        if(gameViewModel.getGameModel().getDealer().isTurn()){
            playerHandValue = 0;
            playerSecondHandValue = 0;
            playerFinalHandValue = 0;
            playerNumberOfHands = 0;
        }

        int dealerTotal = gameViewModel.getGameModel().getDealer().getTotalAmount();
        int dealerBetAmount = playerBetAmount;
        int dealerHandValue;
        if(gameViewModel.getGameModel().getDealer().getHand().size() == 2){
            dealerHandValue = 0;
        }else{
            dealerHandValue = gameViewModel.getGameModel().getDealer().getHandValue();
        }


        JDialog statsMessage = new JDialog();
        statsMessage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JLabel textLabel = new JLabel();
        textLabel.setText("<html>Minimum bet: " + minBet + "<br>" + "Maximum bet: " + maxBet + "<br>" + "<br>" + "Your total amount: " + playerTotal + "<br>" + "Your bet amount: " + playerBetAmount + "<br>" + "Your hand value: " + playerHandValue + "<br>" + "Your second hand value: " + playerSecondHandValue + "<br>" + "Your final hand value: " + playerFinalHandValue + "<br>" + "Your insurance bet amount: " + playerInsuranceBetAmount + "<br>" + "Total number of hands: " + playerNumberOfHands + "<br>" + "<br>" + "Dealer total: " + dealerTotal + "<br>" + "Dealer bet amount: " + dealerBetAmount + "<br>" + "Dealer hand value: " + dealerHandValue + "</html>");
        textLabel.setVisible(true);
        statsMessage.add(textLabel);
        statsMessage.setSize(450, 450);
        statsMessage.setLocationRelativeTo(this);
        statsMessage.setAlwaysOnTop(true);
        statsMessage.setVisible(true);

    }
    public void insuranceButton(){
    if(gameViewModel.insuranceButtonClicked()){ //when this returns true, it means player already made insurance bet and if dealer has blackjack then dealer will's hand value and second hand value will be 21 and the insurance bet amount will already be added or deducted from player's total amount
        //if dealer has blackjack then it would be dealer's turn
        if(gameViewModel.getGameModel().getDealer().isHasBlackJack()){
            checkDealerTurn();
        }else{
            JDialogMessage dealerDoesntHaveBlackJack = new JDialogMessage(350, 200, "Dealer does not have blackjack. You lose " + gameViewModel.getGameModel().getPlayer().getInsuranceBetAmount(), this);
            dealerDoesntHaveBlackJack.create();
        }

    }else{
        //error message not your turn or dealer not showing an ace or already clicked on insurance or not enough money to cover insurance bet
        //first check to see if player has enough money to cover insurance bet
        int insuranceBet = gameViewModel.getGameModel().getPlayer().getBetAmount() / 2;
        if(gameViewModel.getGameModel().getPlayer().getTotalAmount() < gameViewModel.getGameModel().getPlayer().getBetAmount() + insuranceBet){
            JDialogMessage notEnoughMoneyMessage = new JDialogMessage(300, 250, "You do not have enough to cover the insurance bet.", this);
            notEnoughMoneyMessage.create();
        }else{
            JDialogMessage notYourTurnOrDealerNotShowingAceOrAlreadyClickedInsurance = new JDialogMessage(600,200, "Either it is not your turn, dealer is not showing an ace, or you already clicked insurance.", this);
            notYourTurnOrDealerNotShowingAceOrAlreadyClickedInsurance.create();
        }


    }

    }
    public void newGameButton(){
    if(gameViewModel.newGameButtonClicked()){
        //set gameOver to false to reactivate the buttons
        gameViewModel.setGameOver(false);
        //clear all the labels
        ArrayList<JLabel> playerCardLabelsList = new ArrayList<JLabel>(); //this array list holds the labels that displays the card icons
        playerCardLabelsList.add(playerFirstCardLabel);
        playerCardLabelsList.add(playerSecondCardLabel);
        playerCardLabelsList.add(playerThirdCardLabel);
        playerCardLabelsList.add(playerFourthCardLabel);
        playerCardLabelsList.add(playerFifthCardLabel);
        playerCardLabelsList.add(playerSixthCardLabel);
        playerCardLabelsList.add(playerSeventhCardLabel);
        playerCardLabelsList.add(playerEigthCardLabel);
        playerCardLabelsList.add(playerNinthCardLabel);
        playerCardLabelsList.add(playerTenthCardLabel);
        ArrayList<JLabel> dealerCardLabelsList = new ArrayList<JLabel>(); //this array list holds the labels that displays the card icons
        dealerCardLabelsList.add(dealerFirstCardLabel);
        dealerCardLabelsList.add(dealerSecondCardLabel);
        dealerCardLabelsList.add(dealerThirdCardLabel);
        dealerCardLabelsList.add(dealerFourthCardLabel);
        dealerCardLabelsList.add(dealerFifthCardLabel);
        dealerCardLabelsList.add(dealerSixthCardLabel);
        dealerCardLabelsList.add(dealerSeventhCardLabel);
        dealerCardLabelsList.add(dealerEigthCardLabel);
        dealerCardLabelsList.add(dealerNinthCardLabel);
        dealerCardLabelsList.add(dealerTenthCardLabel);
        for(int i=0; i<playerCardLabelsList.size(); i++){
            ImageIcon blank = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\Untitled.png");
            playerCardLabelsList.get(i).setIcon(blank);
            dealerCardLabelsList.get(i).setIcon(blank);
        }
        //reset the game data
        gameViewModel.getGameModel().getPlayer().resetData();
        gameViewModel.getGameModel().getDealer().resetData();
        gameViewModel.getGameModel().getDeck().resetData();





    }

    }
    public void checkDealerTurn(){
    //if it is dealer's turn, then display the appropiate UI actions
    if(gameViewModel.checkDealerTurn()){ //by the time this returns true, dealer has already finished hitting and this method just needs to display dealer's cards on the labels
        //timer objects
        ArrayList<JLabel> dealerCardLabelsList = new ArrayList<JLabel>();
        ArrayList<Integer> cardsThatHaveBeenDisplayed = new ArrayList<Integer>();
        dealerCardLabelsList.add(dealerFirstCardLabel);
        dealerCardLabelsList.add(dealerSecondCardLabel);
        dealerCardLabelsList.add(dealerThirdCardLabel);
        dealerCardLabelsList.add(dealerFourthCardLabel);
        dealerCardLabelsList.add(dealerFifthCardLabel);
        dealerCardLabelsList.add(dealerSixthCardLabel);
        dealerCardLabelsList.add(dealerSeventhCardLabel);
        dealerCardLabelsList.add(dealerEigthCardLabel);
        dealerCardLabelsList.add(dealerNinthCardLabel);
        dealerCardLabelsList.add(dealerTenthCardLabel);

        Timer dealTimer = new Timer(1000, new ActionListener() { //deals player's cards and dealer's cards one at a time.ArrayList<JLabel> dealerCardLabelsList = new ArrayList<JLabel>(); //this array list holds the labels that displays the card icons
            int count = 2;
            int index = count;
            public void actionPerformed(ActionEvent e) {
                if(count == index){
                    if(count == gameViewModel.getGameModel().getDealer().getHand().size()){
                        count = 2;
                        index = count;
                        determineWinner(); //after displaying dealer's cards, this method needs to get called to determine winner of the round
                        ((Timer)e.getSource()).stop();
                    }
                    dealerCardLabelsList.get(index).setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(gameViewModel.getGameModel().getDealer().getHand().get(index)));
                    count++;
                    index++;

                }

            }
        });
        //display dealer's face down card
        dealerFirstCardLabel.setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(gameViewModel.getGameModel().getDealer().getHand().get(0)));

        //display the rest of dealer's cards one at a time only if dealer doesn't have blackjack
        if(gameViewModel.getGameModel().getDealer().getHand().size() != 2){ //if dealer doesn't have blackjack (dealer has blackjack if dealer only has two cards since dealer can't hit if theres blackjack)
            dealTimer.start(); //displays dealer's hit cards one at a time per second
        }else{ //if dealer does have blackjack then end the round
            determineWinner();
        }

    }
    }
    public void displayEndOfRoundMessageSplitHand(){
    //check to see if player split the hand
        if(gameViewModel.getGameModel().getPlayer().getSplitHand().size() > 0){
            String text = "<html>";
            for(int i=0; i<gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().size(); i++){
                if(gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) > gameViewModel.getGameModel().getDealer().getHandValue()){
                    if(gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) <= 21){
                        boolean playerHasBlackJack = false;
                        //check blackjack for player
                        if(gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) == 21 && gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).size() == 3){ //if this hand value is 21 and has 2 cards (including the -1) then it has to be a blackjack
                            playerHasBlackJack = true;
                        }
                        if(playerHasBlackJack){
                            String tempText = "Hand " + (i+1) + "." + " Your hand value: Blackjack! " + " Dealer Hand Value: " + gameViewModel.getGameModel().getDealer().getHandValue() + " You won " + gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i) + "<br>";
                            text += tempText;
                        }else{
                            String tempText = "Hand " + (i+1) + "." + " Your hand value: " + gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) + "  Dealer Hand Value: " + gameViewModel.getGameModel().getDealer().getHandValue() + " You won " + gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i) + "<br>";
                            text += tempText;

                        }


                    }else{
                        //check blackjack for dealer
                        boolean dealerHasBlackJack = false;
                        //check blackjack for dealer
                        if(gameViewModel.getGameModel().getDealer().getHand().size() == 3 && gameViewModel.getGameModel().getDealer().getHandValue() == 11){ //if dealer has two cards including the -1
                            dealerHasBlackJack = true;
                        }
                        if(dealerHasBlackJack){
                            String tempText = "Hand " + (i+1) + "." + " Your hand value: " + gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) + "  Dealer Hand Value: Blackjack!" + " You loss " + gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i) + "<br>";
                            text += tempText;
                        }else{
                            String tempText = "Hand " + (i+1) + "." + " Your hand value: " + gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) + "  Dealer Hand Value: " + gameViewModel.getGameModel().getDealer().getHandValue() + " You loss " + gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i) + "<br>";
                            text += tempText;
                        }

                    }

                }else if(gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) < gameViewModel.getGameModel().getDealer().getHandValue()){
                    if(gameViewModel.getGameModel().getDealer().getHandValue() <= 21){
                        boolean dealerHasBlackJack = false;
                        //check blackjack for dealer
                        if(gameViewModel.getGameModel().getDealer().getHand().size() == 3 && gameViewModel.getGameModel().getDealer().getHandValue() == 11){ //if dealer has two cards including the -1
                            dealerHasBlackJack = true;
                        }
                        if(dealerHasBlackJack){
                            String tempText = "Hand " + (i+1) + "." + " Your hand value: " + gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) + "  Dealer Hand Value: Blackjack! " + " You loss " + gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i) + "<br>";
                            text += tempText;
                        }else{
                            String tempText = "Hand " + (i+1) + "." + " Your hand value: " + gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) + "  Dealer Hand Value: " + gameViewModel.getGameModel().getDealer().getHandValue() + " You loss " + gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i) + "<br>";
                            text += tempText;
                            
                        }
                    }else{
                        //check blackjack for player
                        boolean playerHasBlackJack = false;
                        if(gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) == 21 && gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).size() == 3){ //if this hand value is 21 and has 2 cards (including the -1) then it has to be a blackjack
                            playerHasBlackJack = true;
                        }
                        if(playerHasBlackJack){
                            String tempText = "Hand " + (i+1) + "." + " Your hand value: Blackjack!" + " Dealer Hand Value: " + gameViewModel.getGameModel().getDealer().getHandValue() + " You won " + (gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i) * 2) + "<br>";
                            text += tempText;
                        }else{
                            String tempText = "Hand " + (i+1) + "." + " Your hand value: " + gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) + "  Dealer Hand Value: " + gameViewModel.getGameModel().getDealer().getHandValue() + " You won " + gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i) + "<br>";
                            text += tempText;
                        }

                    }


                }else if(gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) == gameViewModel.getGameModel().getDealer().getHandValue()){
                    //if player has 21
                    boolean playerHasBlackJack = false;
                    boolean dealerHasBlackJack = false;
                    //check blackjack for player
                    if(gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) == 21 && gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).size() == 3){ //if this hand value is 21 and has 2 cards (including the -1) then it has to be a blackjack
                        playerHasBlackJack = true;
                    }
                    //check blackjack for dealer
                    if(gameViewModel.getGameModel().getDealer().getHand().size() == 3 && gameViewModel.getGameModel().getDealer().getHandValue() == 11){ //if dealer has two cards including the -1
                        dealerHasBlackJack = true;
                    }
                    if(playerHasBlackJack && !dealerHasBlackJack){
                        String tempText = "Hand " + (i+1) + "." + " Your hand value: " + gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) + "  Dealer Hand Value: " + gameViewModel.getGameModel().getDealer().getHandValue() + " You hit blackjack! You won " + gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i) + "<br>";
                        text += tempText;

                    }else if(!playerHasBlackJack && dealerHasBlackJack){
                        String tempText = "Hand " + (i+1) + "." + " Your hand value: " + gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) + "  Dealer Hand Value: " + gameViewModel.getGameModel().getDealer().getHandValue() + " Dealer hit blackjack. You loss " + gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i) + "<br>";
                        text += tempText;

                    }else{
                        String tempText = "Hand " + (i+1) + "." + " Your hand value: " + gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) + "  Dealer Hand Value: " + gameViewModel.getGameModel().getDealer().getHandValue() + "You push " + "<br>";
                        text += tempText;
                    }

                } else{


                }
            }

            JDialogMessage EndRoundMessage = new JDialogMessage(450, 200, text, this);
            EndRoundMessage.create();
        }
    }
    public void displayWonRoundMessage(){
        if(!gameViewModel.getGameModel().getPlayer().isHasBlackJack()){
            JDialogMessage wonRoundMessage = new JDialogMessage(200, 200, "You won " + gameViewModel.getGameModel().getPlayer().getBetAmount(), this);
            wonRoundMessage.create();
        }else{
            JDialogMessage wonRoundMessage = new JDialogMessage(200, 200, "You won " + (gameViewModel.getGameModel().getPlayer().getBetAmount()*2), this);
            wonRoundMessage.create();
        }
        
    }
    public void displayLossRoundMessage(){
        JDialogMessage lossRoundMessage = new JDialogMessage(200, 200, "You loss " + gameViewModel.getGameModel().getPlayer().getBetAmount(), this);
        lossRoundMessage.create();
    }
    public void pushMessage(){
    JDialogMessage pushMessage = new JDialogMessage(100, 200, "Push!", this);
    pushMessage.create();
    }
    public void noMoreMoneyMessage(){
    JDialogMessage noMoreMoneyMessage = new JDialogMessage(250, 200, "You do not have enough to play! You lose.", this);
    noMoreMoneyMessage.create();
    }
    public void dealerHasNoMoreMoneyMessage(){
        JDialogMessage noMoreMoneyMessage = new JDialogMessage(250, 200, "Dealer has no more money to play. You won!", this);
        noMoreMoneyMessage.create();


    }
    public void newRound(){
    if(gameViewModel.newRound()){
        //clear all the labels
        ArrayList<JLabel> playerCardLabelsList = new ArrayList<JLabel>(); //this array list holds the labels that displays the card icons
        playerCardLabelsList.add(playerFirstCardLabel);
        playerCardLabelsList.add(playerSecondCardLabel);
        playerCardLabelsList.add(playerThirdCardLabel);
        playerCardLabelsList.add(playerFourthCardLabel);
        playerCardLabelsList.add(playerFifthCardLabel);
        playerCardLabelsList.add(playerSixthCardLabel);
        playerCardLabelsList.add(playerSeventhCardLabel);
        playerCardLabelsList.add(playerEigthCardLabel);
        playerCardLabelsList.add(playerNinthCardLabel);
        playerCardLabelsList.add(playerTenthCardLabel);
        ArrayList<JLabel> dealerCardLabelsList = new ArrayList<JLabel>(); //this array list holds the labels that displays the card icons
        dealerCardLabelsList.add(dealerFirstCardLabel);
        dealerCardLabelsList.add(dealerSecondCardLabel);
        dealerCardLabelsList.add(dealerThirdCardLabel);
        dealerCardLabelsList.add(dealerFourthCardLabel);
        dealerCardLabelsList.add(dealerFifthCardLabel);
        dealerCardLabelsList.add(dealerSixthCardLabel);
        dealerCardLabelsList.add(dealerSeventhCardLabel);
        dealerCardLabelsList.add(dealerEigthCardLabel);
        dealerCardLabelsList.add(dealerNinthCardLabel);
        dealerCardLabelsList.add(dealerTenthCardLabel);
        for(int i=0; i<playerCardLabelsList.size(); i++){
            ImageIcon blank = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\Untitled.png");
            playerCardLabelsList.get(i).setIcon(blank);
        }
        for(int i=0; i<dealerCardLabelsList.size(); i++){
            ImageIcon blank = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\Untitled.png");
            dealerCardLabelsList.get(i).setIcon(blank);

        }
    }else{
        //error message cannot start new round
        JDialogMessage cannotStartNewRound = new JDialogMessage(250, 200, "Cannot start a new round now.", this);
        cannotStartNewRound.create();
    }

    }
    private void determineWinner(){
        //This is the only method in the GameView class that performs calculations and updates the GameModel objects directly
        //first check to see if player busted
         if(gameViewModel.getGameModel().getDealer().isHasBlackJack() && !gameViewModel.getGameModel().getPlayer().isHasBlackJack()){
            gameViewModel.getGameModel().getDealer().setHasBlackJack(false);
            if(gameViewModel.getGameModel().getPlayer().getInsuranceBetAmount() > 0){ //if dealer has blackjac and player made the insurance bet
                JDialogMessage dealerHasBlackJack = new JDialogMessage(400, 200, "Dealer has blackjack! You won the insurance bet. Push!", this);
                dealerHasBlackJack.create();
                gameViewModel.setNewRoundButtonCanClick(true);

            }else if(gameViewModel.getGameModel().getPlayer().getInsuranceBetAmount() == 0){ //if dealer has blackjack and player didn't make the insurane bet
                gameViewModel.getGameModel().getPlayer().setTotalAmount(gameViewModel.getGameModel().getPlayer().getTotalAmount() - gameViewModel.getGameModel().getPlayer().getBetAmount());
                gameViewModel.getGameModel().getDealer().setTotalAmount(gameViewModel.getGameModel().getDealer().getTotalAmount() + gameViewModel.getGameModel().getDealer().getBetAmount());
                JDialogMessage dealerHasBlackJack = new JDialogMessage(400, 200, "Dealer has blackjack! You loss " + gameViewModel.getGameModel().getPlayer().getBetAmount(),this);
                dealerHasBlackJack.create();
                gameViewModel.setNewRoundButtonCanClick(true);
            }
             //check to see if the player or dealer ran out of money to determine if game is over
             if(gameViewModel.getGameModel().getPlayer().getTotalAmount() < 10){ //check to see if player has no more money
                 noMoreMoneyMessage();
                 gameViewModel.setGameOver(true);
             }else if(gameViewModel.getGameModel().getDealer().getTotalAmount() < 10) { //check to see if dealer has no more money
                 dealerHasNoMoreMoneyMessage();
                 gameViewModel.setGameOver(true);
             }

        } else{
            //if the round is over (which means player's turn and dealer's turn is set to false
            //figure out if round is over when player's hand and dealer's hand contain -1
            boolean playerStayedOnAllHands = true;
            boolean dealerStayedOnHand = true;
            if(gameViewModel.getGameModel().getPlayer().getSplitHand().size() > 0){
                for(int i=0; i<gameViewModel.getGameModel().getPlayer().getSplitHand().size(); i++){
                    if(!gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).contains(-1)){
                        playerStayedOnAllHands = false;
                    }
                }
                if(!gameViewModel.getGameModel().getDealer().getHand().contains(-1)){
                    dealerStayedOnHand = false;
                }

            }else{
                if(!gameViewModel.getGameModel().getPlayer().getHand().contains(-1)){
                    playerStayedOnAllHands = false;
                }
                if(!gameViewModel.getGameModel().getDealer().getHand().contains(-1)){
                    dealerStayedOnHand = false;
                }
            }
            if(playerStayedOnAllHands && dealerStayedOnHand){ //if the round is over
                //find out if player split hand
                if(gameViewModel.getGameModel().getPlayer().getSplitHand().size() > 0){
                    for(int i=0; i<gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().size(); i++){
                        if(gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) > gameViewModel.getGameModel().getDealer().getHandValue()){
                            if(gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) <= 21){
                                //check if player has blackjack
                                boolean playerHasBlackJack = false;
                                //check blackjack for player
                                if(gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) == 21 && gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).size() == 3){ //if this hand value is 21 and has 2 cards (including the -1) then it has to be a blackjack
                                    playerHasBlackJack = true;

                                }
                                if(playerHasBlackJack){
                                    gameViewModel.getGameModel().getPlayer().setTotalAmount(gameViewModel.getGameModel().getPlayer().getTotalAmount() + (gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i) * 2));
                                    gameViewModel.getGameModel().getDealer().setTotalAmount(gameViewModel.getGameModel().getDealer().getTotalAmount() - (gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i) * 2));
                                }else{
                                    gameViewModel.getGameModel().getPlayer().setTotalAmount(gameViewModel.getGameModel().getPlayer().getTotalAmount() + gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i));
                                    gameViewModel.getGameModel().getDealer().setTotalAmount(gameViewModel.getGameModel().getDealer().getTotalAmount() - gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i));
                                }


                            }else{ //if the hand busted
                                gameViewModel.getGameModel().getPlayer().setTotalAmount(gameViewModel.getGameModel().getPlayer().getTotalAmount() - gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i));
                                gameViewModel.getGameModel().getDealer().setTotalAmount(gameViewModel.getGameModel().getDealer().getTotalAmount() + gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i));
                            }

                        }else if(gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) < gameViewModel.getGameModel().getDealer().getHandValue()){
                            if(gameViewModel.getGameModel().getDealer().getHandValue() <= 21){
                                gameViewModel.getGameModel().getPlayer().setTotalAmount(gameViewModel.getGameModel().getPlayer().getTotalAmount() - gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i));
                                gameViewModel.getGameModel().getDealer().setTotalAmount(gameViewModel.getGameModel().getDealer().getTotalAmount() + gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i));
                            }else{ //if dealer's hand busted
                                //check if player has blackjack
                                boolean playerHasBlackJack = false;
                                //check blackjack for player
                                if(gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) == 21 && gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).size() == 3){ //if this hand value is 21 and has 2 cards (including the -1) then it has to be a blackjack
                                    playerHasBlackJack = true;

                                }
                                if(playerHasBlackJack){
                                    gameViewModel.getGameModel().getPlayer().setTotalAmount(gameViewModel.getGameModel().getPlayer().getTotalAmount() + (gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i) * 2));
                                    gameViewModel.getGameModel().getDealer().setTotalAmount(gameViewModel.getGameModel().getDealer().getTotalAmount() - (gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i) * 2));
                                }else{
                                    gameViewModel.getGameModel().getPlayer().setTotalAmount(gameViewModel.getGameModel().getPlayer().getTotalAmount() + gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i));
                                    gameViewModel.getGameModel().getDealer().setTotalAmount(gameViewModel.getGameModel().getDealer().getTotalAmount() - gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i));
                                }

                            }


                        }else if(gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) == gameViewModel.getGameModel().getDealer().getHandValue()){ //if player and dealer has equal hand values
                            //if player has 21
                            boolean playerHasBlackJack = false;
                            boolean dealerHasBlackJack = false;
                            //check blackjack for player
                            if(gameViewModel.getGameModel().getPlayer().getSplitHandValueAmounts().get(i) == 21 && gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).size() == 3){ //if this hand value is 21 and has 2 cards (including the -1) then it has to be a blackjack
                                playerHasBlackJack = true;

                            }
                            //check blackjack for dealer
                            if(gameViewModel.getGameModel().getDealer().getHand().size() == 3 && gameViewModel.getGameModel().getDealer().getHandValue() == 11){ //if dealer has two cards including the -1
                                dealerHasBlackJack = true;

                            }
                            if(playerHasBlackJack && !dealerHasBlackJack){
                                gameViewModel.getGameModel().getPlayer().setTotalAmount(gameViewModel.getGameModel().getPlayer().getTotalAmount() + (gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i) * 2));
                                gameViewModel.getGameModel().getDealer().setTotalAmount(gameViewModel.getGameModel().getDealer().getTotalAmount() - (gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i) * 2));

                            }else if(!playerHasBlackJack && dealerHasBlackJack){
                                gameViewModel.getGameModel().getPlayer().setTotalAmount(gameViewModel.getGameModel().getPlayer().getTotalAmount() - gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i));
                                gameViewModel.getGameModel().getDealer().setTotalAmount(gameViewModel.getGameModel().getDealer().getTotalAmount() + gameViewModel.getGameModel().getPlayer().getSplitBetAmount().get(i));

                            }else{
                                pushMessage();
                            }
                        }
                    }
                    displayEndOfRoundMessageSplitHand();
                    gameViewModel.setNewRoundButtonCanClick(true);
                    //check to see if the player or dealer ran out of money to determine if game is over
                    if(gameViewModel.getGameModel().getPlayer().getTotalAmount() < 10){ //check to see if player has no more money
                        noMoreMoneyMessage();
                        gameViewModel.setGameOver(true);
                    }else if(gameViewModel.getGameModel().getDealer().getTotalAmount() < 10) { //check to see if dealer has no more money
                        dealerHasNoMoreMoneyMessage();
                        gameViewModel.setGameOver(true);
                    }
                }else{
                    if(playerStayedOnAllHands && dealerStayedOnHand){
                        //if player's hand beats dealer's hand
                        if(gameViewModel.getGameModel().getPlayer().getFinalHandValue() > gameViewModel.getGameModel().getDealer().getHandValue()){
                            //make sure player's hand didn't bust
                            if(gameViewModel.getGameModel().getPlayer().getFinalHandValue() <= 21){
                                gameViewModel.getGameModel().getPlayer().setTotalAmount(gameViewModel.getGameModel().getPlayer().getTotalAmount() + gameViewModel.getGameModel().getPlayer().getBetAmount());
                                gameViewModel.getGameModel().getDealer().setTotalAmount(gameViewModel.getGameModel().getDealer().getTotalAmount() - gameViewModel.getGameModel().getDealer().getBetAmount());
                                displayWonRoundMessage();
                            }else{
                                gameViewModel.getGameModel().getPlayer().setTotalAmount(gameViewModel.getGameModel().getPlayer().getTotalAmount() - gameViewModel.getGameModel().getPlayer().getBetAmount());
                                gameViewModel.getGameModel().getDealer().setTotalAmount(gameViewModel.getGameModel().getDealer().getTotalAmount() + gameViewModel.getGameModel().getDealer().getBetAmount());
                                displayLossRoundMessage();
                            }
                        }else if(gameViewModel.getGameModel().getPlayer().getFinalHandValue() < gameViewModel.getGameModel().getDealer().getHandValue()){
                            //if dealer's hand beat player's hand
                            //make sure dealer didn't bust
                            if(gameViewModel.getGameModel().getDealer().getHandValue() <= 21){
                                gameViewModel.getGameModel().getPlayer().setTotalAmount(gameViewModel.getGameModel().getPlayer().getTotalAmount() - gameViewModel.getGameModel().getPlayer().getBetAmount());
                                gameViewModel.getGameModel().getDealer().setTotalAmount(gameViewModel.getGameModel().getDealer().getTotalAmount() + gameViewModel.getGameModel().getDealer().getBetAmount());
                                displayLossRoundMessage();
                            }else{
                                //dealer busted. make sure player didn't bust too. if player did bust, then that means player busted before dealer
                                //check to see if player busted
                                if(gameViewModel.getGameModel().getPlayer().getHandValue() > 21){ //player busted and dealer busted. player loses because player busted before dealer
                                    gameViewModel.getGameModel().getPlayer().setTotalAmount(gameViewModel.getGameModel().getPlayer().getTotalAmount() - gameViewModel.getGameModel().getPlayer().getBetAmount());
                                    gameViewModel.getGameModel().getDealer().setTotalAmount(gameViewModel.getGameModel().getDealer().getTotalAmount() + gameViewModel.getGameModel().getDealer().getBetAmount());
                                    displayLossRoundMessage();
                                }else{ //player didn't bust but dealer busted
                                    gameViewModel.getGameModel().getPlayer().setTotalAmount(gameViewModel.getGameModel().getPlayer().getTotalAmount() + gameViewModel.getGameModel().getPlayer().getBetAmount());
                                    gameViewModel.getGameModel().getDealer().setTotalAmount(gameViewModel.getGameModel().getDealer().getTotalAmount() - gameViewModel.getGameModel().getDealer().getBetAmount());
                                    displayWonRoundMessage();
                                }


                            }


                        }else{
                            //check to see if player and dealer busted
                            boolean playerBusted = false;
                            boolean dealerBusted = false;

                            if(gameViewModel.getGameModel().getPlayer().getFinalHandValue() > 21){
                                playerBusted = true;
                            }

                            if(playerBusted){
                                displayLossRoundMessage();
                            }else{
                                pushMessage();
                            }

                        }
                        gameViewModel.setNewRoundButtonCanClick(true);
                        //check to see if the player or dealer ran out of money to determine if game is over
                        if(gameViewModel.getGameModel().getPlayer().getTotalAmount() < 10){ //check to see if player has no more money
                            noMoreMoneyMessage();
                            gameViewModel.setGameOver(true);
                        }else if(gameViewModel.getGameModel().getDealer().getTotalAmount() < 10) { //check to see if dealer has no more money
                            dealerHasNoMoreMoneyMessage();
                            gameViewModel.setGameOver(true);
                        }



                    }
                }
            }
        }
    }
    public void noInsuranceButton(){
        if(gameViewModel.noInsuranceButtonClicked()){
            if(gameViewModel.getGameModel().getDealer().isHasBlackJack()){
                checkDealerTurn();
            }else{
                JDialogMessage dealerDoesNotHaveBlackJack = new JDialogMessage(300, 200, "Dealer does not have blackjack.", this);
                dealerDoesNotHaveBlackJack.create();
            }
        }else{
            JDialogMessage dealerNotShowingAce = new JDialogMessage(300, 200, "Dealer is not showing an ace.", this);
            dealerNotShowingAce.create();
        }
    }
    public boolean checkPlayerAndDealerForBlackJack(){
        //check player and dealer for blackjack
        if(gameViewModel.getGameModel().getPlayer().getSplitHand().size() > 0){
            ArrayList<Integer> tempHand = new ArrayList<Integer>();
            for(int i=0; i<gameViewModel.getGameModel().getPlayer().getSplitHand().size(); i++){
                if(!gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).contains(-1) && gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).size() == 2){
                    tempHand.add(gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).get(0));
                    tempHand.add(gameViewModel.getGameModel().getPlayer().getSplitHand().get(i).get(1));
                    break;
                }
            }
            if(tempHand.size() == 0){
                return false;
            }
           //check player for blackjack
            int value = 0;
            int valueSecond = 0;
            boolean hasAce = false;
            for(int i=0; i<tempHand.size(); i++){
                value += gameViewModel.getGameModel().getDeck().getCardStrengthsLinkedHashMap().get(tempHand.get(i));
                if(tempHand.get(i) == 1 || tempHand.get(i) == 2 || tempHand.get(i) == 3 || tempHand.get(i) == 4){
                    hasAce = true;
                }
            }
            if(hasAce){
                valueSecond = value + 10;
                if(valueSecond > 21){
                    valueSecond = 0;
                }
            }
            if(value == 11 && valueSecond == 21){ //if player has blackjack
                gameViewModel.getGameModel().getPlayer().setHasBlackJack(true);
            }
            if(gameViewModel.getGameModel().getPlayer().isHasBlackJack()){
                //display blackjack message
                gameViewModel.getGameModel().getPlayer().setHasBlackJack(false);
                return true;
            }else{
                return false;
            }
            
        }else{
            if(gameViewModel.getGameModel().getDealer().getHandValue() == 21 &&  gameViewModel.getGameModel().getDealer().getSecondHandValue() == 21){
                gameViewModel.getGameModel().getDealer().setHasBlackJack(true);
            }
            if(gameViewModel.getGameModel().getPlayer().getHandValue() == 11 && gameViewModel.getGameModel().getPlayer().getSecondHandValue() == 21 && gameViewModel.getGameModel().getPlayer().getFinalHandValue() == 21){
                gameViewModel.getGameModel().getPlayer().setHasBlackJack(true);
            }
            //if player has blackjack and dealer doesn't then player wins
            if(gameViewModel.getGameModel().getPlayer().isHasBlackJack() && !gameViewModel.getGameModel().getDealer().isHasBlackJack()){
                //display dealer's face down card
                dealerFirstCardLabel.setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(gameViewModel.getGameModel().getDealer().getHand().get(0)));
                gameViewModel.getGameModel().getPlayer().setTotalAmount(gameViewModel.getGameModel().getPlayer().getTotalAmount() + gameViewModel.getGameModel().getPlayer().getBetAmount() * 2); //player wins double the amount
                gameViewModel.getGameModel().getDealer().setTotalAmount(gameViewModel.getGameModel().getDealer().getTotalAmount() - gameViewModel.getGameModel().getDealer().getBetAmount() * 2);
                displayWonRoundMessage();
                gameViewModel.getGameModel().getPlayer().setTurn(false);
                gameViewModel.getGameModel().getDealer().setTurn(false);
                gameViewModel.setNewRoundButtonCanClick(true);
                return true;
            }else if(gameViewModel.getGameModel().getPlayer().isHasBlackJack() && gameViewModel.getGameModel().getDealer().isHasBlackJack()){
                //display dealer's face down card
                dealerFirstCardLabel.setIcon(gameViewModel.getGameModel().getDeck().getCardsToImageIconsLinkedHashMap().get(gameViewModel.getGameModel().getDealer().getHand().get(0)));
                pushMessage();
                gameViewModel.getGameModel().getPlayer().setTurn(false);
                gameViewModel.getGameModel().getDealer().setTurn(false);
                gameViewModel.setNewRoundButtonCanClick(true);
                return true;

            }else{
                return false;
            }
        }

    }


}
