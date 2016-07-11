package com.xmz.handson20.addeventdevice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xmz.handson20.data.EventDevice;

import java.util.List;

/**
 * Created by xmz on 2016/7/11.
 */
public class AddEventDeviceFragment extends Fragment {

    private List<EventDevice> mEventDevices;

    @Override
    public void onResume() {
        super.onResume();
        EventDevice eventDevice = mEventDevices.get(i);
        eventDevice.getCoordinate_x();
        eventDevice.getPicSrcId();
         imageView =
        View view;
        view.setTag(eventDevice);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    }
}
