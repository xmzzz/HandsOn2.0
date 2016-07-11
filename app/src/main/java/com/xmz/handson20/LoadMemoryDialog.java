package com.xmz.handson20;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.xmz.handson20.data.MemoryDatabaseNameFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xmz on 2016/7/8.
 */
public class LoadMemoryDialog extends DialogFragment {

    private ListView mListView;

    private TextView mEditTV;

    private TextView mDeleteTV;

    private boolean isEdit = false;

    private MyListAdapter mAdapter;

    private MemoryDatabaseNameFactory mMemoryDatabaseNameFactory;

    List<String> allMemoryName;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        allMemoryName = new ArrayList<String>();
        mMemoryDatabaseNameFactory = MemoryDatabaseNameFactory.getInstance(getActivity());
        allMemoryName = mMemoryDatabaseNameFactory.getAllMemoryName();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View memoryLayout = inflater.inflate(R.layout.memory_dialog_layout, null);
        mListView = (ListView) memoryLayout.findViewById(R.id.memoryList);
        mEditTV = (TextView) memoryLayout.findViewById(R.id.dialog_edit_tv);
        mEditTV.setOnClickListener(editOnClickListener);
        mDeleteTV = (TextView) memoryLayout.findViewById(R.id.dialog_delete_tv);
        mDeleteTV.setOnClickListener(deleteOnClickListener);
        mDeleteTV.setVisibility(View.GONE);
        mAdapter = new MyListAdapter(getActivity(), mListView);
        mListView.setAdapter(mAdapter);
//        mListView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_multiple_choice, allMemoryName));
//        mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        mListView.setChoiceMode(ListView.CHOICE_MODE_NONE);
        mListView.setOnItemClickListener(modeNoneItemListener);

        builder.setView(memoryLayout);
        return builder.create();
    }

    View.OnClickListener editOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isEdit) {
                isEdit = false;
                mListView.setChoiceMode(ListView.CHOICE_MODE_NONE);
                mEditTV.setText("编辑");
                mListView.setOnItemClickListener(modeNoneItemListener);
                mDeleteTV.setVisibility(View.GONE);
                mAdapter.notifyDataSetChanged();
            } else {
                isEdit = true;
                mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                mEditTV.setText("确定");
                mListView.setOnItemClickListener(modeMultipleItemListener);
                mDeleteTV.setVisibility(View.VISIBLE);
                mListView.clearChoices();
            }
        }
    };

    View.OnClickListener deleteOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String string;
            for (int i = 0; i < mListView.getCount(); i++) {
                if (mListView.isItemChecked(i)) {
                    string = (String) mListView.getItemAtPosition(i);
                    mMemoryDatabaseNameFactory.deleteMemory(string);
                    getActivity().deleteDatabase(string);
                }
            }
            mListView.clearChoices();
            allMemoryName = mMemoryDatabaseNameFactory.getAllMemoryName();
            mAdapter.notifyDataSetChanged();
        }
    };

    AdapterView.OnItemClickListener modeNoneItemListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d("noneListener", position + "");
            String selectedDatabaseName;
            selectedDatabaseName = (String) mListView.getItemAtPosition(position);
            copyDatabase(selectedDatabaseName, MemoryDatabaseNameFactory.getDefaultDatabaseName());
            Intent intent = new Intent(getContext(), DeviceConnectActivity.class);
            startActivity(intent);
            LoadMemoryDialog.this.dismiss();
        }
    };

    AdapterView.OnItemClickListener modeMultipleItemListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mAdapter.notifyDataSetChanged();
            String[] nowSelected;
            nowSelected = new String[mListView.getCheckedItemCount()];
            for (int i = 0, j = 0; i < mListView.getCount(); i++) {
                if (mListView.isItemChecked(i)) {
                    nowSelected[j] = (String) mListView.getItemAtPosition(i);
                    j++;
                }
            }

            String string = "";
            for (int i=0; i<nowSelected.length; i++) {
                string += nowSelected[i] + " ";
            }

            Log.d("multipleClick", string);

        }
    };

    private class MyListAdapter extends BaseAdapter {
        private Context mContext;
        private ListView mListView;

//        private String[] mStrings = {
//                "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam",
//                "Abondance", "Ackawi", "Acorn",
//                "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag",
//                "Airedale", "Aisy Cendre",
//                "Allgauer Emmentaler", "Alverca", "Ambert", "American Cheese",
//                "Ami du Chambertin", "Anejo Enchilado",
//                "Anneau du Vic-Bilh", "Anthoriro"};

        public MyListAdapter(Context context, ListView list) {
            mContext = context;
            mListView = list;
        }

        public int getCount() {
//            return mStrings.length;
            return allMemoryName.size();
        }

        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEnabled(int position) {
            String string = allMemoryName.get(position);
            return !string.startsWith("-");
//            return !mStrings[position].startsWith("-");
        }

        public Object getItem(int position) {
            return allMemoryName.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv;
            if (convertView == null) {
                tv = (TextView) LayoutInflater.from(mContext).inflate(
                        R.layout.list_item, parent,
                        false);
            } else {
                tv = (TextView) convertView;
            }
//            tv.setText(mStrings[position]);
            tv.setText(allMemoryName.get(position));
            updateBackground(position, tv);
            return tv;
        }

        public void updateBackground(int position, View view) {
            int backgroundId;
            if (mListView.isItemChecked(position)) {
                backgroundId = R.drawable.list_selected_holo_light;
            } else {
                backgroundId = R.drawable.conversation_item_background_read;
            }
            Drawable background = mContext.getResources().getDrawable(backgroundId);
            view.setBackground(background);
        }

    }

    public void copyDatabase(String srcName, String dstName) {
        File srcFile = getActivity().getDatabasePath(srcName);
        File dstFile = new File(getActivity().getDatabasePath(srcName).getParent(), dstName);
        try {
            copyFile(srcFile, dstFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if (!destFile.getParentFile().exists()) {
            destFile.getParentFile().mkdirs();
        }

        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;

        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());

        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
    }
}
