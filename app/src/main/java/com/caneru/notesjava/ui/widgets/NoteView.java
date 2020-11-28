package com.caneru.notesjava.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.caneru.notesjava.R;

public class NoteView extends View {
    public NoteView(Context context) {
        super(context);
        init(context, null);
    }

    public NoteView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public NoteView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attributeSet) {
        inflate(context, R.layout.view_note_item_layout, (ViewGroup) getParent());
    }
}
