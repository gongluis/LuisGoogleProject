package com.luis.luisgoogleproject.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.luis.luisgoogleproject.R;
import com.luis.luisgoogleproject.base.BaseFragment;
import com.luis.luisgoogleproject.data.database.Student;
import com.luis.luisgoogleproject.databinding.FragmentContactBinding;
import com.luis.luisgoogleproject.request.RequestCollectViewModel;
import com.luis.luisgoogleproject.ui.adapter.CollectAdapter;

import java.util.List;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ContactFragment extends BaseFragment {

    private RequestCollectViewModel mCollectViewModel;
    private FragmentContactBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCollectViewModel = new ViewModelProvider(this).get(RequestCollectViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contact,container, false);
        showActionBar();
        binding = FragmentContactBinding.bind(root);
        binding.setVm(mCollectViewModel);
        binding.setClick(new ProxyClick());
        binding.setLifecycleOwner(this);


        //初始化适配器然后设置给列表
        CollectAdapter collectAdapter = new CollectAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(collectAdapter);

        mCollectViewModel.getStudentsLive().observe(getViewLifecycleOwner(), new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                collectAdapter.setAllStudents(students);
                collectAdapter.notifyDataSetChanged();
            }
        });

        return root;
    }



    public class ProxyClick{
        //插入数据
        public void insertData(){
            String[] names = {
                    "吴彦祖",
                    "刘德华",
                    "黎明",
                    "郭富城",
                    "张家辉",
                    "梁家辉",
                    "古天乐",
                    "张三",
                    "李四",
                    "王五",
                    "赵六",
                    "李二麻子"
            };
            int[] ages = {
                    43,
                    24,
                    19,
                    83,
                    64,
                    21,
                    56,
                    32,
                    17,
                    32,
                    45,
                    14
            };

            for(int i = 0;i<names.length;i++){
                mCollectViewModel.touchOffInsertStudents(new Student(names[i],ages[i]));
            }
        }

        //清空列表
        public void clearData(){
            mCollectViewModel.touchOffDeleteAllWords();
        }

    }
}