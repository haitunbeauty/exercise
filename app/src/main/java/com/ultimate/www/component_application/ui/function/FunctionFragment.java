package com.ultimate.www.component_application.ui.function;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.ultimate.www.component_application.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class FunctionFragment extends Fragment {

    private FunctionViewModel functionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        functionViewModel =
                ViewModelProviders.of(this).get(FunctionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_function, container, false);
        ListView lv = root.findViewById(R.id.rlv);
//        final TextView textView = root.findViewById(R.id.text_notifications);
//        functionViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        MyAdapter myAdapter = new MyAdapter(getActivity());
        ArrayList<FunctionMenu> functionMenus = new ArrayList<>();
        myAdapter.setData(functionMenus);
        lv.setAdapter(myAdapter);

        return root;
    }

    class MyAdapter extends BaseAdapter{

        Context mContext;
        List<FunctionMenu> menuList = new ArrayList<>();

        public MyAdapter(Context context) {
            mContext = context;
        }

        public void setData(ArrayList<FunctionMenu> list){
            this.menuList = list;
        }

        @Override
        public int getCount() {
            return menuList.size() == 0 ? 20: menuList.size();//Todo 待处理
        }

        @Override
        public FunctionMenu getItem(int i) {
            return menuList == null ? null : menuList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_function_menu,null);
            return itemView;
        }
    }





}