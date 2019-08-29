public class SouthAfricanPlayer implements IPlayer {
    public ICricketPlayer GetCricketPlayer() {
        return new AlanDonald();
    }

    public ISoccerPLayer GetSoccerPLayer() {
        return new AurthurZwane();
    }
}
