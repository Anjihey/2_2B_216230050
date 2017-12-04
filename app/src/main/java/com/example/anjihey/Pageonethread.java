package com.example.anjihey;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Pageonethread.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Pageonethread#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pageonethread extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Pageonethread newInstance() {
        Pageonethread fragment = new Pageonethread();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Pageonethread.
     */
    // TODO: Rename and change types and number of parameters
    public static Pageonethread newInstance(String param1, String param2) {
        Pageonethread fragment = new Pageonethread();
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
    //////////////////////////////////////////////////////////////////////////////////////////////////////

    Picture p;
    Handler h;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_pageonethread, container, false);

        p = (Picture) v.findViewById(R.id.pview);
        h = new H();
        thread1.start();

        return v;
    }

    class H extends Handler {
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                p.invalidate();
            }else {

            }
        }
    }

    Thread thread1 = new Thread(new Runnable() {
        public void run() {

            while (true) {

                while ( h != null) {
                    try {
                        p.ii = p.ii + 0.6f;  // nullpointexception
                        Message msg = Message.obtain();
                        msg.what = 0;
                        h.sendMessage(msg);

                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Message msg = Message.obtain(); // 실패
                msg.what = 1;
                h.sendMessage(msg);
            }
        }
    });

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
