package com.epsib3.myappli;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    Button button;
    private MainActivity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.activity = this;



        this.button = new Button(this);
        this.button = findViewById(R.id.button2);

        //En cliquant sur le bouton, ouverture d'une nouvelle page et affichage d'un popup.
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myPopup = new AlertDialog.Builder(activity);
                //Si il accepte il va sur une nouvelle page.
                myPopup.setMessage("Votre adresse mail sera conservée sans être diffusé");
                myPopup.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent otherActivity = new Intent (getApplicationContext(), Page2.class);
                        startActivity(otherActivity);
                        finish();
                    }
                });

                //Si l'utilisateur refuse, retour sur la page d'acceuil.
                myPopup.setNegativeButton("refuser", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Vous devez accepter pour utiliser cette application", Toast.LENGTH_SHORT).show();
                    }
                });

                myPopup.show();
            }
        });

    }
}