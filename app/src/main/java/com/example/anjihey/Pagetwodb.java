package com.example.anjihey;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Pagetwodb.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Pagetwodb#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pagetwodb extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Pagetwodb() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Pagetwodb.
     */
    // TODO: Rename and change types and number of parameters
    public static Pagetwodb newInstance(String param1, String param2) {
        Pagetwodb fragment = new Pagetwodb();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

///////////////////////// DB //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        final DBHelper dbHelper = new DBHelper(getActivity().getApplicationContext(), "LikeThing.db", null, 1);

        View v = inflater.inflate(R.layout.fragment_pagetwodb, container, false);

        final TextView result = (TextView) v.findViewById(R.id.r);

        final EditText Tname = (EditText) v.findViewById(R.id.name);
        final EditText Tage = (EditText) v.findViewById(R.id.age);
        final EditText Tcolor = (EditText) v.findViewById(R.id.color);
        final EditText Tfood = (EditText) v.findViewById(R.id.food);

        Button insert = (Button) v.findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Tname.getText().toString();
                int age = Integer.parseInt(Tage.getText().toString()); // string으로 변환
                String color = Tcolor.getText().toString();
                String food = Tfood.getText().toString();

                dbHelper.insert(name, age, color, food);

                Tname.setText(null);
                Tage.setText(null);
                Tcolor.setText(null);
                Tfood.setText(null);

                result.setText(dbHelper.getResult()); //헬퍼에서 만들어 놓은 getresult
            }
        });

        Button update = (Button) v.findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String color = Tcolor.getText().toString();
                String name = Tname.getText().toString();
                dbHelper.update(name, color);
                result.setText(dbHelper.getResult());
                Tname.setText(null);
                Tcolor.setText(null);
            }
        });

        Button delete = (Button) v.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Tname.getText().toString();

                Tname.setText(null);

                dbHelper.delete(name);
                result.setText(dbHelper.getResult());
            }
        });

        Button select = (Button) v.findViewById(R.id.Lookup);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(dbHelper.getResult());
            }
        });

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        */
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
