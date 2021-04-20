package ke.vk.vinayak.kedge.footballleague.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ke.vk.vinayak.kedge.footballleague.dto.TeamStandingDto;
import ke.vk.vinayak.kedge.footballleague.eventtype.LogEventType;
import ke.vk.vinayak.kedge.footballleague.log.annotation.Trace;
import ke.vk.vinayak.kedge.footballleague.model.TeamStandingRequest;
import ke.vk.vinayak.kedge.footballleague.service.TeamStandingService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/service/v1/team/standing")
public class FootBallStandingController {

	private final TeamStandingService teamStandingService;

	private final Logger LOGGER = LoggerFactory.getLogger(FootBallStandingController.class);

	@Autowired
	public FootBallStandingController(TeamStandingService teamStandingService) {
		this.teamStandingService = teamStandingService;
	}

	@GetMapping
	@Trace(type = LogEventType.CONTROLLER)
	public ResponseEntity<TeamStandingDto> getStandings(@Valid TeamStandingRequest teamStandingRequest) {
		LOGGER.info("Request {}", teamStandingRequest.toString());
		return ResponseEntity.ok(teamStandingService.getTeamStanding(teamStandingRequest));
	}

}
