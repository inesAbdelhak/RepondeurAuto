package com.example.repondeurauto;


// affiche la liste de contacts dans le RecyclerView
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    // Liste de contacts à afficher
    private List<Contact> contacts;
    private Context context;
    // Constructeur de l'adapter
    public ContactAdapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    // Méthode pour créer un nouveau ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ViewHolder(view);
    }

    // Méthode pour binder les données à un ViewHolder
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Récupère le contact à la position courante
        Contact contact = contacts.get(position);
        // Affiche les informations du contact
        holder.textViewName.setText(contact.getName());
        holder.textViewPhone.setText(contact.getPhone());
        holder.textViewEmail.setText(contact.getEmail());
        holder.checkBox.setChecked(contact.isSelected());
    }
    // Méthode pour récupérer le nombre d'items dans la liste
    @Override
    public int getItemCount() {
        return contacts.size();
    }
    //stocke les éléments de l'item de la liste
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewPhone;
        public TextView textViewEmail;
        public ImageView imageViewPhoto;
        public CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            // Récupère les éléments de l'item de la liste
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewPhone = itemView.findViewById(R.id.text_view_phone);
            textViewEmail = itemView.findViewById(R.id.text_view_email);
            imageViewPhoto = itemView.findViewById(R.id.image_view_photo);
            checkBox = itemView.findViewById(R.id.check_box);
            // Écouteur pour le CheckBox
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    // Récupère la position du contact dans la liste
                    int position = getAdapterPosition();
                    // Récupère le contact à la position courante
                    Contact contact = contacts.get(position);
                    // Met à jour l'état de sélection du contact
                    contact.setSelected(isChecked);
                }
            });
        }
    }
}