package com.hjs.ex_1120_popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn, anchor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anchor = findViewById(R.id.anchor);

        btn = findViewById(R.id.show_menu);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 팝업 메뉴 생성
                PopupMenu popup = new PopupMenu(MainActivity.this, // 현재 팝업이 띄워질 액티비티
                        anchor); // anchor : 팝업을 띄울 기준 객체

                // 팝업 메뉴가 참조할 my_menu를 준비
                getMenuInflater().inflate(R.menu.my_menu, popup.getMenu());

                // 팝업 메뉴에게 이벤트 감지자 등록
                popup.setOnMenuItemClickListener( popupClick );

                popup.show(); // 메뉴 보이게 하기
            }
        });
    }
    PopupMenu.OnMenuItemClickListener popupClick = new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {

            switch(menuItem.getItemId()) {
                case R.id.menu1 :
                    Toast.makeText(MainActivity.this,"메뉴1 click",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu2 :
                    Toast.makeText(MainActivity.this,"메뉴2 click",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu3 :
                    Toast.makeText(MainActivity.this,"메뉴3 click",Toast.LENGTH_SHORT).show();

                    finish();
                    break;
            }

            return true;
        }
    };
}
