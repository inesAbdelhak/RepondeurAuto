package com.example.repondeurauto;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



// Fragment pour afficher la liste de contacts
public class ContactFragment extends Fragment {


// RecyclerView pour afficher la liste de contacts
private RecyclerView recyclerView;
    private ContactAdapter contactAdapter;
    // Liste de contacts à affiche
    private List<Contact> contacts;

    public ContactFragment() {
        // Required empty public constructor
    }
// Méthode appelée lors de la création de la vue du fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        // Récupère la RecyclerView du layout
        recyclerView = view.findViewById(R.id.recycler_view);
        // Définit le layout manager pour la RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // Récupère la liste de contacts du téléphone
        contacts = getContactsFromPhone();
        // Crée un adapter pour binder les données à la RecyclerView
        contactAdapter = new ContactAdapter(contacts);
        recyclerView.setAdapter(contactAdapter);

        return view;
    }
    // Méthode pour récupérer la liste de contacts du téléphone
    private List<Contact> getContactsFromPhone() {
        List<Contact> contacts = new ArrayList<>();
        // Récupère le ContentResolver pour accéder aux données du téléphone
        ContentResolver contentResolver = getContext().getContentResolver();
        // Récupère le curseur pour les contacts
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

        if (cursor != null) {
            // Parcourt les contacts et ajoute chaque contact à la liste
            while (cursor.moveToNext()) {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                String phoneNumber = getPhoneNumber(contentResolver, id);
                contacts.add(new Contact(name, phoneNumber));
            }
            cursor.close();
        }

        return contacts;
    }
    // Méthode pour récupérer le numéro de téléphone d'un contact
    private String getPhoneNumber(ContentResolver contentResolver, String contactId) {
        // Récupère le curseur pour les numéros de téléphone du contact
        Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " =?", new String[]{contactId}, null);
        String phoneNumber = null;
        if (cursor != null) {
            // Parcourt les numéros de téléphone et récupère le premier
            while (cursor.moveToNext()) {

                phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            }
            cursor.close();
        }
        return phoneNumber;
    }
}