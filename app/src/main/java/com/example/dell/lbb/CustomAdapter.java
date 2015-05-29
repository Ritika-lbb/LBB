package com.example.dell.lbb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

/**
 * Created by dell on 5/19/2015.
 */
public class CustomAdapter extends BaseAdapter {

    String result[];
    Context context;
    int imageId[];
    private static LayoutInflater inflater=null;

    public CustomAdapter(MyLbb myLbb, String[] list, int[] images)
    {
        result= list;
        context = myLbb;
        imageId=images;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder{
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.gridlayout, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);

        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
               // Toast.makeText(context, "You Clicked " +position, Toast.LENGTH_LONG).show();
            }
        });

        return rowView;
    }

}
