package com.parkho.gridview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PhMainActivity extends AppCompatActivity {

    public interface ExtraKey {
        String IMAGE_RES_ID = "ImageResourceId";
    }

    // 이미지 클릭 이벤트를 위한 listener
    public interface ImageItemClickListener {
        void onImageItemClick(int a_imageResId) ;
    }

    // GridView adapter
    private PhGridArrayAdapter mGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Grid 설정
        bindGrid();
    }

    /**
     * Grid 설정
     */
    private void bindGrid() {
        // Grid item 생성
        List<PhGridItem> itemList = new ArrayList<>();
        itemList.add(new PhGridItem(R.drawable.emoji_u1f600, "emoji_u1f600"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f601, "emoji_u1f601"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f602, "emoji_u1f602"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f603, "emoji_u1f603"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f604, "emoji_u1f604"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f605, "emoji_u1f605"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f606, "emoji_u1f606"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f607, "emoji_u1f607"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f608, "emoji_u1f608"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f609, "emoji_u1f609"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f610, "emoji_u1f610"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f611, "emoji_u1f611"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f612, "emoji_u1f612"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f613, "emoji_u1f613"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f614, "emoji_u1f614"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f615, "emoji_u1f615"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f616, "emoji_u1f616"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f617, "emoji_u1f617"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f618, "emoji_u1f618"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f619, "emoji_u1f619"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f620, "emoji_u1f620"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f621, "emoji_u1f621"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f622, "emoji_u1f622"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f623, "emoji_u1f623"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f624, "emoji_u1f624"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f625, "emoji_u1f625"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f626, "emoji_u1f626"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f627, "emoji_u1f627"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f628, "emoji_u1f628"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f629, "emoji_u1f629"));
        itemList.add(new PhGridItem(R.drawable.emoji_u1f630, "emoji_u1f630"));

        // Grid view
        GridView gridView = (GridView) findViewById(R.id.gridview);

        // Grid adapter
        mGridAdapter = new PhGridArrayAdapter(this, itemList);

        // Grid item 중 image view click event 처리
        mGridAdapter.setImageItemClickListener(new ImageItemClickListener() {
            @Override
            public void onImageItemClick(int a_imageResId) {
                Intent intent = new Intent(PhMainActivity.this, PhImageActivity.class);
                intent.putExtra(ExtraKey.IMAGE_RES_ID, a_imageResId);
                startActivity(intent);
            }
        });

        // Adapter 추가
        gridView.setAdapter(mGridAdapter);

        // Grid item click event 처리
        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a_parent, View a_view, int a_position, long a_id) {
                final PhGridItem item = (PhGridItem) mGridAdapter.getItem(a_position);
                Toast.makeText(PhMainActivity.this, item.getName() + " Click event", Toast.LENGTH_SHORT).show();
            }
        });

        // Grid item long click event 처리
        gridView.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> a_parent, View a_view, int a_position, long a_id) {
                final PhGridItem item = (PhGridItem) mGridAdapter.getItem(a_position);
                Toast.makeText(PhMainActivity.this, item.getName() + " Long click event", Toast.LENGTH_SHORT).show();

                // False 로 return 할 경우 long click event 후 click event 발생
                return true;
            }
        });
    }
}