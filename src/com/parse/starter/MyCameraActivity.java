package com.parse.starter;

import android.widget.EditText;
import android.content.Context;
import android.widget.Toast;
import com.parse.ParseObject;
import android.widget.TextView;
import com.parse.ParseFile;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.nio.ByteBuffer;

public class MyCameraActivity extends Activity {
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private ImageView imageView1;
    private TextView TextView01;
    private EditText editText1;
    private EditText editText2;
    private Bitmap photo;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.imageView = (ImageView)this.findViewById(R.id.imageView1);
        Button photoButton = (Button) this.findViewById(R.id.finishButtons);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        Button nextButton = (Button) this.findViewById(R.id.nextbutton);

        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                nextButtonClicked();

            }
        });
    }

    public void nextButtonClicked()
    {
        Context context = getApplicationContext();


        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        imageView1 = (ImageView)findViewById(R.id.imageView1);

        ParseObject listing = new ParseObject("Listing");



        String address = editText2.getText().toString();
        Toast toast = Toast.makeText(context, address, Toast.LENGTH_LONG);
        toast.show();
        listing.put("apartment", address);
        listing.saveInBackground();

        String price = editText1.getText().toString();
        toast = Toast.makeText(context, price, Toast.LENGTH_LONG);
        toast.show();
        double  numericalPrice = Double.parseDouble(price);
        listing.put("price", numericalPrice);
        listing.saveInBackground();

        /*
        int bytes = photo.getWidth()*photo.getHeight()*4;
        ByteBuffer buffer = ByteBuffer.allocate(bytes);
        photo.copyPixelsToBuffer(buffer);
        byte[] array = buffer.array();
        ParseFile file = new ParseFile("image.jpeg", array);
        file.saveInBackground();
        listing.put("Image", file);*/

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }
}


