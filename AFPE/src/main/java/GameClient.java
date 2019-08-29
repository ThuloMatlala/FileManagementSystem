public class GameClient {

    private ICricketPlayer iCricketPlayer;
    private ISoccerPLayer iSoccerPLayer;

    public GameClient(IPlayer southAfricanPlayerFactory) {
        iCricketPlayer = southAfricanPlayerFactory.GetCricketPlayer();
        iSoccerPLayer = southAfricanPlayerFactory.GetSoccerPLayer();
    }

    public String GetCrickerPlayer(){
        return iCricketPlayer.GetPlayerName() + " : " + iCricketPlayer.GetPlayerAge();
    }

    public String GetSoccerPlayer() {
        return iSoccerPLayer.GetName() + " : " + iSoccerPLayer.GetAge();
    }
}
