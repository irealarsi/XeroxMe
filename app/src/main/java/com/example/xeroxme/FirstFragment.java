package com.example.xeroxme;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private static final String TAG = "FirstFragment" ;
    private ArrayList<String> printsArrayList = new ArrayList<>();
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG,"onCreated Fragment");
        Button buttonNext= view.findViewById(R.id.button_first);
        ImageView simpleBitmapView= view.findViewById(R.id.simpleBitImage);
        ImageView simpleImage= view.findViewById(R.id.simpleImageView);
        buttonNext.setVisibility(View.INVISIBLE);
        simpleBitmapView.setVisibility(View.VISIBLE);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume Fragment");
        Bundle b = getArguments();
        if(b != null) {
            Log.d(TAG,b.size() + "");

        } else {
            Log.d(TAG,"Null");
        }
    }
}