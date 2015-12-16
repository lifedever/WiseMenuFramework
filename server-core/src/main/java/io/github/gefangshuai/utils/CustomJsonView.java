package io.github.gefangshuai.utils;

import io.github.gefangshuai.server.core.utils.CommonJsonView;

/**
 * 组织Json序列化
 * Created by gefangshuai on 2015/12/16.
 */
public class CustomJsonView {
    /**
     * 对Restaurant进行序列化定义标识
     */
    public interface RestJsonView extends CommonJsonView.CoreJsonView {
    }


}
