package com.example.user.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by User on 11/22/2017.
 */

public class ExpantableListAdapter extends BaseExpandableListAdapter
{
    Context context;
    List<String> list;
    Map<String,List<String> > topics;

    public ExpantableListAdapter(Context context, List<String> list, Map<String, List<String>> topics) {
        this.context = context;
        this.list = list;
        this.topics = topics;
    }

    @Override
    public int getGroupCount() {
        //how many parents/elements are there-->list.size()
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //how many child in a particular group/parents
        return topics.get(list.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        //For a particular parent/group
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        //Particular group ar particular child ar jonno
        // -->>1st get() for parent, 2nd get() for child
        return topics.get(list.get(groupPosition)).get(childPosition);
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
// Most important part is strated from here -->these 2 below method
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        //We need to fetch the group
        String language=(String)getGroup(groupPosition);
        //If object jodi created na hoi kebol tokhoni object create korbo
        if(convertView==null){
            //here we need to fetch parent xml in java file
            //it will give you the power to embed the xml file in java file
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(R.layout.list_parent,null);
        }
        //Now we neep update the text view java
        TextView view=(TextView)convertView.findViewById(R.id.textparent);
        view.setText(language);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        String topic=(String)getChild(groupPosition,childPosition);
        if(convertView==null){
            //here we need to fetch child xml in java file
            //it will give you the power to embed the xml file in java file
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(R.layout.list_child,null);
        }
        TextView view=(TextView)convertView.findViewById(R.id.textchild);
        view.setText(topic);
        return convertView;
    }

    //If we want to select the child elelment then return true
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
