package com.hdm.monopoly.board;

import com.hdm.monopoly.player.Player;
import com.hdm.monopoly.sendmessage.SendMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FreeParking implements Field{
    private static final Logger log = LogManager.getLogger();

    private final String name;
    private int credit;

    public void setCredit(int amount) {
       credit += amount;
    }

    public FreeParking(String name){
        this.name = name;
        log.info("New Object 'FreeParking' created");
    }

    @Override
    public void moveOnField(Player player, SendMessage sendMessage, String[] SessionIds, Board board) {

        if(credit >=1 ){
            sendMessage.sendToPlayer(SessionIds[player.getID()], "/client/notification", "You get " + credit + "from Free Parking");
            player.playerGetsMoney(credit);
            credit = 0;
        } else {
            sendMessage.sendToPlayer(SessionIds[player.getID()], "/client/notification", "There is no money in Free Parking");
        }
    }

    @Override
    public String getFieldName() {
        return name;
    }
}
