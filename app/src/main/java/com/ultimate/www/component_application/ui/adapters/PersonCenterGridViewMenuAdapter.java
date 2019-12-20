package com.ultimate.www.component_application.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ultimate.www.component_application.R;
import com.ultimate.www.component_application.data.PersonCenterMenuBean;

import java.util.ArrayList;
import java.util.List;

public class PersonCenterGridViewMenuAdapter extends BaseAdapter {

    private Context context = null;
    private LayoutInflater inflater = null;
    private List<PersonCenterMenuBean> list = new ArrayList<>();
    private int mUnreadCount;

    public PersonCenterGridViewMenuAdapter(Context context) {
        // 布局装载器对象
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    //设置菜单数据
    public void setMenuData(List<PersonCenterMenuBean> list, int unreadCount){
        this.list = list;
        mUnreadCount = unreadCount;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public PersonCenterMenuBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.person_center_grid_view_menus, null);
            viewHolder.menuIcon = (ImageView) convertView.findViewById(R.id.menu_icon_iv);
            viewHolder.menuNames = (TextView) convertView.findViewById(R.id.menu_name_tv);
            viewHolder.unReandMsg = (TextView) convertView.findViewById(R.id.unread_msg_tv);
            convertView.setTag(viewHolder);
        }  else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

//        int unreadNum = NIMClient.getService(MsgService.class).getTotalUnreadCount();
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        params.addRule(RelativeLayout.RIGHT_OF, R.id.menu_icon_iv);
//        params.width = 40;
//        params.height = 22;
//        if (unreadNum>99){
//            if (position == 2){
//                viewHolder.unReandMsg.setVisibility(View.VISIBLE);
//                viewHolder.unReandMsg.setBackgroundResource(R.drawable.shape_solid_red_bg);
//                viewHolder.unReandMsg.setLayoutParams(params);
//                viewHolder.unReandMsg.setText("99+");
//            }
//        }else if (unreadNum>0){
//            if (position == 2){
//                viewHolder.unReandMsg.setVisibility(View.VISIBLE);
//                viewHolder.unReandMsg.setBackgroundResource(R.drawable.shape_common_circle_red_bg);
//                viewHolder.unReandMsg.setText(unreadNum+"");
//            }
//        }

        if (position == 2){
            if (mUnreadCount>0){
                viewHolder.unReandMsg.setVisibility(View.VISIBLE);
            }else {
                viewHolder.unReandMsg.setVisibility(View.GONE);
            }
        }else {
            viewHolder.unReandMsg.setVisibility(View.GONE);
        }

        viewHolder.menuNames.setText(list.get(position).getMenuName());
        int menuIcon = list.get(position).getMenuIcon();
        Glide.with(context).load(context.getResources().getDrawable(menuIcon)).into(viewHolder.menuIcon);
        return convertView;
    }

    class ViewHolder {
        TextView unReandMsg;
        ImageView menuIcon;
        TextView menuNames;
    }

}
