package com.example.atividade02entrega.dummy;

import androidx.room.Room;

import com.example.atividade02entrega.dao.AppDatabase;
import com.example.atividade02entrega.model.PontoLocalidade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<PontoLocalidade> ITEMS = new ArrayList<>();

//    private static final int COUNT = 25;
//
//    private static void addItem(PontoLocalidade item) {
//        ITEMS.add(item);
//        //ITEM_MAP.put(item.id, item);
//    }
//
//    private static PontoLocalidade createDummyItem(int position) {
//        return new PontoLocalidade(position,);
//    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }
}
