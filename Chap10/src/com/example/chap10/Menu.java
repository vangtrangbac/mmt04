package com.example.chap10;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class Menu extends ListActivity {
	//Tao 1 mang class chua danh sach cac menu
		String classes[]={"MainActivity","chap3_LinearLayout1","chap3_AbsoluteLayout","chap3_TableLayout1",
				"chap3_RelativeLayout1","chap3_FrameLayout","chap3_ScrollView","chap3_Orientation","chap3_UIactivity"};

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			//Full Screen activities
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
			
			setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1,classes));
			
		}

		@Override
		protected void onListItemClick(ListView l, View v, int position, long id) {
			// TODO Auto-generated method stub
			super.onListItemClick(l, v, position, id);
			String cheese=classes[position];
			Class ourClass;
			try{
				ourClass=Class.forName("com.example.chap10."+cheese);
				Intent ourIntent=new Intent(Menu.this,ourClass);
				startActivity(ourIntent);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		}
		
}

