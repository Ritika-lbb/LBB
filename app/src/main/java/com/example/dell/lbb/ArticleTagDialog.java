package com.example.dell.lbb;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by dell on 5/22/2015.
 */
public class ArticleTagDialog extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.tag_layout);

        if (getWindow().isFloating()) ArticleDialog.maxinumDialogWindowHeight(getWindow());
    }

    public static void maxinumDialogWindowHeight(Window window) {
        WindowManager.LayoutParams layout = new WindowManager.LayoutParams();
        layout.copyFrom(window.getAttributes());
        layout.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(layout);
    }


}
