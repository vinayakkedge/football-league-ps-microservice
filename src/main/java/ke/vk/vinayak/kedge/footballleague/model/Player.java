package ke.vk.vinayak.kedge.footballleague.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {

	@JsonProperty("player_key")
	private Long key;
	@JsonProperty("player_name")
	private String name;
	@JsonProperty("player_number")
	private int number;
	@JsonProperty("player_country")
	private String country;
	@JsonProperty("player_type")
	private String type;
	@JsonProperty("player_age")
	private int age;
	@JsonProperty("player_match_played")
	private int matchPlayed;
	@JsonProperty("player_goals")
	private int goals;
	@JsonProperty("player_yellow_cards")
	private int yellowCards;
	@JsonProperty("player_red_cards")
	private int redCards;
	@JsonProperty("team_name")
	private String teamName;
	@JsonProperty("team_key")
	private Long teamKey;

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMatchPlayed() {
		return matchPlayed;
	}

	public void setMatchPlayed(int matchPlayed) {
		this.matchPlayed = matchPlayed;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getYellowCards() {
		return yellowCards;
	}

	public void setYellowCards(int yellowCards) {
		this.yellowCards = yellowCards;
	}

	public int getRedCards() {
		return redCards;
	}

	public void setRedCards(int redCards) {
		this.redCards = redCards;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Long getTeamKey() {
		return teamKey;
	}

	public void setTeamKey(Long teamKey) {
		this.teamKey = teamKey;
	}

}