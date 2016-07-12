package com.xu.hasee.livewhere.home.hotel_detile.hotel_info;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.xu.hasee.livewhere.R;

import java.util.List;

/**
 * Created by hasee on 2016/5/16.
 */
public class MyAdapter_comments extends BaseExpandableListAdapter {
    private List<MyEntity_comments> list;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter_comments(List<MyEntity_comments> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return list.get(0).getContent().get(0).getUsername().length();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }


    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.comments_group_item, null);
            holder = new GroupHolder();
            holder.username = ((TextView) convertView.findViewById(R.id.username));
            holder.time = ((TextView) convertView.findViewById(R.id.time));
            convertView.setTag(holder);
        } else {
            holder = ((GroupHolder) convertView.getTag());
        }
        List<MyEntity_content> content = list.get(0).getContent();
        MyEntity_content myEntity_content = content.get(groupPosition);
        holder.username.setText(myEntity_content.getUsername());
        holder.time.setText(myEntity_content.getTime());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.child_item, null);
            holder = new ChildHolder();
            holder.content_item = ((TextView) convertView.findViewById(R.id.content_item));
            convertView.setTag(holder);
        } else {
            holder = ((ChildHolder) convertView.getTag());
        }
        List<MyEntity_content> content = list.get(0).getContent();
//        Log.d("tag","grouppostion="+groupPosition);
       MyEntity_content myEntity_content=content.get(groupPosition);
       /* Log.d("tag", "grouppostion=" + groupPosition);*/
        holder.content_item.setText(myEntity_content.getContent());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class GroupHolder {
        TextView username;
        TextView time;
    }

    class ChildHolder {
        TextView content_item;
    }
}
