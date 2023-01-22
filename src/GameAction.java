public interface GameAction {
    public void hit();
    public void stay(Deck deck);
    public void deal();
    public void shuffle();
    public void doubleDown(Deck deck);
    public void split(Deck deck);
    public void insurance();
    public void newGame();


}
