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
        ImageIcon faceDown = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\singlefacedowncard.png");
        cardsToImageIconsLinkedHashMap.put(0, faceDown);

        ImageIcon aceOfSpades = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\aceOfSpadesNumber1.png");
        cardsToImageIconsLinkedHashMap.put(1, aceOfSpades);

        ImageIcon aceOfCloves = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\aceOfClovesNumber2.png");
        cardsToImageIconsLinkedHashMap.put(2, aceOfCloves);


        ImageIcon aceOfDiamonds = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\aceOfDiamondsNumber3.png");
        cardsToImageIconsLinkedHashMap.put(3, aceOfDiamonds);

        ImageIcon aceOfHearts = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\aceOfHeartsNumber4.png");
        cardsToImageIconsLinkedHashMap.put(4, aceOfHearts);

        ImageIcon twoOfSpades = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\twoOfSpadesNumber5.png");
        cardsToImageIconsLinkedHashMap.put(5, twoOfSpades);

        ImageIcon twoOfCloves = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\twoOfClovesNumber6.png");
        cardsToImageIconsLinkedHashMap.put(6, twoOfCloves);

        ImageIcon twoOfDiamonds = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\twoOfDiamondsNumber7.png");
        cardsToImageIconsLinkedHashMap.put(7, twoOfDiamonds);

        ImageIcon twoOfHearts = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\twoOfHeartsNumber8.png");
        cardsToImageIconsLinkedHashMap.put(8, twoOfHearts);

        ImageIcon threeOfSpades = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\threeOfSpadesNumber9.png");
        cardsToImageIconsLinkedHashMap.put(9, threeOfSpades);

        ImageIcon threeOfCloves = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\threeOfClovesNumber10.png");
        cardsToImageIconsLinkedHashMap.put(10, threeOfCloves);

        ImageIcon threeOfDiamonds = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\threeOfDiamondsNumber11.png");
        cardsToImageIconsLinkedHashMap.put(11, threeOfDiamonds);

        ImageIcon threeOfHearts = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\threeOfHeartsNumber12.png");
        cardsToImageIconsLinkedHashMap.put(12, threeOfHearts);

        ImageIcon fourOfSpades = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\fourOfSpadesNumber13.png");
        cardsToImageIconsLinkedHashMap.put(13, fourOfSpades);



        ImageIcon fourOfCloves = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\fourOfClovesNumber14.png");

        cardsToImageIconsLinkedHashMap.put(14, fourOfCloves);

        ImageIcon fourOfDiamonds = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\fourOfDiamondsNumber15.png");
        cardsToImageIconsLinkedHashMap.put(15, fourOfDiamonds);


        ImageIcon fourOfHearts = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\fourOfHeartsNumber16.png");

        cardsToImageIconsLinkedHashMap.put(16, fourOfHearts);

        ImageIcon fiveOfSpades = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\fiveOfSpadesNumber17.png");
        cardsToImageIconsLinkedHashMap.put(17, fiveOfSpades);


        ImageIcon fiveOfCloves = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\fiveOfClovesNumber18.png");
        cardsToImageIconsLinkedHashMap.put(18, fiveOfCloves);


        ImageIcon fiveOfDiamonds = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\fiveOfDiamondsNumber19.png");
        cardsToImageIconsLinkedHashMap.put(19, fiveOfDiamonds);


        ImageIcon fiveOfHearts = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\fiveOfHeartsNumber20.png");
        cardsToImageIconsLinkedHashMap.put(20, fiveOfHearts);


        ImageIcon sixOfSpades = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\sixOfSpadesNumber21.png");
        cardsToImageIconsLinkedHashMap.put(21, sixOfSpades);


        ImageIcon sixOfCloves = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\sixOfClovesNumber22.png");
        cardsToImageIconsLinkedHashMap.put(22, sixOfCloves);


        ImageIcon sixOfDiamonds = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\sixOfDiamondsNumber23.png");
        cardsToImageIconsLinkedHashMap.put(23, sixOfDiamonds);


        ImageIcon sixOfHearts = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\sixOfHeartsNumber24.png");
        cardsToImageIconsLinkedHashMap.put(24, sixOfHearts);


        ImageIcon sevenOfSpades = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\sevenOfSpadesNumber25.png");
        cardsToImageIconsLinkedHashMap.put(25, sevenOfSpades);


        ImageIcon sevenOfCloves = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\sevenOfClovesNumber26.png");
        cardsToImageIconsLinkedHashMap.put(26, sevenOfCloves);

        ImageIcon sevenOfDiamonds = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\sevenOfDiamondsNumber27.png");
        cardsToImageIconsLinkedHashMap.put(27, sevenOfDiamonds);

        ImageIcon sevenOfHearts = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\sevenOfHeartsNumber28.png");
        cardsToImageIconsLinkedHashMap.put(28, sevenOfHearts);


        ImageIcon eightOfSpades = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\eightOfSpadesNumber29.png");
        cardsToImageIconsLinkedHashMap.put(29, eightOfSpades);


        ImageIcon eightOfCloves = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\eightOfClovesNumber30.png");
        cardsToImageIconsLinkedHashMap.put(30, eightOfCloves);


        ImageIcon eightOfDiamonds = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\eightOfDiamondsNumber31.png");
        cardsToImageIconsLinkedHashMap.put(31, eightOfDiamonds);

        ImageIcon eightOfHearts = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\eightOfHeartsNumber32.png");
        cardsToImageIconsLinkedHashMap.put(32, eightOfHearts);


        ImageIcon nineOfSpades = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\nineOfSpadesNumber33.png");
        cardsToImageIconsLinkedHashMap.put(33, nineOfSpades);
        ImageIcon nineOfCloves = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\nineOfClovesNumber34.png");
        cardsToImageIconsLinkedHashMap.put(34, nineOfCloves);
        ImageIcon nineOfDiamonds = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\nineOfDiamondsNumber35.png");
        cardsToImageIconsLinkedHashMap.put(35, nineOfDiamonds);

        ImageIcon nineOfHearts = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\nineOfHeartsNumber36.png");
        cardsToImageIconsLinkedHashMap.put(36, nineOfHearts);

        ImageIcon tenOfSpades = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\tenOfSpadesNumber37.png");
        cardsToImageIconsLinkedHashMap.put(37, tenOfSpades);


        ImageIcon tenOfCloves = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\tenOfClovesNumber38.png");
        cardsToImageIconsLinkedHashMap.put(38, tenOfCloves);


        ImageIcon tenOfDiamonds = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\tenOfDiamondsNumber39.png");
        cardsToImageIconsLinkedHashMap.put(39, tenOfDiamonds);


        ImageIcon tenOfHearts = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\tenOfHeartsNumber40.png");
        cardsToImageIconsLinkedHashMap.put(40, tenOfHearts);


        ImageIcon jackOfSpades = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\jackOfSpadesNumber41.png");
        cardsToImageIconsLinkedHashMap.put(41, jackOfSpades);


        ImageIcon jackOfCloves = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\jackOfClovesNumber42.png");
        cardsToImageIconsLinkedHashMap.put(42, jackOfCloves);


        ImageIcon jackOfDiamonds = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\jackOfDiamondsNumber43.png");
        cardsToImageIconsLinkedHashMap.put(43, jackOfDiamonds);


        ImageIcon jackOfHearts = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\jackOfHeartsNumber44.png");
        cardsToImageIconsLinkedHashMap.put(44, jackOfHearts);


        ImageIcon queenOfSpades = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\queenOfSpadesNumber45.png");
        cardsToImageIconsLinkedHashMap.put(45, queenOfSpades);


        ImageIcon queenOfCloves = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\queenOfClovesNumber46.png");
        cardsToImageIconsLinkedHashMap.put(46, queenOfCloves);


        ImageIcon queenOfDiamonds = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\queenOfDiamondsNumber47.png");
        cardsToImageIconsLinkedHashMap.put(47, queenOfDiamonds);


        ImageIcon queenOfHearts = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\queenOfHeartsNumber48.png");
        cardsToImageIconsLinkedHashMap.put(48, queenOfHearts);


        ImageIcon kingOfSpades = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\kingOfSpadesNumber49.png");
        cardsToImageIconsLinkedHashMap.put(49, kingOfSpades);


        ImageIcon kingOfCloves = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\kingOfClovesNumber50.png");
        cardsToImageIconsLinkedHashMap.put(50, kingOfCloves);


        ImageIcon kingOfDiamonds = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\kingOfDiamondsNumber51.png");
        cardsToImageIconsLinkedHashMap.put(51, kingOfDiamonds);


        ImageIcon kingOfHearts = new ImageIcon("C:\\Users\\Kevin\\IdeaProjects\\practiceproject\\src\\kingOfHeartsNumber52.png");
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
        URL imageUrl = getClass().getResource("/images/singlefacedowncard.png");
        ImageIcon faceDown = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(0, faceDown);

        imageUrl = getClass().getResource("/images/aceOfSpadesNumber1.png");
        ImageIcon aceOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(1, aceOfSpades);

        imageUrl = getClass().getResource("/images/aceOfClovesNumber2.png");
        ImageIcon aceOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(2, aceOfCloves);


        imageUrl = getClass().getResource("/images/aceOfDiamondsNumber3.png");
        ImageIcon aceOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(3, aceOfDiamonds);

        imageUrl = getClass().getResource("/images/aceOfHeartsNumber4.png");
        ImageIcon aceOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(4, aceOfHearts);

        imageUrl = getClass().getResource("/images/twoOfSpadesNumber5.png");
        ImageIcon twoOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(5, twoOfSpades);

        imageUrl = getClass().getResource("/images/twoOfClovesNumber6.png");
        ImageIcon twoOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(6, twoOfCloves);

        imageUrl = getClass().getResource("/images/twoOfDiamondsNumber7.png");
        ImageIcon twoOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(7, twoOfDiamonds);

        imageUrl = getClass().getResource("/images/twoOfHeartsNumber8.png");
        ImageIcon twoOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(8, twoOfHearts);

        imageUrl = getClass().getResource("/images/threeOfSpadesNumber9.png");
        ImageIcon threeOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(9, threeOfSpades);

        imageUrl = getClass().getResource("/images/threeOfClovesNumber10.png");
        ImageIcon threeOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(10, threeOfCloves);

        imageUrl = getClass().getResource("/images/threeOfDiamonds11.png");
        ImageIcon threeOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(11, threeOfDiamonds);

        imageUrl = getClass().getResource("/images/threeOfHeartsNumber12.png");
        ImageIcon threeOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(12, threeOfHearts);


        imageUrl = getClass().getResource("/images/fourOfSpadesNumber13.png");
        ImageIcon fourOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(13, fourOfSpades);



        imageUrl = getClass().getResource("/images/fourOfClovesNumber14.png");
        ImageIcon fourOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(14, fourOfCloves);

        imageUrl = getClass().getResource("/images/fourOfDiamondsNumber15.png");
        ImageIcon fourOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(15, fourOfDiamonds);

        imageUrl = getClass().getResource("/images/fourOfHeartsNumber16.png");
        ImageIcon fourOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(16, fourOfHearts);

        imageUrl = getClass().getResource("/images/fiveOfSpadesNumber17.png");
        ImageIcon fiveOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(17, fiveOfSpades);


        imageUrl = getClass().getResource("/images/fiveOfClovesNumber18.png");
        ImageIcon fiveOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(18, fiveOfCloves);


        imageUrl = getClass().getResource("/images/fiveOfDiamondsNumber19.png");
        ImageIcon fiveOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(19, fiveOfDiamonds);


        imageUrl = getClass().getResource("/images/fiveOfHeartsNumber20.png");
        ImageIcon fiveOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(20, fiveOfHearts);



        imageUrl = getClass().getResource("/images/sixOfSpadesNumber21.png");
        ImageIcon sixOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(21, sixOfSpades);


        imageUrl = getClass().getResource("/images/sixOfClovesNumber22.png");
        ImageIcon sixOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(22, sixOfCloves);



        imageUrl = getClass().getResource("/images/sixOfDiamondsNumber23.png");
        ImageIcon sixOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(23, sixOfDiamonds);



        imageUrl = getClass().getResource("/images/sixOfHeartsNumber24.png");
        ImageIcon sixOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(24, sixOfHearts);


        imageUrl = getClass().getResource("/images/sevenOfSpadesNumber25.png");
        ImageIcon sevenOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(25, sevenOfSpades);

        imageUrl = getClass().getResource("/images/sevenOfClovesNumber26.png");
        ImageIcon sevenOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(26, sevenOfCloves);


        imageUrl = getClass().getResource("/images/sevenOfDiamondsNumber27.png");
        ImageIcon sevenOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(27, sevenOfDiamonds);


        imageUrl = getClass().getResource("/images/sevenOfHeartsNumber28.png");
        ImageIcon sevenOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(28, sevenOfHearts);


        imageUrl = getClass().getResource("/images/eightOfSpadesNumber29.png");
        ImageIcon eightOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(29, eightOfSpades);


        imageUrl = getClass().getResource("/images/eightOfClovesNumber30.png");
        ImageIcon eightOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(30, eightOfCloves);


        imageUrl = getClass().getResource("/images/eightOfDiamondsNumber31.png");
        ImageIcon eightOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(31, eightOfDiamonds);

        imageUrl = getClass().getResource("/images/eightOfHeartsNumber32.png");
        ImageIcon eightOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(32, eightOfHearts);



        imageUrl = getClass().getResource("/images/nineOfSpadesNumber33.png");
        ImageIcon nineOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(33, nineOfSpades);

        imageUrl = getClass().getResource("/images/nineOfClovesNumber34.png");
        ImageIcon nineOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(34, nineOfCloves);

        imageUrl = getClass().getResource("/images/nineOfDiamondsNumber35.png");
        ImageIcon nineOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(35, nineOfDiamonds);

        imageUrl = getClass().getResource("/images/nineOfHeartsNumber36.png");
        ImageIcon nineOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(36, nineOfHearts);


        imageUrl = getClass().getResource("/images/tenOfSpadesNumber37.png");
        ImageIcon tenOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(37, tenOfSpades);



        imageUrl = getClass().getResource("/images/tenOfClovesNumber38.png");
        ImageIcon tenOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(38, tenOfCloves);


        imageUrl = getClass().getResource("/images/tenOfDiamondsNumber39.png");
        ImageIcon tenOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(39, tenOfDiamonds);



        imageUrl = getClass().getResource("/images/tenOfHeartsNumber40.png");
        ImageIcon tenOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(40, tenOfHearts);


        imageUrl = getClass().getResource("/images/jackOfSpadesNumber41.png");
        ImageIcon jackOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(41, jackOfSpades);



        imageUrl = getClass().getResource("/images/jackOfClovesNumber42.png");
        ImageIcon jackOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(42, jackOfCloves);

        imageUrl = getClass().getResource("/images/jackOfDiamondsNumber43.png");
        ImageIcon jackOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(43, jackOfDiamonds);

        imageUrl = getClass().getResource("/images/jackOfHeartsNumber44.png");
        ImageIcon jackOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(44, jackOfHearts);


        imageUrl = getClass().getResource("/images/queenOfSpadesNumber45.png");
        ImageIcon queenOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(45, queenOfSpades);


        imageUrl = getClass().getResource("/images/queenOfClovesNumber46.png");
        ImageIcon queenOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(46, queenOfCloves);


        imageUrl = getClass().getResource("/images/queenOfDiamondsNumber47.png");
        ImageIcon queenOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(47, queenOfDiamonds);


        imageUrl = getClass().getResource("/images/queenOfHeartsNumber48.png");
        ImageIcon queenOfHearts = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(48, queenOfHearts);


        imageUrl = getClass().getResource("/images/kingOfSpadesNumber49.png");
        ImageIcon kingOfSpades = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(49, kingOfSpades);

        imageUrl = getClass().getResource("/images/kingOfClovesNumber50.png");
        ImageIcon kingOfCloves = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(50, kingOfCloves);

        imageUrl = getClass().getResource("/images/kingOfDiamondsNumber51.png");
        ImageIcon kingOfDiamonds = new ImageIcon(imageUrl);
        cardsToImageIconsLinkedHashMap.put(51, kingOfDiamonds);


        imageUrl = getClass().getResource("/images/kingOfHeartsNumber52.png");
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
