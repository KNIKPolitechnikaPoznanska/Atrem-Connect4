package atrem.Connect4.Game;

public interface PlayerType {

	public abstract String getName();

	public abstract void setName(String name);

	public abstract HoleState getPlayerId();

}