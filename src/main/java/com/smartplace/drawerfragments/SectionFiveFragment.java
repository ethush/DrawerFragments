package com.smartplace.drawerfragments;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link android.app.Fragment} subclass.
 * Use the {@link com.smartplace.drawerfragments.SectionFiveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionFiveFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //These are the arguments passed through the constructors
    private static final String ARG_SECTION_NUMBER = "section_number";

    //Variable to save the argument
    private int mSectionNumber;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param sectionNumber Parameter 1.
     * @return A new instance of fragment SectionOneFragment.
     */
    public static SectionFiveFragment newInstance(int sectionNumber) {
        SectionFiveFragment fragment = new SectionFiveFragment();
        Bundle args = new Bundle();
        //set arguments into bundle
        //This is done to avoid null pointer exceptions
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public SectionFiveFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //get arguments from bundle
            mSectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_section_five, container, false);

        //Here reference your fragment's xml objects and initialize them ...

        TextView txtHeader = (TextView)fragmentView.findViewById(R.id.txt_header);
        txtHeader.setText("This is fragment section " + (mSectionNumber+1));

        //fragment view shall be returned
        return fragmentView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //This method is called when the fragment is attached into the activity

        //In order to set the title, call function from holder activity
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
