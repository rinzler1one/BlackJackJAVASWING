public interface DealerAction {
    public void hit(Deck deck);
    public void stay();
    public void bet();
    public void shuffle(Deck deck);
    public void deal(Player player, Deck deck);
    public void calculatePlayerHand(Player player, Deck deck);
    public void calculateSelf(Deck deck);
    public void resetData();

}
