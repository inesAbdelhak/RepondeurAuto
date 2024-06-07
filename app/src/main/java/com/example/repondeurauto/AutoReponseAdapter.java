package com.example.repondeurauto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AutoReponseAdapter extends RecyclerView.Adapter<AutoReponseAdapter.ViewHolder> {
    // liste des réponses automatiques à afficher
    private List<AutoReponse> autoReponses;

    // Constructeur pour initialiser la liste des réponses
    public AutoReponseAdapter(List<AutoReponse> autoReponses) {
        this.autoReponses = autoReponses;
    }

    // Méthode pour créer un ViewHolder pour chaque élément de la liste
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.auto_reponse_item, parent, false);
        return new ViewHolder(view);
    }
    // Pour binder les données à chaque ViewHolder
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AutoReponse autoReponse = autoReponses.get(position);
        holder.titleTextView.setText(autoReponse.getTitle());
        holder.textTextView.setText(autoReponse.getText());
    }
    // Retourne le nombre d'éléments dans la liste
    @Override
    public int getItemCount() {
        return autoReponses.size();
    }
    // Classe interne pour représenter un ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView textTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.text_view_title);
            textTextView = itemView.findViewById(R.id.text_view_text);
        }
    }
}