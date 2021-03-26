package com.luis.luisgoogleproject.ui.dialog;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.luis.luisgoogleproject.R;
import com.luis.luisgoogleproject.base.BaseDialogFragment;

/**
 * author : luis
 * e-mail : luis.gong@cardinfolink.com
 * date   : 2021/3/16  16:36
 * desc   :
 *         CashDialog.Builder builder = new CashDialog.Builder();
 *         CashDialog dialog = builder.setTitle("提现结果")
 *                 .setImg(drawable)
 *                 .setMsg(msg)
 *                 .build();
 *         dialog.setOnConfirmClickListener(new CashDialog.OnClickListener() {
 *             @Override
 *             public void onClick() {
 *                 if (isSuc) {
 *                     dialog.dismissAllowingStateLoss();
 *                     CashActivity.this.finish();
 *                 }else{
 *                     dialog.dismissAllowingStateLoss();
 *                 }
 *             }
 *         });
 *          dialog.showAllowingStateLoss(getSupportFragmentManager(),"CashDialog");
 */
public class CashDialog extends BaseDialogFragment {

    private TextView mCashTitle;
    private ImageView mCashImg;
    private TextView mCashMsg;
    private Builder builder;
    private Button mConfirmBtn;
    private OnClickListener onclickListener;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //step3, get the data from the builder and set to the widget
        if (builder!= null) {
            if (!TextUtils.isEmpty(builder.title)) {
                mCashTitle.setText(builder.title);
            }
            if (!TextUtils.isEmpty(builder.msg)){
                mCashMsg.setText(builder.msg);
            }
            if (builder.drawable !=null) {
                mCashImg.setImageDrawable(builder.drawable);
            }
            if (builder.confirmClickListener != null) {
                mConfirmBtn.setOnClickListener(builder.confirmClickListener);
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_cash, container, false);
        initView(view);
        return view;
    }

    //step1, find the id
    private void initView(View view) {
        mCashTitle = view.findViewById(R.id.cash_title);
        mCashImg = view.findViewById(R.id.cash_img);
        mCashMsg = view.findViewById(R.id.cash_msg);
        ImageView backIv = view.findViewById(R.id.cash_back);
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissAllowingStateLoss();
            }
        });
        mConfirmBtn = view.findViewById(R.id.cash_confirm);
        mConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickListener.onClick();
            }
        });
    }

    public void setOnConfirmClickListener(OnClickListener onClickListener){
        this.onclickListener = onClickListener;
    }
    public interface OnClickListener{
        void onClick();
    }


    private void setBuilder(Builder builder) {
        this.builder = builder;
    }

    //step2, definition Builder to control the widget
    public static class Builder{
        private String title;
        private String msg;
        private Drawable drawable;
        private View.OnClickListener confirmClickListener;

        public Builder() {
        }

        public Builder setTitle(String title){
            this.title = title;
            return this;
        }

        public Builder setMsg(String msg){
            this.msg = msg;
            return this;
        }

        public Builder setImg(Drawable drawable){
            this.drawable = drawable;
            return this;
        }
        public Builder setConfirmClickListener(View.OnClickListener listener){
            this.confirmClickListener = listener;
            return this;
        }

        public CashDialog build(){
            CashDialog cashDialog = new CashDialog();
            cashDialog.setBuilder(this);
            return cashDialog;
        }
    }
}
