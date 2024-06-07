package com.example.repondeurauto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AutoReponseFragment extends Fragment {
    // éléments du fragment
    private RecyclerView recyclerView;
    private AutoReponseAdapter adapter;
    private List<AutoReponse> autoReponses;

    public AutoReponseFragment() {
        // Required empty public constructor
    }
    // Méthode pour créer la vue du fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auto_reponse, container, false);
        // Initialisation du RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view_auto_reponse);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // Création d'un exemple de liste de réponses automatiques
        autoReponses = new ArrayList<>();
        autoReponses.add(new AutoReponse("Réponse 1", "Bonjour"));
        autoReponses.add(new AutoReponse("Réponse 2", "Au revoir"));
        autoReponses.add(new AutoReponse("Réponse 3", "....."));
        // Création de l'adaptateur et liaison à la liste des réponses
        adapter = new AutoReponseAdapter(autoReponses);
        recyclerView.setAdapter(adapter);

        return view;
    }
}