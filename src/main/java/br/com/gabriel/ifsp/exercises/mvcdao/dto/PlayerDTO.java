package br.com.gabriel.ifsp.exercises.mvcdao.dto;

public record PlayerDTO(
        String teamName,
        int number,
        String name,
        String postion,
        boolean isFielded
) {}
