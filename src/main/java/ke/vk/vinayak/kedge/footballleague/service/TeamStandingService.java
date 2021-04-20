package ke.vk.vinayak.kedge.footballleague.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ke.vk.vinayak.kedge.footballleague.client.TeamStandingRestClient;
import ke.vk.vinayak.kedge.footballleague.dto.TeamStandingDto;
import ke.vk.vinayak.kedge.footballleague.eventtype.LogEventType;
import ke.vk.vinayak.kedge.footballleague.exception.BadRequestException;
import ke.vk.vinayak.kedge.footballleague.log.annotation.Trace;
import ke.vk.vinayak.kedge.footballleague.model.Competitions;
import ke.vk.vinayak.kedge.footballleague.model.Country;
import ke.vk.vinayak.kedge.footballleague.model.TeamStanding;
import ke.vk.vinayak.kedge.footballleague.model.TeamStandingRequest;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TeamStandingService {

	private final Logger LOGGER = LoggerFactory.getLogger(TeamStandingService.class);

	private final TeamStandingRestClient teamStandingRestClient;

	@Autowired
	public TeamStandingService(TeamStandingRestClient teamStandingRestClient) {
		this.teamStandingRestClient = teamStandingRestClient;
	}

	@Trace(type = LogEventType.SERVICE)
	public TeamStandingDto getTeamStanding(TeamStandingRequest teamStandingRequest) {
		// Validate the request
		TeamStanding teamStandingDefault = getDefaultTeamStanding(teamStandingRequest);
		List<Country> countries = getCountries();
		Country country = getCountryByName(teamStandingRequest, countries);
		if (!isValidateCountryResponse(teamStandingRequest, teamStandingDefault, country)) {
			return TeamStandingDto.from(teamStandingDefault);
		}
		teamStandingDefault.setCountryId(country.getId());

		List<Competitions> leaguesList = getLeagues(country.getId());
		Competitions leagues = getLeaguesByName(teamStandingRequest, leaguesList);
		if (!isValidLeagueResponse(teamStandingRequest, teamStandingDefault, leagues)) {
			return (TeamStandingDto.from(teamStandingDefault));
		}
		teamStandingDefault.setLeagueId(leagues.getLeagueId());
		List<TeamStanding> teamStandings = getTeamStanding(leagues.getLeagueId());
		LOGGER.info("team standing found {}", teamStandings.toString());

		TeamStanding teamStandingsFiltered = getFilteredTeamStanding(teamStandingRequest, teamStandings);
		teamStandingsFiltered.setCountryId(country.getId());
		LOGGER.info("team standing filtered found {}", teamStandingsFiltered.toString());
		if (teamStandingsFiltered.getTeamId() == 0) {
			return TeamStandingDto.from(teamStandingDefault);
		}

		return TeamStandingDto.from(teamStandingsFiltered);
	}

	private Country getCountryByName(TeamStandingRequest teamStandingRequest, List<Country> countries) {
		return countries.stream().filter(c -> teamStandingRequest.getCountryName().equalsIgnoreCase(c.getName()))
				.findFirst().orElse(null);
	}

	private Competitions getLeaguesByName(TeamStandingRequest teamStandingRequest, List<Competitions> leaguesList) {
		return leaguesList.stream().filter(l -> teamStandingRequest.getLeagueName().equalsIgnoreCase(l.getLeagueName()))
				.findFirst().orElse(null);
	}

	private TeamStanding getFilteredTeamStanding(TeamStandingRequest teamStandingRequest,
			List<TeamStanding> teamStandings) {
		return teamStandings.stream().filter(t -> teamStandingRequest.getTeamName().equalsIgnoreCase(t.getTeamName()))
				.findFirst().orElse(null);
	}

	private boolean isValidLeagueResponse(TeamStandingRequest teamStandingRequest, TeamStanding teamStandingDefault,
			Competitions leagues) {
		if (Objects.isNull(leagues)) {
			throw new BadRequestException("leagues Not Found by name " + teamStandingRequest.getLeagueName());
		}
		LOGGER.info("league found {}", leagues.toString());
		if (leagues.getLeagueId() == 0) {
			return false;
		}
		return true;
	}

	private boolean isValidateCountryResponse(TeamStandingRequest teamStandingRequest, TeamStanding teamStandingDefault,
			Country country) {
		if (Objects.isNull(country)) {
			throw new BadRequestException("Country Not Found by name " + teamStandingRequest.getCountryName());
		}
		LOGGER.info("Country found {}", country.toString());

		if (country.getId() == 0) {
			teamStandingDefault.setCountryId(0);
			return false;
		}
		return true;
	}

	private TeamStanding getDefaultTeamStanding(TeamStandingRequest teamStandingRequest) {
		TeamStanding teamStanding = new TeamStanding();
		teamStanding.setTeamName(teamStandingRequest.getTeamName());
		teamStanding.setCountryName(teamStandingRequest.getCountryName());
		teamStanding.setLeagueName(teamStandingRequest.getLeagueName());
		return teamStanding;
	}

	private List<Country> getCountries() {
		return new ArrayList<>(Arrays.asList(teamStandingRestClient.getCountries()));
	}

	private List<Competitions> getLeagues(int countryId) {
		return new ArrayList<>(Arrays.asList(teamStandingRestClient.getLeagues(countryId)));
	}

	private List<TeamStanding> getTeamStanding(int leagueId) {
		return new ArrayList<>(Arrays.asList(teamStandingRestClient.getTeamStanding(leagueId)));
	}

}
