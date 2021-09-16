package com.example.rnandandroid.embed_fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.rnandandroid.R;

public class CustomFragment extends Fragment {
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_container_view, parent, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("CustomFragment", "in Destrpy view");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("CustomFragment", "onDetach");
    }
}
