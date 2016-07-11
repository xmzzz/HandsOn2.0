package com.xmz.handson20.data;

/**
 * Created by xmz on 2016/7/8.
 */
public class DeviceSocket {

    private int mId;

    private int mPicSrcId;

    private String mType;

    public DeviceSocket(int picSrcId, String type) {
        mPicSrcId = picSrcId;
        mType = type;
    }

    public DeviceSocket(int id, int picSrcId, String type) {
        mId = id;
        mPicSrcId = picSrcId;
        mType = type;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getPicSrcId() {
        return mPicSrcId;
    }

    public void setPicSrcId(int picSrcId) {
        mPicSrcId = picSrcId;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }
}
