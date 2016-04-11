package ingrid.jack.matteo.projectnative;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Home.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "array";
    private static final String ARG_PARAM2 = "boolean";

    // TODO: Rename and change types of parameters
    public ArrayList<EventCaneva> arrayList;
    public Boolean mParam2;
    private CallPost callPost;


    private OnFragmentInteractionListener mListener;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param arrayList Parameter 1.
     * @param bool Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(ArrayList<EventCaneva> arrayList, Boolean bool) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, arrayList);
        args.putBoolean(ARG_PARAM2, bool);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            arrayList = (ArrayList<EventCaneva>) getArguments().get(ARG_PARAM1);
            mParam2 = getArguments().getBoolean(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView rv = (RecyclerView)view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        Adapter adapter = new Adapter(arrayList);
        callPost = new CallPost(this, adapter);
        if(savedInstanceState != null) {
            arrayList = (ArrayList<EventCaneva>) savedInstanceState.get(ARG_PARAM1);
            mParam2 = savedInstanceState.getBoolean(ARG_PARAM2);
            if(mParam2 == false){
                callPost.request();
            }
        }else{
            callPost.request();
        }

        rv.setAdapter(adapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_PARAM1, arrayList);
        outState.putBoolean(ARG_PARAM2, mParam2);
    }
}
