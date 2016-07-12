package com.xu.hasee.livewhere.home.hotel_detile.hotel_info;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xu.hasee.livewhere.R;

public class MyAdapter extends BaseExpandableListAdapter {

    private List<GroupEntity> list;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(List<GroupEntity> list, Context context) {
        super();
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    // 返回分组数量
    @Override
    public int getGroupCount() {
        return list.size();
    }

    // 返回分组中子项的数量
    @Override
    public int getChildrenCount(int groupPosition) {

        return list.get(groupPosition).getChildren().size();
    }

    // 获得分组数据
    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    // 获得分组中子项的数据
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getChildren().get(childPosition);
    }

    // 获得组的id
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    // 获得分组中子项的id
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    // 返回组的视图,isExpanded表示列表是否展开
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.group_item, null);
            holder = new GroupHolder();
            holder.iv = (ImageView) convertView.findViewById(R.id.iv);
            holder.name = (TextView) convertView.findViewById(R.id.g_name);
            convertView.setTag(holder);
        } else {
            holder = (GroupHolder) convertView.getTag();
        }
        GroupEntity groupEntity=list.get(groupPosition);

        holder.name.setText(groupEntity.getParent_name());
        if (isExpanded) {
            holder.iv.setImageResource(R.drawable.rounds_open);
        } else {
            holder.iv.setImageResource(R.drawable.rounds_close);
        }
        return convertView;
    }

    // 返回组中子项的视图
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
                             ViewGroup parent) {
        ChildHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.nearby_list_item, null);
            holder = new ChildHolder();
            holder.nearby_name = (TextView) convertView.findViewById(R.id.nearby_name);
            holder.nearby_phome = (TextView) convertView.findViewById(R.id.nearby_phome);
            holder.distance= ((TextView) convertView.findViewById(R.id.distance));
            holder.address= ((TextView) convertView.findViewById(R.id.address));
            holder.imageview= ((ImageView) convertView.findViewById(R.id.imageview));
            convertView.setTag(holder);
        } else {
            holder = (ChildHolder) convertView.getTag();
        }
        ChildEntity childEntity = list.get(groupPosition).getChildren().get(childPosition);
        holder.nearby_name.setText(childEntity.getName());
        holder.nearby_phome.setText(childEntity.getTelphone());
        holder.distance.setText(childEntity.getDistance());
        holder.address.setText(childEntity.getAddress());
        Picasso.with(context).load(childEntity.getPicture()).into(holder.imageview);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // 返回true表示让setOnChildClickListener方法得到响应
        return true;
    }

    class GroupHolder {
        TextView name;
        ImageView iv;
    }

    class ChildHolder {
        ImageView imageview;
        TextView nearby_name,nearby_phome,distance,address;
    }

}
