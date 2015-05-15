package com.zjk.wifiproject.picture;

import com.squareup.otto.Subscribe;
import com.zjk.wifiproject.presenters.BasePresenterFragment;
import com.zjk.wifiproject.util.FileUtils;

import java.util.List;

public class PictureFragment extends BasePresenterFragment<PictureFolderVu> {

    private List<PictureFolderEntity> list;

    @Override
    protected void onBindVu() {
        list = FileUtils.getPictureFolderList(context);
        vu.setDate(list);
    }

    @Override
    protected Class<PictureFolderVu> getVuClass() {
        return PictureFolderVu.class;
    }

    @Override
    public void onResume() {
        super.onResume();
        vu.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        vu.onPause();
    }


    @Subscribe
    public void showImages(ShowImageListEvent event){
        vu.setListDate(event.list);
    }
}
