package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnarti, btneksi, btncarpi, btnbolu, btnsonuc, btnsil, btnnokta;
    EditText textbox1;
    Float sayi1, sayi2;
    TextView txtTututlan;
    String kayitliIslem = "";
    Boolean tekSeferDegerTutma = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        tiklanma();

    }


    public void tiklanma() {
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textbox1.getText().toString().matches("0"))
                    textbox1.setText(textbox1.getText() + "0");


            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textbox1.getText().toString().matches("0"))
                    textbox1.setText(textbox1.getText() + "1");
                else textbox1.setText("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textbox1.getText().toString().matches("0"))
                    textbox1.setText(textbox1.getText() + "2");
                else textbox1.setText("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textbox1.getText().toString().matches("0"))
                    textbox1.setText(textbox1.getText() + "3");
                else textbox1.setText("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textbox1.getText().toString().matches("0"))
                    textbox1.setText(textbox1.getText() + "4");
                else textbox1.setText("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textbox1.getText().toString().matches("0"))
                    textbox1.setText(textbox1.getText() + "5");
                else textbox1.setText("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textbox1.getText().toString().matches("0"))
                    textbox1.setText(textbox1.getText() + "6");
                else textbox1.setText("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textbox1.getText().toString().matches("0"))
                    textbox1.setText(textbox1.getText() + "7");
                else textbox1.setText("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textbox1.getText().toString().matches("0"))
                    textbox1.setText(textbox1.getText() + "8");
                else textbox1.setText("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textbox1.getText().toString().matches("0"))
                    textbox1.setText(textbox1.getText() + "9");
                else textbox1.setText("9");
            }
        });
        btnarti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textboxDoluKontrol()) {
                    textboxSonKarakterNoktaTemizle();
                    tekSeferDegerTutma = false;
                    islemYap(kayitliIslemKontrol("+"));
                    kayitliIslem = "+";
                    yedekTextAyarla(kayitliIslem);
                }
            }
        });
        btneksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textboxDoluKontrol()) {
                    textboxSonKarakterNoktaTemizle();
                    tekSeferDegerTutma = false;
                    islemYap(kayitliIslemKontrol("-"));
                    kayitliIslem = "-";
                    yedekTextAyarla(kayitliIslem);
                }
            }
        });
        btncarpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textboxDoluKontrol()) {
                    textboxSonKarakterNoktaTemizle();
                    tekSeferDegerTutma = false;
                    islemYap(kayitliIslemKontrol("x"));
                    kayitliIslem = "x";
                    yedekTextAyarla(kayitliIslem);
                }
            }
        });
        btnbolu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textboxDoluKontrol()) {
                    textboxSonKarakterNoktaTemizle();
                    tekSeferDegerTutma = false;
                    islemYap(kayitliIslemKontrol("/"));
                    kayitliIslem = "/";
                    yedekTextAyarla(kayitliIslem);
                }
            }
        });
        btnsonuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textboxDoluKontrol()) {
                    textboxSonKarakterNoktaTemizle();
                    islemYap("sonuc");
                    tekSeferDegerTutma = true;
                }
            }
        });
        btnsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textboxDoluKontrol()) {
                    String txtDeger = textbox1.getText().toString();
                    txtDeger = txtDeger.substring(0, txtDeger.length() - 1);
                    textbox1.setText(txtDeger);
                }

            }
        });
        btnsil.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                degerlerTemizle();
                return false;
            }
        });
        btnnokta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textboxDoluKontrol()) {
                    if (textbox1.getText().toString().indexOf('.') == -1) {
                        if (!textbox1.getText().toString().matches(""))
                            textbox1.setText(textbox1.getText() + ".");
                    }
                }
            }
        });
    }

    public Boolean textboxDoluKontrol() {
        if (textbox1.getText().toString().length() > 0) return true;
        else return false;
    }

    public void textboxSonKarakterNoktaTemizle() {
        if (textbox1.getText().toString().indexOf('.') == textbox1.getText().toString().length() - 1)
            textbox1.setText(textbox1.getText().toString().substring(0, textbox1.getText().toString().length() - 1));
    }

    public void degerlerTemizle() {
        sayi1 = null;
        sayi2 = null;
        textbox1.setText(null);
        txtTututlan.setText(null);
        kayitliIslem = null;
        tekSeferDegerTutma = false;
    }

    public String kayitliIslemKontrol(String islem) {
        if (kayitliIslem == "") {
            kayitliIslem = islem;
            return kayitliIslem;
        } else return kayitliIslem;
    }

    public void islemYap(String islem) {
        if (!textboxDegerAl().matches("") && sayi1 != null && !txtTututlan.getText().toString().matches("")) {

            if (!tekSeferDegerTutma) sayi2 = Float.parseFloat(textboxDegerAl());

            switch (islem) {
                case "+":
                    sayi1 += sayi2;
                    break;
                case "-":
                    sayi1 -= sayi2;
                    break;
                case "x":
                    sayi1 *= sayi2;
                    break;
                case "/":
                    sayi1 /= sayi2;
                    break;
                case "sonuc":
                    switch (kayitliIslem) {
                        case "+":
                            sayi1 += sayi2;
                            break;
                        case "-":
                            sayi1 -= sayi2;
                            break;
                        case "x":
                            sayi1 *= sayi2;
                            break;
                        case "/":
                            sayi1 /= sayi2;
                            break;
                    }
                    break;
            }
            if (islem == "sonuc") yedekTextAyarla("sonuc");

        } else if (!textboxDegerAl().matches("")) {
            sayi1 = Float.parseFloat(textboxDegerAl());
        }
    }


    public void yedekTextAyarla(String islem) {
        if (islem == "sonuc") {
            txtTututlan.setText("");
            if (sayi1 % 1 == 0)
                textbox1.setText(String.valueOf(Math.round(sayi1)));
            else
                textbox1.setText(sayi1.toString());
        } else {
            if (sayi1 % 1 == 0)
                txtTututlan.setText(String.valueOf(Math.round(sayi1)) + " " + islem);
            else
                txtTututlan.setText(sayi1 + " " + islem);
            textbox1.setText(null);
        }
    }


    public String textboxDegerAl() {
        return textbox1.getText().toString();
    }

    public void tanimla() {
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnarti = (Button) findViewById(R.id.btn_arti);
        btneksi = (Button) findViewById(R.id.btn_eksi);
        btncarpi = (Button) findViewById(R.id.btn_carpi);
        btnbolu = (Button) findViewById(R.id.btn_bolu);
        btnsonuc = (Button) findViewById(R.id.btn_sonuc);
        btnsil = (Button) findViewById(R.id.btn_sil);
        btnnokta = (Button) findViewById(R.id.btn_nokta);
        textbox1 = (EditText) findViewById(R.id.textbox1);
        txtTututlan = (TextView) findViewById(R.id.txtTutulan);
    }


}
