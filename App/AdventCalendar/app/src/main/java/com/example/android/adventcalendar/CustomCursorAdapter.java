/*
* Copyright (C) 2016 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.adventcalendar;

import android.content.Context;
import android.database.Cursor;
import java.util.Calendar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;

import com.example.android.adventcalendar.data.TaskContract;


/**
 * This CustomCursorAdapter creates and binds ViewHolders, that hold the description and priority of a task,
 * to a RecyclerView to efficiently display data.
 */
public class CustomCursorAdapter extends RecyclerView.Adapter<CustomCursorAdapter.TaskViewHolder> {

    // Class variables for the Cursor that holds task data and the Context
    private Cursor mCursor;
    private Context mContext;
    public ListItemClickListener mOnClickListener;


    public interface ListItemClickListener {
        void onListItemClick(View v,int clickedItemIndex);
    }

    /**
     * Constructor for the CustomCursorAdapter that initializes the Context.
     *
     * @param mContext the current Context
     */
    public CustomCursorAdapter(Context mContext,ListItemClickListener listener) {
        this.mContext = mContext;
        mOnClickListener = listener;
    }



    /**
     * Called when ViewHolders are created to fill a RecyclerView.
     *
     * @return A new TaskViewHolder that holds the view for each task
     */
    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Inflate the task_layout to a view
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.task_layout, parent, false);

        return new TaskViewHolder(view);
    }


    /**
     * Called by the RecyclerView to display data at a specified position in the Cursor.
     *
     * @param holder The ViewHolder to bind Cursor data to
     * @param position The position of the data in the Cursor
     */
    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {

        // Indices for the _id, description, and priority columns
        int idIndex = mCursor.getColumnIndex(TaskContract.TaskEntry._ID);
        int descriptionIndex = mCursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_DESCRIPTION);
        int yearIndex =mCursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_YEAR);
        int monthIndex =mCursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_MONTH);
        int dayIndex =mCursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_DAY);
        int timeInMillsIndex =mCursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_TIME_IN_MILLS);

        mCursor.moveToPosition(position); // get to the right location in the cursor

        // Determine the values of the wanted data
        final int id = mCursor.getInt(idIndex);
        String description = mCursor.getString(descriptionIndex);
        int year = mCursor.getInt(yearIndex);
        int month = mCursor.getInt(monthIndex);
        int day = mCursor.getInt(dayIndex);
        long eventTimeInMills = mCursor.getLong(timeInMillsIndex);

        //Set values
        holder.itemView.setTag(id);
        holder.taskDescriptionView.setText(description);

        //set dayView
        String rest_time=restTime(eventTimeInMills)+"天";
        String deadline =String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day);
        holder.dayView.setText(deadline+"\t\t"+rest_time);

    }





    /**
     * Returns the number of items to display.
     */
    @Override
    public int getItemCount() {
        if (mCursor == null) {
            return 0;
        }
        return mCursor.getCount();
    }


    /**
     * When data changes and a re-query occurs, this function swaps the old Cursor
     * with a newly updated Cursor (Cursor c) that is passed in.
     */
    public Cursor swapCursor(Cursor c) {
        // check if this cursor is the same as the previous cursor (mCursor)
        if (mCursor == c) {
            return null; // bc nothing has changed
        }
        Cursor temp = mCursor;
        this.mCursor = c; // new cursor value assigned

        //check if this is a valid cursor, then update the cursor
        if (c != null) {
            this.notifyDataSetChanged();
        }
        return temp;
    }


    // Inner class for creating ViewHolders
    public class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // Class variables for the task description and priority TextViews
        TextView taskDescriptionView;
        TextView dayView;

        /**
         * Constructor for the TaskViewHolders.
         *
         * @param itemView The view inflated in onCreateViewHolder
         */
        private TaskViewHolder(View itemView) {
            super(itemView);

            taskDescriptionView = (TextView) itemView.findViewById(R.id.taskDescription);
            dayView =(TextView) itemView.findViewById(R.id.dayView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(v,clickedPosition);
        }
    }

    /**
     *  把（事件時間-現在時間）轉為天數，再判斷 還有OR已過
     *
     * @return Day in String
     */
    private String restTime(long eventTimeInMills)
    {
        String restDay;
        Calendar c=Calendar.getInstance();
        float rest=((float)(eventTimeInMills-c.getTimeInMillis())/(60 * 60 * 24 * 1000));
        if (rest>0) {
            rest+=1;
            restDay="還有"+String.valueOf((int)rest);
        }
        else{
            rest=rest*(-1);
            restDay="已過"+String.valueOf((int)rest);
        }
        Log.v("index",String.valueOf(rest));
        return restDay;
    }
}