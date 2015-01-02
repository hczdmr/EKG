package com.haci.EKG;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.LineChart;
import org.achartengine.chart.PointStyle;
import org.achartengine.chart.ScatterChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyActivity extends Activity {

    private GraphicalView gv;
    private GraphicalView gv2;

    Float[] benzerlikOrani = new Float[32];

    InputStream is;

    InputStream is1;
    InputStream is2;
    InputStream is3;
    InputStream is4;
    InputStream is5;
    InputStream is6;
    InputStream is7;
    InputStream is8;
    InputStream is9;
    InputStream is10;
    InputStream is11;
    InputStream is12;
    InputStream is13;
    InputStream is14;
    InputStream is15;
    InputStream is16;
    InputStream is17;
    InputStream is18;
    InputStream is19;
    InputStream is20;
    InputStream is21;
    InputStream is22;
    InputStream is23;
    InputStream is24;
    InputStream is25;
    InputStream is26;
    InputStream is27;
    InputStream is28;
    InputStream is29;
    InputStream is30;
    InputStream is31;


    TextView hastalikAdiiii;
    private String diseaseText;
    private String bilgi;

    TextView heartbeat;
    TextView heartrate;
    TextView rr;
    TextView samplesayisi;

    Button knnsinif;
    Button RRsinif;

    private ArrayList<Float> rrIntervalSaniye;
    private ArrayList<Float> rrIntervalSaniye2;
    private ArrayList<String> hastalikAdi;


    //Dosyadan okunacak data gelecek.
    private ArrayList<Float> dataArray;
    private ArrayList<String> dataArray2;

    private ArrayList<Float> data1;
    private ArrayList<Float> data2;
    private ArrayList<Float> data3;
    private ArrayList<Float> data4;
    private ArrayList<Float> data5;
    private ArrayList<Float> data6;
    private ArrayList<Float> data7;
    private ArrayList<Float> data8;
    private ArrayList<Float> data9;
    private ArrayList<Float> data10;
    private ArrayList<Float> data11;
    private ArrayList<Float> data12;
    private ArrayList<Float> data13;
    private ArrayList<Float> data14;
    private ArrayList<Float> data15;
    private ArrayList<Float> data16;
    private ArrayList<Float> data17;
    private ArrayList<Float> data18;
    private ArrayList<Float> data19;
    private ArrayList<Float> data20;
    private ArrayList<Float> data21;
    private ArrayList<Float> data22;
    private ArrayList<Float> data23;
    private ArrayList<Float> data24;
    private ArrayList<Float> data25;
    private ArrayList<Float> data26;
    private ArrayList<Float> data27;
    private ArrayList<Float> data28;
    private ArrayList<Float> data29;
    private ArrayList<Float> data30;
    private ArrayList<Float> data31;


    //zamani tutacak array
    private ArrayList<Float> zamanArray;
    private ArrayList<Float> zamanArray2;

    //ekg tutacak array
    private ArrayList<Float> ekgArray;
    private ArrayList<Float> ekgArray2;

    private ArrayList<Float> dosyadakidegerler;

    ArrayList<Integer> qrslocation;
    ArrayList<Float> qrsdegeri;

    ArrayList<Integer> qrslocation2;
    ArrayList<Float> qrsdegeri2;

    float kalpHizi=0;
    float kalpHizi2=0;
    float rrOrtalama=0;
    float rrOrtalama2=0;
    int position;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Bundle bundle=getIntent().getExtras();
        position=bundle.getInt("position");
        int spinnerPos=bundle.getInt("spinnerPos");

        ArrayList<InputStream> arrayinputstream=new ArrayList<InputStream>();
        ArrayList<InputStream> arrayinputstream2=new ArrayList<InputStream>();
        if (spinnerPos==0){
            arrayinputstream.add(getResources().openRawResource(R.raw.comb1));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb2));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb3));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb4));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb5));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb6));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb7));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb8));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb9));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb11));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb12));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb13));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb14));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb15));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb16));

            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_100));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_101));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_102));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_103));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_104));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_105));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_106));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_108));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_109));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_111));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_112));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_113));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_114));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_115));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_116));
        }else{
            arrayinputstream.add(getResources().openRawResource(R.raw.comb17));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb18));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb19));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb20));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb21));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb22));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb23));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb24));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb25));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb26));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb27));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb28));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb29));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb30));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb31));
            arrayinputstream.add(getResources().openRawResource(R.raw.comb32));

            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_16265));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_16272));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_16273));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_16420));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_16483));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_16539));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_16773));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_16786));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_16795));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_17052));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_17453));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_18177));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_18184));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_19088));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_19090));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_19093));
            arrayinputstream2.add(getResources().openRawResource(R.raw.samples_19830));
        }

        dataArray=new ArrayList<Float>();
        dataArray2=new ArrayList<String>();
        dosyadakidegerler=new ArrayList<Float>();

        String str="";
        StringBuffer buf = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(arrayinputstream.get(position)));
        try {
            int count=0;
            while ((str = reader.readLine()) != null) {
                count++;
                if (count<5) {
                    dosyadakidegerler.add(Float.parseFloat(str));
                } else if (count>4) {
                    dataArray.add(Float.parseFloat(str));
                    //buf.append(str + "\n" );
                }
            }
          //  System.out.println(dosyadakidegerler.get(0));
          //  System.out.println(dosyadakidegerler.get(1));
          //  System.out.println(dosyadakidegerler.get(2));
          //  System.out.println(dosyadakidegerler.get(3));
        }
        catch (IOException e) {
            e.printStackTrace();
        }



        String str2="";
        try{
            BufferedReader reader2=new BufferedReader(new InputStreamReader(arrayinputstream2.get(position)));
            String line2="";
            int count2=0;
            while ((str2=reader2.readLine())!=null){
                str2+=line2+"\n";
                count2++;
                if (count2>2){
                    String[] tokensa2 = str2.split("\t");
                    int sayacım=0;
                    for (String t2 : tokensa2){
                        sayacım++;
                        if(sayacım%2==0){
                            dataArray2.add(t2);
                        }
                    }
                }
            }
            reader2.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }



       zamanArray = new ArrayList<Float>();
        ekgArray = new ArrayList<Float>();


        for(int i=0; i<dataArray.size(); i++){
            zamanArray.add((float)(i));
            ekgArray.add(dataArray.get(i));
        }
        /*

        //QRS bulan kod
        float qrsThr = (float) 0.4;
        int qrsCnt = 0;
        qrslocation = new ArrayList<Integer>();
        qrsdegeri=new ArrayList<Float>();
        for(int i=1; i<dataArray.size()-1; i++){

            if(ekgArray.get(i) > qrsThr && ekgArray.get(i) > ekgArray.get(i-1) && ekgArray.get(i) > ekgArray.get(i+1)){
                qrsCnt++;
                qrslocation.add((Integer) i);
                qrsdegeri.add(ekgArray.get(i));
                i+=50;
            }
        }




        //RR interval degerlerinin bulunması.
        int rrToplam=0;

        ArrayList<Integer> rrinterval=new ArrayList<Integer>();
        if (qrslocation.size()>1){
            for (int i=0;i<qrslocation.size()-1;i++){
                rrinterval.add((Integer)qrslocation.get(i+1)-qrslocation.get(i));
                rrToplam+=((Integer)qrslocation.get(i+1)-qrslocation.get(i));
            }
            rrOrtalama=rrToplam/rrinterval.size();
        }

        //phsiyonette dataların kac sample içerdiğini header dosyalarından aldım.
        int[] olcumdata = {11730944,11520000,11354112,11051008,11960320,113274488,11046912,11284480,
                10866688,10659840,11235328,11960320,10942464,10967040,11143168};
        //Hız hesaplamalarının yapılması MİTDB İÇİN
        rrIntervalSaniye=new ArrayList<Float>();

        int rsayisi=0;
        float olcumsaati=0;
        if (rrinterval.size()>1){
            if (spinnerPos==0){
                olcumsaati=(float)650000/(360*3600);
                float saniye=(float)(Float.valueOf(qrslocation.get(0))/360.0);
                for (int i=0;i<rrinterval.size();i++){
                    float k=(float)(Float.valueOf(rrinterval.get(i))/360.0);
                    rrIntervalSaniye.add(k);
                    if (saniye<6){
                        saniye+=k;
                        rsayisi=i+1;
                    }
                }
                kalpHizi=(float)rsayisi*10;
            }else if(spinnerPos==1){//Hız hesaplamalarının yapılması NSRDB İÇİN
                olcumsaati=olcumdata[position]/(128*3600);
                float saniye=(float)(Float.valueOf(qrslocation.get(0))/128.0);
                for (int i=0;i<rrinterval.size();i++){
                    float k=(float)(Float.valueOf(rrinterval.get(i))/128.0);
                    rrIntervalSaniye.add(k);
                    if (saniye<6){
                        saniye+=k;
                        rsayisi=i+1;
                    }
                }
                kalpHizi=(float)rsayisi*10;
            }
        }
*/

        //sinyalin time ve ecg array olarak ayrılması
        zamanArray2 = new ArrayList<Float>();
        ekgArray2 = new ArrayList<Float>();

        //Dataarray ecgarraye atılıyor ve her array
        // için time degeri oluşturulup o da timearraye atılıyor.
        for(int i=0; i<dataArray2.size(); i++){
            // if(i%2==0){
            zamanArray2.add((float)(i));
            // }
            // else{
            ekgArray2.add(Float.parseFloat(dataArray2.get(i)));
            // }
        }

        //QRS bulan kod

        float qrsThr2 = (float) 0.4;
        int qrsCnt2 = 0;
        qrslocation2 = new ArrayList<Integer>();
        qrsdegeri2=new ArrayList<Float>();
        for(int i=1; i<dataArray2.size()-1; i++){

            if(ekgArray2.get(i) > qrsThr2 && ekgArray2.get(i) > ekgArray2.get(i-1) && ekgArray2.get(i) > ekgArray2.get(i+1)){
                qrsCnt2++;
                qrslocation2.add((Integer) i);
                qrsdegeri2.add(ekgArray2.get(i));
                i+=50;
            }
        }

//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

        // setContentView(hastalik);



        //RR interval degerlerinin bulunması.
        int rrToplam2=0;

        ArrayList<Integer> rrinterval2=new ArrayList<Integer>();
        if (qrslocation2.size()>1){
            for (int i=0;i<qrslocation2.size()-1;i++){
                rrinterval2.add((Integer)qrslocation2.get(i+1)-qrslocation2.get(i));
                rrToplam2+=((Integer)qrslocation2.get(i+1)-qrslocation2.get(i));
            }
            rrOrtalama2=rrToplam2/rrinterval2.size();
        }

        //phsiyonette dataların kac sample içerdiğini header dosyalarından aldım.
        int[] olcumdata2 = {11730944,11520000,11354112,11051008,11960320,113274488,11046912,11284480,
                10866688,10659840,11235328,11960320,10942464,10967040,11143168};
        //Hız hesaplamalarının yapılması MİTDB İÇİN
        rrIntervalSaniye2=new ArrayList<Float>();

        int rsayisi2=0;
        float olcumsaati2=0;
        if (rrinterval2.size()>1){
            if (spinnerPos==0){
                olcumsaati2=(float)650000/(360*3600);
                float saniye2=(float)(Float.valueOf(qrslocation2.get(0))/360.0);
                for (int i=0;i<rrinterval2.size();i++){
                    float k2=(float)(Float.valueOf(rrinterval2.get(i))/360.0);
                    rrIntervalSaniye2.add(k2);
                    if (saniye2<6){
                        saniye2+=k2;
                        rsayisi2=i+1;
                    }
                }
                kalpHizi2=(float)rsayisi2*10;
            }else if(spinnerPos==1){//Hız hesaplamalarının yapılması NSRDB İÇİN
                olcumsaati2=olcumdata2[position]/(128*3600);
                float saniye2=(float)(Float.valueOf(qrslocation2.get(0))/128.0);
                for (int i=0;i<rrinterval2.size();i++){
                    float k2=(float)(Float.valueOf(rrinterval2.get(i))/128.0);
                    rrIntervalSaniye2.add(k2);
                    if (saniye2<6){
                        saniye2+=k2;
                        rsayisi2=i+1;
                    }
                }
                kalpHizi2=(float)rsayisi2*10;
            }
        }

        //rrinterval değeri varsa eğer algoritmalar gerçekleştirlek :)
        if(rrIntervalSaniye2.size()>0){
            int rrtabanlisiniflandirma=RRTabanliSiniflandirma.siniflandir(rrIntervalSaniye2);
            String hastalikName="";
            if(rrtabanlisiniflandirma==2){
                hastalikName="Atrial, Nodal and supraventriculer premature 2-beats";
            }else if(rrtabanlisiniflandirma==3){
                hastalikName="Ventriculer premature 3-beat";
            }else if(rrtabanlisiniflandirma==4){
                hastalikName="Escape 4-Beats";
            }else if(rrtabanlisiniflandirma==5){
                hastalikName="Ventriculer Flutter-Fibrilattion 5-Beats";
            }else{
                hastalikName="Normal 1-Beat";
            }
            if(hastalikName=="Normal 1-Beat"){
                bilgi=hastalikName + " hastalık belirtisine rastlanmadı.";
            }else {
                bilgi = hastalikName + " hastalığına sahipsiniz!";
            }
            RRsinif=(Button)findViewById(R.id.RRSiniflandirma);
        }

        RRsinif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hastalikAdiiii.setTextColor(Color.parseColor("#a4c639"));
                hastalikAdiiii.setText(bilgi);
            }
        });



        hastalikAdi=HastalikTespit.hastalikBul(dosyadakidegerler.get(0));//heart beat gonderdik.
        if(hastalikAdi.size()==1){
            if (hastalikAdi.get(0)=="Normal Sinüs Ritmi"){
                diseaseText = hastalikAdi.get(0) + " herhangi bir hastalık belirtisine rastlanmadı!";
            }else {
                diseaseText = hastalikAdi.get(0) + " hastalığına sahipsiniz!";
            }
        }
        else{
            diseaseText = "Şu hastalıklara sahipsiniz:\n";
            for(int i=0; i<hastalikAdi.size(); i++){
                diseaseText += hastalikAdi.get(i)+"\n";
            }
        }

        hastalikAdiiii = (TextView)findViewById(R.id.hastalikad);
        hastalikAdiiii.setText(diseaseText);


        String hb=String.valueOf(dosyadakidegerler.get(0)); //qrs complex sayisi
        String hr=String.valueOf(dosyadakidegerler.get(1));
        String x=String.valueOf(dosyadakidegerler.get(2));
        String y=String.valueOf(dataArray.size());
        String z=String.valueOf(dosyadakidegerler.get(3));

        heartbeat=(TextView) findViewById(R.id.heartbeat);
        heartrate=(TextView) findViewById(R.id.heartrate);
        rr=(TextView) findViewById(R.id.rr);
        samplesayisi=(TextView) findViewById(R.id.samplesayisi);

        heartbeat.setText("Heart Beats[#]: "+hb);
        heartrate.setText("Heart Rate[bpm]: "+hr);
        rr.setText("RR[ms] Ortalama: "+x);
        samplesayisi.setText("Sample Sayısı: "+y);


        //System.out.println(zamanArray.size());
        //System.out.println(ekgArray.size());

        // qrsSay=(TextView) findViewById(R.id.qrsSayac);
        //qrsSay.setText(qrsSayisi+" tane QRS Komplexi Bulunmaktadir.");
        chartCizdir();
        knnsinif=(Button) findViewById(R.id.knn);
        knnsinif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 knnSiniflandirma();
            }
        });
       // knnSiniflandirma();
    }

    private void chartCizdir() {
        //cizdirilecek nesne
        XYSeries ekgSeries = new XYSeries("EKG");
        XYSeries ekgSeries2=new XYSeries("EKG2");
        //cizdirilecek nesne
        //XYSeries rPeakSeries=new XYSeries("R Peak");

        for (int i = 0; i < dataArray.size() - 1; i++) {
            ekgSeries.add(i, ekgArray.get(i));
        }

        for(int i=0; i< dataArray2.size()-1;i++){
            ekgSeries2.add(i,ekgArray2.get(i));
        }

        //for (int i=0; i<qrslocation.size()-1;i++){
        //    rPeakSeries.add(qrslocation.get(i),qrsdegeri.get(i));
        //}
        //cizdirilecek nesneleri tutan dataset
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        dataset.addSeries(ekgSeries);
        XYMultipleSeriesDataset dataset2=new XYMultipleSeriesDataset();
        dataset2.addSeries(ekgSeries2);

        //dataset.addSeries(rPeakSeries);

        //ekgSeries nesnesinin cizimini customize et.
        XYSeriesRenderer ekgrenderer = new XYSeriesRenderer();
        ekgrenderer.setColor(Color.BLUE);
        ekgrenderer.setPointStyle(PointStyle.POINT);
        ekgrenderer.setFillPoints(true);
        ekgrenderer.setLineWidth(2);
        ekgrenderer.setDisplayChartValues(false);

        XYSeriesRenderer ekgrenderer2=new XYSeriesRenderer();
        ekgrenderer2.setColor(Color.BLUE);
        ekgrenderer2.setPointStyle(PointStyle.POINT);
        ekgrenderer2.setFillPoints(true);
        ekgrenderer2.setLineWidth(2);
        ekgrenderer2.setDisplayChartValues(false);

        //rPeakSeries nesnesinin cizimini customize et.
        //XYSeriesRenderer rPeakRenderer=new XYSeriesRenderer();
        //rPeakRenderer.setColor(Color.RED);
        //rPeakRenderer.setPointStyle(PointStyle.CIRCLE);
        //rPeakRenderer.setFillPoints(true);
        //rPeakRenderer.setLineWidth(2);
        //rPeakRenderer.setDisplayChartValues(false);

        //Tum chart'i customize et.
        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
        multiRenderer.setXLabels(0);
        multiRenderer.setChartTitle("EKG Filtrelenmiş Sinyal LineChart");
        multiRenderer.setXTitle("Zaman");
        multiRenderer.setYTitle("Ölçüm Değeri");
        multiRenderer.setZoomButtonsVisible(true);
        multiRenderer.setBarSpacing(4);
       // multiRenderer.setPointSize(15);
       // multiRenderer.setXAxisMin(0);
       // multiRenderer.setXAxisMax(700);
        multiRenderer.setChartTitleTextSize(30);//EKG Sinyal LINECHART
        multiRenderer.setAxisTitleTextSize(20);//zaman ve olcum degeri
       // multiRenderer.setLabelsTextSize(20);//sayilar
        multiRenderer.setLegendTextSize(20);//EKG ve R Peak gosterimlerini

        //Tum chart'i customize et.
        XYMultipleSeriesRenderer multiRenderer2 = new XYMultipleSeriesRenderer();
        multiRenderer2.setXLabels(0);
        multiRenderer2.setChartTitle("EKG Filtrelenmemiş Sinyal LineChart");
        multiRenderer2.setXTitle("Zaman");
        multiRenderer2.setYTitle("Ölçüm Değeri");
        multiRenderer2.setZoomButtonsVisible(true);
        multiRenderer2.setBarSpacing(4);
        // multiRenderer2.setPointSize(15);
        // multiRenderer2.setXAxisMin(0);
        // multiRenderer2.setXAxisMax(700);
        multiRenderer2.setChartTitleTextSize(30);//EKG Sinyal LINECHART
        multiRenderer2.setAxisTitleTextSize(20);//zaman ve olcum degeri
        // multiRenderer2.setLabelsTextSize(20);//sayilar
        multiRenderer2.setLegendTextSize(20);//EKG ve R Peak gosterimlerini


        //x degerlerini yazdirdik.
        for (int i = 0; i < zamanArray.size(); i++) {
            multiRenderer.addXTextLabel(i, Integer.toString(i));
            i += 49;
        }

        //x degerlerini yazdirdik.
        for (int i = 0; i < zamanArray2.size(); i++) {
            multiRenderer2.addXTextLabel(i, Integer.toString(i));
            i += 49;
        }

        //iki rendereri da multi renderira ekledik
        //dataSeries i datasete renderer i da multi renderer a ekleme sirasi ayni olmali.
        multiRenderer.addSeriesRenderer(ekgrenderer);
        multiRenderer2.addSeriesRenderer(ekgrenderer2);
       // multiRenderer.addSeriesRenderer(rPeakRenderer);

        RelativeLayout chartGoster = (RelativeLayout) findViewById(R.id.lineChart);
        RelativeLayout chartGoster2=(RelativeLayout) findViewById(R.id.lineChart2);


        // Grafikte cizilecek olan chart tiplerini belirliyoruz.
        // DataSeries ve chart tip sayisi ayni olmali. Siralari da ayni olmali.
        String[] chartTipleri = new String[]{LineChart.TYPE};
        String[] chartTipleri2=new String[]{LineChart.TYPE};

        //Array icindeki chartTipleri ile bir combinedchart yarattik.
        gv = (GraphicalView) ChartFactory.getCombinedXYChartView(getBaseContext(), dataset, multiRenderer, chartTipleri);
        gv2=(GraphicalView) ChartFactory.getCombinedXYChartView(getBaseContext(),dataset2,multiRenderer2,chartTipleri2);
        //Relative layout u combined chart a ekledik.
        chartGoster.addView(gv);
        chartGoster2.addView(gv2);
    }

     private void knnSiniflandirma(){
         String satir1="";
         String satir2="";
         String satir3="";
         String satir4="";
         String satir5="";
         String satir6="";
         String satir7="";
         String satir8="";
         String satir9="";
         String satir10="";
         String satir11="";
         String satir12="";
         String satir13="";
         String satir14="";
         String satir15="";
         String satir16="";
         String satir17="";
         String satir18="";
         String satir19="";
         String satir20="";
         String satir21="";
         String satir22="";
         String satir23="";
         String satir24="";
         String satir25="";
         String satir26="";
         String satir27="";
         String satir28="";
         String satir29="";
         String satir30="";
         String satir31="";


         StringBuffer buf1=new StringBuffer();
         StringBuffer buf2=new StringBuffer();
         StringBuffer buf3=new StringBuffer();
         StringBuffer buf4=new StringBuffer();
         StringBuffer buf5=new StringBuffer();
         StringBuffer buf6=new StringBuffer();
         StringBuffer buf7=new StringBuffer();
         StringBuffer buf8=new StringBuffer();
         StringBuffer buf9=new StringBuffer();
         StringBuffer buf10=new StringBuffer();
         StringBuffer buf11=new StringBuffer();
         StringBuffer buf12=new StringBuffer();
         StringBuffer buf13=new StringBuffer();
         StringBuffer buf14=new StringBuffer();
         StringBuffer buf15=new StringBuffer();
         StringBuffer buf16=new StringBuffer();
         StringBuffer buf17=new StringBuffer();
         StringBuffer buf18=new StringBuffer();
         StringBuffer buf19=new StringBuffer();
         StringBuffer buf20=new StringBuffer();
         StringBuffer buf21=new StringBuffer();
         StringBuffer buf22=new StringBuffer();
         StringBuffer buf23=new StringBuffer();
         StringBuffer buf24=new StringBuffer();
         StringBuffer buf25=new StringBuffer();
         StringBuffer buf26=new StringBuffer();
         StringBuffer buf27=new StringBuffer();
         StringBuffer buf28=new StringBuffer();
         StringBuffer buf29=new StringBuffer();
         StringBuffer buf30=new StringBuffer();
         StringBuffer buf31=new StringBuffer();

         data1=new ArrayList<Float>();
         data2=new ArrayList<Float>();
         data3=new ArrayList<Float>();
         data4=new ArrayList<Float>();
         data5=new ArrayList<Float>();
         data6=new ArrayList<Float>();
         data7=new ArrayList<Float>();
         data8=new ArrayList<Float>();
         data9=new ArrayList<Float>();
         data10=new ArrayList<Float>();
         data11=new ArrayList<Float>();
         data12=new ArrayList<Float>();
         data13=new ArrayList<Float>();
         data14=new ArrayList<Float>();
         data15=new ArrayList<Float>();
         data16=new ArrayList<Float>();
         data17=new ArrayList<Float>();
         data18=new ArrayList<Float>();
         data19=new ArrayList<Float>();
         data20=new ArrayList<Float>();
         data21=new ArrayList<Float>();
         data22=new ArrayList<Float>();
         data23=new ArrayList<Float>();
         data24=new ArrayList<Float>();
         data25=new ArrayList<Float>();
         data26=new ArrayList<Float>();
         data27=new ArrayList<Float>();
         data28=new ArrayList<Float>();
         data29=new ArrayList<Float>();
         data30=new ArrayList<Float>();
         data31=new ArrayList<Float>();


         is1=getResources().openRawResource(R.raw.comb1);
         is2=getResources().openRawResource(R.raw.comb2);
         is3=getResources().openRawResource(R.raw.comb3);
         is4=getResources().openRawResource(R.raw.comb4);
         is5=getResources().openRawResource(R.raw.comb5);
         is6=getResources().openRawResource(R.raw.comb6);
         is7=getResources().openRawResource(R.raw.comb7);
         is8=getResources().openRawResource(R.raw.comb8);
         is9=getResources().openRawResource(R.raw.comb9);
         is10=getResources().openRawResource(R.raw.comb11);
         is11=getResources().openRawResource(R.raw.comb12);
         is12=getResources().openRawResource(R.raw.comb13);
         is13=getResources().openRawResource(R.raw.comb14);
         is14=getResources().openRawResource(R.raw.comb15);
         is15=getResources().openRawResource(R.raw.comb16);
         is16=getResources().openRawResource(R.raw.comb17);
         is17=getResources().openRawResource(R.raw.comb18);
         is18=getResources().openRawResource(R.raw.comb19);
         is19=getResources().openRawResource(R.raw.comb20);
         is20=getResources().openRawResource(R.raw.comb21);
         is21=getResources().openRawResource(R.raw.comb22);
         is22=getResources().openRawResource(R.raw.comb23);
         is23=getResources().openRawResource(R.raw.comb24);
         is24=getResources().openRawResource(R.raw.comb25);
         is25=getResources().openRawResource(R.raw.comb26);
         is26=getResources().openRawResource(R.raw.comb27);
         is27=getResources().openRawResource(R.raw.comb28);
         is28=getResources().openRawResource(R.raw.comb29);
         is29=getResources().openRawResource(R.raw.comb30);
         is30=getResources().openRawResource(R.raw.comb31);
         is31=getResources().openRawResource(R.raw.comb32);


         BufferedReader bufread1=new BufferedReader(new InputStreamReader(is1));
         BufferedReader bufread2=new BufferedReader(new InputStreamReader(is2));
         BufferedReader bufread3=new BufferedReader(new InputStreamReader(is3));
         BufferedReader bufread4=new BufferedReader(new InputStreamReader(is4));
         BufferedReader bufread5=new BufferedReader(new InputStreamReader(is5));
         BufferedReader bufread6=new BufferedReader(new InputStreamReader(is6));
         BufferedReader bufread7=new BufferedReader(new InputStreamReader(is7));
         BufferedReader bufread8=new BufferedReader(new InputStreamReader(is8));
         BufferedReader bufread9=new BufferedReader(new InputStreamReader(is9));
         BufferedReader bufread10=new BufferedReader(new InputStreamReader(is10));
         BufferedReader bufread11=new BufferedReader(new InputStreamReader(is11));
         BufferedReader bufread12=new BufferedReader(new InputStreamReader(is12));
         BufferedReader bufread13=new BufferedReader(new InputStreamReader(is13));
         BufferedReader bufread14=new BufferedReader(new InputStreamReader(is14));
         BufferedReader bufread15=new BufferedReader(new InputStreamReader(is15));
         BufferedReader bufread16=new BufferedReader(new InputStreamReader(is16));
         BufferedReader bufread17=new BufferedReader(new InputStreamReader(is17));
         BufferedReader bufread18=new BufferedReader(new InputStreamReader(is18));
         BufferedReader bufread19=new BufferedReader(new InputStreamReader(is19));
         BufferedReader bufread20=new BufferedReader(new InputStreamReader(is20));
         BufferedReader bufread21=new BufferedReader(new InputStreamReader(is21));
         BufferedReader bufread22=new BufferedReader(new InputStreamReader(is22));
         BufferedReader bufread23=new BufferedReader(new InputStreamReader(is23));
         BufferedReader bufread24=new BufferedReader(new InputStreamReader(is24));
         BufferedReader bufread25=new BufferedReader(new InputStreamReader(is25));
         BufferedReader bufread26=new BufferedReader(new InputStreamReader(is26));
         BufferedReader bufread27=new BufferedReader(new InputStreamReader(is27));
         BufferedReader bufread28=new BufferedReader(new InputStreamReader(is28));
         BufferedReader bufread29=new BufferedReader(new InputStreamReader(is29));
         BufferedReader bufread30=new BufferedReader(new InputStreamReader(is30));
         BufferedReader bufread31=new BufferedReader(new InputStreamReader(is31));


        try {
            int count=0;
            while ((satir1=bufread1.readLine())!=null && (satir2=bufread2.readLine())!=null && (satir3=bufread3.readLine())!=null && (satir4=bufread4.readLine())!=null && (satir5=bufread5.readLine())!=null && (satir6=bufread6.readLine())!=null && (satir7=bufread7.readLine())!=null && (satir8=bufread8.readLine())!=null && (satir9=bufread9.readLine())!=null && (satir10=bufread10.readLine())!=null && (satir11=bufread11.readLine())!=null && (satir12=bufread12.readLine())!=null && (satir13=bufread13.readLine())!=null && (satir14=bufread14.readLine())!=null && (satir15=bufread15.readLine())!=null && (satir16=bufread16.readLine())!=null && (satir17=bufread17.readLine())!=null && (satir18=bufread18.readLine())!=null && (satir19=bufread19.readLine())!=null && (satir20=bufread20.readLine())!=null && (satir21=bufread21.readLine())!=null && (satir22=bufread22.readLine())!=null && (satir23=bufread23.readLine())!=null && (satir24=bufread24.readLine())!=null && (satir25=bufread25.readLine())!=null && (satir26=bufread26.readLine())!=null && (satir27=bufread27.readLine())!=null && (satir28=bufread28.readLine())!=null && (satir29=bufread29.readLine())!=null && (satir30=bufread30.readLine())!=null && (satir31=bufread31.readLine())!=null){
                count++;
                 if (count>4) {
                    data1.add(Float.parseFloat(satir1));
                   // buf1.append(satir1 + "\n");
                    data2.add(Float.parseFloat(satir2));
                   // buf2.append(satir2 + "\n");
                    data3.add(Float.parseFloat(satir3));
                   // buf3.append(satir3 + "\n");
                    data4.add(Float.parseFloat(satir4));
                   // buf4.append(satir4 + "\n");
                    data5.add(Float.parseFloat(satir5));
                   // buf5.append(satir5 + "\n");
                    data6.add(Float.parseFloat(satir6));
                   // buf6.append(satir6 + "\n");
                    data7.add(Float.parseFloat(satir7));
                   // buf7.append(satir7 + "\n");
                    data8.add(Float.parseFloat(satir8));
                   // buf8.append(satir8 + "\n");
                    data9.add(Float.parseFloat(satir9));
                   // buf9.append(satir9 + "\n");
                    data10.add(Float.parseFloat(satir10));
                   // buf10.append(satir10 + "\n");
                    data11.add(Float.parseFloat(satir11));
                   // buf11.append(satir11 + "\n");
                    data12.add(Float.parseFloat(satir12));
                  //  buf12.append(satir12 + "\n");
                    data13.add(Float.parseFloat(satir13));
                   // buf13.append(satir13 + "\n");
                    data14.add(Float.parseFloat(satir14));
                   // buf14.append(satir14 + "\n");
                    data15.add(Float.parseFloat(satir15));
                   // buf15.append(satir15 + "\n");
                    data16.add(Float.parseFloat(satir16));
                   // buf16.append(satir16 + "\n");
                    data17.add(Float.parseFloat(satir17));
                   // buf17.append(satir17 + "\n");
                    data18.add(Float.parseFloat(satir18));
                   // buf18.append(satir18 + "\n");
                    data19.add(Float.parseFloat(satir19));
                   // buf19.append(satir19 + "\n");
                    data20.add(Float.parseFloat(satir20));
                   // buf20.append(satir20 + "\n");
                    data21.add(Float.parseFloat(satir21));
                   // buf21.append(satir21 + "\n");
                    data22.add(Float.parseFloat(satir22));
                   // buf22.append(satir22 + "\n");
                    data23.add(Float.parseFloat(satir23));
                   // buf23.append(satir23 + "\n");
                    data24.add(Float.parseFloat(satir24));
                   // buf24.append(satir24 + "\n");
                    data25.add(Float.parseFloat(satir25));
                   // buf25.append(satir25 + "\n");
                    data26.add(Float.parseFloat(satir26));
                   // buf26.append(satir26 + "\n");
                    data27.add(Float.parseFloat(satir27));
                   // buf27.append(satir27 + "\n");
                    data28.add(Float.parseFloat(satir28));
                   // buf28.append(satir28 + "\n");
                    data29.add(Float.parseFloat(satir29));
                   // buf29.append(satir29 + "\n");
                    data30.add(Float.parseFloat(satir30));
                   // buf30.append(satir30 + "\n");
                    data31.add(Float.parseFloat(satir31));
                   // buf31.append(satir31 + "\n");
                }


            }
        }catch (IOException e){
            e.printStackTrace();
        }try {
             is1.close();
             is2.close();
             is3.close();
             is4.close();
             is5.close();
             is6.close();
             is7.close();
             is8.close();
             is9.close();
             is10.close();
             is11.close();
             is12.close();
             is13.close();
             is14.close();
             is15.close();
             is16.close();
             is17.close();
             is18.close();
             is19.close();
             is20.close();
             is21.close();
             is22.close();
             is23.close();
             is24.close();
             is25.close();
             is26.close();
             is27.close();
             is28.close();
             is29.close();
             is30.close();
             is31.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        float toplamust,toplamalt1,toplamalt2;
        toplamust=0;
        toplamalt1=0;
        toplamalt2=0;
        for (int i=0; i<dataArray.size(); i++) {
            toplamust +=(dataArray.get(i))*(data1.get(i));
            toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
            toplamalt2 +=(data1.get(i))*(data1.get(i));
        }
        benzerlikOrani[0]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

        toplamust=0;
        toplamalt1=0;
        toplamalt2=0;
        for (int i=0; i<dataArray.size(); i++) {
            toplamust +=(dataArray.get(i))*(data2.get(i));
            toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
            toplamalt2 +=(data2.get(i))*(data2.get(i));
        }
        benzerlikOrani[1]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

        toplamust=0;
        toplamalt1=0;
        toplamalt2=0;
        for (int i=0; i<dataArray.size(); i++) {
            toplamust +=(dataArray.get(i))*(data3.get(i));
            toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
            toplamalt2 +=(data3.get(i))*(data3.get(i));
        }
        benzerlikOrani[2]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data4.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data4.get(i))*(data4.get(i));
         }
         benzerlikOrani[3]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data5.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data5.get(i))*(data5.get(i));
         }
         benzerlikOrani[4]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data6.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data6.get(i))*(data6.get(i));
         }
         benzerlikOrani[5]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data7.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data7.get(i))*(data7.get(i));
         }
         benzerlikOrani[6]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data8.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data8.get(i))*(data8.get(i));
         }
         benzerlikOrani[7]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data9.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data9.get(i))*(data9.get(i));
         }
         benzerlikOrani[8]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data10.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data10.get(i))*(data10.get(i));
         }
         benzerlikOrani[9]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data11.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data11.get(i))*(data11.get(i));
         }
         benzerlikOrani[10]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data12.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data12.get(i))*(data12.get(i));
         }
         benzerlikOrani[11]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data13.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data13.get(i))*(data13.get(i));
         }
         benzerlikOrani[12]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data14.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data14.get(i))*(data14.get(i));
         }
         benzerlikOrani[13]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data15.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data15.get(i))*(data15.get(i));
         }
         benzerlikOrani[14]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data16.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data16.get(i))*(data16.get(i));
         }
         benzerlikOrani[15]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data17.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data17.get(i))*(data17.get(i));
         }
         benzerlikOrani[16]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data18.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data18.get(i))*(data18.get(i));
         }
         benzerlikOrani[17]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data19.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data19.get(i))*(data19.get(i));
         }
         benzerlikOrani[18]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data20.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data20.get(i))*(data20.get(i));
         }
         benzerlikOrani[19]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data21.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data21.get(i))*(data21.get(i));
         }
         benzerlikOrani[20]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data22.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data22.get(i))*(data22.get(i));
         }
         benzerlikOrani[21]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data23.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data23.get(i))*(data23.get(i));
         }
         benzerlikOrani[22]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data24.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data24.get(i))*(data24.get(i));
         }
         benzerlikOrani[23]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data25.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data25.get(i))*(data25.get(i));
         }
         benzerlikOrani[24]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data26.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data26.get(i))*(data26.get(i));
         }
         benzerlikOrani[25]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data27.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data27.get(i))*(data27.get(i));
         }
         benzerlikOrani[26]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data28.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data28.get(i))*(data28.get(i));
         }
         benzerlikOrani[27]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data29.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data29.get(i))*(data29.get(i));
         }
         benzerlikOrani[28]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data30.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data30.get(i))*(data30.get(i));
         }
         benzerlikOrani[29]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));

         toplamust=0;
         toplamalt1=0;
         toplamalt2=0;
         for (int i=0; i<dataArray.size(); i++) {
             toplamust +=(dataArray.get(i))*(data31.get(i));
             toplamalt1 +=(dataArray.get(i))*(dataArray.get(i));
             toplamalt2 +=(data31.get(i))*(data31.get(i));
         }
         benzerlikOrani[30]=toplamust / (float)(Math.sqrt(toplamalt1) * Math.sqrt(toplamalt2));


        float max = benzerlikOrani[0];
        int indexmax = 1;
        for (int i = 1; i <31; i++)
        {
            if (benzerlikOrani[i] > max)
            {
                max =benzerlikOrani[i];
                indexmax = i+1;
            }

        }
         if(indexmax<16){
             hastalikAdiiii.setTextColor(Color.RED);
             hastalikAdiiii.setText("Sınıf:HASTA. Şu hastalıklara sahip olabilirsiniz:\n Sol Dal Blok,Sağ Dal Blok,Pacet Beat");
         }
         else{
             hastalikAdiiii.setTextColor(Color.RED);
             hastalikAdiiii.setText("Sınıf:SAĞLIKLI. Turp gibisiniz maşallah :)");
         }
         //Toast.makeText(getApplicationContext(), "Veriniz " +indexmax+ ". sinifa aittir.",
         //        Toast.LENGTH_SHORT).show();
        //System.out.println("\nVeriniz " + indexmax + ". sinifa aittir\n");
        //hastalikAdi=(TextView) findViewById(R.id.hastalikad);
        //hastalikAdi.setText("Kisi"+indexmax+". siniftaki hastaliga sahiptir.");
    }

}
