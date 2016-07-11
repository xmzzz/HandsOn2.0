package com.xmz.handson20.data;

/**
 * Created by xmz on 2016/7/8.
 */
public class DeviceDescription {

    private int mId;

    private String mName;

    private int mFuncCount;

    private String[] mFuncName;

    private int mPicSrcId;

    private String mTypeFeatureId;

    public DeviceDescription(String name, int funcCount, String[] funcName, int picSrcId, String typeFeatureId) {
        mName = name;
        mFuncCount = funcCount;
        mFuncName = funcName;
        mPicSrcId = picSrcId;
        mTypeFeatureId = typeFeatureId;
    }

    public DeviceDescription(int id, String name, int funcCount, String[] funcName, int picSrcId, String typeFeatureId) {
        mId = id;
        mName = name;
        mFuncCount = funcCount;
        mFuncName = funcName;
        mPicSrcId = picSrcId;
        mTypeFeatureId = typeFeatureId;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getFuncCount() {
        return mFuncCount;
    }

    public void setFuncCount(int funcCount) {
        mFuncCount = funcCount;
    }

    public String[] getFuncName() {
        return mFuncName;
    }

    public void setFuncName(String[] funcName) {
        mFuncName = funcName;
    }

    public int getPicSrcId() {
        return mPicSrcId;
    }

    public void setPicSrcId(int picSrcId) {
        mPicSrcId = picSrcId;
    }

    public String getTypeFeatureId() {
        return mTypeFeatureId;
    }

    public void setTypeFeatureId(String typeFeatureId) {
        mTypeFeatureId = typeFeatureId;
    }

}
