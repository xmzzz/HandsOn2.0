package com.xmz.handson20.data;

/**
 * Created by xmz on 2016/7/11.
 */
public class DeviceAvailable extends DeviceDescription {

    private DeviceSocket mDeviceSocket;

    public DeviceAvailable(String name, int funcCount, String[] funcName, int picSrcId, String typeFeatureId) {
        super(name, funcCount, funcName, picSrcId, typeFeatureId);
    }

    public DeviceAvailable(int id, String name, int funcCount, String[] funcName, int picSrcId, String typeFeatureId) {
        super(id, name, funcCount, funcName, picSrcId, typeFeatureId);
    }

    public DeviceSocket getDeviceSocket() {
        return mDeviceSocket;
    }

    public void setDeviceSocket(DeviceSocket deviceSocket) {
        mDeviceSocket = deviceSocket;
    }
}
