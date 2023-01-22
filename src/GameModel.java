public class GameModel implements GameAction {
    ///This class stores all the game objects, data, and handles the game logic
    ///This class updates the data in its game objects when the GameViewModel tells it to
    ///This class does not perform any input validation. It leaves the input validation to the GameViewModel and assumes the input is correct and performs functions without worrying about input validation.
    Player player;
    Dealer dealer;
    Deck deck;
    //constructor method
    public GameModel(Player player, Dealer dealer, Deck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
    }
    //getter methods
    public Player getPlayer() {

        return player;
    }

    public Dealer getDealer() {

        return dealer;
    }

    public Deck getDeck() {

        return deck;
    }
    //setter methods
    public void setPlayer(Player player) {

        this.player = player;
    }

    public void setDealer(Dealer dealer) {

        this.dealer = dealer;
    }

    public void setDeck(Deck deck) {

        this.deck = deck;
    }
    //instance methods
    @Override
    public void hit() {
        player.hit(deck);

    }

    @Override
    public void stay(Deck deck) {
        player.stay(deck);

    }

    @Override
    public void deal() {

        dealer.deal(player, deck);
    }

    @Override
    public void shuffle() {
        dealer.shuffle(deck);

    }

    @Override
    public void doubleDown(Deck deck) {
        player.doubleDown(deck);

    }

    @Override
    public void split(Deck deck) {
        player.split(deck);
    }



    @Override
    public void insurance() {
        player.insurance();
    }

    @Override
    public void newGame() {

    }
    public void newRound(){
        player.newRound();
        dealer.newRound();
    }

    public void noInsurance(){ //delete this method
        player.noInsurance();
    }

}
