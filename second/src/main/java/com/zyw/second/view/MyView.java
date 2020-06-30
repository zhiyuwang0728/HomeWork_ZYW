package com.zyw.second.view;
import com.zyw.second.bean.ListBean;
import com.zyw.second.bean.TitleBean;

import java.util.List;
public interface MyView {

    void onTitleSuccess(List<TitleBean.DataBean> data);

    void onListSuccess(List<ListBean.DataBean.DatasBean> data);

    void onFail(String msg);

}
