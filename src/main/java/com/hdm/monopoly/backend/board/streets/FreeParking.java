package com.hdm.monopoly.backend.board.streets;

import com.hdm.monopoly.backend.board.send_message.SendMessage;
import com.hdm.monopoly.backend.player_money.Player;

public class FreeParking implements Field{

    private String name;

    public FreeParking(String name){
        this.name = name;
    }

    @Override
    public void moveOnField(Player player, SendMessage sendMessage, String[] SessionIds) {
        //TODO
    }

    @Override
    public String getFieldName() {
        return name;
    }
}
