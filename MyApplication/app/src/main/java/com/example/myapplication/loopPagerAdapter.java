package com.example.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class loopPagerAdapter extends PagerAdapter {
    private List<Integer> sPics=null;

    @Override
    public int getCount() {
        if(sPics!=null){
            return Integer.MAX_VALUE;
        }
        return 0;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        int realPosition=position % sPics.size();
        ImageView imageView=new ImageView(container.getContext());
        //imageView.setBackgroundColor(sColors.get(position));
        imageView.setImageResource(sPics.get(realPosition));
        //设置完颜色，添加到容器中
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
    public void setData(List<Integer> pics){

        this.sPics=pics;
    }
    public int getDataRealSize() {
        if (sPics != null) {
            return sPics.size();
        }
        return 0;
    }
}
