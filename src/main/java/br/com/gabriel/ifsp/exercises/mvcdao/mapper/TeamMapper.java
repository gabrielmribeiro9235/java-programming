package br.com.gabriel.ifsp.exercises.mvcdao.mapper;

import br.com.gabriel.ifsp.exercises.mvcdao.dto.TeamDTO;
import br.com.gabriel.ifsp.exercises.mvcdao.model.Team;

import java.util.Objects;

public class TeamMapper {
    private TeamMapper() {}

    public static TeamDTO toDTO(Team team) {
        Objects.requireNonNull(team, "team cannot be null");

        return new TeamDTO(
                team.getName(),
                team.getBaseLocation(),
                team.getCoachName(),
                (team.getCaptain() == null ? -1 : team.getCaptain().getNumber())
        );
    }

    public static Team fromDto(TeamDTO dto) {
        Objects.requireNonNull(dto, "dto cannot be null");

        return new Team(
                dto.name(),
                dto.baseLocation(),
                dto.coachName()
        );
    }
}
