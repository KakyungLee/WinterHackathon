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
import android.widget.Toast;

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
                    cusData.cusButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(view.getContext(), "삭제", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else{
                    cusData.cusButton.setVisibility(View.GONE);
                }
                break;
            case "borrowed":
                cusData.cusButton.setVisibility(View.VISIBLE);
                if(allMenuData.cusThird != null){
                    cusData.cusButton.setText("수정");
                    cusData.cusButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                          /*  LayoutInflater inflater = (LayoutInflater) view.getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                            View mView = inflater.inflate(R.layout.contest_modify_dialog, null);
                            AlertDialog.Builder builder = new AlertDialog.Builder(ContestApplyActivity.this);
                            builder.setView(mView);
                            final AlertDialog dialog = builder.create();
                            dialog.show();

                            Button ok = (Button) mView.findViewById(R.id.contest_modify_dialog_ok);
                            ok.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    dialog.cancel();
                                }
                            });*/
                        }
                    });
                }
                else{
                    cusData.cusButton.setText("작성");
                    cusData.cusButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            /*  LayoutInflater inflater = (LayoutInflater) view.getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                            View mView = inflater.inflate(R.layout.contest_modify_dialog, null);
                            AlertDialog.Builder builder = new AlertDialog.Builder(ContestApplyActivity.this);
                            builder.setView(mView);
                            final AlertDialog dialog = builder.create();
                            dialog.show();

                            Button ok = (Button) mView.findViewById(R.id.contest_modify_dialog_ok);
                            ok.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    dialog.cancel();
                                }
                            });*/
                        }
                    });
                }
                break;
            case "borrowing":
                cusData.cusButton.setText("연장");
                cusData.cusButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "연장", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case "reservation":
                cusData.cusButton.setText("취소");
                cusData.cusButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "취소", Toast.LENGTH_LONG).show();
                    }
                });
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
