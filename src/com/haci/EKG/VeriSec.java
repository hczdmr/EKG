package com.haci.EKG;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * Created by HaciOzdemir on 24/12/14.
 */
public class VeriSec extends Activity {
    private ListView lv;

    String hastalikli[] = {"Hastalıklı_Veri1", "Hastalıklı_Veri2", "Hastalıklı_Veri3", "Hastalıklı_Veri4","Hastalıklı_Veri5",
            "Hastalıklı_Veri6", "Hastalıklı_Veri7", "Hastalıklı_Veri8", "Hastalıklı_Veri9", "Hastalıklı_Veri10",
            "Hastalıklı_Veri11", "Hastalıklı_Veri12", "Hastalıklı_Veri13", "Hastalıklı_Veri14","Hastalıklı_Veri15"};


    String mitdb= "MIT-BIH Arrhythmia Database(mitdb)";
    int iconeksi = R.drawable.icon;

    String saglikli[]={"Sağlıklı_Veri1","Sağlıklı_Veri2","Sağlıklı_Veri3","Sağlıklı_Veri4","Sağlıklı_Veri5",
            "Sağlıklı_Veri6","Sağlıklı_Veri7","Sağlıklı_Veri8","Sağlıklı_Veri9","Sağlıklı_Veri10",
            "Sağlıklı_Veri11","Sağlıklı_Veri12","Sağlıklı_Veri13","Sağlıklı_Veri14","Sağlıklı_Veri15"};
    String nsrdb= "MIT-BIH Normal Sinus Rhythm Database(nsrdb)";
    int iconarti = R.drawable.icon;

    int poss;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verisec);

        Bundle bundle=getIntent().getExtras();
        poss=bundle.getInt("position");


        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new VersionAdapter(this));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                Bundle bundle = new Bundle();
                if (poss==0){
                    bundle.putString("isim", hastalikli[arg2]);
                }else if (poss==1){
                    bundle.putString("isim", saglikli[arg2]);
                }

                bundle.putInt("position", arg2);
                bundle.putInt("spinnerPos",poss);
                Intent i = new Intent(VeriSec.this, MyActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }

    // Create an Adapter Class extending the BaseAdapter
    class VersionAdapter extends BaseAdapter {

        private LayoutInflater layoutInflater;

        public VersionAdapter(VeriSec activity) {
            // TODO Auto-generated constructor stub
            layoutInflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            int uzunluk=0;
            if (poss==0){
                uzunluk=hastalikli.length;
            }else{
                uzunluk=saglikli.length;
            }
            return uzunluk;
        }

        @Override
        public Object getItem(int position) {
// TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
// TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View listItem = convertView;
            int pos = position;
            if (listItem == null) {
                listItem = layoutInflater.inflate(R.layout.list_item, null);
            }

            ImageView iv = (ImageView) listItem.findViewById(R.id.thumb);
            TextView tvTitle = (TextView) listItem.findViewById(R.id.title);
            TextView tvDesc = (TextView) listItem.findViewById(R.id.desc);

            if (poss==0){
                iv.setBackgroundResource(iconeksi);
                tvTitle.setText(hastalikli[pos]);
                tvDesc.setText(mitdb);
            }else {
                iv.setBackgroundResource(iconarti);
                tvTitle.setText(saglikli[pos]);
                tvDesc.setText(nsrdb);
            }


            return listItem;
        }

    }

}
