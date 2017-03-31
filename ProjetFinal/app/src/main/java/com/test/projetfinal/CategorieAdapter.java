package com.test.projetfinal;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 18/02/2017.
 */

public class CategorieAdapter extends ArrayAdapter<Categorie> {
    ListView listView;

    public CategorieAdapter(Context context, List categories,ListView mListView){
        super(context,0,categories);
        listView = mListView;


    }
    public View getView(int position,View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_categorie,parent,false);
        }

        CategorieViewHolder viewHolder = (CategorieViewHolder) convertView.getTag();
        if (viewHolder == null) {
            // récupére le nom du Categorie ou de la catégorie
            viewHolder = new CategorieViewHolder();
            viewHolder.categorie = (LinearLayout) convertView.findViewById(R.id.categorie);
            viewHolder.nom = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.logo = (ImageView) convertView.findViewById(R.id.logo);

            convertView.setTag(viewHolder);
        }

        final Categorie categorie = getItem(position);

        viewHolder.nom.setText(categorie.getNom());
        viewHolder.categorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Categorie> sousCats = categorie.getSousCats();

                // afficher dans la vue actuel
                listView.setAdapter(new CategorieAdapter(getContext(),sousCats,listView));

            }
        });

        return convertView;
    }
}
