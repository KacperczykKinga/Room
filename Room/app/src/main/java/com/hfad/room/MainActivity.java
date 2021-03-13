package com.hfad.room;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GestureDetector mDetector;
    ImageView myView;
    ImageView myView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = (ImageView) this.findViewById(R.id.app);
        myView2 = (ImageView) this.findViewById(R.id.app2);

        // get the gesture detector
        mDetector = new GestureDetector(this, new MyGestureListener(myView, myView2));

        // Add a touch listener to the view
        // The touch listener passes all its events on to the gesture detector
        myView.setOnTouchListener(touchListener);

    }

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            // pass the events to the gesture detector
            // a return value of true means the detector is handling it
            // a return value of false means the detector didn't
            // recognize the event
            return mDetector.onTouchEvent(event);


            //return true;
        }
    };

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        Bitmap bitmap2;
        ImageView myView;
        ImageView myView2;
        int obecnaPozycja = 0;

        public MyGestureListener(ImageView first, ImageView second) {
            myView = first;
            myView2 = second;
            myView2.setDrawingCacheEnabled(true);
            myView2.buildDrawingCache(true);
        }

        int[] tabelaRamek = {R.drawable.anim0000, R.drawable.anim0002, R.drawable.anim0004, R.drawable.anim0006, R.drawable.anim0008,
                R.drawable.anim0010, R.drawable.anim0012, R.drawable.anim0014, R.drawable.anim0016, R.drawable.anim0018,
                R.drawable.anim0020, R.drawable.anim0022, R.drawable.anim0024, R.drawable.anim0026, R.drawable.anim0028,
                R.drawable.anim0030, R.drawable.anim0032, R.drawable.anim0034, R.drawable.anim0036, R.drawable.anim0038,
                R.drawable.anim0040, R.drawable.anim0042, R.drawable.anim0044, R.drawable.anim0046, R.drawable.anim0048,
                R.drawable.anim0050, R.drawable.anim0052, R.drawable.anim0054, R.drawable.anim0056, R.drawable.anim0058,
                R.drawable.anim0060, R.drawable.anim0062, R.drawable.anim0064, R.drawable.anim0066, R.drawable.anim0068,
                R.drawable.anim0070, R.drawable.anim0072, R.drawable.anim0074, R.drawable.anim0076, R.drawable.anim0080,
                R.drawable.anim0082, R.drawable.anim0084, R.drawable.anim0086, R.drawable.anim0088, R.drawable.anim0090,
                R.drawable.anim0092, R.drawable.anim0094, R.drawable.anim0096, R.drawable.anim0098, R.drawable.anim0100,
                R.drawable.anim0102, R.drawable.anim0104, R.drawable.anim0106, R.drawable.anim0108, R.drawable.anim0110,
                R.drawable.anim0112, R.drawable.anim0114, R.drawable.anim0116, R.drawable.anim0118, R.drawable.anim0120,
                R.drawable.anim0122, R.drawable.anim0124, R.drawable.anim0126, R.drawable.anim0128, R.drawable.anim0130,
                R.drawable.anim0132, R.drawable.anim0134, R.drawable.anim0136, R.drawable.anim0138, R.drawable.anim0140,
                R.drawable.anim0142, R.drawable.anim0144, R.drawable.anim0146, R.drawable.anim0148, R.drawable.anim0150,
                R.drawable.anim0152, R.drawable.anim0154, R.drawable.anim0156, R.drawable.anim0158, R.drawable.anim0160,
                R.drawable.anim0162, R.drawable.anim0164, R.drawable.anim0166, R.drawable.anim0168, R.drawable.anim0170,
                R.drawable.anim0172, R.drawable.anim0174, R.drawable.anim0176, R.drawable.anim0178, R.drawable.anim0180,
                R.drawable.anim0182, R.drawable.anim0184, R.drawable.anim0186, R.drawable.anim0188, R.drawable.anim0190,
                R.drawable.anim0192, R.drawable.anim0194, R.drawable.anim0196, R.drawable.anim0198, R.drawable.anim0200,
                R.drawable.anim0202, R.drawable.anim0204, R.drawable.anim0206, R.drawable.anim0208, R.drawable.anim0210,
                R.drawable.anim0212, R.drawable.anim0214, R.drawable.anim0216, R.drawable.anim0218, R.drawable.anim0220,
                R.drawable.anim0222, R.drawable.anim0224, R.drawable.anim0226, R.drawable.anim0228, R.drawable.anim0230,
                R.drawable.anim0232, R.drawable.anim0234, R.drawable.anim0236, R.drawable.anim0238, R.drawable.anim0240,
                R.drawable.anim0242, R.drawable.anim0244, R.drawable.anim0246, R.drawable.anim0248, R.drawable.anim0250,
                R.drawable.anim0252, R.drawable.anim0254, R.drawable.anim0256, R.drawable.anim0258, R.drawable.anim0260,
                R.drawable.anim0262, R.drawable.anim0264, R.drawable.anim0266, R.drawable.anim0268, R.drawable.anim0270,
                R.drawable.anim0272, R.drawable.anim0274, R.drawable.anim0276, R.drawable.anim0278, R.drawable.anim0280,
                R.drawable.anim0282, R.drawable.anim0284, R.drawable.anim0286, R.drawable.anim0288, R.drawable.anim0290,
                R.drawable.anim0292, R.drawable.anim0294, R.drawable.anim0296, R.drawable.anim0298, R.drawable.anim0300,
                R.drawable.anim0302, R.drawable.anim0304, R.drawable.anim0306, R.drawable.anim0308, R.drawable.anim0310,
                R.drawable.anim0312, R.drawable.anim0314, R.drawable.anim0316, R.drawable.anim0318, R.drawable.anim0320,
                R.drawable.anim0322, R.drawable.anim0324, R.drawable.anim0326, R.drawable.anim0328, R.drawable.anim0330,
                R.drawable.anim0332, R.drawable.anim0334, R.drawable.anim0336, R.drawable.anim0338, R.drawable.anim0340,
                R.drawable.anim0342, R.drawable.anim0344, R.drawable.anim0346, R.drawable.anim0348, R.drawable.anim0350,
                R.drawable.anim0352, R.drawable.anim0354, R.drawable.anim0356, R.drawable.anim0358, R.drawable.anim0360,
                R.drawable.anim0362, R.drawable.anim0364, R.drawable.anim0366, R.drawable.anim0368, R.drawable.anim0370,
                R.drawable.anim0372, R.drawable.anim0374, R.drawable.anim0376, R.drawable.anim0378, R.drawable.anim0380,
                R.drawable.anim0382, R.drawable.anim0384, R.drawable.anim0386, R.drawable.anim0388, R.drawable.anim0390,
                R.drawable.anim0392, R.drawable.anim0394, R.drawable.anim0396, R.drawable.anim0398, R.drawable.anim0400,
                R.drawable.anim0402, R.drawable.anim0404, R.drawable.anim0406, R.drawable.anim0408, R.drawable.anim0410,
                R.drawable.anim0412, R.drawable.anim0414, R.drawable.anim0416, R.drawable.anim0418, R.drawable.anim0420,
                R.drawable.anim0422, R.drawable.anim0424, R.drawable.anim0426, R.drawable.anim0428, R.drawable.anim0430,
                R.drawable.anim0432, R.drawable.anim0434, R.drawable.anim0436, R.drawable.anim0438, R.drawable.anim0440,
                R.drawable.anim0442, R.drawable.anim0444, R.drawable.anim0446, R.drawable.anim0448, R.drawable.anim0450,
                R.drawable.anim0452, R.drawable.anim0454, R.drawable.anim0456, R.drawable.anim0458, R.drawable.anim0460,
                R.drawable.anim0462, R.drawable.anim0464, R.drawable.anim0466, R.drawable.anim0468, R.drawable.anim0470,
                R.drawable.anim0472, R.drawable.anim0474, R.drawable.anim0476, R.drawable.anim0478, R.drawable.anim0480,
                R.drawable.anim0482, R.drawable.anim0484, R.drawable.anim0486, R.drawable.anim0488, R.drawable.anim0490,
                R.drawable.anim0492, R.drawable.anim0494, R.drawable.anim0496, R.drawable.anim0498, R.drawable.anim0500,
                R.drawable.anim0502, R.drawable.anim0504, R.drawable.anim0506, R.drawable.anim0508, R.drawable.anim0510,
                R.drawable.anim0512, R.drawable.anim0514, R.drawable.anim0516, R.drawable.anim0518, R.drawable.anim0520,
                R.drawable.anim0522, R.drawable.anim0524, R.drawable.anim0526, R.drawable.anim0528, R.drawable.anim0530,
                R.drawable.anim0532, R.drawable.anim0534, R.drawable.anim0536, R.drawable.anim0538, R.drawable.anim0540,
                R.drawable.anim0542, R.drawable.anim0544, R.drawable.anim0546, R.drawable.anim0548, R.drawable.anim0550,
                R.drawable.anim0552, R.drawable.anim0554, R.drawable.anim0556, R.drawable.anim0558, R.drawable.anim0560,
                R.drawable.anim0562, R.drawable.anim0564, R.drawable.anim0566, R.drawable.anim0568, R.drawable.anim0570,
                R.drawable.anim0572, R.drawable.anim0574, R.drawable.anim0576, R.drawable.anim0578, R.drawable.anim0580,
                R.drawable.anim0582, R.drawable.anim0584, R.drawable.anim0586, R.drawable.anim0588, R.drawable.anim0590,
                R.drawable.anim0592, R.drawable.anim0594
        };
        int[] tabelaRamekKolor = {R.drawable.kol0000,R.drawable.kol0002,R.drawable.kol0004,R.drawable.kol0006,R.drawable.kol0008,
                R.drawable.kol0010,R.drawable.kol0012,R.drawable.kol0014,R.drawable.kol0016,R.drawable.kol0018,
                R.drawable.kol0020,R.drawable.kol0022,R.drawable.kol0024,R.drawable.kol0026,R.drawable.kol0028,
                R.drawable.kol0030,R.drawable.kol0032,R.drawable.kol0034,R.drawable.kol0036,R.drawable.kol0038,
                R.drawable.kol0040,R.drawable.kol0042,R.drawable.kol0044,R.drawable.kol0046,R.drawable.kol0048,
                R.drawable.kol0050,R.drawable.kol0052,R.drawable.kol0054,R.drawable.kol0056,R.drawable.kol0058,
                R.drawable.kol0060,R.drawable.kol0062,R.drawable.kol0064,R.drawable.kol0066,R.drawable.kol0068,
                R.drawable.kol0072,R.drawable.kol0074,R.drawable.kol0076,R.drawable.kol0078,R.drawable.kol0080,
                R.drawable.kol0082,R.drawable.kol0084,R.drawable.kol0086,R.drawable.kol0088,R.drawable.kol0090,
                R.drawable.kol0092,R.drawable.kol0094,R.drawable.kol0096,R.drawable.kol0098,R.drawable.kol0100,
                R.drawable.kol0102,R.drawable.kol0104,R.drawable.kol0106,R.drawable.kol0108,R.drawable.kol0110,
                R.drawable.kol0112,R.drawable.kol0114,R.drawable.kol0116,R.drawable.kol0118,R.drawable.kol0120,
                R.drawable.kol0122,R.drawable.kol0124,R.drawable.kol0126,R.drawable.kol0128,R.drawable.kol0130,
                R.drawable.kol0132,R.drawable.kol0134,R.drawable.kol0136,R.drawable.kol0138,R.drawable.kol0140,
                R.drawable.kol0142,R.drawable.kol0144,R.drawable.kol0146,R.drawable.kol0148,R.drawable.kol0150,
                R.drawable.kol0152,R.drawable.kol0154,R.drawable.kol0156,R.drawable.kol0158,R.drawable.kol0160,
                R.drawable.kol0162,R.drawable.kol0164,R.drawable.kol0166,R.drawable.kol0168,R.drawable.kol0170,
                R.drawable.kol0172,R.drawable.kol0174,R.drawable.kol0176,R.drawable.kol0178,R.drawable.kol0180,
                R.drawable.kol0182,R.drawable.kol0184,R.drawable.kol0186,R.drawable.kol0188,R.drawable.kol0190,
                R.drawable.kol0192,R.drawable.kol0194,R.drawable.kol0196,R.drawable.kol0198,R.drawable.kol0200,
                R.drawable.kol0202,R.drawable.kol0204,R.drawable.kol0206,R.drawable.kol0208,R.drawable.kol0210,
                R.drawable.kol0212,R.drawable.kol0214,R.drawable.kol0216,R.drawable.kol0218,R.drawable.kol0220,
                R.drawable.kol0222,R.drawable.kol0224,R.drawable.kol0226,R.drawable.kol0228,R.drawable.kol0230,
                R.drawable.kol0232,R.drawable.kol0234,R.drawable.kol0236,R.drawable.kol0238,R.drawable.kol0240,
                R.drawable.kol0242,R.drawable.kol0244,R.drawable.kol0246,R.drawable.kol0248,R.drawable.kol0250,
                R.drawable.kol0252,R.drawable.kol0254,R.drawable.kol0256,R.drawable.kol0258,R.drawable.kol0260,
                R.drawable.kol0262,R.drawable.kol0264,R.drawable.kol0266,R.drawable.kol0268,R.drawable.kol0270,
                R.drawable.kol0272,R.drawable.kol0274,R.drawable.kol0276,R.drawable.kol0278,R.drawable.kol0280,
                R.drawable.kol0282,R.drawable.kol0284,R.drawable.kol0286,R.drawable.kol0288,R.drawable.kol0290,
                R.drawable.kol0292,R.drawable.kol0294,R.drawable.kol0296,R.drawable.kol0298,R.drawable.kol0300,
                R.drawable.kol0302,R.drawable.kol0304,R.drawable.kol0306,R.drawable.kol0308,R.drawable.kol0310,
                R.drawable.kol0312,R.drawable.kol0314,R.drawable.kol0316,R.drawable.kol0318,R.drawable.kol0320,
                R.drawable.kol0322,R.drawable.kol0324,R.drawable.kol0326,R.drawable.kol0328,R.drawable.kol0330,
                R.drawable.kol0332,R.drawable.kol0334,R.drawable.kol0336,R.drawable.kol0338,R.drawable.kol0340,
                R.drawable.kol0342,R.drawable.kol0344,R.drawable.kol0346,R.drawable.kol0348,R.drawable.kol0350,
                R.drawable.kol0352,R.drawable.kol0354,R.drawable.kol0356,R.drawable.kol0358,R.drawable.kol0360,
                R.drawable.kol0362,R.drawable.kol0364,R.drawable.kol0366,R.drawable.kol0368,R.drawable.kol0370,
                R.drawable.kol0372,R.drawable.kol0374,R.drawable.kol0376,R.drawable.kol0378,R.drawable.kol0380,
                R.drawable.kol0382,R.drawable.kol0384,R.drawable.kol0386,R.drawable.kol0388,R.drawable.kol0390,
                R.drawable.kol0392,R.drawable.kol0394,R.drawable.kol0396,R.drawable.kol0398,R.drawable.kol0400,
                R.drawable.kol0402,R.drawable.kol0404,R.drawable.kol0406,R.drawable.kol0408,R.drawable.kol0410,
                R.drawable.kol0412,R.drawable.kol0414,R.drawable.kol0416,R.drawable.kol0418,R.drawable.kol0420,
                R.drawable.kol0422,R.drawable.kol0424,R.drawable.kol0426,R.drawable.kol0428,R.drawable.kol0430,
                R.drawable.kol0432, R.drawable.kol0434, R.drawable.kol0436, R.drawable.kol0438, R.drawable.kol0440,
                R.drawable.kol0442, R.drawable.kol0444, R.drawable.kol0446, R.drawable.kol0448, R.drawable.kol0450,
                R.drawable.kol0452, R.drawable.kol0454, R.drawable.kol0456, R.drawable.kol0458, R.drawable.kol0460,
                R.drawable.kol0462, R.drawable.kol0464, R.drawable.kol0466, R.drawable.kol0468, R.drawable.kol0470,
                R.drawable.kol0472, R.drawable.kol0474, R.drawable.kol0476, R.drawable.kol0478, R.drawable.kol0480,
                R.drawable.kol0482, R.drawable.kol0484, R.drawable.kol0486, R.drawable.kol0488, R.drawable.kol0490,
                R.drawable.kol0492, R.drawable.kol0494, R.drawable.kol0496, R.drawable.kol0498, R.drawable.kol0500,
                R.drawable.kol0502, R.drawable.kol0504, R.drawable.kol0506, R.drawable.kol0508, R.drawable.kol0510,
                R.drawable.kol0512, R.drawable.kol0514, R.drawable.kol0516, R.drawable.kol0518, R.drawable.kol0520,
                R.drawable.kol0522, R.drawable.kol0524, R.drawable.kol0526, R.drawable.kol0528, R.drawable.kol0530,
                R.drawable.kol0532, R.drawable.kol0534, R.drawable.kol0536, R.drawable.kol0538, R.drawable.kol0540,
                R.drawable.kol0542, R.drawable.kol0544, R.drawable.kol0546, R.drawable.kol0548, R.drawable.kol0550,
                R.drawable.kol0552, R.drawable.kol0554, R.drawable.kol0556, R.drawable.kol0558, R.drawable.kol0560,
                R.drawable.kol0562, R.drawable.kol0564, R.drawable.kol0566, R.drawable.kol0568, R.drawable.kol0570,
                R.drawable.kol0572, R.drawable.kol0574, R.drawable.kol0576, R.drawable.kol0578, R.drawable.kol0580,
                R.drawable.kol0582, R.drawable.kol0584, R.drawable.kol0586, R.drawable.kol0588, R.drawable.kol0590,
                R.drawable.kol0592, R.drawable.kol0594

        };



        @Override
        public boolean onDown(MotionEvent e2) {

            // don't return false here or else none of the other
            // gestures will work
            if (e2.getAction() == MotionEvent.ACTION_DOWN) {
                bitmap2 = myView2.getDrawingCache();
                int piksel2 = bitmap2.getPixel((int) e2.getX(), (int) e2.getY());


                int r2 = Color.red(piksel2);
                int g2 = Color.green(piksel2);
                int b2 = Color.blue(piksel2);

                Log.i("r", " r: " + r2 + " g " + g2 + " b " + b2);
                Context co = getApplicationContext();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                String title = "";
                String desc = "";

                if (r2 >= 90 && r2 <= 170 && g2 >= 160 && g2 <= 230 && b2 >= 85 && b2 <= 170) {
                    title = "Telewizor";
                    desc = "Telewizor QLED SAMSUNG QE55Q85RAT :    6999 zł";
                }

                if (r2 >= 90 && r2 <= 150 && g2 >= 95 && g2 <= 150 && b2 >= 180 && b2 <= 230) {
                    title = "Półka";
                    desc = "Sosnowa ręcznie robiona półka :    5599 zł";
                }

                if (r2 >= 170 && r2 <= 230 && g2 >= 170 && g2 <= 220 && b2 >= 40 && b2 <= 100) {
                    title = "Wazony";
                    desc = "Wazony ceramiczne :    399 zł";
                }

                builder.setMessage(desc).setTitle(title).setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.cancel();
                            }
                        });

                AlertDialog dialog = builder.create();
               // dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
                if(title.length() > 0 )
                {
                    dialog.show();
                }
            }


            return true;
        }


        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            if (e2.getAction() == MotionEvent.ACTION_MOVE)
            {
                Log.i("TAG", "MOVE: " + distanceX + " " + obecnaPozycja);
                myView.setBackground(getResources().getDrawable(tabelaRamek[obecnaPozycja]));
                myView2.setBackground(getResources().getDrawable(tabelaRamekKolor[obecnaPozycja]));
                int change = 0;
                if (Math.abs(distanceX) < 40) {
                    change = 1;
                } else if (Math.abs(distanceX) < 70) {
                    change = 2;
                } else if (Math.abs(distanceX) < 110) {
                    change = 3;
                } else if (Math.abs(distanceX) < 170) {
                    change = 4;
                } else if (Math.abs(distanceX) < 260) {
                    change = 5;
                } else if (Math.abs(distanceX) < 350) {
                    change = 6;
                } else if (Math.abs(distanceX) < 470) {
                    change = 7;
                } else if (Math.abs(distanceX) < 600) {
                    change = 8;
                } else {
                    change = 9;
                }

                if (distanceX > 0) {
                    Log.i("TAG", "xd: ");
                    obecnaPozycja += change;
                } else {
                    Log.i("TAG", "dddddd ");
                    obecnaPozycja -= change;
                }

                if (obecnaPozycja > tabelaRamekKolor.length - 1) {
                    Log.i("TAG", "ppppppppppp ");
                    obecnaPozycja = tabelaRamekKolor.length - 1;
                }
                if (obecnaPozycja < 0) {
                    Log.i("TAG", "xxxxxxxxxxxxxxxxx ");
                    obecnaPozycja = 0;
                }
                Log.i("TAG", "MOVE: " + distanceX + " " + obecnaPozycja);


            }

            return true;
        }

    }

}
