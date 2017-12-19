package com.example.user.library.activity.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.library.R;
import com.example.user.library.activity.contest.ContestActivity;
import com.example.user.library.activity.mypage.MypageActivity;
import com.example.user.library.activity.studyroom.StudyRoom;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MenuViewHolder> {

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView menuTitle;
        ImageView backgroudnImgae;
        int position;
        Context mcontext;

        MenuViewHolder(View itemView, final Context context) {
            super(itemView);
            mcontext = context;
            cv = (CardView)itemView.findViewById(R.id.cv);
            menuTitle = (TextView)itemView.findViewById(R.id.item_title);
            backgroudnImgae = (ImageView)itemView.findViewById(R.id.item_background);

            cv.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {

                    Intent intent;
                    switch(position){
                        case 0:
                            startStudyRoom();
                            break;
                        case 1:
                            startContest();
                            break;
                        case 2:
                            startMypage();
                            break;
                    }
                }
            });


        }

        public void startStudyRoom(){
            Intent intent = new Intent(mcontext, StudyRoom.class);
            mcontext.startActivity(intent);
        }
        public void startContest(){
            Intent intent = new Intent(mcontext, ContestActivity.class);
            mcontext.startActivity(intent);
        }
        public void startMypage(){
            Intent intent = new Intent(mcontext, MypageActivity.class);
            mcontext.startActivity(intent);
        }

    }

    Context context;
    List<Menu> menus;

    public RVAdapter(Context context, List<Menu> menus){
        this.context = context;
        this.menus = menus;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        MenuViewHolder mvh = new MenuViewHolder(v,context);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder menuViewHolder, int position) {
        menuViewHolder.menuTitle.setText(menus.get(position).title);
        menuViewHolder.backgroudnImgae.setImageResource(menus.get(position).photoId);
        menuViewHolder.position = position;
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }
}
