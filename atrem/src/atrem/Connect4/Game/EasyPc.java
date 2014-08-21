package atrem.Connect4.Game;

public class EasyPc extends AI implements PlayerController {

	public EasyPc(String name, HoleState playerId) {
		this.name = name;
		this.playerId = playerId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public HoleState getPlayerId() {
		return playerId;

	}

}
