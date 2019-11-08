package com.example.atividade02entrega.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.atividade02entrega.MapsFragment;
import com.example.atividade02entrega.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

public class HomeFragment extends Fragment {

    private static View view;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FragmentManager fm = this.getFragmentManager();

        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            // Substitui um Fragment
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.mapFragment, new MapsFragment());
            ft.commit();
            view = inflater.inflate(R.layout.fragment_home, container, false);

//            Button button4 = (Button) view.findViewById(R.id.);
//            button4.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    FragmentTransaction fra = getFragmentManager().beginTransaction();
//                    fra.replace(R.id.fragment_container, new Fragment3());
//                    fra.commit();
//                }
//            });

        } catch (InflateException e) {
        }
        return view;
    }

}

