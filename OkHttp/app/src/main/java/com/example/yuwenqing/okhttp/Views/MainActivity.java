package com.example.yuwenqing.okhttp.Views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yuwenqing.okhttp.Presenters.TranslationPresenter;
import com.example.yuwenqing.okhttp.R;

public class MainActivity extends MvpBaseActivity<TranslationPresenter>{

    TextView textView=null;
    EditText editText=null;
    Button button=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化
        initViews();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getTranslationResultAndShow();
            }
        });
    }

    private void initViews() {
        button=(Button)findViewById(R.id.send);
        textView=(TextView)findViewById(R.id.msg);
        editText=(EditText)findViewById(R.id.text);
        createPresenter();
    }



    //得到原数据，供presenter调用。
    @Override
    public String getSrc() {
        String content=editText.getText().toString();
        Log.i("TAG",content);
        if(content!=null)
        {
            return content;
        }
        return null;
    }

    //显示翻译结果，供presenter调用
    @Override
    public void showTrg(String result) {
        textView.setText(result);
        editText.setText("");
    }

    @Override
    protected void createPresenter() {
        mPresenter=new TranslationPresenter();
        mPresenter.attachView(MainActivity.this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
