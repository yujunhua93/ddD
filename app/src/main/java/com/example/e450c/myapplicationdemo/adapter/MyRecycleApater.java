package com.example.e450c.myapplicationdemo.adapter;


import android.content.Context;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.e450c.myapplicationdemo.R;
import com.example.e450c.myapplicationdemo.activity.Main17Activity;
import com.example.e450c.myapplicationdemo.inter.OnItemClickListener;
import com.example.e450c.myapplicationdemo.widgets.VerticalTextview;

import java.util.List;

/**
 * Created by e450c on 2016/8/26.
 */
public class MyRecycleApater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 0;

    public static final int TYPE_LIST = 1;

    public static final int TYPE_FOOTER = 2;

    private int mHeaderCount = 1;

    private int mFooterCount = 1;

    private List<String> lists;

    private List<Fragment> fragmentList;

    private Context context;

    private View mHeader;

    OnItemClickListener onItemClickListener;

    private FragmentManager fm;

    public MyRecycleApater(Context context, List<String> lists, List<Fragment> list, FragmentManager fragmentManager) {
            this.lists = lists;
            this.context = context;
            this.fragmentList = list;
            this.fm = fragmentManager;
    }

    public boolean isHeaderView(int position){
        return mHeaderCount!= 0 && position<mHeaderCount;
    }

    public boolean isFooterView(int postion){
        return  mFooterCount!=0 && mFooterCount>= (mHeaderCount+getItemCount());
    }

    public void setHeaderView(View mHeader){
        mHeader = mHeader;
        notifyItemInserted(0);

    }

    public View getmHeader() {
        return mHeader;
    }

    public int getContentItemCount(){
        return lists.size();
    }

    @Override
    public int getItemViewType(int position) {
        int dataItemCount = getContentItemCount();
        if (mHeaderCount != 0 && position<mHeaderCount){
            return  TYPE_HEADER;
        }else if(mFooterCount != 0 && position>(mHeaderCount+dataItemCount)){
            return  TYPE_FOOTER;
        }else {
            return TYPE_LIST;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER){
                return  new HeaderHolder(LayoutInflater.from(context).inflate(R.layout.headerview,parent,false));
        }else if(viewType == TYPE_FOOTER){
                return  new FooterHolder(LayoutInflater.from(context).inflate(R.layout.footerview,parent,false));
        }else if (viewType == mHeaderCount){
             return  new ViewHolder( LayoutInflater.from(context).inflate(R.layout.layout,parent,false));
        }

//        View view = LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
//        ViewHolder holder = new ViewHolder(view);



        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof HeaderHolder){
                ((HeaderHolder) holder).viewPager.setAdapter(new MyFragemntAdapter(fragmentList,fm));
            }else if (holder instanceof ViewHolder){
                    ((ViewHolder) holder).textview.setText(lists.get(position));
            }else if (holder instanceof FooterHolder){

            }


    }





    @Override
    public int getItemCount() {
        return mHeaderCount+mHeaderCount+getContentItemCount();
    }

     class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textview;

         public ViewHolder(View itemView) {
             super(itemView);
             textview = (TextView)itemView.findViewById(R.id.layout_tv);
         }


         @Override
         public void onClick(View v) {

         }
     }

    class HeaderHolder extends RecyclerView.ViewHolder{
        ViewPager viewPager;
        public HeaderHolder(View itemView) {
            super(itemView);
            viewPager = (ViewPager) itemView.findViewById(R.id.hd_vp);
        }
    }

    class FooterHolder extends  RecyclerView.ViewHolder{

        public FooterHolder(View itemView) {
            super(itemView);
        }
    }
}
