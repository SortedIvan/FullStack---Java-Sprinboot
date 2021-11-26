package com.fontys.sem3gamewebshop.converters;
import com.fontys.sem3gamewebshop.dto.GameDTO;
import com.fontys.sem3gamewebshop.model.Game;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class GameConverter {

    public GameDTO entityToDto(Game entity)
    {
        ModelMapper mapper = new ModelMapper();
        GameDTO dto = mapper.map(entity,GameDTO.class);

        return dto;

    }
    public List<GameDTO> entityToDto(List<Game> games)
    {
        return games.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }
    public Game dtoToEntity(GameDTO dto)
    {
        ModelMapper mapper = new ModelMapper();
        Game entity = mapper.map(dto,Game.class);
        return entity;

    }
    public List<Game> dtoToEntity(List<GameDTO> gameDTOS)
    {
        return gameDTOS.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());

    }
}