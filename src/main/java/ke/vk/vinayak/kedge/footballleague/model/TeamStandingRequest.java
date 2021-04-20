package ke.vk.vinayak.kedge.footballleague.model;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TeamStandingRequest {

	@NotBlank
	private String teamName;
	@NotBlank
	private String countryName;
	@NotBlank
	private String leagueName;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

}
