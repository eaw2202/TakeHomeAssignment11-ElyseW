package com.elysewarren.takehomeassignment11_elysew;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

public class DogAdapter extends FirebaseRecyclerAdapter<Dog, DogViewHolder> {


    public DogAdapter(Query ref) {
        super(Dog.class, R.layout.card_view_holder, DogViewHolder.class, ref);
    }


    @Override
    protected void populateViewHolder(DogViewHolder viewHolder, Dog dog, int position) {
        viewHolder.bind(dog);
    }
}
