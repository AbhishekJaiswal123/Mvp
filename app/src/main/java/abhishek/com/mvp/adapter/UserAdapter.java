package abhishek.com.mvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import abhishek.com.mvp.R;
import abhishek.com.mvp.data.model.UserModel;

/**
 * Created by abhishek on 10/11/16.
 */

public class UserAdapter extends BaseAdapter {

    private List<UserModel> mUsers;

    public UserAdapter(List<UserModel> users) {
        setList(users);

    }

    public void replaceData(List<UserModel> users) {
        setList(users);
        notifyDataSetChanged();
    }

    private void setList(List<UserModel> users) {
        mUsers = users;
    }

    @Override
    public int getCount() {
        return mUsers.size();
    }

    @Override
    public UserModel getItem(int i) {
        return mUsers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = view;
        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            rowView = inflater.inflate(R.layout.list_item_user, viewGroup, false);
        }

        final UserModel user = getItem(i);

        TextView userName = (TextView) rowView.findViewById(R.id.username_tv);
        userName.setText(user.getUser_name());
        TextView userMail = (TextView) rowView.findViewById(R.id.usermail_tv);
        userMail.setText(user.getUser_mail());



        return rowView;
    }
}