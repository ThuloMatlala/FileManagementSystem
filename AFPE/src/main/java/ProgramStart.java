public class ProgramStart {

    public static void main(String[] args) {
        IPlayer southAfricanPlayerFactory = new SouthAfricanPlayer();
        GameClient southAfricanClient = new GameClient(southAfricanPlayerFactory);
        System.out.println(southAfricanClient.GetCrickerPlayer());
        System.out.println(southAfricanClient.GetSoccerPlayer());

        IPlayer zimFactory = new ZimPLayer();
        GameClient zimClient = new GameClient(zimFactory);
        System.out.println(zimClient.GetCrickerPlayer());
        System.out.println(zimClient.GetSoccerPlayer());
    }
}
