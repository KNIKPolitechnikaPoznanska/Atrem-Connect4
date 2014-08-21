package atrem.Connect4.Game;

public interface PlayerController {

	public abstract String getName();

	public abstract void setName(String name);

	public abstract HoleState getPlayerId();

	public abstract int getSlots();

}