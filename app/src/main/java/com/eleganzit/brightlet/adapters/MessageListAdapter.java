package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.model.GetMessages;
import com.philliphsu.bottomsheetpickers.Utils;

import java.util.ArrayList;

/**
 * Created by Uv on 6/6/2018.
 */

public class MessageListAdapter extends RecyclerView.Adapter
{
    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int SEEN_TYPE_MESSAGE_SENT = 3;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;
    ArrayList<GetMessages> arrayList;
    Context context;

    public MessageListAdapter(ArrayList<GetMessages> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    // Determines the appropriate ViewType according to the sender of the message.
    @Override
    public int getItemViewType(int position) {
        GetMessages message = (GetMessages) arrayList.get(position);

        if (message.getFrom().equalsIgnoreCase("zahir")) {
            // If the current user is the sender of the message
            if(position==arrayList.size()-1){
                // If some other user sent the message
                Toast.makeText(context, "position is last", Toast.LENGTH_SHORT).show();
                return SEEN_TYPE_MESSAGE_SENT;
            }
            return VIEW_TYPE_MESSAGE_SENT;
        }
        else {
            // If some other user sent the message
            return VIEW_TYPE_MESSAGE_RECEIVED;
        }
    }

    // Inflates the appropriate layout according to the ViewType.
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.sent_message_layout, parent, false);
            return new SentMessageHolder(view);
        } else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.received_message_layout, parent, false);
            return new ReceivedMessageHolder(view);
        }
        else if (viewType == SEEN_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.seen_sent_message_layout, parent, false);
            return new SentSeenMessageHolder(view);
        }

        return null;
    }

    // Passes the message object to a ViewHolder so that the contents can be bound to UI.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GetMessages message = (GetMessages) arrayList.get(position);
        int size=arrayList.size();

        Log.d("position : size ",""+position+":"+arrayList.size());

        switch (holder.getItemViewType()) {
            case VIEW_TYPE_MESSAGE_SENT:
                ((SentMessageHolder) holder).bind(message);
                break;
            case VIEW_TYPE_MESSAGE_RECEIVED:
                ((ReceivedMessageHolder) holder).bind(message);
                break;
            case SEEN_TYPE_MESSAGE_SENT:
                ((SentSeenMessageHolder) holder).bind(message);

        }
    }

    private class SentMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText;

        SentMessageHolder(View itemView) {
            super(itemView);

            messageText = (TextView) itemView.findViewById(R.id.text_message_body);
            //timeText = (TextView) itemView.findViewById(R.id.text_message_time);
        }

        void bind(GetMessages message) {
            messageText.setText(message.getMessage());

            // Format the stored timestamp into a readable String using method.
            //timeText.setText(message.getTime());
        }
    }

    private class SentSeenMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText,timeText;

        SentSeenMessageHolder(View itemView) {
            super(itemView);

            messageText = (TextView) itemView.findViewById(R.id.text_message_body);
            timeText = (TextView) itemView.findViewById(R.id.text_message_time);
        }

        void bind(GetMessages message) {
            messageText.setText(message.getMessage());

            // Format the stored timestamp into a readable String using method.
            timeText.setText(message.getTime());
        }
    }

    private class ReceivedMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText;
        ImageView profileImage;

        ReceivedMessageHolder(View itemView) {
            super(itemView);

            messageText = (TextView) itemView.findViewById(R.id.text_message_body);
            profileImage = (ImageView) itemView.findViewById(R.id.image_message_profile);
        }

        void bind(GetMessages message) {
            messageText.setText(message.getMessage());

            // Format the stored timestamp into a readable String using method.
            //timeText.setText(message.getTime());

            //nameText.setText(message.getName());


        }
    }
}
