package com.fontys.semester3individualprojectplayvera.Service;

import com.fontys.semester3individualprojectplayvera.interfaces.IFakeDataStore;
import com.fontys.semester3individualprojectplayvera.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService implements IGameService {

    IFakeDataStore _fakeDataStore;
    @Autowired
    public GameService(IFakeDataStore _fakeDataStore){this._fakeDataStore = _fakeDataStore;}


    @Override
    public List<Game> GetAllGames(){
        return this._fakeDataStore.getGames();
    }

}
