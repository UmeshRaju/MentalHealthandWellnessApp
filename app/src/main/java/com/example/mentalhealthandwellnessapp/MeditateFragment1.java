package com.example.mentalhealthandwellnessapp;

import static android.net.Uri.parse;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MeditateFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeditateFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MeditateFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MeditateFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static MeditateFragment1 newInstance(String param1, String param2) {
        MeditateFragment1 fragment = new MeditateFragment1();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meditate1, container, false);
        VideoView videoView1 = view.findViewById(R.id.meditateVideo);

        // Specify the location of the video file
        String videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.meditate_tutorial;

        // Create a Uri object
        Uri uri = Uri.parse(videoPath);

        // Set the video URI to the VideoView
        videoView1.setVideoURI(uri);

        // Create a MediaController to control playback (optional)
        MediaController mediaController = new MediaController(requireContext());
        videoView1.setMediaController(mediaController);
        mediaController.setAnchorView(videoView1);

        // Start playing the video
        videoView1.start();

        return view;
    }


}