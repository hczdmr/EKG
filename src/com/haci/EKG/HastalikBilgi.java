package com.haci.EKG;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

/**
 * Created by HaciOzdemir on 24/12/14.
 */
public class HastalikBilgi extends Activity {
    Spinner spin;
    ImageView image;
    TextView aciklama;
    private static String[] spinnerValues = new String[]{"Weka Nedir?","Sinüs Taşikardisi","Sağ Dal Bloğu (RBBB)", "Atriyal Fibrilasyon", "Sol Anterior Fasiküler Blok (LAFB)"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hastalikbilgi);

        image=(ImageView) findViewById(R.id.resim);
        aciklama=(TextView) findViewById(R.id.aciklama);
        aciklama.setTextColor(Color.WHITE);
        spin=(Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> arrayadapter=new ArrayAdapter<String>(this,R.layout.spinner,spinnerValues);
        arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(arrayadapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    image.setImageResource(R.drawable.weka);
                    aciklama.setText(
                                    "\t\tWEKA , Yeni Zelanda Waikato Üniversitesi’nde geliştirilen bir veri madenciliği\n" +
                                    "\t\tve makine öğrenmesi yazılımı olup  Java programlama dili ile geliştirilmiştir.\n" +
                                    "\t\tWEKA,  birçok sınıflandırma tekniğini içermektedir.  \n" +
                                    "\t\tWEKA’da, Preprocess (önisleme), Classify (sınıflama), Cluster (kümeleme), Associate (birliktelik kuralları),\n" +
                                    "\t\t Select Attribute (nitelik seçme) ve Visualize (görsellestirme) işlemleri gerçekleştirilebilir.");

                }
                else if(position==2){
                    image.setImageResource(R.drawable.sagdalblogu);
                    aciklama.setText(
                            "\t•\tSağ dal bloğunda, depolarizasyon, septum üzerinden, sol ventrikülden sağa doğru yayıldığı için sağ ventrikülün aktivasyonu gecikir.\n" +
                            "\t•\tSol ventrikül normal olarak aktive olur, böylelikle QRS kompleksinin ilk kısmı değişmez.\n" +
                            "\t•\tGecikmiş sağ ventrikül aktivasyonu sağ prekordiyal derivasyonlarda (V1-3) ikinci bir R dalgası (R’) ve lateral derivasyonlarda geniş, uzamış S dalgası meydana getirir.\n" +
                            "\t•\tSağ ventrikülün gecikmiş aktivasyonu ayrıca sağ prekordiyal derivasyonlarda ST depresyonu ve T dalga inversiyonu ile birlikte ikincil repolarizasyon anormalliklerine de yol açar.\n" +
                            "\t•\tİzole sağ dal bloğunda sol ventriküler aktivasyon sol dal demeti üzerinden ilerlerdiğinden, kardiyak aks değişmez.");

                }else if (position==1){
                    image.setImageResource(R.drawable.sinustasikardisi);
                    aciklama.setText(
                            "SEBEPLER:                                                                                  \n" +
                            "\uF076 Fizyolojik: çocuklar,efor, emosyonel vs.\n" +
                            "\uF076 Farmakolojik: Atropin,epinefrin ve diğer\n" +
                            "\uF076 Patolojik: Ateş, hipoksi,hipovolemi,\n" +
                            "\n" +
                            "TEDAVİ:                                                                                    \n" +
                            "\uF076 Çoğunlukla tedavi gerektirmez\n" +
                            "\uF076 Altta yatan nedenin tedavisi;\n" +
                            "Hidrasyon\n" +
                            "Yeterli ağrı tedavisi\n" +
                            "Ateş kontrolü vs.\n" +
                            "\uF076 MI’a eşlik eden uygunsuz taşikardide ß bloker");
                }else if(position==3){
                    image.setImageResource(R.drawable.atrialfibrilasyon);
                    aciklama.setText(
                            "\t•\tDüzensiz ritim.\n" +
                            "\t•\tP dalgası yoktur.\n" +
                            "\t•\tİzoelektrik hat yokluğu.\n" +
                            "\t•\tDeğişken ventriküler hız.\n" +
                            "\t•\tÖnceden var olan dal bloğu, aksesuar yolak ya da hız ilişkili aberran iletim yoksa, QRS kompleksleri genellikle < 120 ms’dir.\n" +
                            "\t•\tFibrilasyon dalgaları ufak (amplitüd <0.5 mm) ya da iri (amplitüd > 0.5 mm) olabilir.\n" +
                            "\t•\tFibrilasyon dalgaları P dalgaları gibi görünüp yanlış tanıya neden olabilir.");
                }
                else if(position==4){
                    image.setImageResource(R.drawable.solanterierfasikuler);
                    aciklama.setText(
                            "\t•\tSol anterior fasiküler blokta (sol anterior hemiblok olarak da bilinir) impulslar, sol ventriküle sol ventrikülün endokardiyal yüzeyi boyunca inferoseptal duvarına eklenen sol posterior fasikül ile iletilir.\n" +
                            "\t•\tDepolarizasyonun büyük olan dalgası yukarı ve sol doğrultuda yayılarak sol taraf derivasyonlarında geniş pozitif voltajlar (uzun R dalgaları) ve inferior derivasyonlarda (derin S dalgaları) geniş negatif dalgalar oluşturur.\n" +
                            "\t•\tBu süreç her iki fasikül aracılığı ile olan spontan iletimden yaklaşık 20 ms daha uzun sürerek QRS’te hafif bir genişlemeyle sonuçlanır.\n" +
                            "\t•\tİmpuls sol taraf derivasyonlarına normalden daha geç ulaşarak aVL’de artmış R dalga pik süresi ile sonuçlanır (QRS başlangıcından R dalga pikine kadar geçen süre).");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}