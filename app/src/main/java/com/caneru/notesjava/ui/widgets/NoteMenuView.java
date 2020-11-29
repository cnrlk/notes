package com.caneru.notesjava.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;

import com.caneru.notesjava.R;

public class NoteMenuView extends LinearLayout {

    private PopupMenu popupMenu;
    private ImageButton imageButton;
    private OnClickListener editListener;
    private OnClickListener deleteListener;


    public NoteMenuView(Context context) {
        super(context);
        init(context, null);
    }

    public NoteMenuView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public NoteMenuView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attributeSet) {
        addView(inflate(context, R.layout.view_menu_item, null));

        imageButton = findViewById(R.id.buttonImage);
        popupMenu = new PopupMenu(context, imageButton);

        popupMenu.getMenuInflater().inflate(R.menu.note_menu, popupMenu.getMenu());

        imageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.show();
            }
        });

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_delete:
                        deleteListener.onClick(item.getActionView());
                        break;
                    case R.id.menu_edit:
                        editListener.onClick(item.getActionView());
                        break;
                }
                return false;
            }
        });

    }

    public void setEditListener(OnClickListener onClickListener) {
        this.editListener = onClickListener;
    }

    public void setDeleteListener(OnClickListener onClickListener) {
        this.deleteListener = onClickListener;
    }


}
