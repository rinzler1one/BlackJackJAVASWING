import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;

//This class represents a Deck object. It holds an array list of integers and these individual integers represent individual cards in a deck.
//It also maps each individual number (which represents an individual card) to corresponding card image icon
//It also maps each individual number(which represents an individual ard) to a corresponding strength, with ace having a stregnth of 1, 2 having a strength of 2, 3 having a strength of 3 and all the way to jack, queen, and king having a strength of 10

public class Deck {
    //fields
    private ArrayList<Integer> deckArrayList; //holds cards. individual integer represents an individual card
    private LinkedHashMap<Integer, ImageIcon> cardsToImageIconsLinkedHashMap; //maps integers (cards) to their corresponding card image icons
    private LinkedHashMap<Integer, Integer> cardStrengthsLinkedHashMap; //maps individual integer (cards) to their corresponding value
    //constructor method
    public Deck(){
        deckArrayList = new ArrayList<Integer>();
        cardsToImageIconsLinkedHashMap = new LinkedHashMap<Integer, ImageIcon>();
        cardStrengthsLinkedHashMap = new LinkedHashMap<Integer, Integer>();

        //initialize cardsToImageIconsLinkedHashMap
        URL imageUrl = getClass().getClassLoader().getResource("images/singlefacedowncard.png");
        ImageIcon faceDown = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(0, faceDown);

        imageUrl = getClass().getClassLoader().getResource("images/aceOfSpadesNumber1.png");
        ImageIcon aceOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(1, aceOfSpades);

        imageUrl = getClass().getClassLoader().getResource("images/aceOfClovesNumber2.png");
        ImageIcon aceOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(2, aceOfCloves);


        imageUrl = getClass().getClassLoader().getResource("images/aceOfDiamondsNumber3.png");
        ImageIcon aceOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(3, aceOfDiamonds);

        imageUrl = getClass().getClassLoader().getResource("images/aceOfHeartsNumber4.png");
        ImageIcon aceOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(4, aceOfHearts);

        imageUrl = getClass().getClassLoader().getResource("images/twoOfSpadesNumber5.png");
        ImageIcon twoOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(5, twoOfSpades);

        imageUrl = getClass().getClassLoader().getResource("images/twoOfClovesNumber6.png");
        ImageIcon twoOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(6, twoOfCloves);

        imageUrl = getClass().getClassLoader().getResource("images/twoOfDiamondsNumber7.png");
        ImageIcon twoOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(7, twoOfDiamonds);

        imageUrl = getClass().getClassLoader().getResource("images/twoOfHeartsNumber8.png");
        ImageIcon twoOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(8, twoOfHearts);

        imageUrl = getClass().getClassLoader().getResource("images/threeOfSpadesNumber9.png");
        ImageIcon threeOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(9, threeOfSpades);

        imageUrl = getClass().getClassLoader().getResource("images/threeOfClovesNumber10.png");
        ImageIcon threeOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(10, threeOfCloves);

        imageUrl = getClass().getClassLoader().getResource("images/threeOfDiamondsNumber11.png");
        ImageIcon threeOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(11, threeOfDiamonds);

        imageUrl = getClass().getClassLoader().getResource("images/threeOfHeartsNumber12.png");
        ImageIcon threeOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(12, threeOfHearts);


        imageUrl = getClass().getClassLoader().getResource("images/fourOfSpadesNumber13.png");
        ImageIcon fourOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(13, fourOfSpades);



        imageUrl = getClass().getClassLoader().getResource("images/fourOfClovesNumber14.png");
        ImageIcon fourOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(14, fourOfCloves);

        imageUrl = getClass().getClassLoader().getResource("images/fourOfDiamondsNumber15.png");
        ImageIcon fourOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(15, fourOfDiamonds);

        imageUrl = getClass().getClassLoader().getResource("images/fourOfHeartsNumber16.png");
        ImageIcon fourOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(16, fourOfHearts);

        imageUrl = getClass().getClassLoader().getResource("images/fiveOfSpadesNumber17.png");
        ImageIcon fiveOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(17, fiveOfSpades);


        imageUrl = getClass().getClassLoader().getResource("images/fiveOfClovesNumber18.png");
        ImageIcon fiveOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(18, fiveOfCloves);


        imageUrl = getClass().getClassLoader().getResource("images/fiveOfDiamondsNumber19.png");
        ImageIcon fiveOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(19, fiveOfDiamonds);


        imageUrl = getClass().getClassLoader().getResource("images/fiveOfHeartsNumber20.png");
        ImageIcon fiveOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(20, fiveOfHearts);



        imageUrl = getClass().getClassLoader().getResource("images/sixOfSpadesNumber21.png");
        ImageIcon sixOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(21, sixOfSpades);


        imageUrl = getClass().getClassLoader().getResource("images/sixOfClovesNumber22.png");
        ImageIcon sixOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(22, sixOfCloves);



        imageUrl = getClass().getClassLoader().getResource("images/sixOfDiamondsNumber23.png");
        ImageIcon sixOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(23, sixOfDiamonds);



        imageUrl = getClass().getClassLoader().getResource("images/sixOfHeartsNumber24.png");
        ImageIcon sixOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(24, sixOfHearts);


        imageUrl = getClass().getClassLoader().getResource("images/sevenOfSpadesNumber25.png");
        ImageIcon sevenOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(25, sevenOfSpades);

        imageUrl = getClass().getClassLoader().getResource("images/sevenOfClovesNumber26.png");
        ImageIcon sevenOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(26, sevenOfCloves);


        imageUrl = getClass().getClassLoader().getResource("images/sevenOfDiamondsNumber27.png");
        ImageIcon sevenOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(27, sevenOfDiamonds);


        imageUrl = getClass().getClassLoader().getResource("images/sevenOfHeartsNumber28.png");
        ImageIcon sevenOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(28, sevenOfHearts);


        imageUrl = getClass().getClassLoader().getResource("images/eightOfSpadesNumber29.png");
        ImageIcon eightOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(29, eightOfSpades);


        imageUrl = getClass().getClassLoader().getResource("images/eightOfClovesNumber30.png");
        ImageIcon eightOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(30, eightOfCloves);


        imageUrl = getClass().getClassLoader().getResource("images/eightOfDiamondsNumber31.png");
        ImageIcon eightOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(31, eightOfDiamonds);

        imageUrl = getClass().getClassLoader().getResource("images/eightOfHeartsNumber32.png");
        ImageIcon eightOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(32, eightOfHearts);



        imageUrl = getClass().getClassLoader().getResource("images/nineOfSpadesNumber33.png");
        ImageIcon nineOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(33, nineOfSpades);

        imageUrl = getClass().getClassLoader().getResource("images/nineOfClovesNumber34.png");
        ImageIcon nineOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(34, nineOfCloves);

        imageUrl = getClass().getClassLoader().getResource("images/nineOfDiamondsNumber35.png");
        ImageIcon nineOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(35, nineOfDiamonds);

        imageUrl = getClass().getClassLoader().getResource("images/nineOfHeartsNumber36.png");
        ImageIcon nineOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(36, nineOfHearts);


        imageUrl = getClass().getClassLoader().getResource("images/tenOfSpadesNumber37.png");
        ImageIcon tenOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(37, tenOfSpades);



        imageUrl = getClass().getClassLoader().getResource("images/tenOfClovesNumber38.png");
        ImageIcon tenOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(38, tenOfCloves);


        imageUrl = getClass().getClassLoader().getResource("images/tenOfDiamondsNumber39.png");
        ImageIcon tenOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(39, tenOfDiamonds);



        imageUrl = getClass().getClassLoader().getResource("images/tenOfHeartsNumber40.png");
        ImageIcon tenOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(40, tenOfHearts);


        imageUrl = getClass().getClassLoader().getResource("images/jackOfSpadesNumber41.png");
        ImageIcon jackOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(41, jackOfSpades);



        imageUrl = getClass().getClassLoader().getResource("images/jackOfClovesNumber42.png");
        ImageIcon jackOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(42, jackOfCloves);

        imageUrl = getClass().getClassLoader().getResource("images/jackOfDiamondsNumber43.png");
        ImageIcon jackOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(43, jackOfDiamonds);

        imageUrl = getClass().getClassLoader().getResource("images/jackOfHeartsNumber44.png");
        ImageIcon jackOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(44, jackOfHearts);


        imageUrl = getClass().getClassLoader().getResource("images/queenOfSpadesNumber45.png");
        ImageIcon queenOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(45, queenOfSpades);


        imageUrl = getClass().getClassLoader().getResource("images/queenOfClovesNumber46.png");
        ImageIcon queenOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(46, queenOfCloves);


        imageUrl = getClass().getClassLoader().getResource("images/queenOfDiamondsNumber47.png");
        ImageIcon queenOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(47, queenOfDiamonds);


        imageUrl = getClass().getClassLoader().getResource("images/queenOfHeartsNumber48.png");
        ImageIcon queenOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(48, queenOfHearts);


        imageUrl = getClass().getClassLoader().getResource("images/kingOfSpadesNumber49.png");
        ImageIcon kingOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(49, kingOfSpades);

        imageUrl = getClass().getClassLoader().getResource("images/kingOfClovesNumber50.png");
        ImageIcon kingOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(50, kingOfCloves);

        imageUrl = getClass().getClassLoader().getResource("images/kingOfDiamondsNumber51.png");
        ImageIcon kingOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(51, kingOfDiamonds);


        imageUrl = getClass().getClassLoader().getResource("images/kingOfHeartsNumber52.png");
        ImageIcon kingOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(52, kingOfHearts);

        //initialize cardStrengthsLinkedHashMap
        int count = 0;
        int cardNumber = 0;
        for(int i=1; i<=10; i++){
            count++;
            cardNumber++;
            cardStrengthsLinkedHashMap.put(cardNumber, i);
            if(count == 4 && cardNumber < 37){
                count = 0;
                continue;
            }
            i--;
            if(cardNumber == 52){
                break;
            }

        }

    }
    //getter methods
    public ArrayList<Integer> getDeckArrayList() {
        return deckArrayList;
    }

    public LinkedHashMap<Integer, ImageIcon> getCardsToImageIconsLinkedHashMap() {
        return cardsToImageIconsLinkedHashMap;
    }

    public LinkedHashMap<Integer, Integer> getCardStrengthsLinkedHashMap() {
        return cardStrengthsLinkedHashMap;
    }
    //setter methods
    public void setDeckArrayList(ArrayList<Integer> deckArrayList) {
        this.deckArrayList = deckArrayList;
    }

    //instance methods
    public void resetData(){
        deckArrayList = new ArrayList<Integer>();
        cardsToImageIconsLinkedHashMap = new LinkedHashMap<Integer, ImageIcon>();
        cardStrengthsLinkedHashMap = new LinkedHashMap<Integer, Integer>();

        //initialize cardsToImageIconsLinkedHashMap
        URL imageUrl = getClass().getClassLoader().getResource("images/singlefacedowncard.png");
        ImageIcon faceDown = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(0, faceDown);

        imageUrl = getClass().getClassLoader().getResource("images/aceOfSpadesNumber1.png");
        ImageIcon aceOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(1, aceOfSpades);

        imageUrl = getClass().getClassLoader().getResource("images/aceOfClovesNumber2.png");
        ImageIcon aceOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(2, aceOfCloves);


        imageUrl = getClass().getClassLoader().getResource("images/aceOfDiamondsNumber3.png");
        ImageIcon aceOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(3, aceOfDiamonds);

        imageUrl = getClass().getClassLoader().getResource("images/aceOfHeartsNumber4.png");
        ImageIcon aceOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(4, aceOfHearts);

        imageUrl = getClass().getClassLoader().getResource("images/twoOfSpadesNumber5.png");
        ImageIcon twoOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(5, twoOfSpades);

        imageUrl = getClass().getClassLoader().getResource("images/twoOfClovesNumber6.png");
        ImageIcon twoOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(6, twoOfCloves);

        imageUrl = getClass().getClassLoader().getResource("images/twoOfDiamondsNumber7.png");
        ImageIcon twoOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(7, twoOfDiamonds);

        imageUrl = getClass().getClassLoader().getResource("images/twoOfHeartsNumber8.png");
        ImageIcon twoOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(8, twoOfHearts);

        imageUrl = getClass().getClassLoader().getResource("images/threeOfSpadesNumber9.png");
        ImageIcon threeOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(9, threeOfSpades);

        imageUrl = getClass().getClassLoader().getResource("images/threeOfClovesNumber10.png");
        ImageIcon threeOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(10, threeOfCloves);

        imageUrl = getClass().getClassLoader().getResource("images/threeOfDiamondsNumber11.png");
        ImageIcon threeOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(11, threeOfDiamonds);

        imageUrl = getClass().getClassLoader().getResource("images/threeOfHeartsNumber12.png");
        ImageIcon threeOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(12, threeOfHearts);


        imageUrl = getClass().getClassLoader().getResource("images/fourOfSpadesNumber13.png");
        ImageIcon fourOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(13, fourOfSpades);



        imageUrl = getClass().getClassLoader().getResource("images/fourOfClovesNumber14.png");
        ImageIcon fourOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(14, fourOfCloves);

        imageUrl = getClass().getClassLoader().getResource("images/fourOfDiamondsNumber15.png");
        ImageIcon fourOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(15, fourOfDiamonds);

        imageUrl = getClass().getClassLoader().getResource("images/fourOfHeartsNumber16.png");
        ImageIcon fourOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(16, fourOfHearts);

        imageUrl = getClass().getClassLoader().getResource("images/fiveOfSpadesNumber17.png");
        ImageIcon fiveOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(17, fiveOfSpades);


        imageUrl = getClass().getClassLoader().getResource("images/fiveOfClovesNumber18.png");
        ImageIcon fiveOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(18, fiveOfCloves);


        imageUrl = getClass().getClassLoader().getResource("images/fiveOfDiamondsNumber19.png");
        ImageIcon fiveOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(19, fiveOfDiamonds);


        imageUrl = getClass().getClassLoader().getResource("images/fiveOfHeartsNumber20.png");
        ImageIcon fiveOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(20, fiveOfHearts);



        imageUrl = getClass().getClassLoader().getResource("images/sixOfSpadesNumber21.png");
        ImageIcon sixOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(21, sixOfSpades);


        imageUrl = getClass().getClassLoader().getResource("images/sixOfClovesNumber22.png");
        ImageIcon sixOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(22, sixOfCloves);



        imageUrl = getClass().getClassLoader().getResource("images/sixOfDiamondsNumber23.png");
        ImageIcon sixOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(23, sixOfDiamonds);



        imageUrl = getClass().getClassLoader().getResource("images/sixOfHeartsNumber24.png");
        ImageIcon sixOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(24, sixOfHearts);


        imageUrl = getClass().getClassLoader().getResource("images/sevenOfSpadesNumber25.png");
        ImageIcon sevenOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(25, sevenOfSpades);

        imageUrl = getClass().getClassLoader().getResource("images/sevenOfClovesNumber26.png");
        ImageIcon sevenOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(26, sevenOfCloves);


        imageUrl = getClass().getClassLoader().getResource("images/sevenOfDiamondsNumber27.png");
        ImageIcon sevenOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(27, sevenOfDiamonds);


        imageUrl = getClass().getClassLoader().getResource("images/sevenOfHeartsNumber28.png");
        ImageIcon sevenOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(28, sevenOfHearts);


        imageUrl = getClass().getClassLoader().getResource("images/eightOfSpadesNumber29.png");
        ImageIcon eightOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(29, eightOfSpades);


        imageUrl = getClass().getClassLoader().getResource("images/eightOfClovesNumber30.png");
        ImageIcon eightOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(30, eightOfCloves);


        imageUrl = getClass().getClassLoader().getResource("images/eightOfDiamondsNumber31.png");
        ImageIcon eightOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(31, eightOfDiamonds);

        imageUrl = getClass().getClassLoader().getResource("images/eightOfHeartsNumber32.png");
        ImageIcon eightOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(32, eightOfHearts);



        imageUrl = getClass().getClassLoader().getResource("images/nineOfSpadesNumber33.png");
        ImageIcon nineOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(33, nineOfSpades);

        imageUrl = getClass().getClassLoader().getResource("images/nineOfClovesNumber34.png");
        ImageIcon nineOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(34, nineOfCloves);

        imageUrl = getClass().getClassLoader().getResource("images/nineOfDiamondsNumber35.png");
        ImageIcon nineOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(35, nineOfDiamonds);

        imageUrl = getClass().getClassLoader().getResource("images/nineOfHeartsNumber36.png");
        ImageIcon nineOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(36, nineOfHearts);


        imageUrl = getClass().getClassLoader().getResource("images/tenOfSpadesNumber37.png");
        ImageIcon tenOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(37, tenOfSpades);



        imageUrl = getClass().getClassLoader().getResource("images/tenOfClovesNumber38.png");
        ImageIcon tenOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(38, tenOfCloves);


        imageUrl = getClass().getClassLoader().getResource("images/tenOfDiamondsNumber39.png");
        ImageIcon tenOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(39, tenOfDiamonds);



        imageUrl = getClass().getClassLoader().getResource("images/tenOfHeartsNumber40.png");
        ImageIcon tenOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(40, tenOfHearts);


        imageUrl = getClass().getClassLoader().getResource("images/jackOfSpadesNumber41.png");
        ImageIcon jackOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(41, jackOfSpades);



        imageUrl = getClass().getClassLoader().getResource("images/jackOfClovesNumber42.png");
        ImageIcon jackOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(42, jackOfCloves);

        imageUrl = getClass().getClassLoader().getResource("images/jackOfDiamondsNumber43.png");
        ImageIcon jackOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(43, jackOfDiamonds);

        imageUrl = getClass().getClassLoader().getResource("images/jackOfHeartsNumber44.png");
        ImageIcon jackOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(44, jackOfHearts);


        imageUrl = getClass().getClassLoader().getResource("images/queenOfSpadesNumber45.png");
        ImageIcon queenOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(45, queenOfSpades);


        imageUrl = getClass().getClassLoader().getResource("images/queenOfClovesNumber46.png");
        ImageIcon queenOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(46, queenOfCloves);


        imageUrl = getClass().getClassLoader().getResource("images/queenOfDiamondsNumber47.png");
        ImageIcon queenOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(47, queenOfDiamonds);


        imageUrl = getClass().getClassLoader().getResource("images/queenOfHeartsNumber48.png");
        ImageIcon queenOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(48, queenOfHearts);


        imageUrl = getClass().getClassLoader().getResource("images/kingOfSpadesNumber49.png");
        ImageIcon kingOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(49, kingOfSpades);

        imageUrl = getClass().getClassLoader().getResource("images/kingOfClovesNumber50.png");
        ImageIcon kingOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(50, kingOfCloves);

        imageUrl = getClass().getClassLoader().getResource("images/kingOfDiamondsNumber51.png");
        ImageIcon kingOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(51, kingOfDiamonds);


        imageUrl = getClass().getClassLoader().getResource("images/kingOfHeartsNumber52.png");
        ImageIcon kingOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(52, kingOfHearts);

        //initialize cardStrengthsLinkedHashMap
        int count = 0;
        int cardNumber = 0;
        for(int i=1; i<=10; i++){
            count++;
            cardNumber++;
            cardStrengthsLinkedHashMap.put(cardNumber, i);
            if(count == 4 && cardNumber < 37){
                count = 0;
                continue;
            }
            i--;
            if(cardNumber == 52){
                break;
            }

        }
    }
}
