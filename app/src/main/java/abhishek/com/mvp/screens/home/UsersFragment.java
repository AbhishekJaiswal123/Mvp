package abhishek.com.mvp.screens.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import abhishek.com.mvp.R;
import abhishek.com.mvp.adapter.UserAdapter;
import abhishek.com.mvp.data.model.UserModel;

/**
 * Created by abhishek on 10/11/16.
 */

public class UsersFragment extends Fragment implements UserContract.View{


    private UserAdapter mUserAdapter;
    private UserContract.Presenter mPresenter;

    public static UsersFragment newInstance() {
        return new UsersFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserAdapter = new UserAdapter(new ArrayList<UserModel>(0));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users,container,false);
        ListView listView = (ListView) view.findViewById(R.id.user_list_lv);
        listView.setAdapter(mUserAdapter);

        return view;
    }


    @Override
    public void showUsers(List<UserModel> users) {
        mUserAdapter.replaceData(users);
    }

    @Override
    public void setPresenter(UserContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
