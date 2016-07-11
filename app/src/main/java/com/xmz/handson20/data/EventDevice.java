package com.xmz.handson20.data;

/**
 * Created by xmz on 2016/7/11.
 */
public class EventDevice {

    private int mId;

    private String mName;

    private String mType;

    private int mFuncCount;

    private String[] mFuncName;

    private int mPicSrcId;

    private int mCoordinate_x;

    private int mCoordinate_y;

    public EventDevice(String name, String type, int funcCount, String[] funcName, int picSrcId, int coordinate_x, int coordinate_y) {
        mName = name;
        mType = type;
        mFuncCount = funcCount;
        mFuncName = funcName;
        mPicSrcId = picSrcId;
        mCoordinate_x = coordinate_x;
        mCoordinate_y = coordinate_y;
    }

    public EventDevice(int id, String name, String type, int funcCount, String[] funcName, int picSrcId, int coordinate_x, int coordinate_y) {
        mId = id;
        mName = name;
        mType = type;
        mFuncCount = funcCount;
        mFuncName = funcName;
        mPicSrcId = picSrcId;
        mCoordinate_x = coordinate_x;
        mCoordinate_y = coordinate_y;
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

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
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

    public int getCoordinate_x() {
        return mCoordinate_x;
    }

    public void setCoordinate_x(int coordinate_x) {
        mCoordinate_x = coordinate_x;
    }

    public int getCoordinate_y() {
        return mCoordinate_y;
    }

    public void setCoordinate_y(int coordinate_y) {
        mCoordinate_y = coordinate_y;
    }
}
