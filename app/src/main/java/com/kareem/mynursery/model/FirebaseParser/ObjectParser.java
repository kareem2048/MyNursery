package com.kareem.mynursery.model.FirebaseParser;

import com.google.firebase.database.DataSnapshot;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by kareem on 9/15/17.
 */

public class ObjectParser {

    public <T> T getValue(Class<T> cls, DataSnapshot dataSnapshot) {
        try {
            return  getValue(cls, cls.newInstance() , dataSnapshot );
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T getValue(Class<T> cls, T object, DataSnapshot dataSnapshot) {
        boolean accessibility;
        for (DataSnapshot snapshot: dataSnapshot.getChildren()
             ) {
            try {
                Field field = cls.getDeclaredField(snapshot.getKey());
                accessibility = field.isAccessible();
                field.setAccessible(true);
                if (isKeyList(field)) setListValues(snapshot, field, object);
                else if (!isExcluded(field)) field.set(object, snapshot.getValue() );
                field.setAccessible(accessibility);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    private <T>  void setListValues(DataSnapshot dataSnapshot, Field field, T object)
    {
        ArrayList<String> list = new ArrayList<>();
        for (DataSnapshot snapshot: dataSnapshot.getChildren()
                ) {
            list.add(snapshot.getKey());
        }
        try {
            field.set(object, list);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private boolean isKeyList(Field field)
    {
        return  (field.getAnnotation(KeyList.class) != null);

    }
    private boolean isExcluded(Field field){
        return (field.getAnnotation(KeyList.class) != null);
    }
}
