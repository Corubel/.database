package com.example.petagramm3.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.gridlayout.widget.GridLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.petagramm3.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {
    
    String[] laikanumbers = {"6", "9", "12", "17", "14", "19", "21", "6", "3"};
    int[] laikaimg = {R.drawable.weimanarer0,R.drawable.weimaraner1,R.drawable.weimaraner2,R.drawable.weimaraner3,R.drawable.weimaraner4,R.drawable.weimanarer5,R.drawable.weimanarer6,R.drawable.weimanarer7,R.drawable.weimaraner8};
    int[] huesoimg = {R.mipmap.ic_huesogrid, R.mipmap.ic_huesogrid, R.mipmap.ic_huesogrid, R.mipmap.ic_huesogrid, R.mipmap.ic_huesogrid, R.mipmap.ic_huesogrid, R.mipmap.ic_huesogrid, R.mipmap.ic_huesogrid, R.mipmap.ic_huesogrid};
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }

    }
    public class  CustomAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return laikaimg.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {


            View viewl = getLayoutInflater().inflate(R.layout.raw_data, parent, false);


            TextView numbers =  viewl.findViewById(R.id.perfilnumber);
            ImageView imageView = viewl.findViewById(R.id.weimar);
            ImageView hueso = viewl.findViewById(R.id.huesofragment);

            numbers.setText(laikanumbers[position]);
            imageView.setImageResource(laikaimg[position]);
            hueso.setImageResource(huesoimg[position]);

            return viewl;
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        GridView gridLayout = (GridView) view.findViewById(R.id.gridLaika);
        CustomAdapter customAdapter = new CustomAdapter();
        gridLayout.setAdapter(customAdapter);
        return view;




    }
}