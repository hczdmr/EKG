package com.haci.EKG;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;

/**
 * Created by HaciOzdemir on 23/12/14.
 */
public class Login extends Activity {
    DBAdapter dbAdapter;
    EditText kullaniciAdi;
    EditText sifre;
    Button giris;
    Button kayit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set View to register.xml
        setContentView(R.layout.login);

        kullaniciAdi= (EditText) findViewById(R.id.kullanici);
        sifre=(EditText) findViewById(R.id.sifre);
        giris=(Button) findViewById(R.id.btnLogin);
        kayit=(Button) findViewById(R.id.btnkayit);

        dbAdapter=new DBAdapter(this);
        try{
            dbAdapter.open();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(kullaniciAdi.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(sifre.getWindowToken(), 0);
                String username = kullaniciAdi.getText().toString();
                String password = sifre.getText().toString();
                if (username.length() > 0 && password.length() > 0) {
                    try {

                        if (dbAdapter.giris(username, password)) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Giriş Başarılı! Hoşgeldin "+kullaniciAdi.getText().toString(), Toast.LENGTH_SHORT);
                            LinearLayout toastLayout = (LinearLayout) toast.getView();
                            TextView toastTV = (TextView) toastLayout.getChildAt(0);
                            toastTV.setTextSize(30);
                            toast.show();
                            Intent i = new Intent(getApplicationContext(), Baslangic.class);
                            startActivity(i);
                        } else {
                            Toast toast = Toast.makeText(getApplicationContext(), "Lütfen Kullanıcı Adı veya Şifrenizi Doğru Giriniz!.", Toast.LENGTH_SHORT);
                            LinearLayout toastLayout = (LinearLayout) toast.getView();
                            TextView toastTV = (TextView) toastLayout.getChildAt(0);
                            toastTV.setTextSize(30);
                            toast.show();
                        }

                    } catch (Exception e) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Bilinmeyen Hata!.", Toast.LENGTH_SHORT);
                        LinearLayout toastLayout = (LinearLayout) toast.getView();
                        TextView toastTV = (TextView) toastLayout.getChildAt(0);
                        toastTV.setTextSize(30);
                        toast.show();

                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Lütfen Kullanıcı Adı veya Şifrenizi Boş Bırakmayınız!.", Toast.LENGTH_SHORT);
                    LinearLayout toastLayout = (LinearLayout) toast.getView();
                    TextView toastTV = (TextView) toastLayout.getChildAt(0);
                    toastTV.setTextSize(30);
                    toast.show();
                }
            }
        });

    /*    giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((kullaniciAdi.getText().toString().equals("haci") && sifre.getText().toString().equals("haci")) || (kullaniciAdi.getText().toString().equals("kasim") && sifre.getText().toString().equals("kasim")) || (kullaniciAdi.getText().toString().equals("ismail") && sifre.getText().toString().equals("ismail"))  || (kullaniciAdi.getText().toString().equals("serkan") && sifre.getText().toString().equals("serkan"))  || (kullaniciAdi.getText().toString().equals("ozge") && sifre.getText().toString().equals("ozge")) ){
                    Toast toast = Toast.makeText(getApplicationContext(), "Giriş Başarılı! Hoşgeldin "+kullaniciAdi.getText().toString(), Toast.LENGTH_SHORT);
                    LinearLayout toastLayout = (LinearLayout) toast.getView();
                    TextView toastTV = (TextView) toastLayout.getChildAt(0);
                    toastTV.setTextSize(30);
                    toast.show();
                   // Toast.makeText(getApplicationContext(), "Giriş Başarılı! Hoşgeldin "+kullaniciAdi.getText().toString(), Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), Baslangic.class);
                    startActivity(i);

                }else {
                    //Toast.makeText(getApplicationContext(),"Lütfen Kullanıcı Adı veya Şifrenizi Doğru Giriniz!.", Toast.LENGTH_LONG).show();
                    Toast toast = Toast.makeText(getApplicationContext(), "Lütfen Kullanıcı Adı veya Şifrenizi Doğru Giriniz!.", Toast.LENGTH_SHORT);
                    LinearLayout toastLayout = (LinearLayout) toast.getView();
                    TextView toastTV = (TextView) toastLayout.getChildAt(0);
                    toastTV.setTextSize(30);
                    toast.show();
                }
            }
        });
*/
        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(kullaniciAdi.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(sifre.getWindowToken(), 0);
                try {

                    String username = kullaniciAdi.getText().toString();
                    String password = sifre.getText().toString();
                    long i = dbAdapter.register(username, password);
                    if(i != -1){
                        Toast toast = Toast.makeText(getApplicationContext(), "Kayıt başarılı bir şekilde yapılmıştır.", Toast.LENGTH_SHORT);
                        LinearLayout toastLayout = (LinearLayout) toast.getView();
                        TextView toastTV = (TextView) toastLayout.getChildAt(0);
                        toastTV.setTextSize(30);
                        toast.show();
                    }

                } catch (SQLException e) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Bilinmeyen Hata!.", Toast.LENGTH_SHORT);
                    LinearLayout toastLayout = (LinearLayout) toast.getView();
                    TextView toastTV = (TextView) toastLayout.getChildAt(0);
                    toastTV.setTextSize(30);
                    toast.show();

                }
            }
        });

    }
}
