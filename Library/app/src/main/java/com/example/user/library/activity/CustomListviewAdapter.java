package com.example.user.library.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.library.R;

import java.util.ArrayList;


public class CustomListviewAdapter extends BaseAdapter {

    private Context allMenuContext = null;
    private ArrayList<CustomItem> allMenuListData = new ArrayList<CustomItem>();
    CustomItem addInfo;

    public CustomListviewAdapter(Context allMenuContext){
        super();
        this.allMenuContext = allMenuContext;
    }
    @Override
    public int getCount() {
        return allMenuListData.size();
    }

    @Override
    public Object getItem(int position) {
        return allMenuListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(String cusType, Drawable cusImage, String cusFirst,String cusSecond, String cusThird, String cusButton){
        addInfo = new CustomItem();
        addInfo.cusType = cusType;
        addInfo.cusImage = cusImage;
        addInfo.cusFirst = cusFirst;
        addInfo.cusSecond = cusSecond;
        addInfo.cusThird = cusThird;
        addInfo.cusButton = cusButton;
        allMenuListData.add(addInfo);
    }

    private class ViewHolder{
        public String cusType;
        public ImageView cusImage;
        public TextView cusFirst;
        public TextView cusSecond;
        public TextView cusThird;
        public Button cusButton;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
       ViewHolder cusData;
        if(convertView == null){
            cusData = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater)allMenuContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_view,null);

            //리스트에 들어갈 데이터
            cusData.cusImage = (ImageView)convertView.findViewById(R.id.custom_Image);
            cusData.cusFirst = (TextView)convertView.findViewById(R.id.custom_first);
            cusData.cusSecond = (TextView)convertView.findViewById(R.id.custom_second);
            cusData.cusThird = (TextView)convertView.findViewById(R.id.custom_third);
            cusData.cusButton = (Button) convertView.findViewById(R.id.custom_button);

            cusData.cusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    //startActivity(intent);
                }
            });

            convertView.setTag(cusData);
        }
        else{
            cusData = (ViewHolder)convertView.getTag();
        }

        CustomItem allMenuData = allMenuListData.get(position);

        switch (allMenuData.cusType){
            case "contest" :
                if(allMenuData.cusButton != null){
                    cusData.cusButton.setVisibility(View.VISIBLE);
                    cusData.cusButton.setText("삭제");
                }
                else{
                    cusData.cusButton.setVisibility(View.GONE);
                }
                break;
            case "borrowed":
                cusData.cusButton.setVisibility(View.VISIBLE);
                if(allMenuData.cusButton != null){
                    cusData.cusButton.setText("수정");
                }
                else{
                    cusData.cusButton.setText("작성");
                }
                break;
            case "borrowing":
                break;
        }


        cusData.cusImage.setVisibility(View.VISIBLE);
        cusData.cusImage.setImageDrawable(allMenuData.cusImage);
        cusData.cusFirst.setText(allMenuData.cusFirst);
        cusData.cusSecond.setText(allMenuData.cusSecond);
        cusData.cusThird.setText(allMenuData.cusThird);

        return convertView;
    }
}
