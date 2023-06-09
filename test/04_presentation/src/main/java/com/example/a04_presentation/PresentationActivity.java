package com.example.a04_presentation;

import android.app.Presentation;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.media.MediaRouter;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PresentationActivity extends AppCompatActivity {
    private Button btnShow;
    private Button btnHide;
    static MyPresentation myPresentation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

        btnShow = (Button) findViewById(R.id.btn_show);
        btnHide = (Button) findViewById(R.id.btn_hide);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != myPresentation) {
                    initPresentation();
                } else {
                    myPresentation.show();
                }
            }
        });

        btnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null == myPresentation) {
                    return;
                }
                myPresentation.dismiss();
            }
        });
        if (null != myPresentation) {
            myPresentation.show();
        } else {
            initPresentation();
        }
    }


    void initPresentation() {
        if (null != myPresentation) {
            myPresentation.dismiss();
        }
        MediaRouter mediaRouter = (MediaRouter) getSystemService(Context.MEDIA_ROUTER_SERVICE);
        MediaRouter.RouteInfo route = mediaRouter.getSelectedRoute(MediaRouter.ROUTE_TYPE_LIVE_AUDIO);
        if (route != null) {
            Display presentationDisplay = route.getPresentationDisplay();
            if (presentationDisplay != null) {
                myPresentation = new MyPresentation(PresentationActivity.this, presentationDisplay);
                myPresentation.show();
            }
        }
    }

    void initPresentation2() {
        DisplayManager mDisplayManager = (DisplayManager) getSystemService(Context.DISPLAY_SERVICE);
        Display[] displays = mDisplayManager.getDisplays();
        if (displays.length > 1) {
            //displays[0] 主屏，displays[1] 副屏
            myPresentation = new MyPresentation(PresentationActivity.this, displays[1]);
            myPresentation.show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (null != myPresentation) {
            myPresentation.dismiss();
            myPresentation = null;
        }
    }

    public static class MyPresentation2 extends Presentation {
        public MyPresentation2(Context outerContext, Display display) {
            super(outerContext, display);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.pretation_main);
        }

        @Override
        public void onDisplayRemoved() {
            super.onDisplayRemoved();
        }
    }
}