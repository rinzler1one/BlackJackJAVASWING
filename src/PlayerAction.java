public interface PlayerAction {
    public void hit(Deck deck);
    public void stay(Deck deck);
    public void bet();
    public void doubleDown(Deck deck);
    public void split(Deck deck);
    public void checkStats();
    public void insurance();
    public void newGame();
    public void calculateHandValue(Deck deck);
    public void resetData();


}
