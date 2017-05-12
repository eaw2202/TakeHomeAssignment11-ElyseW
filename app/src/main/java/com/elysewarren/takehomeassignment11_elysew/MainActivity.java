package com.elysewarren.takehomeassignment11_elysew;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DogAdapter dogAdapter;


    private DatabaseReference dogReference = FirebaseDatabase.getInstance().getReference("dog");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dogAdapter = new DogAdapter(dogReference); // Stop listening if the activity is destroyed


        recyclerView.setAdapter(dogAdapter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dogAdapter.cleanup();
    }


    public void addDog(View view) {
        String id = UUID.randomUUID().toString();
        Random random = new Random();
        dogReference.child(id).setValue(new Dog(id, "Some Dog", random.nextInt(100), random.nextBoolean()));
    }
}
