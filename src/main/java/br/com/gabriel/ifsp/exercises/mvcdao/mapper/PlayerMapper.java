package br.com.gabriel.ifsp.exercises.mvcdao.mapper;

import br.com.gabriel.ifsp.exercises.mvcdao.dao.impl.SqliteTeamDAO;
import br.com.gabriel.ifsp.exercises.mvcdao.dao.interfaces.TeamDAO;
import br.com.gabriel.ifsp.exercises.mvcdao.dto.PlayerDTO;
import br.com.gabriel.ifsp.exercises.mvcdao.dto.TeamDTO;
import br.com.gabriel.ifsp.exercises.mvcdao.model.Player;

import java.util.Objects;

public class PlayerMapper {
    private final static TeamDAO teamDAO = new SqliteTeamDAO();
    private PlayerMapper() {}

    public static PlayerDTO toDto(Player player) {
        Objects.requireNonNull(player, "player cannot be null");

        return new PlayerDTO(
                player.getTeam().getName(),
                player.getNumber(),
                player.getName(),
                player.getPosition(),
                player.isFielded()
        );
    }

    public static Player fromDto(PlayerDTO dto) {
        Objects.requireNonNull(dto, "dto cannot be null");

        TeamDTO teamDto = teamDAO.findOne(dto.teamName()).orElseThrow(() -> new RuntimeException("Team not found"));

        Player player = new Player(dto.name(), dto.number(), dto.postion(), TeamMapper.fromDto(teamDto));
        player.setFielded(dto.isFielded());
        return player;
    }
}
