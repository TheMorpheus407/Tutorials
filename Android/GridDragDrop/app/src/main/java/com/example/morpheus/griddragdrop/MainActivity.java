package com.example.morpheus.griddragdrop;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView) findViewById(R.id.grid);
        List<Button> items = new ArrayList<Button>();
        grid.setAdapter(new DragGridAdapter(items, this));

        grid.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    GridView parent = (GridView) v;

                    int x = (int) event.getX();
                    int y = (int) event.getY();

                    int position = parent.pointToPosition(x, y);
                    if (position > AdapterView.INVALID_POSITION) {

                        int count = parent.getChildCount();
                        for (int i = 0; i < count; i++) {
                            View curr = parent.getChildAt(i);
                            curr.setOnDragListener(new View.OnDragListener() {

                                @Override
                                public boolean onDrag(View v, DragEvent event) {

                                    boolean result = true;
                                    int action = event.getAction();
                                    switch (action) {
                                        case DragEvent.ACTION_DRAG_STARTED:
                                            break;
                                        case DragEvent.ACTION_DRAG_LOCATION:
                                            break;
                                        case DragEvent.ACTION_DRAG_ENTERED:
                                            break;
                                        case DragEvent.ACTION_DRAG_EXITED:
                                            break;
                                        case DragEvent.ACTION_DROP:
                                            if (event.getLocalState() == v) {
                                                result = false;
                                            } else {
                                                Button droped = (Button) event.getLocalState();

                                                GridView parent = (GridView) droped.getParent();
                                                DragGridAdapter adapter = (DragGridAdapter) parent.getAdapter();
                                                List<Button> items = adapter.getItems();

                                                Button target = (Button) v;
                                                int index = items.indexOf(target);
                                                items.remove(droped);
                                                items.add(index, droped);
                                                adapter.notifyDataSetChanged();
                                            }
                                            break;
                                        case DragEvent.ACTION_DRAG_ENDED:
                                            break;
                                        default:
                                            result = false;
                                            break;
                                    }
                                    return result;
                                }
                            });
                        }

                        int relativePosition = position - parent.getFirstVisiblePosition();


                        View target = (View) parent.getChildAt(relativePosition);

                        ClipData data = ClipData.newPlainText("DragData", new Integer(target.getId()).toString());
                        target.startDrag(data, new View.DragShadowBuilder(target), target, 0);
                    }
                }
                return false;
            }
        });
    }
}