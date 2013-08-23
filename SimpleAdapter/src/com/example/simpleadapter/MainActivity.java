package com.example.simpleadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	private ListView listView=null;
	private List<HashMap<String, String>>imgsHashMaps=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		//获取国家名字
		String[] countryStrings=getResources().getStringArray(R.array.country);
		
		/**
		 * 通过名字获取资源id
		 * 
		 * 		getResources().
				public int getIdentifier (String name, String defType, String defPackage) 
		 */
		

		
		imgsHashMaps=new ArrayList<HashMap<String,String>>();
		Resources rs=getResources();
		
		for (int i = 0; i <countryStrings.length; i+=4) {
			
			HashMap<String, String>map=new HashMap<String, String>();
			for (int j = 0; j < 4; j++) {
				map.put("icon_"+(j+1),countryStrings[i+j]);
				map.put("name_"+(j+1),countryStrings[i+j]);
			}
			
			imgsHashMaps.add(map);
		}
		
		listView=(ListView) findViewById(R.id.main_listView);
		
		/**
		 * layout:R.layout.listlayout
		 * "icon":R.id.imageView1
		 * "name":R.id.textView1
		 */
		SimpleAdapter simpleAdapter=
				new SimpleAdapter
				(
						this, imgsHashMaps,
						R.layout.listlayout2, 
						new String[]{
								"icon_1","name_1",
								"icon_2","name_2",
								"icon_3","name_3",
								"icon_4","name_4"}, 
						new int[]{
								R.id.imageView1_1,R.id.textView1_1,
								R.id.imageView1_2,R.id.textView1_2,
								R.id.imageView2_1,R.id.textView2_1,
								R.id.imageView2_2,R.id.textView2_2}
				)
		{

			@Override
			public void setViewImage(ImageView v, String value) {
				// TODO Auto-generated method stub
				super.setViewImage(v, value);
				
				//res文件夹下的drawable文件夹里有 名字为 value.toLowerCase()的资源
				int rsId=getResources().getIdentifier(value.toLowerCase(), "drawable", getPackageName());
				v.setBackgroundResource(rsId);
			}
			
		};
		listView.setAdapter(simpleAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
