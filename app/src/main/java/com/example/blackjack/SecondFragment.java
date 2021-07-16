package com.example.blackjack;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static android.widget.Toast.LENGTH_SHORT;
import static java.lang.Thread.sleep;

public class SecondFragment extends Fragment {
    BlackJackGame game;
    MediaPlayer soundPlayer;
    boolean newHandButton;
    boolean notified;
    boolean newTurn;
    boolean houseWon;

    Button hitButton;
    Button stayButton;
    Button tBButton;
    Button fBButton;
    Button hBButton;

    ImageView pc1;
    ImageView pc2;
    ImageView pc3;
    ImageView pc4;
    ImageView dc1;
    ImageView dc2;
    ImageView dc3;
    ImageView dc4;

    TextView poolView;
    TextView handsWon;
    TextView pScore;
    TextView hScore;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            game = new BlackJackGame();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        boolean notified = false;
        boolean houseWon = false;

         hitButton = (Button)view.findViewById(R.id.buttonHit);
         stayButton = (Button)view.findViewById(R.id.buttonStand);
         tBButton = (Button)view.findViewById(R.id.button25);
         fBButton = (Button)view.findViewById(R.id.button50);
         hBButton = (Button)view.findViewById(R.id.button100);



        view.findViewById(R.id.button25).setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View view) {
                                                                    betButton25(view);
                                                                }
                                                            }
        );
        view.findViewById(R.id.button50).setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View view) {
                                                                    betButton50(view);
                                                                }
                                                            }
        );
        view.findViewById(R.id.button100).setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View view) {
                                                                    betButton100(view);
                                                                }
                                                            }
        );
        view.findViewById(R.id.buttonHit).setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View view) {
                                                                    try {
                                                                        hitButton(view);
                                                                    } catch (NoSuchFieldException e) {
                                                                        e.printStackTrace();
                                                                    } catch (IllegalAccessException e) {
                                                                        e.printStackTrace();
                                                                    }
                                                                }
                                                            }
        );
        view.findViewById(R.id.buttonStand).setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View view) {
                                                                    try {
                                                                        stayButton(view);
                                                                    } catch (NoSuchFieldException e) {
                                                                        e.printStackTrace();
                                                                    } catch (IllegalAccessException e) {
                                                                        e.printStackTrace();
                                                                    } catch (InterruptedException e) {
                                                                        e.printStackTrace();
                                                                    }
                                                                }
                                                            }
        );

        handsWon = (TextView) view.findViewById(R.id.handsWonView);
        poolView = (TextView) view.findViewById(R.id.poolView);
        hScore = (TextView) view.findViewById(R.id.textView2);
        pScore = (TextView) view.findViewById(R.id.textView3);

        pc1 = (ImageView) view.findViewById(R.id.pc1);
        pc2 = (ImageView) view.findViewById(R.id.pc2);
        pc3 = (ImageView) view.findViewById(R.id.pc3);
        pc4 = (ImageView) view.findViewById(R.id.pc4);

        dc1 = (ImageView) view.findViewById(R.id.dc1);
        dc2 = (ImageView) view.findViewById(R.id.dc2);
        dc3 = (ImageView) view.findViewById(R.id.dc3);
        dc4 = (ImageView) view.findViewById(R.id.dc4);

        imageHandler();
        updateTexts();

    }

    public void imageHandler(){
        if(1 > game.getPlayerHand().size()){
            pc1.setVisibility(INVISIBLE);
        }
        if(2 > game.getPlayerHand().size()){
            pc2.setVisibility(INVISIBLE);
        }
        if(3 > game.getPlayerHand().size()){
            pc3.setVisibility(INVISIBLE);
        }
        if(4 > game.getPlayerHand().size()){
            pc4.setVisibility(INVISIBLE);
        }
        if(1 > game.getDealerHand().size()){
            dc1.setVisibility(INVISIBLE);
        }
        if(1 >= game.getDealerHand().size()){
            dc2.setImageResource(getResources().getIdentifier("red_back","drawable",getContext().getPackageName()));
            dc2.setVisibility(VISIBLE);
        }
        if(3 > game.getDealerHand().size()){
            dc3.setVisibility(INVISIBLE);
        }
        if(4 > game.getDealerHand().size()){
            dc4.setVisibility(INVISIBLE);
        }

        if(1 <= game.getPlayerHand().size()){
            pc1.setImageResource((game.getPlayerHand().getCard(0).getCardFace()));
            pc1.setVisibility(VISIBLE);
        }
        if(2 <= game.getPlayerHand().size()){
            pc2.setImageResource((game.getPlayerHand().getCard(1).getCardFace()));
            pc2.setVisibility(VISIBLE);
        }
        if(3 <= game.getPlayerHand().size()){
            pc3.setImageResource((game.getPlayerHand().getCard(2).getCardFace()));

            pc3.setVisibility(VISIBLE);
        }
        if(4 <= game.getPlayerHand().size()){
            pc4.setImageResource((game.getPlayerHand().getCard(3).getCardFace()));

            pc4.setVisibility(VISIBLE);
        }
        if(5 <= game.getPlayerHand().size()){
            pc1.setImageResource((game.getPlayerHand().getCard(4).getCardFace()));

            pc1.setVisibility(VISIBLE);
        }
        if(6 <= game.getPlayerHand().size()){
            pc2.setImageResource((game.getPlayerHand().getCard(5).getCardFace()));

            pc2.setVisibility(VISIBLE);
        }

        if(1 <= game.getDealerHand().size()){
            dc1.setImageResource((game.getDealerHand().getCard(0).getCardFace()));
            dc1.setVisibility(VISIBLE);
        }
        if(2 <= game.getDealerHand().size()){
            dc2.setImageResource((game.getDealerHand().getCard(1).getCardFace()));
            dc2.setVisibility(VISIBLE);
        }
        if(3 <= game.getDealerHand().size()){
            dc3.setImageResource((game.getDealerHand().getCard(2).getCardFace()));

            dc3.setVisibility(VISIBLE);
        }
        if(4 <= game.getDealerHand().size()){
            dc4.setImageResource((game.getDealerHand().getCard(3).getCardFace()));
            dc4.setVisibility(VISIBLE);
        }
        if(5 <= game.getDealerHand().size()){
            dc1.setImageResource((game.getDealerHand().getCard(4).getCardFace()));

            dc1.setVisibility(VISIBLE);
        }
        if(6 <= game.getDealerHand().size()){
            dc2.setImageResource((game.getDealerHand().getCard(5).getCardFace()));
            dc2.setVisibility(VISIBLE);
        }


    }



    public void hitButton(View v) throws NoSuchFieldException, IllegalAccessException {
        soundPlayer = MediaPlayer.create( this.getContext() ,R.raw.hit);
        tBButton.setVisibility(INVISIBLE);
        fBButton.setVisibility(INVISIBLE);
        hBButton.setVisibility(INVISIBLE);
        soundPlayer.start();
        newTurn = false;
        if(newHandButton){
            game.resetGame();
            resetButtons();
            notified = false;
            newHandButton = false;
            newTurn = true;
            houseWon = false;
            imageHandler();
            updateTexts();
        }
        if(!newTurn){
            game.resolveHand();
            imageHandler();
            updateTexts();
            interactiveLogic();
        }
        if(game.getPlayer().getHandValue() == 21){
            hitButton.setVisibility(INVISIBLE);
        }

    }

    private void updateTexts(){
        String pool = String.valueOf(game.getPlayerPool());
        String hands = String.valueOf(game.getPlayerHandsWon());
        String pScore = String.valueOf(game.getPlayerHand().getHandValue());
        String hScore = String.valueOf(game.getDealerHand().getHandValue());
        handsWon.setText("Hands Won: "+hands);
        poolView.setText("Cash: "+ pool);
        this.pScore.setText("Player: "+ pScore+ "  ");
        this.hScore.setText("House: "+hScore);

    }

    public void betButton25(View v){
        betButtonHelper(25);

    }
    public void betButton50(View v){
        betButtonHelper(50);

    }
    public void betButton100(View v){
        betButtonHelper(100);
    }


    private void betButtonHelper(int amount){
        soundPlayer = MediaPlayer.create( this.getContext() ,R.raw.changebet);
        game.playerChangeBet(amount);
        soundPlayer.start();
        Toast toast = Toast.makeText(this.getContext(),"Bet Amount: $"+amount,LENGTH_SHORT);
        toast.show();
        tBButton.setVisibility(INVISIBLE);
        fBButton.setVisibility(INVISIBLE);
        hBButton.setVisibility(INVISIBLE);
    }

    public void stayButton(View v) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        soundPlayer = MediaPlayer.create( v.getContext() ,R.raw.stay);
        game.playerStays();
        while(!game.getDealer().isStaying() && !game.getDealer().isBusted() && !houseWon){
            soundPlayer = MediaPlayer.create( v.getContext() ,R.raw.stay);
            game.resolveHand();
            soundPlayer.start();
            imageHandler();
            Thread.sleep(1000);
            interactiveLogic();
        }

    }

    private void interactiveLogic() throws NoSuchFieldException, IllegalAccessException {
        if(game.getDealer().isStaying() && !notified && !game.getPlayer().isStaying()){
            soundPlayer = MediaPlayer.create(this.getContext(), R.raw.notify);
            soundPlayer.start();
            notified = true;
            Toast toast = Toast.makeText(this.getContext(),"Dealer Stands",LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
        }

        if(game.deckNeedsShuffled()) {
            soundPlayer = MediaPlayer.create(this.getContext(), R.raw.shuffling);
            soundPlayer.start();
        }
        if(game.getPlayer().isBusted()) {
            interactiveHelper("BUSTED!", false);
            game.getPlayer().subtractCash(game.getPlayer().getBet());
        }
        if(game.getPlayer().getHand().getHandValue() == 21 && game.getDealer().getHandValue() != 21 && game.getDealer().isStaying() || game.getDealer().isBusted()){
            interactiveHelper("Win!",true);
            game.getPlayer().wonAHand();
            game.getPlayer().addCash(game.getPlayer().getBet());
        }
        if(game.getPlayer().getHand().getHandValue() > game.getDealer().getHandValue() && game.getDealer().isStaying() && game.getPlayer().isStaying() && !game.getPlayer().isBusted()){
            interactiveHelper("Win!",true);
            game.getPlayer().wonAHand();
            game.getPlayer().addCash(game.getPlayer().getBet());
        }
        if(game.getPlayer().getHand().getHandValue() == game.getDealer().getHandValue() && game.getDealer().isStaying() && game.getPlayer().isStaying()){
                interactiveHelper("Draw",true);
        }
        if(game.getPlayer().isStaying() && game.getDealer().getHandValue() > game.getPlayer().getHandValue() && !game.getDealer().isBusted()){
            interactiveHelper("House Wins",false);
            houseWon = true;
            game.getPlayer().subtractCash(game.getPlayer().getBet());

        }
        updateTexts();
        }

    private void interactiveHelper(String message,boolean win){
        Toast toast;
        if(win){
            soundPlayer = MediaPlayer.create( this.getContext() ,R.raw.win);
            toast = Toast.makeText(this.getContext(),message,LENGTH_SHORT);

        }
        else{
            soundPlayer = MediaPlayer.create( this.getContext() ,R.raw.bust);
            toast = Toast.makeText(this.getContext(),message,LENGTH_SHORT);
        }
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
        soundPlayer.start();
        newHandButton();
        hideButtons();
        updateTexts();
    }

    private void newHandButton(){
        hitButton.setText("New Hand");
        newHandButton = true;
    }

    private void hideButtons(){
        hitButton.setVisibility(VISIBLE);
        tBButton.setVisibility(INVISIBLE);
        fBButton.setVisibility(INVISIBLE);
        hBButton.setVisibility(INVISIBLE);
        stayButton.setVisibility(INVISIBLE);

    }
    private void resetButtons(){
        hitButton.setText("Hit");
        tBButton.setVisibility(VISIBLE);
        fBButton.setVisibility(VISIBLE);
        hBButton.setVisibility(VISIBLE);
        stayButton.setVisibility(VISIBLE);

    }

}