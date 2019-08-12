package com.amit.myapplication1;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.amrdeveloper.reactbutton.ReactButton;
import com.amrdeveloper.reactbutton.Reaction;

import java.util.ArrayList;
import java.util.List;

public class MessageListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final static int TYPE_Others=1,TYPE_Self=2;
    private List<MessageModel> messages =new ArrayList();
    // Context is not used here but may be required to
    // perform complex operations or call methods from outside
    private Context context;

    // Constructor
    public MessageListAdapter(Context context){
        this.context=context;
    }


    public void setMessages(List<MessageModel> messages) {
        this.messages = messages;
    }


    @Override
    public int getItemViewType(int position) {
        if (messages.get(position).isSendByOthers() == true) {
            return TYPE_Others;
        } else {
            return TYPE_Self;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Attach layout for single cell
        int layout = 0;
        RecyclerView.ViewHolder viewHolder;
        // Identify viewType returned by getItemViewType(...)
        // and return ViewHolder Accordingly
        switch (i){
            case TYPE_Others:
                layout=R.layout.cell1;
                View callsView = LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(layout, viewGroup, false);
                viewHolder=new OthersmessageHolder(callsView);
                break;
            case TYPE_Self:
                layout=R.layout.cell2;
                View smsView = LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(layout, viewGroup, false);
                viewHolder=new SelfmessageHolder(smsView);
                break;
            default:
                viewHolder=null;
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int viewType=viewHolder.getItemViewType();
        switch (viewType){
            case TYPE_Others:
                MessageModel model = messages.get(i);
                ((OthersmessageHolder)viewHolder).showDetails(model);
                break;
            case TYPE_Self:
                MessageModel selfmodel = messages.get(i);
                ((SelfmessageHolder)viewHolder).showDetails(selfmodel);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class SelfmessageHolder extends RecyclerView.ViewHolder {

        private TextView mesageTV,timeTV;

        public SelfmessageHolder(View itemView) {
            super(itemView);
            // Initiate view
            mesageTV=(TextView)itemView.findViewById(R.id.msglbl);
            timeTV=(TextView)itemView.findViewById(R.id.timelbl);
        }

        public void showDetails(MessageModel model){
            // Attach values for each ite
            mesageTV.setText(model.getMessage());
            timeTV.setText(model.getTime());
        }
    }

    public class OthersmessageHolder extends RecyclerView.ViewHolder {

        private TextView mesageTV,timeTV,nameHeaderlbl;
        FrameLayout root;

        public OthersmessageHolder(View itemView) {
            super(itemView);
            // Initiate view
            mesageTV=(TextView)itemView.findViewById(R.id.deslbl);
            timeTV=(TextView)itemView.findViewById(R.id.timelbl);
            nameHeaderlbl=(TextView)itemView.findViewById(R.id.namelbl);
            root=itemView.findViewById(R.id.root);
        }

        public void showDetails(MessageModel model){
            // Attach values for each ite

            mesageTV.setText(model.getMessage());
            timeTV.setText(model.getSenderName()+" "+
                    model.getTime());
            String name = String.valueOf(model.getSenderName().charAt(0));
            nameHeaderlbl.setText(name);
            ReactButton reactButton = new ReactButton(context);
            reactButton.setBackgroundColor(Color.TRANSPARENT);
           // reactButton.setDefaultReaction(new Reaction().getReactIconId());
            root.addView(reactButton);



        }
    }
}
