public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName){
        super("Игрок" + playerName + "не зарегестрирован.");
    }
}
