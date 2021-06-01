package com.hdm.monopoly.backend.board.game_logic;

import com.hdm.monopoly.backend.player_money.DiceNumber;
import com.hdm.monopoly.backend.board.streets.Map;
import com.hdm.monopoly.backend.player_money.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;

/**
 * Class that starts and manages the game, is implemented as a singleton
 */
@Component("game")
public class Game {

    public int playerCount; // helper for constructor

    // These two attributes enable a connection between a map and players
    private Player[] players; /*we assume the game knows on its creation how many players there are.
    That could be achieved by a controller class that manages the network communication*/
    private Map board;

    private int currentPlayer = 0;



    /**
     * Constructor for Game
     * @param players Array with players
     */
    @Autowired
    public  Game(Player[] players, Map map){
        this.players = players;
        this.board = map;

        //based on the playerCount the Players are created and gets put into the players ArrayList

    }


    /**
     * Standard getter for the board.
     * @return Board of the running game.
     */
    public Map getBoard(){
        return board;
    }

    /**
     * This method moves the player to his new position and executes the field action.
     * This method does not take the action of rolling the dice. It has to happen before.
     * @param playerToBeMoved Is the player that is getting moved
     * @param steps Number of fields the player should be moved
     */

    public void movePlayer(Player playerToBeMoved, int steps){
        //Calculating players new position and checking if he made a whole round around the map and is at the start again
        int newPosition = (playerToBeMoved.getPosition() + steps) % board.size();
        if(playerToBeMoved.getPosition()>newPosition){
            //TODO get money for crossing map start = yet to be implemented
        }
        playerToBeMoved.setPosition(newPosition);
        //activates the moveOnField function which is the field action
        board.getField(newPosition).moveOnField(playerToBeMoved);
    }

    /**
     * A getter for the player that is now on the turn. So he is the current player.
     * @return The current player.
     */
    public Player getCurrentPlayer(){
        return players[currentPlayer];
    }

    /**
     * method which controls the end of the turn and sets the currentPlayer to the next
     */
    public void endOfTurn(){
        //TODO check if game has to end
        currentPlayer=++currentPlayer%playerCount;
    }
}

