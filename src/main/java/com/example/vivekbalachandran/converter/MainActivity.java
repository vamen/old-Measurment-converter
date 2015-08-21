package com.example.vivekbalachandran.converter;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
   HashMap<String,List<String>> data= new HashMap<String,List<String>>() ;
    myadapter myadap;
    final String[] clist= {
            " Length_Conversions",
            " Temperature_Conversions",
            " weight_Conversions",
            " Area_Conversions",
            " Time_Conversions",
            " Speed _Conversions",
            " volume_Conversion",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> converter_streems= new ArrayList<>(Arrays.asList(clist));
        data=Dataprovider.getDataprovider();

       myadap = new myadapter(this,data,converter_streems);
        ExpandableListView listview=(ExpandableListView)findViewById(R.id.listView);
        listview.setAdapter(myadap);

              listview.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                  public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                      Intent calculate=new Intent(MainActivity.this,Units.class);
                      int[] args={groupPosition,childPosition};
                      calculate.putExtra("EXTRA_VALES",args);
                      startActivity(calculate);

                      return true;
                  }

              });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
           startActivity(new Intent(MainActivity.this,mysetting_activity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   public  class myadapter extends BaseExpandableListAdapter{

       Context ctx;
       HashMap<String,List<String>> data = new HashMap<String ,List<String>>();
       List<String> clist= new LinkedList<>();

       public myadapter(Context ctx,HashMap<String,List<String>> data,List<String> clist)
       {
           this.ctx=ctx;
           this.data=data;
           this.clist=clist;

       }
       @Override
       public Object getChild(int groupPosition, int childPosition) {

           return Dataprovider.getchildname(groupPosition,childPosition);
       }
       @Override
       public int getGroupTypeCount() {
           return super.getGroupTypeCount();
       }

       @Override
       public int getGroupType(int groupPosition) {
           return super.getGroupType(groupPosition);
       }

       @Override
       public int getChildTypeCount() {
           return super.getChildTypeCount();
       }

       @Override
       public int getChildType(int groupPosition, int childPosition) {
           return super.getChildType(groupPosition, childPosition);
       }

       @Override
       public void registerDataSetObserver(DataSetObserver observer) {
           super.registerDataSetObserver(observer);
       }

       @Override
       public void unregisterDataSetObserver(DataSetObserver observer) {
           super.unregisterDataSetObserver(observer);
       }

       @Override
       public void notifyDataSetInvalidated() {
           super.notifyDataSetInvalidated();
       }

       @Override
       public void notifyDataSetChanged() {
           super.notifyDataSetChanged();
       }

       @Override
       public boolean areAllItemsEnabled() {
           return super.areAllItemsEnabled();
       }

       @Override
       public long getCombinedChildId(long groupId, long childId) {
           return super.getCombinedChildId(groupId, childId);
       }

       @Override
       public long getCombinedGroupId(long groupId) {
           return super.getCombinedGroupId(groupId);
       }

       @Override
       public boolean isEmpty() {
           return super.isEmpty();
       }

       @Override
       protected Object clone() throws CloneNotSupportedException {
           return super.clone();
       }

       @Override
       public boolean equals(Object o) {
           return super.equals(o);
       }

       @Override
       protected void finalize() throws Throwable {
           super.finalize();
       }

       @Override
       public int hashCode() {
           return super.hashCode();
       }

       @Override
       public String toString() {
           return super.toString();
       }

       @Override
       public boolean isChildSelectable(int groupPosition, int childPosition) {
           return true;
       }

       @Override
       public void onGroupCollapsed(int groupPosition) {
           super.onGroupCollapsed(groupPosition);
       }

       @Override
       public boolean hasStableIds() {
           return false;
       }


       @Override
       public void onGroupExpanded(int groupPosition) {

           super.onGroupExpanded(groupPosition);
       }

       @Override
       public int getGroupCount() {
           return clist.size();
       }

       @Override
       public int getChildrenCount(int groupPosition) {

           return Dataprovider.getsize(groupPosition);
       }

       @Override
       public Object getGroup(int groupPosition) {
           return clist.get(groupPosition);
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
       public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
          // String grp_name=(String)clist.get(groupPosition);
           String grp_name=(String)getGroup(groupPosition);
           if(convertView==null)
           {
               LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               convertView = inflater.inflate(R.layout.listcast,parent,false);
           }
           TextView grp_text=(TextView)convertView.findViewById(R.id.listcasting);
           grp_text.setText(grp_name);

           return convertView;
       }

       @Override
       public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
           String child_name=new String();
           child_name=(String)getChild(groupPosition,childPosition);
           if(convertView==null)
           {
               LayoutInflater inflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               convertView=inflater.inflate(R.layout.childlist,parent,false);

           }
           TextView child_text=(TextView)convertView.findViewById(R.id.childtext);
           child_text.setText(child_name);

           return convertView;
       }
   }
}
