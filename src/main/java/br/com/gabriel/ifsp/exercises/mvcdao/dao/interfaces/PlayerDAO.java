package br.com.gabriel.ifsp.exercises.mvcdao.dao.interfaces;

import br.com.gabriel.ifsp.exercises.mvcdao.dto.PlayerDTO;

import java.util.Optional;
import java.util.Set;

public interface PlayerDAO {
    void insert(PlayerDTO playerDto);
    void update(PlayerDTO playerDto);
    void delete(PlayerDTO playerDto);
    void delete(int playerNumber, String teamName);
    Set<PlayerDTO> findAll();
    Set<PlayerDTO> findAllByTeam(String teamName);
    Optional<PlayerDTO> findOne(int playerNumber, String teamName);
}
