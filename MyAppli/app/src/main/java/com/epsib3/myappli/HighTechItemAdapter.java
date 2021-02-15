package com.epsib3.myappli;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class HighTechItemAdapter extends BaseAdapter {

    //field
    private Context context;
    private List<HighTechItem> highTechItemList;
    private LayoutInflater inflater;

    //Constructor
    public HighTechItemAdapter(Context context, List<HighTechItem> highTechItemList)
    {
        this.context = context;
        this.highTechItemList = highTechItemList;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return highTechItemList.size();
    }

    @Override
    public HighTechItem getItem(int position) {
        return highTechItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.adapter_item, null);

        //get information about item
        HighTechItem currentItem = getItem(i);
        final String itemName = currentItem.getName();
        String mnemonic = currentItem.getMnemonic();
        final double itemPrice = currentItem.getPrice();

        //get item icon view
        ImageView  itemIconView = view.findViewById(R.id.item_icon);

        //Pictures in local (actually take online)
        //String resourceName = "item_" + mnemonic + "_icon";
        //int resId = context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
        //itemIconView.setImageResource(resId);

        //Picture get on WEB
        Picasso.get().load(currentItem.geturl()).resize(70,100).into(itemIconView);

        //get item name view
        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);

        //get item price view
        TextView itemPriceView = view.findViewById(R.id.item_price);
        itemPriceView.setText(itemPrice + "€");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Vous essayez d'acheter un/une "+ itemName +",  pour le prix de "+ itemPrice +"€", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
