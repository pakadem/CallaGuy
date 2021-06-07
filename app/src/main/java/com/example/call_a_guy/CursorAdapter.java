package com.example.call_a_guy;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class CursorAdapter  extends ResourceCursorAdapter {

    public CursorAdapter(Context context, int layout, Cursor cursor, int flags) {
        super(context, layout, cursor, flags);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(cursor.getString(cursor.getColumnIndex("name")));

        TextView phone = (TextView) view.findViewById(R.id.phone);
        phone.setText(cursor.getString(cursor.getColumnIndex("phone")));
    }
}
