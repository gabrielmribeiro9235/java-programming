package br.com.gabriel.ifsp.exercises.mvcdao.dao.interfaces;

import br.com.gabriel.ifsp.exercises.mvcdao.dto.TeamDTO;

import java.util.Optional;
import java.util.Set;

public interface TeamDAO {
    void insert(TeamDTO teamDto);
    void update(TeamDTO teamDto);
    void delete(TeamDTO teamDto);
    void delete(String teamName);
    Set<TeamDTO> findAll();
    Optional<TeamDTO> findOne(String teamName);
}
