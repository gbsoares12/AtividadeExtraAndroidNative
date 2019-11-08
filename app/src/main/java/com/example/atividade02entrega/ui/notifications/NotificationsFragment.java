package com.example.atividade02entrega.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import com.example.atividade02entrega.MyItemRecyclerViewAdapter;
import com.example.atividade02entrega.R;
import com.example.atividade02entrega.dao.AppDatabase;
import com.example.atividade02entrega.model.PontoLocalidade;

import java.util.List;

public class NotificationsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

//        FragmentManager fm = this.getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//
//        ft.replace(R.id.fragment_container_notification, new MyItemRecyclerViewAdapter(carregarPontosLocalidades()));
//        ft.commit();

        return root;
    }

}