package ke.vk.vinayak.kedge.footballleague.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {

	@JsonProperty("team_key")
	private String key;
	@JsonProperty("team_name")
	private String name;
	@JsonProperty("team_badge")
	private String badge;
	@JsonProperty("players")
	private List<Player> players;
	@JsonProperty("coaches")
	private List<Coach> coaches;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Coach> getCoaches() {
		return coaches;
	}

	public void setCoaches(List<Coach> coaches) {
		this.coaches = coaches;
	}

}
