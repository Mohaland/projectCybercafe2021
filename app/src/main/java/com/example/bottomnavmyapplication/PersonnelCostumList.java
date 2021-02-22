package com.example.bottomnavmyapplication;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PersonnelCostumList extends ArrayAdapter<PersonnelAdapter> {
    private ArrayList<PersonnelAdapter> personnels;
    private Context context;
    private int resource;


    public PersonnelCostumList(@NonNull Context context, int resource, @NonNull List<PersonnelAdapter> objects) {
        super(context, resource, objects);
        this.personnels = personnels;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.itempersonnel, null, true);
        }

        PersonnelAdapter personnelAdapter = getItem(position);

        TextView nomtitre = (TextView) convertView.findViewById(R.id.idnom);
        nomtitre.setText(personnelAdapter.getNom());

        TextView nom = (TextView) convertView.findViewById(R.id.idnom2);
        nom.setText(personnelAdapter.getNom());

        TextView prenom = (TextView) convertView.findViewById(R.id.idprenom);
        prenom.setText(personnelAdapter.getPrenom());

        TextView login = (TextView) convertView.findViewById(R.id.login);
        login.setText(personnelAdapter.getLogin());

        TextView mdp = (TextView) convertView.findViewById(R.id.mdp);
        mdp.setText(personnelAdapter.getPassword());

        return convertView;
    }
}
