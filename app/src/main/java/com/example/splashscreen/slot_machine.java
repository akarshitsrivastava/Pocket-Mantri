package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splashscreen.ImageViewScrolling.IEventEnd;
import com.example.splashscreen.ImageViewScrolling.ImageViewScrolling;

import java.util.Random;

public class slot_machine extends AppCompatActivity implements IEventEnd {

        ImageView btn_up , btn_down;
        ImageViewScrolling image , image2, image3;
        TextView text_score;

        int count_done=0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_slot_machine);

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            btn_down=(ImageView)findViewById(R.id.btn_down);
            btn_up=(ImageView)findViewById(R.id.btn_up);
            image=(ImageViewScrolling) findViewById(R.id.image);
            image2=(ImageViewScrolling) findViewById(R.id.image2);
            image3=(ImageViewScrolling) findViewById(R.id.image3);

            text_score=(TextView)findViewById(R.id.text_score);
            image.setEventEnd(slot_machine.this);
            image2.setEventEnd(slot_machine.this);
            image3.setEventEnd(slot_machine.this);

            btn_up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Common.SCORE >= 50)
                    {
                        btn_up.setVisibility(View.GONE);
                        btn_down.setVisibility(View.VISIBLE);

                        image.setValueRandom(new Random().nextInt(6),
                                new Random().nextInt((15-5)+1)+5);
                        image2.setValueRandom(new Random().nextInt(6),
                                new Random().nextInt((15-5)+1)+5);
                        image3.setValueRandom(new Random().nextInt(6),
                                new Random().nextInt((15-5)+1)+5);
                        Common.SCORE -= 50;
                        text_score.setText(String.valueOf(Common.SCORE));

                    }
                    else {
                        Toast.makeText(slot_machine.this, "NOT ENOUGH MONEY", Toast.LENGTH_SHORT).show();
                    }
                }

            });


        }


        @Override
        public void eventEnd(int result, int count) {
            if (count_done < 2)
                count_done ++ ;
            else
            {
                btn_down.setVisibility(View.GONE);
                btn_up.setVisibility(View.VISIBLE);
                count_done=0;
                if(image.getValue()== image2.getValue() && image2.getValue()== image3.getValue())
                {
                    Toast.makeText(this, "YOU WIN A CARD", Toast.LENGTH_SHORT).show();
                    Common.SCORE += 300;
                    text_score.setText(String.valueOf(Common.SCORE));
                }
                else if (image.getValue()==image2.getValue() ||
                        image2.getValue()==image3.getValue() ||
                        image.getValue()==image3.getValue())
                {
                    Toast.makeText(this, "YOU WIN A BRONZE CARD", Toast.LENGTH_SHORT).show();
                    Common.SCORE += 300;
                    text_score.setText(String.valueOf(Common.SCORE));
                }
                else
                {
                    Toast.makeText(this, "YOU LOSE", Toast.LENGTH_SHORT).show();
                }

            }

        }
    }
