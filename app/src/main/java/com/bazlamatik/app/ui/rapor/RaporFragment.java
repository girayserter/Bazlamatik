package com.bazlamatik.app.ui.rapor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bazlamatik.app.R;

public class RaporFragment extends Fragment {

    private RaporViewModel raporViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_rapor, container, false);
        return root;
    }
}