package com.epsib3.myappli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

public class Page2 extends AppCompatActivity {
    Button scan_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        //List of items
        List<HighTechItem> highTechItemList = new ArrayList<>();

    //@GET("/ users") // Entourez la réponse dans un objet Call avec le type du résultat attendu
    //Call getAllUsers ();


        // Parcourt résultat BDD FOREACH
        //Pour chaque résultat bdd HighTechItemList.add(new HighTechItem("Ordinateur", 99.99));

        //Liste d'item en static
        highTechItemList.add(new HighTechItem("Ordinateur", "desktop", 99.99, "http://lorempixel.com/180/241/"));
        highTechItemList.add(new HighTechItem("Monte escalier stana","paraplegic", 3000, "http://lorempixel.com/180/241/"));
        highTechItemList.add(new HighTechItem("Vélo","bicycle", 200,"http://lorempixel.com/180/241/"));
        highTechItemList.add(new HighTechItem("fusée","startup", 2000000, "http://lorempixel.com/180/241/"));
        highTechItemList.add(new HighTechItem("Grenade","handgrenade", 150, "http://lorempixel.com/180/241/"));
        highTechItemList.add(new HighTechItem("Mouse","mouse", 20, "http://lorempixel.com/180/241/"));

        //get list view
        ListView shopListView = findViewById(R.id.shop_list_view);
        shopListView.setAdapter(new HighTechItemAdapter(this, highTechItemList));

        //Chargement et utilisation du QRCode
        scan_btn = findViewById(R.id.scan_btn);
        final Activity activity = this;
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();

            }
        });
    }

    //affichage/exploitation du resultat du QRCode
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            //Si le scan à été annulé (aucun résultat)
            if (result.getContents()==null){
                Toast.makeText(this,"Vous avez annulé le scan", Toast.LENGTH_LONG).show();
            }
            //Si le scan retourne un résultat affichage dans un Popup
            else{
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}


