package com.example.hectorvera.recyclerproject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private Button bListViewH, bListViewV, bGridView, bSGridView, bAddPeople;

    private static final String URL = "https://pbs.twimg.com/profile_images/616076655547682816/6gMRtQyY.jpg";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Bitmap image;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bListViewH = ((Button) findViewById(R.id.bListViewH));
        bListViewV = ((Button) findViewById(R.id.bListViewV));
        bGridView = ((Button) findViewById(R.id.bGridView));
        bSGridView = ((Button) findViewById(R.id.bSGridView));
        bAddPeople = ((Button) findViewById(R.id.bAddPeople));

        mRecyclerView = ((RecyclerView) findViewById(R.id.mRecyclerView));

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        final ArrayList<Person> people = getPersons();

        mAdapter = new RecyclerAdapter(people);
        mRecyclerView.setAdapter(mAdapter);

                View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.bListViewH:
                        mLayoutManager = null;
                        mLayoutManager = new LinearLayoutManager(v.getContext(),LinearLayoutManager.HORIZONTAL,false);
                        mRecyclerView.setLayoutManager(mLayoutManager);
                        Toast.makeText(getBaseContext(),"Click on Horizontal list view button", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bListViewV:
                        mLayoutManager = null;
                        mLayoutManager = new LinearLayoutManager(v.getContext(),LinearLayoutManager.VERTICAL,false);
                        mRecyclerView.setLayoutManager(mLayoutManager);
                        Toast.makeText(getBaseContext(),"Click on Vertical list view button", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bGridView:
                        mLayoutManager = null;
                        mLayoutManager = new GridLayoutManager(v.getContext(), 2);
                        mRecyclerView.setLayoutManager(mLayoutManager);
                        Toast.makeText(getBaseContext(),"Click on Grid button", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bSGridView:
                        mLayoutManager = null;
                        mLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
                        mRecyclerView.setLayoutManager(mLayoutManager);
                        Toast.makeText(getBaseContext(),"Click on Scrable grid view button", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bAddPeople:
                        people.add(1,new Person("Persona1","11/10/2016","************",image));
                        mAdapter.notifyItemInserted(1);
                        Toast.makeText(getBaseContext(),"Add a people", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        };
        bListViewV.setOnClickListener(listener);
        bListViewH.setOnClickListener(listener);
        bGridView.setOnClickListener(listener);
        bSGridView.setOnClickListener(listener);
        bAddPeople.setOnClickListener(listener);
    }

    @NonNull
    private ArrayList<Person> getPersons() {
        //Falta generar el constructor para pasarle los datos.
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("Hector Vera","22/05/1982","-----------Hector Vera--22/05/1982--------------------"));
        people.add(new Person("Jorge Ramirez","12/05/1979","---------Jorge Ramirez--12/05/1979----------------------"));
        people.add(new Person("Elizabeth Barraza","08/04/1977","-----Elizabeth Barraza--08/04/1977--------------------------"));
        people.add(new Person("Sofia San Roman","16/08/1951","-------Sofia San Roman--16/08/1951------------------------"));
        people.add(new Person("Gilberto Hernandez","08/05/1982","-----Gilberto Hernandez--08/05/1982--------------------------"));
        people.add(new Person("Veronica Perez","01/01/1980","---------Veronica Perez--01/01/1980----------------------"));
        people.add(new Person("Arturo Castillo","02/02/1990","--------Arturo Castillo--03/03/1991-----------------------"));
        people.add(new Person("Sonia Bermudez","03/03/1991","---------Sonia Bermudez--03/03/1991----------------------"));
        people.add(new Person("Sasha Montenegro","04/04/1985","-------Sasha Montenegro--04/04/1985------------------------"));
        return people;
    }


}
