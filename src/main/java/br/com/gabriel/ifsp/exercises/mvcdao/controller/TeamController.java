package br.com.gabriel.ifsp.exercises.mvcdao.controller;

import br.com.gabriel.ifsp.exercises.mvcdao.dao.interfaces.PlayerDAO;
import br.com.gabriel.ifsp.exercises.mvcdao.dao.interfaces.TeamDAO;
import br.com.gabriel.ifsp.exercises.mvcdao.dto.PlayerDTO;
import br.com.gabriel.ifsp.exercises.mvcdao.dto.TeamDTO;
import br.com.gabriel.ifsp.exercises.mvcdao.mapper.PlayerMapper;
import br.com.gabriel.ifsp.exercises.mvcdao.mapper.TeamMapper;
import br.com.gabriel.ifsp.exercises.mvcdao.model.Player;
import br.com.gabriel.ifsp.exercises.mvcdao.model.Team;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class TeamController {
    private final PlayerDAO playerDAO;
    private final TeamDAO teamDAO;

    public TeamController(PlayerDAO playerDAO, TeamDAO teamDAO) {
        this.playerDAO = playerDAO;
        this.teamDAO = teamDAO;
    }

    public void addTeam(Team team) {
        teamDAO.insert(TeamMapper.toDTO(team));
    }

    public void deleteTeam(Team team) {
        teamDAO.delete(TeamMapper.toDTO(team));
    }

    public void deleteTeam(String teamName) {
        teamDAO.delete(teamName);
    }

    public void updateTeam(Team team) {
        teamDAO.update(TeamMapper.toDTO(team));
    }

    public Set<Team> findAllTeams() {
        Set<TeamDTO> dtoSet = teamDAO.findAll();

        return dtoSet.stream()
                .map(teamDto -> {
                    Team t = TeamMapper.fromDto(teamDto);
                    PlayerDTO captainDto = playerDAO.findOne(teamDto.captainNumber(), teamDto.name()).orElse(null);
                    t.setCaptain(PlayerMapper.fromDto(captainDto));
                    return t;
                })
                .collect(Collectors.toSet());
    }

    public Team findTeamByName(String teamName) {
        TeamDTO dto = teamDAO.findOne(teamName).orElseThrow(() -> new NoSuchElementException("Team not found"));

        Team team = TeamMapper.fromDto(dto);

        PlayerDTO captainDto = playerDAO.findOne(dto.captainNumber(), dto.name()).orElse(null);
        team.setCaptain(PlayerMapper.fromDto(captainDto));

        return team;
    }

    public void addPlayer(Team team, Player player) {
        Objects.requireNonNull(team, "Team cannot be null");
        Objects.requireNonNull(player, "Player cannot be null");

        team.addPlayer(player);
        player.setTeam(team);
        playerDAO.insert(PlayerMapper.toDto(player));
    }

    public void removePlayer(Team team, Player player) {
        Objects.requireNonNull(team, "Team cannot be null");
        Objects.requireNonNull(player, "Player cannot be null");

        team.removePlayer(player);
        playerDAO.delete(PlayerMapper.toDto(player));
    }

    public void setCaptain(Team team, Player player) {
        Objects.requireNonNull(team, "Team cannot be null");
        Objects.requireNonNull(player, "Player cannot be null");

        team.setCaptain(player);
        teamDAO.update(TeamMapper.toDTO(team));
    }

    public void substitutePlayer(Team team, Player substitute, Player starter) {
        Objects.requireNonNull(team, "Team cannot be null");
        Objects.requireNonNull(substitute, "Substitute cannot be null");
        Objects.requireNonNull(starter, "Starter cannot be null");

        team.substitute(substitute, starter);
        playerDAO.update(PlayerMapper.toDto(substitute));
        playerDAO.update(PlayerMapper.toDto(starter));
    }

    public Player[] getFieldedPlayers(Team team) {
        Objects.requireNonNull(team, "Team cannot be null");
        return team.getFieldedPlayers();
    }

    public Player[] getOutfieldedPlayers(Team team) {
        Objects.requireNonNull(team, "Team cannot be null");
        return team.getOutfieldedPlayers();
    }

    public Player[] getAllPlayersFrom(Team team) {
        Objects.requireNonNull(team, "Team cannot be null");
        return playerDAO.findAllByTeam(team.getName())
                .stream().map(dto -> {
                    Player p = PlayerMapper.fromDto(dto);
                    TeamDTO teamDto = teamDAO.findOne(dto.teamName()).orElse(null);
                    p.setTeam(TeamMapper.fromDto(teamDto));
                    return p;
                }).toArray(Player[]::new);
    }

    public Player[] getAllPlayers() {
        return playerDAO.findAll()
                .stream().map(dto -> {
                    Player p = PlayerMapper.fromDto(dto);
                    TeamDTO teamDto = teamDAO.findOne(dto.teamName()).orElse(null);
                    p.setTeam(TeamMapper.fromDto(teamDto));
                    return p;
                }).toArray(Player[]::new);
    }
}
