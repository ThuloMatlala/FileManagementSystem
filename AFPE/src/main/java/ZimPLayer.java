public class ZimPLayer implements IPlayer {
    public ICricketPlayer GetCricketPlayer() {
        return new AndyFlower();
    }

    public ISoccerPLayer GetSoccerPLayer() {
        return new CollinsMbesuma();
    }
}
