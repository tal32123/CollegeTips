package com.example.android.collegetips;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class MainActivity extends AppCompatActivity {
private final String convoURL = "https://pixabay.com/static/uploads/photo/2014/09/18/18/19/playmobil-451203_960_720.jpg";
    private final String goodURL = "https://pixabay.com/static/uploads/photo/2016/01/05/17/49/good-1123013__340.jpg";
    private final String mindURL = "https://pixabay.com/static/uploads/photo/2014/10/09/23/55/sueaking-482701_960_720.jpg";
    private final String organizationURL = "https://pixabay.com/static/uploads/photo/2015/11/03/09/20/network-1020332_960_720.jpg";
    private final String study_abroad_URL ="https://pixabay.com/static/uploads/photo/2014/09/18/19/30/man-451289_960_720.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Imageview Id's
        final ImageView conversation = (ImageView)findViewById(R.id.conversation);
        final ImageView mind = (ImageView) findViewById(R.id.mind);
        final ImageView good = (ImageView) findViewById(R.id.good);
        final ImageView organization = (ImageView) findViewById(R.id.organization);
        final ImageView study_abroad = (ImageView) findViewById(R.id.study_abroad);





        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
        ImageLoader.getInstance().init(config);
            ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.loadImage(convoURL, new SimpleImageLoadingListener(){

            @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                conversation.setImageBitmap(loadedImage);
            }
        });

        imageLoader.loadImage(goodURL, new SimpleImageLoadingListener(){

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                good.setImageBitmap(loadedImage);
            }
        });
        imageLoader.loadImage(mindURL, new SimpleImageLoadingListener(){

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                mind.setImageBitmap(loadedImage);
            }
        });

        imageLoader.loadImage(organizationURL, new SimpleImageLoadingListener(){

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                organization.setImageBitmap(loadedImage);
            }
        });
        imageLoader.loadImage(study_abroad_URL, new SimpleImageLoadingListener(){

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                study_abroad.setImageBitmap(loadedImage);
            }
        });





    }

    /**create link for more info
     *
     */
    public void moreTips(View view){
        Uri webpage = Uri.parse("http://collegeinfogeek.com/42-things-i-learned-freshman-year/");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void submitTip(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"tal32123@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "College Tips Tip Submittion");
        intent.putExtra(Intent.EXTRA_TEXT, "TEST TEXT ");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

