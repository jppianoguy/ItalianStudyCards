package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.japagnotta.italianstudycards.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Future.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Future#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Future extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private String title;
    private int page=0;

    public String getHeading() {
        return heading;
    }

    private String heading;

//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Future() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Present.
     */
    // TODO: Rename and change types and number of parameters
    public static Future newInstance(int page, String title) {
        Future fragment = new Future();
        Bundle args = new Bundle();
        args.putString("someTitle",title);
        args.putInt("someInt",page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString("someTitle");
            page = getArguments().getInt("someInt",0);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        heading = getString(R.string.future_toolbar);
        return inflater.inflate(R.layout.fragment_future, container, false);
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(int position) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(position);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof BlankFragment.OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        }
//        else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.future_toolbar);
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
        void onFutureFragmentInteraction(int position);
    }
}
