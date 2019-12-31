package com.ultimate.www.component_application.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.ultimate.www.component_application.R;


public class GlideUtils {

    /**
    * @日期 2019/12/24 10:06
    * @Processor libao
    * @Description 中文官网 https://muyangmin.github.io/glide-docs-cn/doc/placeholders.html
    * @Parameter url 图片地址
    * @Parameter resId 本地图片资源id
    * @Parameter radius 设置图片圆角
    */
    public static void setRadius(Context context, String url,int resId,ImageView view, int radius){

        RequestOptions requestOptions = new RequestOptions()
        .timeout(10000)
        .centerCrop()
        .transform(new RoundedCorners(radius))
        .error(R.mipmap.ic_load_err);

        if (TextUtils.isEmpty(url)){
            Glide.with(context).load(resId).apply(requestOptions).into(view);
        }else {
            Glide.with(context).load(url).apply(requestOptions).into(view);
        }


    }



}
